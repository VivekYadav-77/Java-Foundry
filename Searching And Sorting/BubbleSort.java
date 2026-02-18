import java.util.Scanner;
import java.util.Arrays;

public class BubbleSort {
    public static void swap(int a[], int i, int j) {
        int k = a[i];
        a[i] = a[j];
        a[j] = k;
    }

    public static void smartBubbleSort(int a[], boolean isAscending) {
        for (int i = 0; i < a.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (isAscending ? (a[j] > a[j + 1]) : (a[j] < a[j + 1])) {
                    swap(a, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }

    enum SortOrder {
        ASCENDING, DESCENDING
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.printf("Enter the Element at the index %d\n", i);
            array[i] = sc.nextInt();
        }
        sc.nextLine();
        System.out.println("Here is your array" + Arrays.toString(array));
        SortOrder selectedOrder = null;
        while (selectedOrder == null) {
            System.out.println("\nSelect sort order:");
            System.out.println("1: Ascending");
            System.out.println("2: Decending ");
            String input = sc.nextLine().trim();
            switch (input) {
                case "1" -> selectedOrder = SortOrder.ASCENDING;
                case "2" -> selectedOrder = SortOrder.DESCENDING;
                default -> System.out.println("Error please enter 1 or 2");
            }
        }
        smartBubbleSort(array, selectedOrder == SortOrder.ASCENDING);
        System.out.println("Here is your sorted  array" + Arrays.toString(array));
        sc.close();

    }
}