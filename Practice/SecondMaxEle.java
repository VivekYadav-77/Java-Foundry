public class SecondMaxEle{
     public static void main(String[] args) {
        int[] arr = {10, 10, 8};
        Integer first = null;
        Integer second = null;
        for (int current : arr) {
            if (first == null || current > first) {
                second = first;
                first = current;
            }
            else if (current != first && (second == null || current > second)) {
                second = current;
            }
        }
        if (second != null) {
            System.out.println("Second largest: " + second);
        } else {
            System.out.println("No second largest distinct element");
        }
    }

}  