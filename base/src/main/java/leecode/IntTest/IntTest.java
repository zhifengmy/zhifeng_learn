package leecode.IntTest;

/**
 * Created with H
 * Description:
 * Time: 2020/5/15
 */
public class IntTest {

    public static void main(String[] args) {
        int reverse = reverse(234);

        System.out.printf("reverse:"+reverse);
    }

    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
