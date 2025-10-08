import java.util.HashMap;
import java.util.Map;

abstract class Beverage {
    protected Map<String, Double> recipe;
    protected int quantity;

    Beverage() {
        recipe = new HashMap<>();
        quantity = 0;
    }
    protected abstract boolean Create(State state);
    protected abstract boolean Dispense(State state);

    protected synchronized void updateQuantity(int quantity, State state) {
        if (state != State.READY) {
            System.out.println("Modifications only allowed before creation!");
            return;
        }
        this.quantity = quantity;
    }
}
