import java.util.ArrayDeque;
import java.util.Deque;

class LargestrectangleWithAll1 {
    static int CalculateArea(int arr[], int n) {
        Deque<Integer> s = new ArrayDeque<>();
        int topIndex = 0;
        int currValue = 0;
        int res = 0;
        for (int i = 0; i <= n; i++) {
            int currElem = i == n ? 0 : arr[i];
            while (!s.isEmpty() && arr[s.peek()] >= currElem) {
                topIndex = s.pop();
                currValue = arr[topIndex] * (s.isEmpty() ? i : (i - s.peek() - 1));
                res = Math.max(res, currValue);
            }
            s.push(i);
        }

        return res;
    }

    static int MaxArea(int R, int C, int arr[][]) {
        int res = CalculateArea(arr[0], C);
        for (int i = 1; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] != 0) {
                    arr[i][j] += arr[i - 1][j];
                }
                res = Math.max(res, CalculateArea(arr[i], C));

            }

        }
        return res;
    }

    public static void main(String[] args) {
        int matrix[][] = {
                { 0, 1, 1, 0 },
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 0, 0 }
        };
        int R = 4;
        int C = 4;
        int result = MaxArea(R, C, matrix);
        System.out.println("The Maximum Area is :" + result);
    }

}