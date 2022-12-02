package MementoPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 备忘录模式
 * @author 秋玄
 * @version 1.0
 * @email qiu_2022@aliyun.com
 * @project DesignPattern
 * @package MementoPattern
 * @date 2022-10-25-14:56
 * @since 1.0
 */
public class MementoPattern {
    public static void main(String[] args) {
        Caretaker caretaker = new Caretaker();
        Originator originator = new Originator();

        originator.setState("1024");
        Memento backup1 = originator.createMemento();
        caretaker.addMemento(backup1);

        originator.setState("2048");
        Memento backup2 = originator.createMemento();
        caretaker.addMemento(backup2);

        originator.setState("4096");
        Memento backup3 = originator.createMemento();
        caretaker.addMemento(backup3);

        System.out.println(originator.getState());

        caretaker.showMemento();

        // 还原状态
        Memento memento = caretaker.getMemento(2);
        originator.setMemento(memento);

        System.out.println("还原后的状态：" + originator.getState());
    }
}

// 原发器
class Originator{
    private String state;

    public void setState(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }

    public Memento createMemento(){
        return new Memento(state);
    }

    public void setMemento(Memento memento){
        state = memento.getState();
    }
}

class Memento{
    private String state;

    public Memento(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }
}

class Caretaker{
    private List<Memento> mementoList = new ArrayList<>();

    public void addMemento(Memento memento){
        mementoList.add(memento);
    }

    public Memento getMemento(int index){
        // 这里最好要做合法性判断
        return mementoList.get(index - 1);
    }

    public void showMemento(){
        int cnt = 1;
        for (Memento memento : mementoList) {
            System.out.println("第 " + cnt + "次备份，状态为：" + memento.getState());
            cnt++;
        }
    }
}
