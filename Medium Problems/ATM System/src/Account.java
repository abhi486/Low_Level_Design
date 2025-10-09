import java.util.HashMap;
import java.util.Map;

class Account {
    private String accountNumber;
    private double balance;
    private Map<String, Card> cards;

    Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.cards = new HashMap<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            synchronized (this) {
                balance += amount;
            }
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0) {
            synchronized (this) {
                if (balance >= amount) {
                    balance -= amount;
                    return true;
                }
            }
        }
        return false;
    }

    public void addCard(Card card) {
        cards.put(card.getCardNumber(), card);
    }

    public Card getCard(String cardNumber) {
        return cards.get(cardNumber);
    }

    public synchronized void displayBalance() {
        System.out.println("Current balance: " + balance);
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        displayBalance();
        System.out.println("Cards associated with this account:");
        for (String cardNum : cards.keySet()) {
            System.out.println(" - Card Number: " + cardNum);
        }
    }
}
