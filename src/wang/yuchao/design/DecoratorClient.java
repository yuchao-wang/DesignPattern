package wang.yuchao.design;

/**
 * Created by wangyuchao on 2018/4/18.
 */
public class DecoratorClient {
    //组件对象
    public interface Component {
        public abstract void operation();
    }

    public class ConcreteComponent implements Component {
        @Override
        public void operation() {
            System.out.println("具体组件对象");
        }
    }

    //装饰者
    public abstract class Decorator implements Component {
        private Component component;

        protected Decorator(Component component) {
            this.component = component;
        }

        @Override
        public void operation() {
            System.out.println("装饰者原始方法...");
        }
    }

    //具体三个不同的装饰者A,B,C
    public class ConcreteDecoratorA extends Decorator {

        protected ConcreteDecoratorA(Component component) {
            super(component);
        }

        public void operationA() {
            System.out.println("装饰者A新的方法...");
        }

        @Override
        public void operation() {
            super.operation();
            operationA();
        }
    }

    public class ConcreteDecoratorB extends Decorator {

        protected ConcreteDecoratorB(Component component) {
            super(component);
        }

        public void operationB() {
            System.out.println("装饰者B新的方法...");
        }

        @Override
        public void operation() {
            super.operation();
            operationB();
        }
    }


    public class ConcreteDecoratorC extends Decorator {

        protected ConcreteDecoratorC(Component component) {
            super(component);
        }

        public void operationC() {
            System.out.println("装饰者C新的方法...");
        }

        @Override
        public void operation() {
            super.operation();
            operationC();
        }
    }

    //IO流就是装饰者模式
    public void test() {
        Component component = new ConcreteComponent();
        Decorator decorator = new ConcreteDecoratorC(new ConcreteDecoratorB(new ConcreteDecoratorA(component)));
        decorator.operation();
    }

    public static void main(String[] args) {
        new DecoratorClient().test();
    }
}
