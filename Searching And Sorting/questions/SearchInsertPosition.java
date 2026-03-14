//Finding the Correct index of a target element in the array
public class SearchInsertPosition {
    public static int BinarySearch(int a[],int target){
        int start =0;
        int end = a.length-1;
        while(start<=end){
            int mid = end-(end-start)/2;
            if(a[mid]==target){
                return mid;
            }
            else if(a[mid]>target){
                end = mid-1;
            }
            else{
                start = mid+1;  
            }
        }
       return start;
    }
    public static void main(String[]args){
        int a[]={1,3,5,6};
        int mid = BinarySearch(a, 0);
        System.out.println("Here is the actual index :"+mid);
    }
}

