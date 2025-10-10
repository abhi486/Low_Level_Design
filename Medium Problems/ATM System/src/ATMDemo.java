public class ATMDemo {
    public static void main(String[] args) {
        BankingService bankingService = new BankingService();

        bankingService.createAccount("123456789", 2000.0);
        bankingService.createCardForAccount(bankingService.getAccount("123456789"), "1111-2222-3333-4444", "John Doe", "12/25", "123", 1234);

        ATM atm = new ATM(bankingService);
        atm.insertNotes(100, 1000); // Add 1000 notes of 100 denomination
        atm.insertNotes(500, 1000); // Add 1000 notes of 500 denomination

        atm.insertCard("1111-2222-3333-4444");
        // selecting operation without entering PIN
        atm.selectOperation(Operation.CHECK_BALANCE);

        atm.enterPin(1234);
        atm.selectOperation(Operation.CHECK_BALANCE);

        atm.insertCard("1111-2222-3333-4444");
        atm.enterPin(1234);
        atm.selectOperation(Operation.WITHDRAW, 1700);
    }
}
