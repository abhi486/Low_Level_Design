import java.time.LocalDate;

class Card {
    String cardNumber;
    String cardHolderName;
    String expiryDate;
    String cvv;
    int pin;

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

    public synchronized boolean changePin(int oldPin, int newPin) {
        if (this.pin == oldPin) {
            this.pin = newPin;
            return true;
        }
        return false;
    }
}
