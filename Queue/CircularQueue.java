import java.util.Scanner;

class CircularQueue {
    static int front = -1;
    static int rear = -1;
    static int size = 3;
    static int Queue[] = new int[size];

    static boolean isFull() {
        if (((rear + 1) % size) == front) {
            return true;
        }
        return false;
    }

    static boolean isEmpty() {
        if (front == -1 && rear == -1) {
            return true;
        }
        return false;
    }

    static void enque(int a) {
        if (isFull()) {
            System.out.println("Queue overflow! Cannot insert " + a);
            return;
        }
        
        if (rear == -1 && front == -1) {
            front = 0;
        }
        
        rear = (rear + 1) % size;
        Queue[rear] = a;
        System.out.println("Element: " + a + " is inserted in the Queue");
    }

    static void deque() {
        if (isEmpty()) {
            System.out.println("Queue underflow! Nothing to dequeue.");
            return;
        }
        
        if (front == rear) {
            System.out.println("Element: " + Queue[front] + " is dequeued");
            front = rear = -1;
        } else {
            int k = Queue[front];
            front = (front + 1) % size;
            System.out.println("Element: " + k + " is dequeued");
        }
    }

    static void display() {
        if (!isEmpty()) {
            System.out.println("Here are the elements:");
            int i = front;
            while (i != rear) {
                System.out.println(Queue[i]);
                i = (i + 1) % size;
            }
            System.out.println(Queue[rear]);
        } else {
            System.out.println("Queue is empty");
        }
    }

    public static void main(String[] args) {
        boolean keepRunning = true;
        Scanner sc = new Scanner(System.in);
        
        while (keepRunning) {
            System.out.println("\nSelect which operation you want to perform");
            System.out.println("Enter 1 for enqueue");
            System.out.println("Enter 2 for dequeue");
            System.out.println("Enter 3 to display");
            System.out.println("Enter 0 to exit");

            int userinput = sc.nextInt();
            switch (userinput) {
                case 1:
                    System.out.print("Enter the item in queue: ");
                    int uservalue = sc.nextInt();
                    enque(uservalue); 
                    break;
                case 2:
                    deque();
                    break;
                case 3:
                    display();
                    break;
                case 0:
                    System.out.println("Good bye, have a nice day!");
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Wrong input! Please enter 1, 2, 3 or 0.");
                    break;
            }
        }
        sc.close();
    }
}