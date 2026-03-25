import java.util.Stack;
class NextGreatestElement{
    static void CalculateNGE(int a[]){
        Stack<Integer> stack = new Stack<>();
        for(int i =a.length-1;i>=0;i--){
            while(!stack.isEmpty()&&a[stack.peek()]<a[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                System.out.println("No next greatest element for :"+a[i]);
            }else{
                System.out.println("Greates element for "+a[i]+" is :"+a[stack.peek()]);
            }
            stack.push(i);
        }
    }
    public static void main(String[] args) {
        int arr[]={12,10,20,22,15,14,18,32,20,22,19};
        CalculateNGE(arr);
    }
}