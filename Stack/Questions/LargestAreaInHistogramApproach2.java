package Questions;
import java.util.ArrayDeque;
import java.util.Deque;

class LargestAreaInHistogramApproach2 {

    static void calculateArea(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        int n = arr.length;

        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : arr[i];

            while (!stack.isEmpty() && arr[stack.peek()] >= currentHeight) {
                int topIndex = stack.pop();

                int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
                int currentArea = arr[topIndex] * width;

                if (currentArea > maxArea) {
                    maxArea = currentArea;
                }
            }
            stack.push(i);
        }

        System.out.println("The maximum Area is: " + maxArea);
    }

    public static void main(String[] args) {
        int[] histoData = { 11, 3, 4, 4, 1, 5, 6 };
        calculateArea(histoData);
    }
}