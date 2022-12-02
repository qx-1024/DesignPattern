package ObserverPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式
 * @author 秋玄
 * @version 1.0
 * @email qiu_2022@aliyun.com
 * @project DesignPattern
 * @package ObserverPattern
 * @date 2022-10-25-15:21
 * @since 1.0
 */
public class ObserverPattern {
    public static void main(String[] args) {
        Subject subjectA = new ConcreteSubject("目标A");

        Observer observerB = new ConcreteObserver("张三",subjectA);
        Observer observerC = new ConcreteObserver("李四",subjectA);
        Observer observerD = new ConcreteObserver("王五",subjectA);

        subjectA.setState("更新了");

        System.out.println("===================================");

        subjectA.setState("停更了");
    }
}

// 目标接口
interface Subject{
    void attach(Observer observer); // 增
    void detach(Observer observer); // 删
    void inform();                  // 通知
    void setState(String state);    // 设置状态
    String getState();              // 获取状态
}

class ConcreteSubject implements Subject{
    private String name;
    private String state;
    private List<Observer> observers;

    public String getState() {
        return state;
    }

    @Override
    public void setState(String state) {
        this.state = state;
        System.out.println(name + "的状态发生变化，变化后的状态为：" + state);
        inform();
    }

    public ConcreteSubject(String name){
        state = "未更新";
        this.name = name;
        observers = new ArrayList<>();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void inform() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

// 观察者接口
interface Observer{
    void update();
}

class ConcreteObserver implements Observer{
    private String state;
    private String name;
    private Subject subject;

    public ConcreteObserver(String name,Subject subject){
        this.name = name;
        this.subject = subject;
        subject.attach(this);

        state = subject.getState();
    }

    @Override
    public void update() {
        System.out.println(name + "收到通知");
        state = subject.getState();
        System.out.println(name + "改变后的状态为：" + state);
    }
}
