public class TreeCalculator extends Calculator{

    public double evaluate (String expr){
        ExpressionTree expTree = new ExpressionTree();
        expTree.BuildExpressionTree(expr);
    }
    private double evaluateExpression(TreeNode node){
        double result = 0;
        if (node.data instanceof BinaryOp){
            double operand1 = evaluateExpression(node.left);
            double operand2 = evaluateExpression(node.right);
            result = ((BinaryOp) node.data).operate(operand1,operand2);
        }
        else {
            ValueToken token = (ValueToken)node.data;
            result = token.getValue();
        }
        return result;
    }
}
