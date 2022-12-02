package ChainOfResponsibilityPattern;

/**
 * 责任链模式
 * @author 秋玄
 * @version 1.0
 * @email qiu_2022@aliyun.com
 * @project DesignModel
 * @package ChainOfResponsibilityPattern
 * @date 2022-10-25-09:52
 * @since 1.0
 */
public class ChainOfResponsibility {
    public static void main(String[] args) {
        Handler instructor = new Instructor();
        Handler dean = new Dean();
        instructor.setNext(dean);
        Handler principal = new Principal();
        dean.setNext(principal);
        instructor.HandlerRequest(30);
    }
}

abstract class Handler{
    protected Handler next;

    public void setNext(Handler next){
        this.next = next;
    }

    public abstract void HandlerRequest(int request);
}

// 辅导员
class Instructor extends Handler{
    @Override
    public void HandlerRequest(int request) {
        if (request <= 7) {
            System.out.println("辅导员同意批假");
        } else {
            if (next != null){
                System.out.println("辅导员同意批假");
                next.HandlerRequest(request);
            } else {
                System.out.println("无法审批");
            }
        }
    }
}

// 院长
class Dean extends Handler{
    @Override
    public void HandlerRequest(int request) {
        if (request <= 15) {
            System.out.println("院长同意批假");
        } else {
            if (next != null){
                System.out.println("院长同意批假");
                next.HandlerRequest(request);
            } else {
                System.out.println("无法审批");
            }
        }
    }
}

// 校长
class Principal extends Handler{
    @Override
    public void HandlerRequest(int request) {
        if (request <= 30) {
            System.out.println("校长同意批假");
        } else {
            if (next != null){
                next.HandlerRequest(request);
            } else {
                System.out.println("无法审批");
            }
        }
    }
}
