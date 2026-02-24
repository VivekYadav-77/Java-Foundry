// MERGE SORT ALOG T.C = O(nlogn)
import java.util.Arrays;
import java.util.Scanner;
public class MergeSort {
    enum SortingOrder {
        ASCENDING, DESCENDING;
    }

    public static void merge(int[] a, int low, int high, int mid, int[] b, boolean isAscending) {
        for (int s = low; s <= high; s++) {
            b[s] = a[s];
        }
        int i = low;
        int j = mid + 1;
        int k = low;
        while (i <= mid && j <= high) {
            if (isAscending ? (b[i] <= b[j]) : (b[i] >= b[j])) {
                a[k] = b[i];
                i++;
            } else {
                a[k] = b[j];
                j++;
            }
            k++;
        }
      while (i <= mid) {
            a[k] = b[i];
            i++;
            k++;
        }
        
    }

    public static void mergeSort(int[] a, int low, int high, int[] b, boolean isAscending) {
        if (low < high) {
            int mid = low+(high-low) / 2;
            mergeSort(a, low, mid, b, isAscending);
            mergeSort(a, mid + 1, high, b, isAscending);
            merge(a, low, high, mid, b, isAscending);
        }
        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array :");
        int size = sc.nextInt();
        int[] a = new int[size];
        int[] b = new int[size];
        System.out.println("Enter the element in the array");
        for (int i = 0; i < size; i++) {
            System.out.printf("Enter the element at index %d :", i);
            a[i] = sc.nextInt();
        }
        sc.nextLine();

        SortingOrder choosen = null;
        while (choosen == null) {
            System.out.println("Choose your order: ");
            System.out.println("1:ASCENDING ");
            System.out.println("2:DESCENDING ");
            String order = sc.nextLine().trim();
            switch (order) {
                case "1" -> choosen = SortingOrder.ASCENDING;
                case "2" -> choosen = SortingOrder.DESCENDING;
                default -> System.out.println("Wrong input enter 1 or 2");
            }

        }
        mergeSort(a, 0, a.length - 1, b, choosen == SortingOrder.ASCENDING);
        System.out.println("Here is the array :" + Arrays.toString(a));
        sc.close();
    }

}
