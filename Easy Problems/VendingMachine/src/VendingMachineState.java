public interface VendingMachineState {
    void selectProduct(Product product);
    void insertCoin(Coin coin);
    void insertNote(Note note);
    void returnChange();
    void dispenseProduct();
}
