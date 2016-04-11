public class Evaluate
{
    public static void main(String[] args)
    {
        String expression = "(1+((2+3)*(4*5)))";
        System.out.println(expression);

        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();

        for(int i = 0; i < expression.length(); i++)
        {
            String s = expression.substring(i, i+1);
            if (s.equals("(")); 
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals(")"))
            {
                String op = ops.pop();
                if (op.equals("+")) vals.push(vals.pop() + vals.pop());
                else if (op.equals("*")) vals.push(vals.pop() * vals.pop());
            }
            else vals.push(Double.parseDouble(s));
        }
        System.out.println(vals.pop());
    }
}