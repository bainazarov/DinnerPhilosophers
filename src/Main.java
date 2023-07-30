public class Main {
    public static void main(String[] args){
        int philosophers = 5;
        Object[] forks = new Object[philosophers];

        for(int i = 0; i < philosophers; i++) {
            forks[i] = new Object();
        }

        for (int i = 0; i < philosophers; i++) {
            Thread philosopher;
            if (i == 0) {
                philosopher = new Thread(new Philosopher(i, forks[i], forks[(i + 1) % forks.length]));
            } else {
                philosopher = new Thread(new Philosopher(i, forks[(i + 1) % forks.length], forks[i]));
            }
            philosopher.start();
        }
    }
}