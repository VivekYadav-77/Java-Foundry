// Radix Sort Time Complexity is O(d.(n+b)) where d is max number n is size b base(10)
/* 
* Algorithm Steps:
 * 1. Find the maximum element in the array to determine the total number of digits.
 * 2. Set the current digit `place` to 1 (the ones place).
 * 3. While `place` is less than or equal to the maximum number:
 * a. Perform a stable Counting Sort on the array based ONLY on the digit at `place`.
 * - Extract the digit using: (number / place) % 10.
 * - For Ascending: Count frequencies normally.
 * - For Descending: Invert the digit using (9 - digit) before counting.
 * - Compute the cumulative prefix sum of the frequency array.
 * - Iterate through the original array backwards (right-to-left) to maintain stability,
 * place elements into a temporary array using the prefix sums, and decrement the count.
 * - Copy the sorted temporary array back to the original array.
 * b. Multiply `place` by 10 to move to the next digit (tens, hundreds, etc.).
 * 4. The array is fully sorted once all digit places of the maximum number are processed.
 * * Time Complexity: O(d * (n + b)) where 'n' is the array size, 'b' is the base (10), and 'd' is the max number of digits.
 * Space Complexity: O(n + b) for the temporary output array and the size-10 frequency array.
 */

import java.util.Scanner;
import java.util.Arrays;

public class RadixSort {
    enum SortOrder {
        ASCENDING, DESCENDING
    };

    public static void CountSort(int[] originalArray, int place, boolean isAscending, int[] tempArray) {
        int[] frequencyArray = new int[10];
        for (int i = 0; i < originalArray.length; i++) {
            int index = (originalArray[i] / place) % 10;
            if (isAscending) {
                frequencyArray[index]++;
            } else {
                frequencyArray[(9 - index)]++;
            }
        }
        for (int i = 1; i < frequencyArray.length; i++) {
            frequencyArray[i] += frequencyArray[i - 1];
        }
        for (int i = originalArray.length - 1; i >= 0; i--) {
            int index = (originalArray[i] / place) % 10;
            if (isAscending) {
                tempArray[--frequencyArray[index]] = originalArray[i];
            } else {
                tempArray[--frequencyArray[(9 - index)]] = originalArray[i];
            }

        }
        System.arraycopy(tempArray, 0, originalArray, 0, originalArray.length);

    }

    public static void radixSort(int[] originalArray, boolean isAscending) {
        if (originalArray.length == 0)
            return;
        int max = originalArray[0];
        for (int i = 1; i < originalArray.length; i++) {
            if (originalArray[i] > max) {
                max = originalArray[i];
            }
        }
        int[] tempArray = new int[originalArray.length];
        for (int place = 1; max / place > 0; place *= 10) {
            CountSort(originalArray, place, isAscending, tempArray);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter all array element seperated by space (e.g: 32 12 1 0 4 )");
        String input = sc.nextLine().trim();
        if (input.isEmpty()) {
            System.out.println("Array cannot be empty.");
            sc.close();
            return;
        }
        String[] stringNum = input.split("\\s+");
        int[] originalArray = new int[stringNum.length];
        for (int i = 0; i < stringNum.length; i++) {
            originalArray[i] = Integer.parseInt(stringNum[i]);
        }
        SortOrder selectedOrder = null;
        do {
            System.out.println("Choose the your sorting order");
            System.out.println("1: Ascending");
            System.out.println("2: Descending");
            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    selectedOrder = SortOrder.ASCENDING;
                    break;
                case "2":
                    selectedOrder = SortOrder.DESCENDING;
                    break;
                default:
                    System.out.println("Error wrong input enter 1 or 2");
                    break;
            }

        } while (selectedOrder == null);
        sc.close();
        radixSort(originalArray, selectedOrder == SortOrder.ASCENDING);
        System.out.println("here is the sorted array" + Arrays.toString(originalArray));

    }
}