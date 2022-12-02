package CommandPattern;

/**
 * 命令模式
 * @author 秋玄
 * @version 1.0
 * @email qiu_2022@aliyun.com
 * @project DesignPattern
 * @package CommandPattern
 * @date 2022-10-25-10:26
 * @since 1.0
 */
public class CommandPattern {
    public static void main(String[] args) {
        // 接收者
        TV tv = new TV();

        // 具体要指定的命令对象
        Command onCommand = new OnCommand(tv);
        Command offCommand = new OffCommand(tv);

        // 请求者
        Invoker invoker = new Invoker();

        // 为设置接受者命令
        invoker.setCommand(onCommand);
        // 执行命令
        invoker.call();
        System.out.println("================");
        invoker.setCommand(offCommand);
        invoker.call();
    }
}

class Invoker{
    private Command command;

    public void setCommand(Command command){
        this.command = command;
    }

    public void call(){
        command.execute();
    }
}

interface Command{
    void execute();  // 执行命令
}

// 开机
class OnCommand implements Command{
    private TV tv;

    public OnCommand(TV tv){
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.onAction();
    }
}

// 关机
class OffCommand implements Command{
    private TV tv;

    public OffCommand(TV tv){
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.offAction();
    }
}

class TV{
    public void onAction(){
        System.out.println("电视机开机");
    }

    public void offAction(){
        System.out.println("电视机关机");
    }
}
