public class Philosopher extends Thread {
    private final Table table;
    private final int leftFork, rightFork;
    private final int id;
    private boolean mode = true;

    public Philosopher(int id, Table table, boolean mode ) {

        this.mode = mode;
        this.id = id;
        this.table = table;

        rightFork = id == 4 && mode? id: (id + 1) % 5;
        leftFork = id == 4 && mode? (id + 1) % 5: id;

        start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Philosopher" + id + " is thinking " + (i + 1) + " times");
            if (!mode) {
                table.startEat();
            }
            table.getFork(rightFork);
            table.getFork(leftFork);
            System.out.println("Philosopher" + id + " is eating " + (i + 1) + " times");
            table.putFork(leftFork);
            table.putFork(rightFork);
            if (!mode) {
                table.finishEat();
            }
        }
    }
}