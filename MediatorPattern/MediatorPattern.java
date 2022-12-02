package MediatorPattern;

/**
 * 中介者模式
 * @author 秋玄
 * @version 1.0
 * @email qiu_2022@aliyun.com
 * @project DesignPattern
 * @package MediatorPattern
 * @date 2022-10-25-14:23
 * @since 1.0
 */
public class MediatorPattern {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();

        Colleague1 colleague1 = new Colleague1(mediator);
        Colleague2 colleague2 = new Colleague2(mediator);

        mediator.setColleague1(colleague1);
        mediator.setColleague2(colleague2);

        colleague1.sendMessage("111111");
        colleague2.sendMessage("222222");
    }
}

abstract class Colleague{
    protected Mediator mediator;
}

class Colleague1 extends Colleague{
    public Colleague1(Mediator mediator){
        this.mediator = mediator;
    }

    public void sendMessage(String msg){
        mediator.sendMessage(msg,this);
    }

    public void inform(String msg){
        System.out.println("同事一收到消息：" + msg);
    }
}

class Colleague2 extends Colleague{
    public Colleague2(Mediator mediator){
        this.mediator = mediator;
    }

    public void sendMessage(String msg){
        mediator.sendMessage(msg,this);
    }

    public void inform(String msg){
        System.out.println("同事二收到消息：" + msg);
    }
}

abstract class Mediator{
    public abstract void sendMessage(String msg,Colleague colleague);
}

class ConcreteMediator extends Mediator{
    // 这里只是做一个简单的模拟，若是 colleague 很多的话就需要考虑使用集合存储
    private Colleague1 colleague1;
    private Colleague2 colleague2;

    public void setColleague1(Colleague1 colleague1){
        this.colleague1 = colleague1;
    }

    public void setColleague2(Colleague2 colleague2){
        this.colleague2 = colleague2;
    }

    /*
    List<Colleague>  list = new ArrayList<>();
    public void add(Colleague colleague){
        list.add(colleague);
    }
    */

    @Override
    public void sendMessage(String msg, Colleague colleague) {
        if (colleague == colleague1){
            colleague2.inform(msg);
        } else {
            colleague1.inform(msg);
        }
    }
}
