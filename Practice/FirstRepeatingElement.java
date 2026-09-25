import java.util.HashSet;

public class FirstRepeatingElement{
    public static void main(String[] args) {
          HashSet<Integer> duplicate = new HashSet<>();
          int arr[]={5, 3, 8, 2, 3, 9, 8};
          boolean found = true;
          for(int ele : arr){
             if(!duplicate.add(ele)){
                System.out.println("First Repeating element is : "+ele);
                found = false; 
                break;
             }
          }
          if(found){
            System.out.println("No elemnt in the array is repeating ");
          }
    }
}