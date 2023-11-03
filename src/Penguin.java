public class Penguin implements Runnable {

    private String name;
    private Table table;

    public Penguin(String name, Table table) {
        this.name = name;
        this.table = table;
    }

    public void eat() {
        int tookForks = 0;
        for (int i = 1; i <= 2; i++) {

            while (!table.forkAvailable()) {
                try {
                    Thread.sleep(500);
                    if (tookForks == 1 && !table.forkAvailable()) {
                        table.returnFork();
                        tookForks--;
                        System.out.println(name + " returns");
                    }
                } catch (InterruptedException e) {
                    System.out.println("Something went wrong. Interrupted!");
                    return;
                }
            }
            if (tookForks <= 2 && table.forkAvailable()) {
                table.takeFork();
                tookForks++;
                System.out.println(name + " takes fork #" + tookForks);
            }
            if (tookForks == 1 && i == 2) {
                i--;
            }




            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Something went wrong. Interrupted!");
                return;
            }

        }

        System.out.println(name + " ate.");

        table.returnFork();
        table.returnFork();
    }

    @Override
    public void run() {
        eat();
    }

}