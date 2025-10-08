public class CoffeeFactory {
    static Beverage getCoffee(CoffeeType coffeeType) {
        Beverage beverage = null;
        if (coffeeType == CoffeeType.Latte) {
            beverage = new Latte();
        }
        else if (coffeeType == CoffeeType.Cappuccino) {
            beverage = new Cappuccino();
        }
        else if (coffeeType == CoffeeType.Americano) {
            beverage = new Americano();
        }
        return beverage;
    }
}
