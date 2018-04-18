package wang.yuchao.design;

import java.util.ArrayList;

/**
 * Created by wangyuchao on 2018/4/18.
 */
public class ObserverClient {
    public interface Observer {
        public void update(Subject subject);
    }

    public class ConcreteObserver implements Observer {
        private String observerState;

        public void update(Subject subject) {
            observerState = ((ConcreteSubject) subject).getSubjectState();
        }
    }

    public class Subject {
        private ArrayList<Observer> observers = new ArrayList<Observer>();

        public void attach(Observer observer) {
            observers.add(observer);
        }

        public void detach(Observer observer) {
            observers.remove(observer);
        }

        protected void notifyObservers() {
            for (Observer observer : observers) {
                observer.update(this);
            }
        }
    }

    public class ConcreteSubject extends Subject {
        private String subjectState;

        public String getSubjectState() {
            return subjectState;
        }

        public void setSubjectState(String subjectState) {
            this.subjectState = subjectState;
            this.notifyObservers();
        }
    }

    public void test() {
        //创建被观察者
        ConcreteSubject subject = new ConcreteSubject();
        //创建观察者
        ConcreteObserver observer1 = new ConcreteObserver();
        ConcreteObserver observer2 = new ConcreteObserver();
        //添加观察着
        subject.attach(observer1);
        subject.attach(observer2);
        //被观察者调用方法
        subject.setSubjectState("大家伙过来领报纸了");
    }

    public static void main(String[] args) {
        new ObserverClient().test();
    }
}
