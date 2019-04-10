package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
* @Description:JDK动态代理
* @author LuDas
* @date 2019/4/10 11:20
*/
public class ProxyTest {

    public static void main(String[] args) {

        UserDao proxy =(UserDao) createProxy();
        int i = proxy.find();
        System.out.println(i);


        proxy.save();

    }

    //创建代理对象
    public static Object createProxy(){
        final UserDao target=new UserDaoImpl();
        Object object=Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 获取当前执行的方法的方法名
                String methodName = method.getName();
                // 方法返回值
                Object result = null;
                if ("find".equals(methodName)) {
                    // 直接调用目标对象方法
                    result = method.invoke(target, args);
                } else {
                    System.out.println("开启事务...");
                    // 执行目标对象方法
                    result = method.invoke(target, args);
                    System.out.println("提交事务...");
                }
                return result;
            }
        });
        return object;
    }

}

interface UserDao{
    void save();
    int find();
}

class UserDaoImpl implements UserDao{
    @Override
    public void save() {
        System.out.println("保存操作");
    }
    @Override
    public int find() {
        System.out.println("查找操作");
        return 1;
    }
}