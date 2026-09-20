import java.util.HashMap;

public class sumOfTwoNumberEqualsTarget{
    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int arr []= {2,7,11,7};
        int target = 9;
        for(int i = 0 ; i<arr.length; i++){
            if(map.containsKey((target-arr[i]))){
                System.out.println("Element at index : "+map.get((target-arr[i]))+" and "+i+" sums to give the target  "+target);
            }
            map.put(arr[i], i);

        }
    }
}