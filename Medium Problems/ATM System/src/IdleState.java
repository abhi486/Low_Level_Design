public class IdleState implements ATMState {
    public IdleState() { }

    @Override
    public void insertCard(ATM atm, String cardNumber) {
        Card card = atm.getCardDetails(cardNumber);
        if (card == null) {
            ejectCard(atm);
        }
        atm.setCurrentCard(card);
        System.out.println("Card inserted successfully. Please enter PIN.");
        atm.changeState(new AuthenticateState());
    }

    @Override
    public void enterPin(ATM atm, int pin) {
        System.out.println("Enter the card first.");
    }

    @Override
    public void selectOperation(ATM atm, Operation op, int... args) {
        System.out.println("Enter the card first.");
    }

    @Override
    public void ejectCard(ATM atm) {
        System.out.println("Card Not found. Ejecting Card.");
        atm.setCurrentCard(null);
        atm.changeState(new IdleState());
    }
}
