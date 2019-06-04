package threadpool;

public class ThreadTest {

    public static void main(String[] args) throws Exception {


        Thread aaa = new Thread() {
            @Override
            public void run() {
                System.out.println("111111");
                try {
                    Thread.sleep(7000);
                } catch (Exception e) {

                }
                System.out.println("2222222");
            }
        };
        aaa.start();
        aaa.join();

        System.out.println("33333333");


        //打印顺序 1，2，3

    }


}
