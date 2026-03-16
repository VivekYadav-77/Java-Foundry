import java.util.Scanner;

public class StackImplementation1 {
    public static int top = -1;
    public static int arr[];

    
    public static void push(int num) {
        if (isFull()) {
            System.out.println("Stack Overflow! Cannot push.");
            return;
        }
        arr[++top] = num;
        System.out.println(num + " pushed to stack.");
    }

    public static void pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Nothing to pop.");
            return;
        }
        System.out.println("Element " + arr[top] + " is popped.");
        top--;
    }

    public static void peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Nothing to peek.");
            return;
        }
        System.out.println("Top stack element is: " + arr[top]);
    }

    public static boolean isEmpty() {
        return top == -1;
    }

    public static boolean isFull() {
        return top == arr.length - 1;
    }

    public static void size() {
        System.out.println("Current size of stack is: " + (top + 1));
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the size of the stack:");
        int size = sc.nextInt();
        sc.nextLine(); 
        
        arr = new int[size];
        boolean run = true;
        
        while (run) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("Enter 1 to perform operation in the stack");
            System.out.println("Enter 2 to exit");
            String choice = sc.nextLine().trim();
            
            switch (choice) {
                case "1": {
                    System.out.println("\n--- Stack Operations ---");
                    System.out.println("Enter 1 to Push");
                    System.out.println("Enter 2 to Pop");
                    System.out.println("Enter 3 to Peek");
                    System.out.println("Enter 4 to check if Empty");
                    System.out.println("Enter 5 to check if Full");
                    System.out.println("Enter 6 to see current Size");
                    String operChoice = sc.nextLine().trim();
                    
                    switch (operChoice) {
                        case "1":
                            if (!isFull()) {
                                System.out.println("Enter the item to push:");
                                int num = sc.nextInt();
                                sc.nextLine(); 
                                push(num);
                            } else {
                                System.out.println("Stack Overflow! Cannot push.");
                            }
                            break;
                        case "2":
                            pop();
                            break;
                        case "3":
                            peek();
                            break;
                        case "4":
                            if (isEmpty()) {
                                System.out.println("Stack is currently empty.");
                            } else {
                                System.out.println("Stack is NOT empty. Total elements: " + (top + 1));
                            }
                            break;
                        case "5":
                            if (isFull()) {
                                System.out.println("Stack is full!");
                            } else {
                                System.out.println("Stack is NOT full. Remaining space: " + (arr.length - (top + 1)));
                            }
                            break;
                        case "6":
                            size();
                            break;
                        default:
                            System.out.println("Error: Wrong input. Enter between 1 to 6.");
                            break;
                    }
                    break; 
                }       
                case "2": {
                    System.out.println("Exiting... Have a good day!");
                    run = false;      
                    break;
                }
                default:
                    System.out.println("Error: Wrong input. Press 1 or 2.");
            }
        }
        sc.close();
    }
}