import java.util.ArrayList;
import java.util.List;

class Pair {
    public Product product;
    public int quantity;

    public Pair(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}

public class VendingMachineDemo {
    public static void main(String[] args) {
        VendingMachine machine = VendingMachine.getInstance();

        List<Pair> productList = new ArrayList<>();
        productList.add(new Pair(new Product("Cola", 10), 15));
        productList.add(new Pair(new Product("Spicy Lays", 15), 10));
        productList.add(new Pair(new Product("Cake", 20), 5));

        for (Pair p : productList) {
            machine.addProduct(p.product, p.quantity);
        }

        Product cola = productList.get(0).product;

        // select a product
        machine.selectProduct(cola);

        // insert coins
        machine.insertCoin(Coin.QUARTER);
        machine.insertCoin(Coin.PENNY);
        machine.insertCoin(Coin.PENNY);

        // insert note
        machine.insertNote(Note.FIVE);
        machine.insertNote(Note.TWENTY);

        // dispense product
        machine.dispenseProduct();

        // return change
        machine.returnChange();


        // Select another product
        Product cake = productList.get(2).product;

        // select product
        machine.selectProduct(cake);

        // insufficient fund
        machine.insertNote(Note.FIVE);

        // dispense won't happen
        machine.dispenseProduct();
    }
}
