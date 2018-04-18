package wang.yuchao.design;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * Created by wangyuchao on 2018/4/18.
 */
public class ProxyDynamicClient {
    public interface Subject {
        public void operation();
    }

    public class RealSubject implements Subject {
        @Override
        public void operation() {
        }
    }

    public class ProxyHandler implements InvocationHandler {
        private Object proxied;

        public ProxyHandler(Object proxied) {
            this.proxied = proxied;
        }

        @Override
        public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
            System.out.println("before");
            Object object = method.invoke(proxied, objects);
            System.out.println("after");
            return object;
        }
    }

    public void test() {
        Subject realSubject = new RealSubject();
        ProxyHandler handler = new ProxyHandler(realSubject);
        Subject proxy = (Subject) Proxy.newProxyInstance(
                realSubject.getClass().getClassLoader(),
                realSubject.getClass().getInterfaces(),
                handler);
        proxy.operation();
    }

    public static void main(String[] args) {
        new ProxyDynamicClient().test();
    }
}
