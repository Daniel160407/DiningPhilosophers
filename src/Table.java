public class Table {

    public int forks;

    public Table(int forks) {
        this.forks = forks;
    }

    public synchronized boolean forkAvailable() {
        return forks > 0;
    }

    public synchronized void takeFork() {
        forks--;
    }

    public synchronized void returnFork() {
        forks++;
    }

}