import java.util.Scanner;
import java.util.Arrays;
public class RadixSort{
    enum SortOrder{ASCENDING,DESCENDING};
    public static void CountSort(int []originalArray,int place){
        int []tempArray = new int[originalArray.length];
        int []frequencyArray = new int[10];
        for(int i =0;i<originalArray.length;i++){
            int index = (originalArray[i]/place)%10;
            frequencyArray[index]++;
        }
        for(int i =1;i<frequencyArray.length;i++){
            frequencyArray[i]+=frequencyArray[i-1];
        }
        for(int i = originalArray.length-1;i>=0;i--){
            int index = (originalArray[i]/place)%10;
            tempArray[--frequencyArray[index]]=originalArray[i];

        }
        System.arraycopy(tempArray, 0, originalArray, 0, originalArray.length);

    }
    public static void radixSort(int[] originalArray){
        int max = originalArray[0];
        for(int i =1;i<originalArray.length;i++) if(originalArray[i]>max) max = originalArray[i];
        String num = String.valueOf(max);
        int i =0;
        int k =1;
        while(i<num.length()){
            CountSort(originalArray,k);
            k=k*10;
            i++;
        }
    }
    public static void main(String []args){
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter all array element seperated by space (e.g: 32 12 1 0 4 )");
        String input = sc.nextLine().trim();
        String [] stringNum = input.split("\\s+");
        if (stringNum.length <= 0) {
            System.out.println("Array size must be greater than 0.");
            sc.close();
            return;
        }
        int []originalArray = new int[stringNum.length];
        for(int i =0;i<stringNum.length;i++){
            originalArray[i]=Integer.parseInt(stringNum[i]);
        }
        SortOrder selectedOrder = null;
        do{
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
                default:
                    System.out.println("Error wrong input enter 1 or 2");
                    break;
            }

        }while(selectedOrder==null);
        sc.close();
        radixSort(originalArray);
System.out.println("here is the sorted array"+Arrays.toString(originalArray));
        

    }
}