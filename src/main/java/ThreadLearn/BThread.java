package ThreadLearn;

public class BThread extends Thread{
    public void BThread(){
    }
    @Override
    public void run() {
        System.out.printf(Thread.currentThread().getName()+"运行了==========");
    }
}
