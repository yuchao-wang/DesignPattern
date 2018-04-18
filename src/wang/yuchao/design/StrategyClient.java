package wang.yuchao.design;

/**
 * 策略模式
 * Created by wangyuchao on 2018/4/18.
 */
public class StrategyClient {
    public class Context {
        private Strategy strategy;

        public Context(Strategy strategy) {
            this.strategy = strategy;
        }

        public void contetextMethod() {
            this.strategy.method();
        }
    }

    public interface Strategy {
        public void method();
    }

    public class ConcreteStrategyA implements Strategy {
        @Override
        public void method() {
            System.out.println("A算法");
        }
    }

    public class ConcreteStrategyB implements Strategy {
        @Override
        public void method() {
            System.out.println("B算法");
        }
    }

    public class ConcreteStrategyC implements Strategy {
        @Override
        public void method() {
            System.out.println("C算法");
        }
    }

    public void test() {
        //这里对象可以是ABC中任意一个
        ConcreteStrategyA concreteStrategyA = new ConcreteStrategyA();
        Context context = new Context(concreteStrategyA);
        context.contetextMethod();
    }

    public static void main(String[] args) {
        new StrategyClient().test();
    }
}
