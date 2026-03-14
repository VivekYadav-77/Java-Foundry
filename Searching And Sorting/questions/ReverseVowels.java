//QUESTION -- Reverse a available vowel in a given string example -- Leetcode so output Leotcede
import java.util.Scanner;
public class ReverseVowels {
    public static boolean VowelCheck(char a) {
        switch (Character.toLowerCase(a)) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
     
    }

    public static void main(String[] arStrings) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your string:");
        String userInput = input.nextLine();
        StringBuilder reversed = new StringBuilder(userInput);
        int start = 0;
        int end = userInput.length() - 1;
        while (start < end) {
            while (start < end && !VowelCheck(reversed.charAt(start))) {
                start++;
            }
            while (start < end && !VowelCheck(reversed.charAt(end))) {
                end--;

            }

            char temp = reversed.charAt(start);
            reversed.setCharAt(start, reversed.charAt(end));
            reversed.setCharAt(end, temp);
            start++;
            end--;

        }
        input.close();
        System.out.println("Original String : " + userInput);
        System.out.printf("Resulted Array : " + reversed);

    }
}