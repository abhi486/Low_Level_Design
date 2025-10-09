import java.util.Map;

class BankingService {
    private Map<String, Account> accounts;
    private Map<String, Account> cardsToAccounts;

    public BankingService() {
        accounts = new java.util.HashMap<>();
        cardsToAccounts = new java.util.HashMap<>();
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public Account getAccountByCard(String cardNumber) {
        return cardsToAccounts.get(cardNumber);
    }

    public void linkCardToAccount(String cardNumber, Account account) {
        cardsToAccounts.put(cardNumber, account);
    }

    public void createCardForAccount(Account account, String cardNumber, String cardHolderName, String expiryDate, String cvv, int pin) {
        Card newCard = new Card(cardNumber, cardHolderName, expiryDate, cvv, pin);
        account.addCard(newCard);
        linkCardToAccount(cardNumber, account);
    }

    public void createAccount(String accountNumber, double initialBalance) {
        Account newAccount = new Account(accountNumber, initialBalance);
        addAccount(newAccount);
    }
}
