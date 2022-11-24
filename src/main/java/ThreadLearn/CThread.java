package ThreadLearn;

public class CThread implements Runnable{
    private String Name;
    @Override
    public void run() {
        System.out.printf("我是线程3运行了====");
    }
}
