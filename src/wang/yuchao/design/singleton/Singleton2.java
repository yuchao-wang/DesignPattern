package wang.yuchao.design.singleton;

/**
 * 懒汉式
 */
public class Singleton2 {
    private static Singleton2 instance = null;

    private Singleton2() {
    }

    public synchronized static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}