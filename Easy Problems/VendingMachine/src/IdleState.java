public class IdleState implements VendingMachineState {
    private final VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        if (vendingMachine.isAvailable(product)) {
            vendingMachine.setProduct(product);

            // change state to ready state for accepting money.
            vendingMachine.changeState(vendingMachine.getReadyState());
            System.out.println("Product selected :) Please insert the money.");
        }
        else {
            System.out.println("Product is not available! :( - " + product.getName());
        }
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please select the product first");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Please select the product first");
    }

    @Override
    public void returnChange() {
        System.out.println("Please select the product first and make payment");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("No change to return.");
    }
}
