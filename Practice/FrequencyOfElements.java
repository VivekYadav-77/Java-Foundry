import java.util.Map;
import java.util.HashMap;
public class FrequencyOfElements{
        public static void main(String[] args) {
        Map<Integer,Integer>freq  = new HashMap<>();
        int arr[]= {2, 3, 2, 5, 3, 2};
        for(int num : arr){
            if(freq.containsKey(num)){
                freq.put(num,freq.getOrDefault(num,0)+1);
            }else{
                freq.put(num, 1);
            }

        }
        freq.forEach((key,value)->System.out.println("Element : "+key+" frequency is : "+value));

    }

}