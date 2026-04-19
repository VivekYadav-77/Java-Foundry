import java.util.ArrayDeque;
import java.util.Deque;

class PrefixToInfix {
    static boolean isOperand(char a) {
        return ((a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z'));

    }

    static String PreToInfix(String exp) {
        Deque<String> s = new ArrayDeque<>();
        for (int i = exp.length() - 1; i >= 0; i--) {
            if (isOperand(exp.charAt(i))) {
                s.push(String.valueOf(exp.charAt(i)));
            } else {
                if (s.size() < 2) {
                    return "Error: Invalid Postfix Expression";
                }
                String fO = s.pop();
                String sO = s.pop();
                String result = "(" + fO + String.valueOf(exp.charAt(i)) + sO + ")";
                s.push(result);

            }
        }
        if (s.size() != 1) {
            return "Error: Invalid Postfix Expression";
        }

        return s.pop();

    }

    public static void main(String[] args) {
        String expression = "+a-*b^-^cde+f*ghi";
        String result = PreToInfix(expression);
        System.out.println("Prefix Expresion: " + expression);
        System.out.println("Infix Expresion: " + result);

    }
}