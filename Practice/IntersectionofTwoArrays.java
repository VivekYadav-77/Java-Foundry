import java.util.HashSet;

public class IntersectionofTwoArrays{
    public static void main(String[] args) {
        HashSet<Integer> match = new HashSet<>();
        int arr1[]={1, 2, 3, 4, 5};
        int arr2[]={4, 5, 6, 7};
        for(int ele : arr1){
            match.add(ele);
        }
        System.out.println("Element that matches : ");
        for(int ele : arr2){
            if(match.contains(ele)){
                System.out.println(ele);
                match.remove(ele);
            }
        }


    }
}