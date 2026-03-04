// Raw code not good yet it will get efficient one soon
// Time Complexity = O(n+k) where k is range 
// Alert not efficient if Range is > then ArrayLength N . Unecessary frequency and temporary array of lenght range will get created at that point

// Algo--
/* step 1 -- Find out maximum and minimum element of the array and then find the range by (max-min+1)
step 2 -- Make a Frequency array of size range then insert the frequency of occuring element in the original array
step 3 -- Make a Prefix sum array by adding i and i+1 element at i+1
step 4 -- Make a temporary array then pick the elemet starting from the last index of the original array then do if ascending the that l =element-min  and for descending l = max-element then at l index of the Prefix Sum array find a value and use that value as index to fill the selected element in the temporary array 
step 5 -- Copy or fill the element of the temporary array to the original array 
*/

import java.util.Arrays;
import java.util.Scanner;

public class CountSort { 
    enum SortOrder {
        ASCENDING, DESCENDING
    };

    public static void countSort(int[] originalArray, SortOrder order) {
        if (originalArray == null || originalArray.length <= 1) {
            return;
        }
        int min = originalArray[0];
        int max = originalArray[0];
        for (int i = 1; i < originalArray.length; i++) {
            if (originalArray[i] < min)
                min = originalArray[i];
            if (originalArray[i] > max)
                max = originalArray[i];
        }
        int range = max - min + 1;
        if (range > originalArray.length) {
            System.out.println("Count sorting will not be effective for this given array");
            return;
        }
        int[] frequencyArray = new int[range];
        int[] tempArray = new int[originalArray.length];
        for (int i = 0; i < originalArray.length; i++) {
            int index = (order == SortOrder.ASCENDING) ? (originalArray[i] - min) : (max - originalArray[i]);
            frequencyArray[index]++;
        }
        for (int j = 1; j < frequencyArray.length; j++) {
            frequencyArray[j] += frequencyArray[j - 1];
        }
        for (int i = originalArray.length - 1; i >= 0; i--) {
            int index = (order == SortOrder.ASCENDING) ? (originalArray[i] - min) : (max - originalArray[i]);
            tempArray[--frequencyArray[index]] = originalArray[i];

        }
        System.arraycopy(tempArray, 0, originalArray, 0, originalArray.length);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter all array elements separated by spaces (eg: 5 2 9 1): ");
        String input = sc.nextLine().trim();
        String[] stringNumber = input.split("\\s+");
        if (stringNumber.length <= 0) {
            System.out.println("Array size must be greater than 0.");
            sc.close();
            return;

        }
        int[] originalArray = new int[stringNumber.length];
        for (int i = 0; i < stringNumber.length; i++) {
            originalArray[i] = Integer.parseInt(stringNumber[i]);
        }
        SortOrder selectedorder = null;
        do {
            System.out.println("choose your sorting order");
            System.out.println("1:Ascending order");
            System.out.println("2:Descending order");
            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    selectedorder = SortOrder.ASCENDING;
                    break;
                case "2":
                    selectedorder = SortOrder.DESCENDING;
                    break;
                default:
                    System.out.println("Error wrong input enter 1 or 2 ");
            }

        } while (selectedorder == null);
        countSort(originalArray, selectedorder);
        System.out.println("\nHere is array" + Arrays.toString(originalArray));
        sc.close();

    }
}
