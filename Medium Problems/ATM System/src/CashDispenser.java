class CashDispenser {
    private static CashDispenser instance;
    private NoteDispense100 noteDispense100;
    private NoteDispense500 noteDispense500;
    // Singleton pattern to ensure only one instance of CashDispenser
    private CashDispenser() {
        noteDispense100 = new NoteDispense100();
        noteDispense500 = new NoteDispense500();
    }

    public static CashDispenser getInstance() {
        if (instance == null) {
            synchronized (CashDispenser.class) {
                if (instance == null) {
                    instance = new CashDispenser();
                }
            }
        }
        return instance;
    }

    public void dispenseCash(Account account, double amount) {
        if (amount % 100 != 0 && amount % 500 != 0) {
            System.out.println("Amount must be in multiples of 100 or 500.");
            return;
        }

        // Case 1: 500, 100 both required
        int count500 = (int) (amount / 500);
        int remainder = (int) (amount % 500);
        int count100 = remainder / 100;
        int remainder100 = remainder % 100;

        if (remainder100 == 0 && account.withdraw(amount)) {
            noteDispense500.dispense(count500);
            noteDispense100.dispense(count100);
            System.out.println("Dispensed " + count500 + " notes of 500 and " + count100 + " notes of 100.");
        }

        // Case 2: Only 500 required
        else if (remainder == 0 && account.withdraw(amount)) {
            noteDispense500.dispense(count500);
            System.out.println("Dispensed " + count500 + " notes of 500.");
        }

        // Case 3: Only 100 required
        else if (amount % 100 == 0 && account.withdraw(amount)) {
            count100 = (int) (amount / 100);
            noteDispense100.dispense(count100);
            System.out.println("Dispensed " + count100 + " notes of 100.");
        }

        else {
            System.out.println("Unable to dispense the requested amount. Please check your balance or try a different amount.");
        }
    }

    public void addNotes(int denomination, int count) {
        if (denomination == 100) {
            noteDispense100.addNotes(count);
        } else if (denomination == 500) {
            noteDispense500.addNotes(count);
        } else {
            System.out.println("Invalid denomination. Only 100 and 500 are accepted.");
        }
    }

}
