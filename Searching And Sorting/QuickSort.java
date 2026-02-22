
//QUICK SORT ALGO TC = O(nlogn)
import java.util.Scanner;
import java.util.Arrays;

public class QuickSort {
    public static void Swap(int[] a, int i, int j) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

    public static int GetMedianOFindex(int[] a, int low, int high) {
        int median = high + (high - low) / 2;
        if ((a[low] > a[median]) ^ (a[low] > a[high])) {
            return low;
        } else if ((a[median] < a[low]) ^ (a[median] < a[high])) {
            return median;
        } else {
            return high;
        }
    }

    public static void Quicksort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        if (high - low >= 2) {
            int medianIndex = GetMedianOFindex(a, low, high);
            Swap(a, high, medianIndex);
        }
        int swap = low - 1;
        int Pivote = a[high];
        for (int j = low; j < high; j++) {
            if (a[j] < Pivote) {
                swap = swap + 1;
                Swap(a, j, swap);
            }
        }
        swap = swap + 1;
        Swap(a, high, swap);
        Quicksort(a, low, swap - 1);
        Quicksort(a, swap + 1, high);
        return;

    }

    public static void main(String[] args) {
        int Pivoteindex = -1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int size = sc.nextInt();
        int[] a = new int[size];
        for (int j = 0; j < size; j++) {
            System.out.printf("Enter the element at the index %d: ", j);
            a[j] = sc.nextInt();
        }
        sc.nextLine();
        System.out.println("Here is your array" + Arrays.toString(a));
        while (Pivoteindex == -1) {
            System.out.println("\nChoose your pivot element postiton");
            System.out.println("1:Start");
            System.out.println("2:End");
            System.out.println("3:Median");
            System.out.println("4:TO enter the particular postition");
            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    Pivoteindex = 0;
                    break;
                case "2":
                    Pivoteindex = a.length - 1;
                    break;
                case "3":
                    Pivoteindex = (a.length - 1) / 2;
                    break;
                case "4":
                    System.out.printf("Enter your custome postion between 1 to %d ", (a.length));
                    int selection = sc.nextInt();
                    if (selection >= 1 && selection <= a.length) {
                        Pivoteindex = selection - 1;
                        break;
                    }
                    System.out.printf("Invalid postion %d.", selection);
                    break;
                default:
                    System.out.println("Invalid input enter 1, 2, 3 or 4");
            }
        }
        Swap(a, Pivoteindex, a.length - 1);
        int swap = -1;
        int Pivote = a[a.length - 1];

        for (int j = 0; j < a.length - 1; j++) {
            if (a[j] < Pivote) {
                swap = swap + 1;
                Swap(a, j, swap);
            }
        }
        swap = swap + 1;
        Swap(a, a.length - 1, swap);
        Quicksort(a, 0, swap - 1);
        Quicksort(a, swap + 1, a.length - 1);
        System.out.println("Here is your array" + Arrays.toString(a));

        sc.close();
    }
}