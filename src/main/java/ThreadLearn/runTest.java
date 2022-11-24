package ThreadLearn;


import java.util.List;
import java.util.concurrent.*;

public class runTest {
    /**
     * 线程的创建方式
     * 1.继承Thread ，重写run（）方法
     * 2.实现Runnable接口，重写run（）方法
     * 3.Callable 和 ExecutorService
     * 4.线程池
     */
    public static void main(String[] args) throws Exception {

        //继承Thread ，重写run（）方法
        AThread aThread=new AThread();
        aThread.setName("线程a");
        aThread.start();

        BThread bthread=new BThread();
        bthread.setName("线程b");
        bthread.start();

        //实现Runnable接口，重写run（）方法
        Thread cThread=new Thread(new CThread());
        cThread.start();
        System.out.printf("当前线程是"+Thread.currentThread().getName()+"==========");

        //FutureTask 通过callable中的call（）方法将返回值传递出来。
        Callable<Object> callable=new Callable<Object>() {
            @Override
            public Object call() throws Exception {
//                System.out.printf("futureTask执行了");
                return "执行结束!";
            }
        };
        FutureTask<Object> futureTask =new FutureTask(callable);
        Thread dthread=new Thread(futureTask);
        dthread.start();
        System.out.printf("futureTask"+futureTask.get()+"\n");


        //通过线程池创建线程

        //创建有固定数量线程的线程池
        ExecutorService executor= Executors.newFixedThreadPool(5);
        //创建一个可缓存的线程池
        Executors.newCachedThreadPool();
        //创建一个单线程化的Executor
        Executors.newSingleThreadExecutor();
        //创建一个支持定时及周期性的任务执行的线程池，多数情况下可用来替代Timer类。
        Executors.newScheduledThreadPool(10);
        for (int i=0;i<20;i++) {
            executor.execute(new eRunableThread());
        }

       //关闭线程池（等待所有的线程执行完毕再关闭）
        executor.shutdown();

        //关闭线程池 (向线程发送中断信号，直接终止线程，并返回未被执行的线程列表)
//       List<Runnable> runnableList= executor.shutdownNow();
//        runnableList.forEach(v-> System.out.printf("未执行的线程"));

        //ThreadPoolExcutor
       BlockingQueue<Runnable> blockingQueue= new LinkedBlockingQueue<Runnable>(10);
        new ThreadPoolExecutor(10,100,3000,TimeUnit.SECONDS,blockingQueue);
    }
}
