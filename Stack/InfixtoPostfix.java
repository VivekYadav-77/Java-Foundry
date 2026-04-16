import java.util.ArrayDeque;
import java.util.Deque;

class InfixtoPostfix {
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

    static void infixtoPostfix(String exp) {
        Deque<Character> s = new ArrayDeque<>();
        StringBuilder PostFixExpe = new StringBuilder();
        for (int i = 0; i < exp.length(); i++) {
            if (isOperands(exp.charAt(i))) {
                PostFixExpe.append(exp.charAt(i));
            } else if (exp.charAt(i) == '(') {
                s.push(exp.charAt(i));

            } else if (exp.charAt(i) == ')') {
                while (!s.isEmpty() && s.peek() != '(') {
                    PostFixExpe.append(s.pop());

                }
                if (!s.isEmpty() && s.peek() != '(') {
                    return;
                } else {
                    s.pop();
                }
            } else {
                while (!s.isEmpty() &&
                        ((precedence(s.peek()) > precedence(exp.charAt(i))) ||
                                (precedence(s.peek()) == precedence(exp.charAt(i)) && exp.charAt(i) != '^'))
                        &&
                        s.peek() != '(') {
                    PostFixExpe.append(s.pop());

                }
                s.push(exp.charAt(i));

            }

        }
        while (!s.isEmpty()) {
            PostFixExpe.append(s.pop());

        }
        System.out.println("here is the Postfix expression: " + PostFixExpe);

    }

    public static void main(String[] args) {
        String expression = "a+b*(c^d-e)^(f+g*h)-i";
        infixtoPostfix(expression);

    }
}