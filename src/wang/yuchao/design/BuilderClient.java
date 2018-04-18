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

    public class Product {
    }

    //具体建造者
    public class ConcreteBuilder implements Builder {
        @Override
        public void buildPartA() {
            System.out.println("建造A部分");
        }

        @Override
        public void buildPartB() {
            System.out.println("建造B部分");
        }

        @Override
        public void buildPartC() {
            System.out.println("建造C部分");
        }

        @Override
        public Product getResult() {
            System.out.println("建造完成");
            return new Product();
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

    public void test() {
        ConcreteBuilder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        director.buildAll();
        Product product = builder.getResult();
    }

    public static void main(String[] args) {
        new BuilderClient().test();
    }
}
