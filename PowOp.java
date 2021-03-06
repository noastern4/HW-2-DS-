
public class PowOp extends BinaryOp {
    private char powOp;

    public PowOp(){
        super();
        this.powOp='^';
    }
    public double operate(double left, double right){
        return Math.pow(left,right);
    }

    public double getPrecedence(){
        return 3;
    }

    public String toString(){
        return "^";
    }
}
