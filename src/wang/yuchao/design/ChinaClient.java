package wang.yuchao.design;

/**
 * 责任链模式
 */
public class ChinaClient {
    private static abstract class Handler {
        protected Handler nextHandler;

        public abstract void handle(int price);

        public void setNextHandler(Handler nextHandler) {
            this.nextHandler = nextHandler;
        }
    }

    private static class ConcreteHandler1 extends Handler {
        @Override
        public void handle(int price) {
            if (price < 100) {
                System.out.println("ConcreteHandler1 Handle" + price);
            } else {
                nextHandler.handle(price);
            }
        }
    }

    private static class ConcreteHandler2 extends Handler {
        @Override
        public void handle(int price) {
            if (price < 1000) {
                System.out.println("ConcreteHandler2 Handle" + price);
            } else {
                nextHandler.handle(price);
            }
        }
    }


    private static class ConcreteHandlerN extends Handler {
        @Override
        public void handle(int price) {
            System.out.println("ConcreteHandlerN Handle" + price);
        }
    }

    public static void main(String[] args) {
        ConcreteHandler1 handler1 = new ConcreteHandler1();
        ConcreteHandler2 handler2 = new ConcreteHandler2();
        ConcreteHandlerN handlerN = new ConcreteHandlerN();

        handler1.setNextHandler(handler2);
        handler2.setNextHandler(handlerN);

        handler1.handle(99);
        handler1.handle(999);
        handler1.handle(9999);
    }
}