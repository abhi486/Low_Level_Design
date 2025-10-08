class VendingMachine {
    private static VendingMachine vendingMachine;
    private final VendingMachineState idleState;
    private final VendingMachineState readyState;
    private final VendingMachineState dispenseState;
    private final VendingMachineState returnChangeState;
    private Inventory inventory;
    private VendingMachineState currentState;
    private Product selectedProduct;
    private double totalMoney;

    private VendingMachine() {
        idleState = new IdleState(this);
        readyState = new ReadyState(this);
        dispenseState = new DispenseState(this);
        returnChangeState = new ReturnChangeState(this);
        inventory = new Inventory();
        currentState = idleState;
        totalMoney = 0.0;
    }

    public static synchronized VendingMachine getInstance() {
        if (vendingMachine == null) {
            vendingMachine = new VendingMachine();
        }
        return vendingMachine;
    }

    void addProduct(Product product, int quantity) {
        inventory.addProduct(product, quantity);
    }

    void updateQuantity(Product product, int quantity) {
        inventory.updateQuantity(product, quantity);
    }

    void removeProduct(Product product) {
        inventory.removeProduct(product);
    }

    int getQuantity(Product product) {
        return inventory.getQuantity(product);
    }

    boolean isAvailable(Product product) {
        return inventory.isAvailable(product);
    }

    VendingMachineState changeState(VendingMachineState state) {
        currentState = state;
        return currentState;
    }

    VendingMachineState getCurrentState() {
        return currentState;
    }

    void addCoin(Coin coin) {
        totalMoney += coin.getValue();
    }

    void addNote(Note note) {
        totalMoney += note.getValue();
    }

    double getTotalMoney() {
        return totalMoney;
    }

    void resetTotalMoney() {
        totalMoney = 0.0;
    }

    void setProduct(Product product) {
        selectedProduct = product;
    }

    void resetSelectedProduct() {
        selectedProduct = null;
    }

    VendingMachineState getIdleState() {
        return idleState;
    }

    VendingMachineState getReadyState() {
        return readyState;
    }

    VendingMachineState getDispenseState() {
        return dispenseState;
    }

    VendingMachineState getReturnChangeState() {
        return returnChangeState;
    }

    Product getProduct() {
        return selectedProduct;
    }

    void selectProduct(Product product) {
        currentState.selectProduct(product);
    }

    void insertCoin(Coin coin) {
        currentState.insertCoin(coin);
    }

    void insertNote(Note note) {
        currentState.insertNote(note);
    }

    void dispenseProduct() {
        currentState.dispenseProduct();
    }

    void returnChange() {
        currentState.returnChange();
    }
}
