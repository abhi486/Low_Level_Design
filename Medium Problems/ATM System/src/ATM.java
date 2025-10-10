class ATM {
    private Card currentCard;
    private final BankingService bankingService;
    private final CashDispenser cashDispenser;
    private ATMState currentState;

    public ATM(BankingService bankingService) {
        this.bankingService = bankingService;
        cashDispenser = CashDispenser.getInstance();
        currentState = new IdleState();
        currentCard = null;
    }

    public Card getCardDetails(String cardNumber) {
        Account account = bankingService.getAccountByCard(cardNumber);
        if (account != null) {
            return account.getCard(cardNumber);
        }
        return null;
    }

    public synchronized void setCurrentCard(Card card) {
        this.currentCard = card;
    }

    public synchronized Card getCurrentCard() {
        return this.currentCard;
    }

    public synchronized void changeState(ATMState newState) {
        this.currentState = newState;
    }

    public void checkBalance() {
        if (currentCard == null) {
            System.out.println("No card inserted.");
            return;
        }
        Account account = bankingService.getAccountByCard(currentCard.getCardNumber());
        if (account != null) {
            account.displayBalance();
        } else {
            System.out.println("Account not found.");
        }
    }

    public void changePin(int newPin) {
        if (currentCard == null) {
            System.out.println("No card inserted.");
            return;
        }
        currentCard.changePin(newPin);
        System.out.println("PIN changed successfully.");
    }

    public void withdraw(int amount) {
        if (currentCard == null) {
            System.out.println("No card inserted.");
            return;
        }
        Account account = bankingService.getAccountByCard(currentCard.getCardNumber());
        if (account != null) {
            cashDispenser.dispenseCash(account, amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void insertNotes(int denomination, int count) {
        cashDispenser.addNotes(denomination, count);
    }

    public ATMState getCurrentState() {
        return currentState;
    }

    public void insertCard(String cardNumber) {
        currentState.insertCard(this, cardNumber);
    }

    public void enterPin(int pin) {
        currentState.enterPin(this, pin);
    }

    public void selectOperation(Operation op, int... args) {
        currentState.selectOperation(this, op, args);
    }

    public void ejectCard() {
        currentState.ejectCard(this);
    }
}
