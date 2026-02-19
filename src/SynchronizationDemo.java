class Table {
    synchronized void printTable(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.print(n * i);
            if (i < 5) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}

class MyThread1 extends Thread {
    Table t;

    MyThread1(Table t) {
        this.t = t;
    }

    public void run() {
        t.printTable(5);
    }
}

class MyThread2 extends Thread {
    Table t;

    MyThread2(Table t) {
        this.t = t;
    }

    public void run() {
        t.printTable(100);
    }
}

public class SynchronizationDemo {
    public static void main(String[] args) {
        Table table = new Table();

        MyThread1 t1 = new MyThread1(table);
        MyThread2 t2 = new MyThread2(table);

        t1.start();
        try {
            t1.join();   //  wait until table of 5 finishes
        } catch (InterruptedException e) {
            // do nothing
        }

        t2.start();
    }
}



