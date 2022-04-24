public class StackCalculator extends Calculator {

    public String infixtopostfix(String expr){
        String str = "";
        Stack stack = new StackAsArray();
        ExpTokenizer tokenExpr = new ExpTokenizer(expr);
        Object token = new 
        for (int i = 0; i < expr.length(); i++) {
            char token = expr.charAt(i);
            if (token.equals("(")) {
                stack.push(token);
                 }
            else if (token.equals(")")) {
                char ch = (char) stack.pop();
                while (!ch.equals("(")) {
                    str = str + ch;
                    ch = (char) stack.pop();
                }
            }

            else if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("^")) {
                char ch = (char) stack.pop();
                while (!(ch.equals("+") || ch.equals("-")) )
            }
            }
        }

    }
}
