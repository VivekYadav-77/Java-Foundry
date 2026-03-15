//Find any element in the given array contains the at least 2 dublicate or not 
public class ContainDuplicate{
    public static boolean findDuplicate(int[] a) {
        if(a==null||a.length==1){
            return false;
        }
        for(int i=0;i<a.length;i++){
            for(int j =i+1;j<a.length;j++){
                if(a[i]==a[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {2, 2, 1, 1, 1, 2}; 
       boolean k = findDuplicate(a);
       if(k){
        System.out.println("Yes your array contains a duplicate of element");
       }
       System.out.println("No duplicate exists");

      
    }
}