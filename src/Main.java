public class Main {

    public static void runSimulation(Table table, boolean mode) {
        for (int i = 0; i < 5; i++) {
            new Philosopher(i, table, mode);
        }
    }

    public static void main(String[] args) {

        boolean mode = true;
        runSimulation(new Table(), mode);
    }
}