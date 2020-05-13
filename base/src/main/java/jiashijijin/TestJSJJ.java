package jiashijijin;

/**
 * Created with H
 * Description:
 * Time: 2020/5/6
 */
public class TestJSJJ {

//    public static void main(String[] args) {
//        int x=4;
//        System.out.println("value is"+ ((x>4) ? 99.9 :9));
//    }


    public static void main(String[] args) {
        int countx = 0;
        int x = 9999;
        while(x > 0) {
            countx++;
            x = x&(x-1);
            System.out.println("x="+x);
        }

        System.out.println(countx);
    }

}
