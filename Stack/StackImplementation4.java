/*It has flaws because -- it allows you to do things a Stack shouldn't do! . For example, you can write myStack.get(0) or myStack.insertElementAt(5, 2). A true stack should strictly force you to only touch the top element. By allowing you to access the middle or bottom directly, it breaks the core concept of a Last-In-First-Out (LIFO) data structure.*/
//  SO USE ARRAYDEQUE INSTEAD OF THIS STACK CLASS

import java.util.Scanner;
import java.util.Stack;

class StackImplementation4 {
    public Stack<Integer> stack = new Stack<>();
    int MaxSize = 23;

    public void push(int num) {
        if (stack.size() == MaxSize) {
            System.out.println("Stack Overflow! Cannot push " + num);
            return;
        }
        stack.push(num);
        System.out.println(num + " pushed to stack.");
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Nothing to pop.");
            return;
        }
        System.out.println("Element " + stack.pop()+ " is popped.");

    }

    public void peek() {
        if (stack.empty()) {
            System.out.println("Stack is empty. Nothing to peek.");
            return;
        }
        System.out.println("Top stack element is: " + stack.peek());
    }

    public boolean isEmpty() {
        return stack.empty();
    }

    public boolean isFull() {
        if (stack.size() == MaxSize) {
            System.out.println("Stack Overflow !---.");
            return true;
        }
        System.out.println("Stack is NOT full " + (MaxSize - stack.size()) + " space remaining ");
        return false;
    }
    public void searchItem(int num) {
        int position = stack.search(num);
        if (position == -1) {
            System.out.println(num + " is not in the stack.");
        } else {
            System.out.println(num + " is at position " + position + " from the top.");
        }
    }

    public void size() {
        System.out.println("Current size of stack is: " + (stack.size()));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        StackImplementation4 s = new StackImplementation4();
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
                    System.out.println("Enter 7 to search item ");

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
                        case "7":
                            System.out.println("Enter the item to search:");
                            int sei = sc.nextInt();
                            sc.nextLine();
                            s.searchItem(sei);
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
// can use "search(item)" Returns the 1-based position of an item from the top.