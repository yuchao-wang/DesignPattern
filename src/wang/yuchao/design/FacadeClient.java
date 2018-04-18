package wang.yuchao.design;

public class FacadeClient {
    public void test() {
        AModuleApi a = new AModuleImpl();
        a.testA();
        BModuleApi b = new BModuleImpl();
        b.testB();
        CModuleApi c = new CModuleImpl();
        c.testC();
    }

    public static void main(String[] args) {
        new FacadeClient().test();
    }
}
