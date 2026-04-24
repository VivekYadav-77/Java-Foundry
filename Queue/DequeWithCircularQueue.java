import java.util.Scanner;

class DequeWithCircularQueue {
    private int size;
    private int queue[];
    private int front = -1;
    private int rear = -1;

    public DequeWithCircularQueue(int size) {
        this.size = size;
        this.queue = new int[size];
    }

    public boolean isFull() {
        return ((front == 0 && rear == size - 1) || (front == rear + 1));
    }

    public boolean isEmpty() {
        return (front == -1);
    }

    public void enqueueFront(int a) {
        if (isFull()) {
            System.out.println("Queue Overflow! " + a + " cannot be inserted at front.");
            return;
        }

        if (front == -1) {
            front = 0;
            rear = 0;
        } else if (front == 0) {
            front = size - 1;
        } else {
            front = front - 1;
        }

        queue[front] = a;
        System.out.println(a + " enqueued at front.");
    }

    public void enqueueRear(int a) {
        if (isFull()) {
            System.out.println("Queue Overflow! " + a + " cannot be inserted at rear.");
            return;
        }

        if (front == -1) {
            front = 0;
            rear = 0;
        } else if (rear == size - 1) {
            rear = 0;
        } else {
            rear = rear + 1;
        }

        queue[rear] = a;
        System.out.println(a + " enqueued at rear.");
    }

    public void dequeueFront() {
        if (isEmpty()) {
            System.out.println("Queue Underflow! Nothing to dequeue.");
            return;
        }

        System.out.println(queue[front] + " is dequeued from front.");

        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (front == size - 1) {
            front = 0;
        } else {
            front = front + 1;
        }
    }

    public void dequeueRear() {
        if (isEmpty()) {
            System.out.println("Queue Underflow! Nothing to dequeue.");
            return;
        }

        System.out.println(queue[rear] + " is dequeued from rear.");

        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (rear == 0) {
            rear = size - 1;
        } else {
            rear = rear - 1;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Current Deque (Front to Rear): ");
        int i = front;
        while (true) {
            System.out.print(queue[i] + " ");
            if (i == rear)
                break;
            i = (i + 1) % size;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of your Deque: ");
        int size = sc.nextInt();

        DequeWithCircularQueue q = new DequeWithCircularQueue(size);
        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println("\n--- Deque Menu ---");
            System.out.println("1: Enqueue Front");
            System.out.println("2: Enqueue Rear");
            System.out.println("3: Dequeue Front");
            System.out.println("4: Dequeue Rear");
            System.out.println("5: Display Deque");
            System.out.println("0: Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to enqueue at front: ");
                    q.enqueueFront(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter value to enqueue at rear: ");
                    q.enqueueRear(sc.nextInt());
                    break;
                case 3:
                    q.dequeueFront();
                    break;
                case 4:
                    q.dequeueRear();
                    break;
                case 5:
                    q.display();
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