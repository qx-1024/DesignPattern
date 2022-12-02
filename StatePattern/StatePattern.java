package StatePattern;

/**
 * 状态模式
 * @author 秋玄
 * @version 1.0
 * @email qiu_2022@aliyun.com
 * @project DesignPattern
 * @package StatePattern
 * @date 2022-10-25-16:36
 * @since 1.0
 */
public class StatePattern {
    public static void main(String[] args) {
        Context context = new Context();
        System.out.println(context.getState());

        context.request();
        context.request();
        context.request();

        System.out.println(context.getState());

        context.request();

        System.out.println(context.getState());

        context.request();
    }
}

// 贩卖机
class Context{
    private int count;
    private State state;

    public Context(){
        count = 3;
        state = new StateA();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    // 购买饮料
    public void request(){
        state.handler(this);
    }
}

interface State{
    void handler(Context context);
}

// 有货
class StateA implements State{
    @Override
    public void handler(Context context) {
        int count = context.getCount();
        if (count >= 1){
            System.out.println("购买成功");
            context.setCount(count - 1);
            if (context.getCount() == 0){
                context.setState(new StateB());
            }
        } else {
            System.out.println("无货，购买失败");
        }
    }
}

// 无货
class StateB implements State{
    @Override
    public void handler(Context context) {
        int count = context.getCount();
        if (count == 0){
            System.out.println("购买失败，等待补货");
            context.setCount(5);
            System.out.println("补货成功，请重新购买");
            context.setState(new StateA());
        }
    }
}
