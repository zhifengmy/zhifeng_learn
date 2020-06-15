package threadlocal;

/**
 * Created with H
 * Description:
 * Time: 2020/6/15
 */
public class ThreadLoacalTest {

    public static void main(String[] args) {
        ThreadLocal<String> local=new ThreadLocal<>();

        local.set("aaaa");

        String s = local.get();
        System.out.println(s);

        ThreadLocal<String> blocal=new ThreadLocal<>();
        blocal.set("bbb");
        String b = blocal.get();
        System.out.println(b);


        Thread thread = Thread.currentThread();
        String c = local.get();
        System.out.println(c);
    }
}
