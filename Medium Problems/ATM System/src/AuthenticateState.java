public class AuthenticateState implements ATMState {
    public AuthenticateState() { }

    @Override
    public void insertCard(ATM atm, String cardNumber) {
        System.out.println("Card already inserted. Please enter PIN.");
    }

    @Override
    public void enterPin(ATM atm, int pin) {
        Card card = atm.getCurrentCard();
        if (card.authenticate(pin)) {
            System.out.println("PIN verified successfully.");
            atm.changeState(new OperationState());
        } else {
            System.out.println("Incorrect PIN. Ejecting card.");
            atm.setCurrentCard(null);
            ejectCard(atm);
        }
    }

    @Override
    public void selectOperation(ATM atm, Operation op, int... args) {
        System.out.println("Please enter PIN first.");
    }

    @Override
    public void ejectCard(ATM atm) {
        System.out.println("Incorrect PIN. Ejecting Card.");
        atm.changeState(new IdleState());
    }
}
