package wang.yuchao.design;

/**
 * 中介者模式
 * Created by wangyuchao on 2018/4/18.
 */
public class ColleagueClient {

    //同事抽象类
    public abstract class Colleague {
        private Mediator mediator;

        public Colleague(Mediator mediator) {
            this.mediator = mediator;
        }

        public Mediator getMediator() {
            return mediator;
        }
    }

    //具体同事类
    public class ConcreteColleagueA extends Colleague {
        public ConcreteColleagueA(Mediator mediator) {
            super(mediator);
        }

        public void someOperationA() {
            getMediator().changed(this);
        }
    }

    public class ConcreteColleagueB extends Colleague {
        public ConcreteColleagueB(Mediator mediator) {
            super(mediator);
        }

        public void someOperationB() {
            getMediator().changed(this);
        }
    }

    public class ConcreteColleagueC extends Colleague {
        public ConcreteColleagueC(Mediator mediator) {
            super(mediator);
        }

        public void someOperationC() {
            getMediator().changed(this);
        }
    }

    //中介接口
    public interface Mediator {
        public void changed(Colleague colleague);
    }

    //具体中介
    public class ConcreteMediator implements Mediator {

        private ConcreteColleagueA colleagueA;
        private ConcreteColleagueB colleagueB;
        private ConcreteColleagueC colleagueC;

        public void setConcreteColleagueA(ConcreteColleagueA colleague) {
            this.colleagueA = colleague;
        }

        public void setConcreteColleagueB(ConcreteColleagueB colleague) {
            this.colleagueB = colleague;
        }

        public void setConcreteColleagueC(ConcreteColleagueC colleagueC) {
            this.colleagueC = colleagueC;
        }

        /**
         * 统一由中介处理关系同事类之间的关系
         */
        public void changed(Colleague colleague) {
            if (colleague == colleagueA) {
                colleagueB.someOperationB();
                colleagueC.someOperationC();
            } else if (colleague == colleagueB) {
                colleagueA.someOperationA();
                colleagueC.someOperationC();
            } else if (colleague == colleagueC) {
                colleagueA.someOperationA();
                colleagueB.someOperationB();
            }
        }
    }

    public void test() {
        //客户端实现
        ConcreteMediator mediator = new ConcreteMediator();

        ConcreteColleagueA colleagueA = new ConcreteColleagueA(mediator);
        ConcreteColleagueB colleagueB = new ConcreteColleagueB(mediator);
        ConcreteColleagueC colleagueC = new ConcreteColleagueC(mediator);

        mediator.setConcreteColleagueA(colleagueA);
        mediator.setConcreteColleagueB(colleagueB);
        mediator.setConcreteColleagueC(colleagueC);

        colleagueA.someOperationA();
    }

    public static void main(String[] args) {
        new ColleagueClient().test();
    }
}
