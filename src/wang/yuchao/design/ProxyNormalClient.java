package wang.yuchao.design;

/**
 * 普通代理
 * Created by wangyuchao on 2018/4/18.
 */
public class ProxyNormalClient {
    public interface Subject {
        public void operation();
    }

    public class RealSubject implements Subject {
        @Override
        public void operation() {
        }
    }

    public class Proxy implements Subject {
        private Subject subject;

        public Proxy() {
            this.subject = new RealSubject();
        }

        public Proxy(Subject subject) {
            this.subject = subject;
        }

        @Override
        public void operation() {
            System.out.println("before");
            this.subject.operation();
            System.out.println("after");
        }
    }

    public void test() {
        Subject realSubject = new RealSubject();
        Proxy proxy = new Proxy(realSubject);
        proxy.operation();
    }

    public static void main(String[] args) {
        new ProxyNormalClient().test();
    }
}
