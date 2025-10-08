public class CoffeeMachineDemo {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = CoffeeMachine.getInstance();
        coffeeMachine.FillIngredients();

        coffeeMachine.create(CoffeeType.Latte);
        coffeeMachine.create(CoffeeType.Americano);
    }
}
