import java.util.Stack;
import java.util.Arrays;
class StockSpan {
    public static int [] StockSpanCount(int a[]){
        int span[] = new int [a.length];
        Stack<Integer>stack = new Stack<>();
        span[0]=1;
        stack.push(0);
        for(int i =1;i<a.length;i++){
            while (!stack.isEmpty()&& a[stack.peek()]<=a[i]) {
                stack.pop();
            }
            if(stack.isEmpty()){
                span[i]=i+1;
            }else{
                span[i]=i-stack.peek();
            }
            stack.push(i);
        }
        return span;
    }
    public static void main(String[] args) {
        int arr []={100,80,60,120};
        int result []=StockSpanCount(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.println("Span of day : "+i+"is : "+result[i]);
            
        }
        
        
        
    }
     
}