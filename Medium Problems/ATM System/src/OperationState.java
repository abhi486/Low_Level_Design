class OperationState implements ATMState {
    public OperationState() { }

    @Override
    public void insertCard(ATM atm, String cardNumber) {
        System.out.println("Card already inserted. Please select operation.");
    }

    @Override
    public void enterPin(ATM atm, int pin) {
        System.out.println("PIN already verified. Please select operation.");
    }

    @Override
    public void selectOperation(ATM atm, Operation op, int... args) {
        switch (op) {
            case WITHDRAW:
                if (args.length < 1) {
                    System.out.println("Withdrawal amount not provided.");
                    break;
                }
                int amount = args[0];
                atm.withdraw(amount);
                break;
            case CHECK_BALANCE:
                atm.checkBalance();
                // Implement deposit logic here
                break;
            case CHANGE_PIN:
                if (args.length < 1) {
                    System.out.println("New PIN not provided.");
                    break;
                }
                int newPin = args[0];
                if (newPin < 1000 || newPin > 9999) {
                    System.out.println("PIN must be a 4-digit number.");
                    break;
                }

                atm.changePin(newPin);
                // Implement balance inquiry logic here
                break;
            default:
                System.out.println("Invalid operation selected.");
        }
        System.out.println("Operation completed. Ejecting card.");
        atm.setCurrentCard(null);
        ejectCard(atm);
    }

    @Override
    public void ejectCard(ATM atm) {
        System.out.println("Ejecting Card. Thank you for using the ATM.");
        atm.changeState(new IdleState());
    }
}
