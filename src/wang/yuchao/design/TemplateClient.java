package wang.yuchao.design;

/**
 * 模板方法模式
 * Created by wangyuchao on 2018/4/18.
 */
public class TemplateClient {
    public abstract class Template {
        public void beforeOperation() {
        }

        public abstract void operation();

        public void afterOperation() {
        }

        public void method() {
            beforeOperation();
            operation();
            afterOperation();
        }
    }

    public class ConcreteTemplate extends Template {
        @Override
        public void operation() {
            System.out.println("具体操作");
        }
    }

    public void test() {
        Template concreteTemplate = new ConcreteTemplate();
        concreteTemplate.method();
    }

    public static void main(String[] args) {
        new TemplateClient().test();
    }
}
