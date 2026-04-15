import java.util.Stack;

class LargestAreaInHistogramApproach1 {
    static int[] NSE(int histoData[], Stack<Integer> stack) {
        int size = histoData.length;
        int NSEarr[] = new int[size];
        stack.push(size - 1);
        NSEarr[size - 1] = size;
        for (int i = size - 2; i >= 0; i--) {
            while (!stack.isEmpty() && histoData[stack.peek()] >= histoData[i]) {
                stack.pop();
            }
            int nSCurrent = stack.isEmpty() ? size : stack.peek();
            NSEarr[i] = nSCurrent;
            stack.push(i);
        }

        return NSEarr;

    }

    static int[] PSE(int histoData[], Stack<Integer> stack) {
        int size = histoData.length;
        int PSEarr[] = new int[size];
        stack.push(0);
        PSEarr[0] = -1;
        for (int i = 1; i < size; i++) {
            while (!stack.isEmpty() && histoData[stack.peek()] >= histoData[i]) {
                stack.pop();
            }
            int pSCurrent = stack.isEmpty() ? -1 : stack.peek();
            PSEarr[i] = pSCurrent;
            stack.push(i);
        }
        return PSEarr;
    }

    static void CalculateArea(int histoData[]) {
        Stack<Integer> stack = new Stack<>();

        int pseArr[] = PSE(histoData, stack);

        stack.clear();

        int nseArr[] = NSE(histoData, stack);
        int AreaMax = 0;
        for (int i = 0; i < histoData.length; i++) {
            int result = histoData[i] * ((nseArr[i] - pseArr[i]) - 1);
            if (result > AreaMax) {
                AreaMax = result;
            }
        }
        System.out.println("The maximum Area is :"+AreaMax);

    }

    public static void main(String args[]) {
        int histoData[] = { 11, 3, 4, 4, 1, 5, 6 };
        CalculateArea(histoData);

    }
}