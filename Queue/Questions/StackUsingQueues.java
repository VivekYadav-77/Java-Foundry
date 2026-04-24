import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Scanner;

class StackUsingQueues {
    int size;
    Queue<Integer> q1 = new ArrayDeque<>();
    Queue<Integer> q2 = new ArrayDeque<>();

    public StackUsingQueues(int size) {
        this.size = size;
    }

    public void Push(int a) {
        if (q1.size() >= size || q2.size() >= size) {
            System.out.println("Stack Overflow ! .");
            return;
        }
        if (!q1.isEmpty()) {

            q1.offer(a);

        } else {
            q2.offer(a);

        }
    }

    public void Pop() {
        if (q1.isEmpty() && q2.isEmpty()) {
            System.out.println("Stack underflow !");
            return;
        } else if (!q1.isEmpty()) {
            while (!q1.isEmpty() && q1.size() > 1) {
                q2.offer(q1.poll());
            }
            System.out.println("Element " + q1.poll() + " is poped");
            return;

        }
        while (!q2.isEmpty() && q2.size() > 1) {
            q1.offer(q2.poll());
        }
        System.out.println("Element " + q2.poll() + " is poped");

    }

    public void Peek() {
        if (q1.isEmpty() && q2.isEmpty()) {
            System.out.println("Stack is Underflow !");
            return;
        }

        int topElement = -1;

        if (!q1.isEmpty()) {
            while (!q1.isEmpty()) {
                topElement = q1.poll();
                q2.offer(topElement);
            }
        } else {
            while (!q2.isEmpty()) {
                topElement = q2.poll();
                q1.offer(topElement);
            }
        }

        System.out.println("Peek element in the stack is : " + topElement);
    }

    public void display() {
        if (q1.isEmpty() && q2.isEmpty()) {
            System.out.println("Stack underflow !");
            return;
        }

        System.out.println("Here are your elements in Stack : ");

        Queue<Integer> activeQueue = q1.isEmpty() ? q2 : q1;

        Object[] arr = activeQueue.toArray();

        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println(arr[i]);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the max size of your Queue: ");
        int size = sc.nextInt();

        StackUsingQueues sq = new StackUsingQueues(size);
        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println("\n--- Menu ---");
            System.out.println("1: Insert element in stack");
            System.out.println("2: Pop from stack");
            System.out.println("3: Display");
            System.out.println("0: Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to insert: ");
                    int ele = sc.nextInt();
                    sq.Push(ele);
                    break;
                case 2:

                    sq.Pop();
                    break;
                case 3:
                    sq.display();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
        sc.close();

    }
}