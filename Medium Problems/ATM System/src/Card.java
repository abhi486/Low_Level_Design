import java.time.LocalDate;

class Card {
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;
    private String cvv;
    private int pin;

    Card (String cardNumber, String cardHolderName, String expiryDate, String cvv, int pin) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.pin = pin;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public synchronized boolean verifyCard(Card card) {
        return this.cardNumber.equals(card.cardNumber) &&
               this.cardHolderName.equals(card.cardHolderName) &&
               this.expiryDate.equals(card.expiryDate) &&
               this.cvv.equals(card.cvv) &&
               this.pin == card.pin;
    }

    public synchronized boolean isExpired(String currentDate) {
        LocalDate current = LocalDate.parse(currentDate);
        LocalDate expiry = LocalDate.parse(this.expiryDate + "-01");
        return current.isAfter(expiry.withDayOfMonth(expiry.lengthOfMonth()));
    }

    public synchronized boolean changePin(int newPin) {
            this.pin = newPin;
            return true;
    }

    public synchronized boolean authenticate(int pin) {
        return this.pin == pin;
    }
}
