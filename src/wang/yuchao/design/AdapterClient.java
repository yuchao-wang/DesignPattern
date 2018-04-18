package wang.yuchao.design;

/**
 * 适配器模式：分为两种
 * Created by wangyuchao on 2018/4/18.
 */
public class AdapterClient {

    // 目标
    public interface Target {
        public void method();
    }

    // 适配者
    public class Adaptee {
        public void originalMethod() {
        }
    }

    //第一种：对象适配器
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

    //第二种：类适配器
    public class Adapter2 extends Adaptee implements Target {
        @Override
        public void method() {
            super.originalMethod();
        }
    }

    public void test() {
        new Adapter1(new Adaptee()).method();
        new Adapter2().method();
    }

    public static void main(String[] args) {
        new AdapterClient().test();
    }
}
