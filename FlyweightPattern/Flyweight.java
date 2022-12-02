package FlyweightPattern;

/**
 * 享元模式
 * @author 秋玄
 * @version 1.0
 * @email qiu_2022@aliyun.com
 * @project DesignModel
 * @package FlyweightPattern
 * @date 2022-10-24-21:44
 * @since 1.0
 */
public class Flyweight {
    public static void main(String[] args) {
        PieceFactory factory = new PieceFactory();

        Piece whitePiece1 = factory.getPiece(0);
        System.out.println(whitePiece1);
        whitePiece1.draw(10,10);

        Piece whitePiece2 = factory.getPiece(0);
        System.out.println(whitePiece2);
        whitePiece2.draw(20,20);

        Piece whitePiece3 = factory.getPiece(0);
        System.out.println(whitePiece3);

        Piece blackPiece1 = factory.getPiece(1);
        System.out.println(blackPiece1);

        Piece blackPiece2 = factory.getPiece(1);
        System.out.println(blackPiece2);

        Piece blackPiece3 = factory.getPiece(1);
        System.out.println(blackPiece3);
    }
}

class PieceFactory{
    private Piece[] pieces = {new WhitePiece(),new BlackPiece()};
    public Piece getPiece(int key){
        if (key == 0) return pieces[0];
        else return pieces[1];
    }
}

abstract class Piece{
    protected String color;
    public abstract void draw(int x,int y);
}

class WhitePiece extends Piece{
    public WhitePiece(){
        this.color = "white";
    }
    @Override
    public void draw(int x, int y) {
        System.out.println("draw a " + color + " piece:x = " + x + ",y = " + y);
    }
}

class BlackPiece extends Piece{
    public BlackPiece(){
        this.color = "black";
    }
    @Override
    public void draw(int x, int y) {
        System.out.println("draw a " + color + " piece:x = " + x + ",y = " + y);
    }
}
