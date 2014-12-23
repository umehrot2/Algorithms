/**
 * Created by uditmehrotra on 22/12/14.
 * 44669100
 */
public class DijkstrasInfixExpression {

    public static void main(String[] args)
    {
        String expr = "(((22*356)+((623*75)*(412+544)))-(60/5))";
        GenericStackLinkedList<Character> operators = new GenericStackLinkedList<Character>();
        GenericStackLinkedList<Integer> operands = new GenericStackLinkedList<Integer>();

        for(int loop = 0; loop < expr.length(); loop++)
        {
            char ch = expr.charAt(loop);

            switch(ch)
            {
                case '(':
                    break;

                case ')':
                    int op1 = operands.pop();
                    int op2 = operands.pop();
                    char oper = operators.pop();
                    if(oper == '+') operands.push(op2 + op1);
                    else if(oper == '-') operands.push(op2 - op1);
                    else if(oper == '*') operands.push(op2 * op1);
                    else if(oper == '/') operands.push(op2 / op1);
                    break;

                case '+':
                case '-':
                case '*':
                case '/':
                    operators.push(ch);
                    break;
                case ' ':
                    break;
                default:
                    char next = expr.charAt(loop + 1);
                    String str = Character.toString(ch);
                    while(Character.isDigit(next))
                    {
                        str += next;
                        loop++;
                        next = expr.charAt(loop + 1);
                    }

                    int operand = Integer.parseInt(str);
                    operands.push(operand);
                    break;


            }
        }

        System.out.println("Result : " + operands.pop());
    }
}
