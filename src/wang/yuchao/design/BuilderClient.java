package wang.yuchao.design;

/**
 * Created by wangyuchao on 2018/4/18.
 */
public class BuilderClient {
    public interface Builder {
        public void buildPartA();

        public void buildPartB();

        public void buildPartC();

        Product getResult();
    }

    public interface Product {
    }

    //具体建造者
    public class ConcreteBuilder implements Builder {
        @Override
        public void buildPartA() {
        }

        @Override
        public void buildPartB() {
        }

        @Override
        public void buildPartC() {
        }

        @Override
        public Product getResult() {
            return null;
        }
    }

    //指导者
    public class Director {
        private Builder builder;

        public Director(Builder builder) {
            this.builder = builder;
        }

        public void buildAll() {
            builder.buildPartA();
            builder.buildPartB();
            builder.buildPartC();
        }
    }

    public void client() {
        ConcreteBuilder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        director.buildAll();
        Product product = builder.getResult();
    }

    public static void main(String[] args) {
        ...
    }
}
