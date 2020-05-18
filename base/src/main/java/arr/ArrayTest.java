package arr;

import java.util.Arrays;

/**
 * Created with H
 * Description:
 * Time: 2020/5/14
 */
public class ArrayTest {

    public static void main(String[] args) {
        int[] digits = {9, 9, 9};
        int[] ints = plusOne(digits);

        System.out.printf(Arrays.toString(ints));
    }


    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }


}
