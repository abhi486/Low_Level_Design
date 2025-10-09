public class NoteDispense500 implements NoteDispense {
    private int count500;

    @Override
    public boolean dispense(int notes) {
        synchronized (this) {
            if (notes <= count500) {
                count500 -= notes;
                return true;
            } else {
                System.out.println("Insufficient 500 notes available.");
                return false;
            }
        }
    }

    public synchronized void addNotes(int notes) {
        count500 += notes;
    }
}
