import java.util.Scanner;

public class BinarySearch {
    public static int BinarySearchFun(int a[], int num, int start, int end) {

        // Recursion way
        /*
         * int mid = start+(end-start)/2;
         * if(start>end){
         * return -1;
         * }
         * else if(a[mid]==num){
         * return mid;
         * 
         * }
         * else if(a[mid]>num){
         * return BinarySearchFun(a, num, start, mid-1);
         * }
         * else{
         * return BinarySearchFun(a, num, mid+1, end);
         * }
         */
        // loop way
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(a[mid]==num){
                return mid;
            }
            if(a[mid]>num){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int a[] = { 10, 20, 30, 40, 56, 87 };
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number:");
        int num = sc.nextInt();
        int result = BinarySearchFun(a, num, 0, a.length - 1);
        if (result == -1) {
            System.out.printf("Element %d not available in the array", num);
        } else {
            System.out.printf("Element %d found a index %d", num, result);
        }
        sc.close();

    }
}