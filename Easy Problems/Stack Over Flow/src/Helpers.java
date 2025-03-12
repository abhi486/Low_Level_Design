public class Helpers {
    public static int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }
}
