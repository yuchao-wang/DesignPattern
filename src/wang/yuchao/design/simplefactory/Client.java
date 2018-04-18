package wang.yuchao.design.simplefactory;

/**
 * 简单工厂
 */
public class Client {
    public static void main(String[] args) {
        Api api = Factory.createApi(1);
        api.operation("正在创建简单工厂");
    }
}