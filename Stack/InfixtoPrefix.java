import java.util.ArrayDeque;
import java.util.Deque;

class InfixtoPrefix {
    static int precedence(char s) {
        return switch (s) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

    static boolean isOperands(char a) {
        return ((a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z'));
    }

    static void infixtoPrefix(String exp) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder PreFixExpe = new StringBuilder();

        for (int i = exp.length() - 1; i >= 0; i--) {
            if (isOperands(exp.charAt(i))) {
                PreFixExpe.append(exp.charAt(i));
            } else if (exp.charAt(i) == ')') {
                stack.push(exp.charAt(i));

            } else if (exp.charAt(i) == '(') {
                while (!stack.isEmpty() && stack.peek() != ')') {
                    PreFixExpe.append(stack.pop());

                }
                if (!stack.isEmpty() && stack.peek() != ')') {
                    return;
                } else {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && stack.peek() != ')' &&
                        ((precedence(stack.peek()) > precedence(exp.charAt(i))) ||
                                (precedence(stack.peek()) == precedence(exp.charAt(i)) && exp.charAt(i) != '^'))) {

                    PreFixExpe.append(stack.pop());
                }
                stack.push(exp.charAt(i));

            }

        }
        while (!stack.isEmpty()) {
            PreFixExpe.append(stack.pop());

        }
        System.out.println("here is the Postfix expression: " + PreFixExpe.reverse());

    }

    public static void main(String[] args) {
        String expression = "a+b*(c^d-e)^(f+g*h)-i";
        infixtoPrefix(expression);

    }
}