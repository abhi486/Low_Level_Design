public class ReturnChangeState implements VendingMachineState {
    private final VendingMachine vendingMachine;

    public ReturnChangeState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Returning change now!");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Returning change now!");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Returning change now!");
    }

    @Override
    public void returnChange() {
        double change = vendingMachine.getTotalMoney() - vendingMachine.getProduct().getPrice();
        if (change > 0) {
            System.out.println("Change returned: $" + change);
        }
        else {
            System.out.println("No change to return!");
        }

        vendingMachine.resetTotalMoney();
        vendingMachine.resetSelectedProduct();
        vendingMachine.changeState(vendingMachine.getIdleState());
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Returning change now!");
    }
}
