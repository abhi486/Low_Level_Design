public interface ATMState {
    void insertCard(ATM atm, String cardNumber);
    void enterPin(ATM atm, int pin);
    void selectOperation(ATM atm, Operation op, int... args);
    void ejectCard(ATM atm);
}
