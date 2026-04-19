import java.util.ArrayDeque;
import java.util.Deque;

class PostfixToInfix {
    static boolean isOperand(char a) {
        return ((a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z'));

    }

    static String PostToInfix(String exp) {
        Deque<String> s = new ArrayDeque<>();
        for (int i = 0; i < exp.length(); i++) {
            if (isOperand(exp.charAt(i))) {
                s.push(String.valueOf(exp.charAt(i)));
            } else {
                if (s.size() < 2) {
                    return "Error: Invalid Prefix Expression";
                }
                String fO = s.pop();
                String sO = s.pop();
                String result = "(" + sO + String.valueOf(exp.charAt(i)) + fO + ")";
                s.push(result);

            }
        }
        if (s.size() != 1) {
            return "Error: Invalid Prefix Expression";
        }
        return s.pop();

    }

    public static void main(String[] args) {
        String expression = "abcd^e-fgh*+^*+i-";
        String result = PostToInfix(expression);
        System.out.println("Prefix expression : " + expression);
        System.out.println("Infix Expresion: " + result);

    }
}