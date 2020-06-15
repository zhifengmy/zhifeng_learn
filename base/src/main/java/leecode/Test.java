package leecode;

/**
 * Created with H
 * Description:
 * Time: 2020/5/19
 */
public class Test {

    //说Excel表用过吧，Excel表中的编号一般是这样的，A....Z AA...AZ BA...BZ，
    // 分别对应数字0...25 26....51 52...77，类比做数字映射，给出一个字符串，求映射的结果。


    public static void main(String[] args) {
        int bb = excelColumParse("BB");
        System.out.printf(""+bb);

//        System.out.print('A'+1);
    }

    public static int  excelColumParse(String column){
        int BASE=26;
        int result=0;
        for(int i=column.length()-1;i>=0;i--){
            if(i==column.length()-1){
                result+=column.charAt(i)-'A';
            }else{
                result+=(column.charAt(i)-'A'+1)*(BASE*(column.length()-1-i));
            }
        }
        return result;
    }





}
