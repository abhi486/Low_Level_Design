public class Cappuccino extends Beverage {

    Cappuccino() {
        super();
        recipe.put("Coffee", 0.3);
        recipe.put("Water", 0.4);
        recipe.put("Milk", 0.3);
        quantity = 250;
    }

    @Override
    protected synchronized boolean Create(State state) {
        if (state != State.READY) {
            System.out.println("Already a coffee is under process");
            return false;
        }
        state = State.CREATE;

        Ingredients ingredientsInstance = Ingredients.getInstance();

        for (String name : recipe.keySet()) {
            int quan = (int) (quantity * recipe.get(name));
            int ing = ingredientsInstance.getIngredient(name, quan);

            if (ing == -1) {
                state = State.READY;
                return false;
            }
        }

        return Dispense(state);
    }

    @Override
    protected synchronized boolean Dispense(State state) {
        if (state != State.CREATE) {
            System.out.println("Nothing to dispense.");
            return false;
        }

        state = State.DISPENSE;
        System.out.println("Now dispensing the Cappuccino!");

        state = State.READY;
        return true;
    }
}
