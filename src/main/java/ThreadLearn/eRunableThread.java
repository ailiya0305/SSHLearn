package ThreadLearn;

public class eRunableThread implements Runnable{
    @Override
    public void run() {
        System.out.printf("e线程运行"+Thread.currentThread().getName()+"\n");
    }
}
