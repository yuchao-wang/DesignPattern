package wang.yuchao.design;

/**
 * Created by wangyuchao on 2018/4/18.
 */
public class AdapterClient {
    public class Adaptee {
        public void originalMethod() {
        }
    }

    public interface Target {
        public void method();
    }

    //对象适配器
    public class Adapter1 implements Target {
        private Adaptee adaptee;

        public Adapter1(Adaptee adaptee) {
            this.adaptee = adaptee;
        }

        @Override
        public void method() {
            adaptee.originalMethod();
        }
    }

    //类适配器
    public class Adapter2 extends Adaptee implements Target {
        @Override
        public void method() {
            super.originalMethod();
        }
    }

    public static void main(String[] args) {
        ...
    }
}
