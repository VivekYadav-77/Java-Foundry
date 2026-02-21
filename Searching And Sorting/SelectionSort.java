import java.util.Scanner;
import java.util.Arrays;

public class SelectionSort {
    public static void Swap(int[] a, int i, int targetIndex) {
        System.out.println("in the swap function");
        int temp = a[i];
        a[i] = a[targetIndex];
        a[targetIndex] = temp;
    }

    public static void SelectionSortFun(int a[], boolean isAscending) {
        for (int i = 0; i < a.length - 1; i++) {
            int targetIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                System.out.println("in the second loop");
                if (isAscending ? (a[j] < a[targetIndex]) : (a[j] > a[targetIndex])) {
                    System.out.println("in the condition");
                    targetIndex = j;
                }
            }
            if (targetIndex != i) {
                System.out.println("swap condition");
                Swap(a, i, targetIndex);
            }
        }
    }

    enum SortOrder {
        ASCENDING, DESCENDING;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int size = sc.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.printf("Enter the Element at index %d:", i);
            array[i] = sc.nextInt();
        }
        sc.nextLine();
        System.out.println("Here is your array" + Arrays.toString(array));
        SortOrder selectedorder = null;
        while (selectedorder == null) {
            System.out.println("\n Select your order");
            System.out.println("1: Ascending order");
            System.out.println("2: Descending order");
            String order = sc.nextLine().trim();
            switch (order) {
                case "1" -> selectedorder = SortOrder.ASCENDING;
                case "2" -> selectedorder = SortOrder.DESCENDING;
                default -> System.out.println("Error wrong input enter 1 or 2");

            }
        }
        SelectionSortFun(array, selectedorder == SortOrder.ASCENDING);
        System.out.println("Here is your sorted array:" + Arrays.toString(array));
        sc.close();
    }
}