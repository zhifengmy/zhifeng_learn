package map;

/**
 * Created with H
 * Description:
 * Time: 2020/6/8
 */
public class TestMap {

    private static final int COUNT_BITS = Integer.SIZE - 3;

    public static void main(String[] args) {

        int RUNNING = -1 << COUNT_BITS;
        int STOP = 1 << COUNT_BITS;
        int TIDYING = 2 << COUNT_BITS;
        int TERMINATED = 3 << COUNT_BITS;

        System.out.println(RUNNING + "");
        System.out.println(STOP + "");
        System.out.println(TIDYING + "");
        System.out.println(TERMINATED + "");

    }
}
