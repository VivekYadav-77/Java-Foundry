import java.util.Scanner;
import java.util.Stack;
class  BalancedParentheses{
    static boolean varifyExpression(Character a,Character b){
        return (a=='('&&b==')')||(a=='{'&&b=='}')||(a=='['&&b==']');
    }
    static boolean checkBalancedParenthesis(String exp){
        Stack<Character>s= new Stack<>();
        for(int i =0;i<exp.length();i++){
            if(exp.charAt(i)=='{'||exp.charAt(i)=='['||exp.charAt(i)=='('){
                s.push(exp.charAt(i));
            }else if(exp.charAt(i)=='}' || exp.charAt(i)==']' || exp.charAt(i)==')'){
                if(s.empty()){
                    return false;
                }else if(varifyExpression(s.peek(),exp.charAt(i))){
                    s.pop();
                }else{
                    return false;
                }      
            }
        }
        return s.empty();
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your parenthesis expression: ");
        String expression=sc.nextLine().trim();
        sc.close();
        boolean out=checkBalancedParenthesis(expression);
        if(out){
            System.out.println("Your expression "+expression+" is Balanced");
        }else{
            System.out.println("Your expression "+expression+" is UnBalanced");
        }
    }

}