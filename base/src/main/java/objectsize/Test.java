package objectsize;

/**
 * Created with 栉风
 * Description:
 * Time: 2020/6/24
 */
public class Test {

    public static void main(String[] args) throws Exception{

        final ClassIntrospector ci = new ClassIntrospector();

        String [] obj=new String[10];
        ObjectInfo res = ci.introspect(obj);
        System.out.println( res.getDeepSize() );

        for(int i=0;i<obj.length-1;i++){
            obj[i]="aaa"+i;
            res = ci.introspect(obj);
            //数组会递归计算所存数据大小
            System.out.println( res.getDeepSize() );
        }

    }
}
