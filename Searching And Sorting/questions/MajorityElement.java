//Finding majority element present in a array which should be greater than the array lenght 
public class MajorityElement {
    public static void findMajority(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }

        int candidate = -1;
        int count = 0;

        for (int i = 0; i < a.length; i++) {
            if (count == 0) {
                candidate = a[i];
                count = 1;
            } else if (a[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }

        int verifyCount = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == candidate) {
                verifyCount++;
            }
        }

        if (verifyCount > a.length / 2) {
            System.out.println("The majority element is: " + candidate);
        } else {
            System.out.println("No element appears more than n/2 times.");
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 2, 1, 1, 1, 2}; 
        findMajority(a);
      
    }
}