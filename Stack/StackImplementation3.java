import java.util.Scanner;
import java.util.ArrayDeque;

class StackImplementation3 {
    public ArrayDeque<Integer> stack = new ArrayDeque<>();
    int MaxSize = 23;

    public void push(int num) {
        if (stack.size() == MaxSize) {
            System.out.println("Stack Overflow! Cannot push " + num);
            return;
        }
        stack.addLast(num);
        System.out.println(num + " pushed to stack.");
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Nothing to pop.");
            return;
        }
        System.out.println("Element " + stack.pollLast() + " is popped.");

    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Nothing to peek.");
            return;
        }
        System.out.println("Top stack element is: " + stack.peekLast());
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public boolean isFull() {
        if (stack.size() == MaxSize) {
            System.out.println("Stack Overflow !---.");
            return true;
        }
        System.out.println("Stack is NOT full " + (MaxSize - stack.size()) + " space remaining ");
        return false;
    }

    public void size() {
        System.out.println("Current size of stack is: " + (stack.size()));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        StackImplementation3 s = new StackImplementation3();
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
                            System.out.println("Enter the item to push:");
                            int num = sc.nextInt();
                            sc.nextLine();
                            s.push(num);
                            break;
                        case "2":
                            s.pop();
                            break;
                        case "3":
                            s.peek();
                            break;
                        case "4":
                            if (s.isEmpty()) {
                                System.out.println("Stack is currently empty.");
                            } else {
                                System.out.println("Stack is NOT empty. Total elements: " + (s.stack.size()));
                            }
                            break;
                        case "5":
                            s.isFull();
                            break;
                        case "6":
                            s.size();
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
