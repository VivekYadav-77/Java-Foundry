import java.util.Scanner;
import java.util.Arrays;

public class InsertionSort {
    public static void InsertionSortFun(int[] a, boolean isAscending) {
        for (int i = 1; i < a.length; i++) {
            int currentElement = a[i];
            int j = i - 1;
            while (j >= 0 && (isAscending ? (a[j] > currentElement) : (a[j] < currentElement))) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = currentElement;
        }

    }

    enum SortOrder {
        ASCENDING, DESCENDING;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int size = sc.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.printf("Enter the element at index %d :", i);
            array[i] = sc.nextInt();
        }
        sc.nextLine();
        System.out.println("Here is your array" + Arrays.toString(array));
        SortOrder selectorder = null;
        while (selectorder == null) {
            System.out.println("\n Select your order");
            System.out.println("1: Ascending");
            System.out.println("2: Descending");
            String order = sc.nextLine().trim();
            switch (order) {
                case "1" -> selectorder = SortOrder.ASCENDING;
                case "2" -> selectorder = SortOrder.DESCENDING;
                default -> System.out.println("Error wrong input enter 1 or 2 ");
            }

        }
        sc.close();
        InsertionSortFun(array, selectorder == SortOrder.ASCENDING);
        System.out.println("Here is your sorted array: " + Arrays.toString(array));
    }
}