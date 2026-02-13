import java.util.Scanner;
public class LinearSearch{
    //Handles both array contains duplicate or not 
    public static void LinearSearchFun(int arr[],int num){
        boolean k =false;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]==num){
                k = true;
                System.out.printf("The number %d is found at index %d\n5",num,i);
            }
        }
        if(!k){
            System.out.printf("The number %d is not available in the array",num);
        }
    }
    public static void main(String[] args){
        int arr1[]  = {10,5,15,21,5,7};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter to number to search:");
        int num = sc.nextInt();
        LinearSearchFun(arr1,num);
        sc.close();

    }

}
//TC = o(n)