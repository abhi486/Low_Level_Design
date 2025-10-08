public class ReadyState implements VendingMachineState {
    private final VendingMachine vendingMachine;

    public ReadyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Product already selected!");
    }

    @Override
    public void insertCoin(Coin coin) {
        vendingMachine.addCoin(coin);
        System.out.println("Coin inserted: " + coin.getValue());
        checkPaymentStatus();
    }

    @Override
    public void insertNote(Note note) {
        vendingMachine.addNote(note);
        System.out.println("Note inserted: " + note.getValue());
        checkPaymentStatus();
    }

    @Override
    public void returnChange() {
        System.out.println("Insert the money!");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Not enough money!");
    }

    void checkPaymentStatus() {
        if (vendingMachine.getTotalMoney() >= vendingMachine.getProduct().getPrice()) {
            System.out.println("Amount received");

            // change state to dispense once enough amount have been received.
            vendingMachine.changeState(vendingMachine.getDispenseState());
        }
    }
}
