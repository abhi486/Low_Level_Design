public class NoteDispense100 implements NoteDispense {
    private int count100;

    @Override
    public boolean dispense(int notes) {
        synchronized (this) {
            if (notes <= count100) {
                count100 -= notes;
                return true;
            } else {
                System.out.println("Insufficient 100 notes available.");
                return false;
            }
        }
    }

    public synchronized void addNotes(int notes) {
        count100 += notes;
    }
}
