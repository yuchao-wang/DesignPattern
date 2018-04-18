package wang.yuchao.design;

/**
 * 外观模式
 */
public class FacadeClient {
    public interface AModuleApi {
        void testA();
    }

    public class AModuleImpl implements AModuleApi {
        @Override
        public void testA() {

        }
    }

    public interface BModuleApi {
        void testB();
    }

    public class BModuleImpl implements BModuleApi {
        @Override
        public void testB() {

        }
    }

    public interface CModuleApi {
        void testC();
    }

    public class CModuleImpl implements CModuleApi {
        @Override
        public void testC() {

        }
    }

    public void method() {
        AModuleApi a = new AModuleImpl();
        a.testA();
        BModuleApi b = new BModuleImpl();
        b.testB();
        CModuleApi c = new CModuleImpl();
        c.testC();
    }

    public static void main(String[] args) {
        new FacadeClient().method();
    }
}
