import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
public class FrequencyOfElements{
        public static void main(String[] args) {
        Map<Integer,Integer>freq  = new HashMap<>();
        HashSet<Integer> duplicate = new HashSet<>();
        int arr[]= {4, 2, 7, 2, 4, 9, 2};
        for(int num : arr){
            freq.put(num,freq.getOrDefault(num,0)+1);
          

        }
        freq.forEach((key,value)->System.out.println("Element : "+key+" frequency is : "+value));


        for(int num : arr){
            if(freq.get(num)==1){
                System.out.println("Element : "+num+" has the frequency 1 first ");
                break;
            }
        }

        //array contains any duplicate element.
        for(int num : arr){
            if(!duplicate.add(num)){
                System.out.println("Duplicate exist in the arr ");
                break;
            }
        }

    }

}