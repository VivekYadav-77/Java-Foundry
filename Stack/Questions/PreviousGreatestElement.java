package Questions;
import java.util.Stack;

class PreviousGreatestElement {
    static void CalculatePGE(int a[]) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            while ((!stack.isEmpty()) && (a[i] > a[stack.peek()])) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                System.out.println("- no PGE for" + a[i]);
                stack.push(i);
            } else {
                System.out.println("PGE for" + a[i] + " is : " + a[stack.peek()]);
                stack.push(i);
            }
        }
    }

    public static void main(String[] args) {
        int a[] = { 12, 10, 20, 22, 15, 14, 18, 32, 20, 22, 19 };
        CalculatePGE(a);
    }
}
