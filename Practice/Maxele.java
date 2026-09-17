public class Maxele{
    public static void main(String[] args) {
        int arr[]={2,4,1,6,2,4};
        int max = arr[0];
        for(int i = 1;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        System.out.println("Max Element : "+max);

    }

}