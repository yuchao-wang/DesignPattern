package wang.yuchao.design.singleton;

/**
 * 内部类：使用 JVM 保持
 */
public class Singleton3 {
    private Singleton3() {
    }

    public static class SingletonHolder {
        private static Singleton3 instance = new Singleton3();
    }

    public static Singleton3 getInstance() {
        return SingletonHolder.instance;
    }
}