public class StackCalculator extends Calculator {

    public String infixtopostfix(String expr){
        String str = "";
        Stack stack = new StackAsArray();
        ExpTokenizer tokenExpr = new ExpTokenizer(expr);

        while (tokenExpr.hasMoreElements()) {
            Object token = tokenExpr.nextElement();

            if (token instanceof OpenBracket){
                stack.push(token);
                 }
            else if (token instanceof CloseBracket) {
                Object ch = stack.pop();
                while (!(ch instanceof OpenBracket)) {
                    str = str + ch.toString();
                    ch = stack.pop();
                }

            }

            else if (token instanceof BinaryOp){
                Object ch = stack.pop();
                while ((ch instanceof BinaryOp) && (((BinaryOp) ch).getPrecedence() >= ((BinaryOp) token).getPrecedence()))
                {
                    str = str + ch;
                    ch = stack.pop();
                    }
                stack.push(token);
            }
            else if (token instanceof ValueToken){
                str = str + token;

            }
        }
        while (!stack.isEmpty()){
            str = str + stack.pop();

        }
        return str;
    }

    public double evaluate (String expr){
        ExpTokenizer tokenExpr = new ExpTokenizer(expr);
        Stack stack = new StackAsArray();
        double res = 0;
        while (tokenExpr.hasMoreElements()) {
            Object token = tokenExpr.nextElement();
            if (token instanceof BinaryOp){
                ValueToken x1 = (ValueToken) stack.pop();
                ValueToken x2 = (ValueToken) stack.pop();
                res = ((BinaryOp) token).operate(x1.getValue(), x2.getValue());
                ValueToken res2 = new ValueToken(res);
                stack.push(res2);
                }
            else {
                stack.push(token);
            }
              }
        ValueToken res3 = (ValueToken) stack.pop();
        return res3.getValue();
    }

}
