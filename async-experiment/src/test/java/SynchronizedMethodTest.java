import java.util.concurrent.TimeUnit;

/**
 * 测试synchronized修饰的非static方法是对象级别的还是类级别的--对象级别（对象锁）
 * created by guoqingpeng on 2019/2/17
 */
public class SynchronizedMethodTest {

    public synchronized void test(){
        int i = 5;
        while( i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException ie) {
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedMethodTest test1 = new SynchronizedMethodTest();
        SynchronizedMethodTest test2 = new SynchronizedMethodTest();
        Thread thread1 = new Thread(  new Runnable() {  public void run() {  test1.test();  }  }, "test1"  );
        Thread thread2 = new Thread(  new Runnable() {  public void run() { test2.test();   }  }, "test2"  );
        thread1.start();;
        thread2.start();

        try{
            Thread.sleep(5000);
            System.out.println("----------------");
        }catch (Exception e){

        }

        SynchronizedMethodTest test3 = new SynchronizedMethodTest();
        Thread thread3 = new Thread(  new Runnable() {  public void run() {  test3.test();  }  }, "test3"  );
        Thread thread4 = new Thread(  new Runnable() {  public void run() { test3.test();   }  }, "test4"  );
        thread3.start();;
        thread4.start();

    }
}
