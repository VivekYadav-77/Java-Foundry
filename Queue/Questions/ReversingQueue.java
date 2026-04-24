import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.Scanner;

class ReversingQueue {
    private int maxSize;
    private Stack<Integer> s = new Stack<>();
    private Queue<Integer> q = new ArrayDeque<>();

    public ReversingQueue(int size) {
        this.maxSize = size;
    }

    public void enqueue(int a) {
        if (q.size() < maxSize) {
            q.offer(a);
            System.out.println(a + " inserted into the queue.");
        } else {
            System.out.println("Queue Overflow! Cannot insert " + a);
        }
    }

    public void reverseQueue() {
        if (q.isEmpty()) {
            System.out.println("Queue is empty! Nothing to reverse.");
            return;
        }

        while (!q.isEmpty()) {
            s.push(q.poll());
        }
        while (!s.empty()) {
            q.offer(s.pop());
        }
        System.out.println("Queue reversed successfully!");
    }

    public void display() {
        if (q.isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        
        System.out.println("Here are your Queue items (Front to Back):");
        for (int v : q) {
            System.out.print(v + " ");
        }
        System.out.println(); 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the max size of your Queue: ");
        int size = sc.nextInt();
        
        ReversingQueue rq = new ReversingQueue(size);
        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println("\n--- Menu ---");
            System.out.println("1: Insert element in queue");
            System.out.println("2: Reverse the queue");
            System.out.println("3: Display queue");
            System.out.println("0: Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to insert: ");
                    int ele = sc.nextInt();
                    rq.enqueue(ele);
                    break;
                case 2:
                    rq.reverseQueue();
                    rq.display();
                    break;
                case 3:
                    rq.display();
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