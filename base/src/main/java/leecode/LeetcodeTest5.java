package leecode;

/**
 * @author LuDas  ( 中等)
 * @Description: 给定一个字符串 s，找到 s 中最长的回文子串。ababcdacf
 * @date 2019/4/25 15:31
 */
public class LeetcodeTest5 {

    private static String str="ababcdacf";


    public static void main(String[] args) {
        method1(str);
    }
    /**
     * 暴力法  获取所有的子串，并检测是否回文
     */
     public static String method1(String str){

         String huiWen="";
         for(int i=0;i<str.length();i++){
             for(int j=i+1;j<str.length();j++){
                String temp= str.substring(i,j);
                 System.out.println(temp);
                 //检测该字符串是否是回文
                 boolean flag=isHuiWen(temp);
                 System.out.println(flag);
                 if(flag&&(huiWen.length()<temp.length())){
                     huiWen=temp;
                 }

             }
         }
         System.out.printf("最长回文字符串:"+huiWen);
         return huiWen;
     }

    /**
     * 检测字符串是否是回文
     */
    public static boolean isHuiWen(String str){
        if(str==null){
            return false;
        }
        if(str.length()==1){
            return true;
        }
        for(int i=0;i<str.length()/2;i++){
             char a=str.charAt(i);
             char b=str.charAt(str.length()-i-1);
             if(a!=b){
                return false;
             }

        }
        return true;
    }



}
