import java.util.HashMap;
import java.util.Map;

class Ingredients {
    Map<String, Integer> coffeeIngredients;
    static Ingredients ingredients;
    private Ingredients() {
        coffeeIngredients = new HashMap<>();
    }

    public synchronized static Ingredients getInstance() {
        if (ingredients == null) {
            ingredients = new Ingredients();
        }
        return ingredients;
    }

    public synchronized void addIngredients(String name, int quantity) {
        coffeeIngredients.put(name, coffeeIngredients.getOrDefault(name, 0) + quantity);
    }

    public synchronized int getIngredient(String name, int quantity) {
        if (!coffeeIngredients.containsKey(name)) {
            System.out.println("Invalid ingredient");
            return -1;
        }
        if (coffeeIngredients.get(name) < quantity) {
            System.out.println(name + "not available, current quantity: " + coffeeIngredients.get(name));
            return -1;
        }

        coffeeIngredients.put(name, coffeeIngredients.get(name) - quantity);
        return quantity;
    }

    public void NotifyRunningLowOnIngredients() {
        // Sends notification when
    }
}
