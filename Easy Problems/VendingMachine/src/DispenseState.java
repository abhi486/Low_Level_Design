public class DispenseState implements VendingMachineState {
    private final VendingMachine vendingMachine;

    public DispenseState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Already Dispensing a product!");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Already Dispensing a product!");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Already Dispensing a product!");
    }

    @Override
    public void returnChange() {
        System.out.println("Dispensing a product before returning change!");
    }

    @Override
    public void dispenseProduct() {
        int quantity = vendingMachine.getQuantity(vendingMachine.getProduct());
        if (quantity > 0) {
            vendingMachine.updateQuantity(vendingMachine.getProduct(), quantity - 1);
            System.out.println("Dispense successful! :)");
            // change state to return change now.
            vendingMachine.changeState(vendingMachine.getReturnChangeState());
        }
        else {
            System.out.println("Selected product does not have enough quantity");
        }
    }
}
