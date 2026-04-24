import java.util.Scanner;
import java.util.Stack;

public class QueueUsingStacks {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    private int Maxsize = 3;

    public void enqueue(int a){
        if(s1.size()+s2.size()>=Maxsize){
            System.out.println("Queue Overflow! Element " + a + " cannot be added.");
            return;
        }
        s1.push(a);
        System.out.println(a + " enqueued.");

    }

    public void dequeue() {
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue Underflow! Nothing to dequeue.");
            return;
        }

        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        System.out.println("Element " + s2.pop() + " is dequeued");
    }
    public void display() {
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        
        System.out.println("Queue elements (Front to Back):");
        for (int i = s2.size() - 1; i >= 0; i--) {
            System.out.println(s2.get(i));
        }
        for (int i = 0; i < s1.size(); i++) {
            System.out.println(s1.get(i));
        }
    }

   public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks(); 
        Scanner sc = new Scanner(System.in);
        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println("\nSelect operation: 1 (Enqueue), 2 (Dequeue), 3 (Display), 0 (Exit)");
            int userinput = sc.nextInt();
            
            switch (userinput) {
                case 1:
                    System.out.print("Enter the item to queue: ");
                    int uservalue = sc.nextInt();
                    queue.enqueue(uservalue);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.display();
                    break;
                case 0:
                    System.out.println("Goodbye, have a nice day!");
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Wrong input. Enter 1, 2, 3, or 0.");
                    break;
            }
        }
        sc.close();
    }
}
