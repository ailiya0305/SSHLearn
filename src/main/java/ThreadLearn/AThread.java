package ThreadLearn;


public class AThread extends Thread {

    public AThread() {

    }

    @Override
    public void run() {
        System.out.printf(Thread.currentThread().getName()+"运行了==========\n");
    }
}
