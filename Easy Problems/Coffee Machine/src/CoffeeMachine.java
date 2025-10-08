import java.util.HashMap;
import java.util.Map;

public class CoffeeMachine {
    State machineState;
    Map<String, CoffeeType> coffeeTypeMap;
    Ingredients ingredients;
    static CoffeeMachine coffeeMachine;
    private CoffeeMachine() {
        machineState = State.READY;
        coffeeTypeMap = new HashMap<>();
        ingredients = Ingredients.getInstance();
    }

    public synchronized static CoffeeMachine getInstance() {
        if (coffeeMachine == null) {
            coffeeMachine = new CoffeeMachine();
        }
        return coffeeMachine;
    }

    public boolean create(CoffeeType coffeeType) {
        Beverage beverage = CoffeeFactory.getCoffee(coffeeType);
        if (beverage == null) {
            System.out.println("Invalid beverage type! Please select Latte, Cappuccino or Americano");
            return false;
        }
        return beverage.Create(machineState);
    }
    public void FillIngredients() {
        ingredients.addIngredients("Coffee", 1000);
        ingredients.addIngredients("Water", 1000);
        ingredients.addIngredients("Milk", 1000);
    }

    State getMachineState() { return machineState; }

}
