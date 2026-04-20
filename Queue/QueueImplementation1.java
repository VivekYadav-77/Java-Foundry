import java.util.Scanner;

public class QueueImplementation1 {
    int front = -1;
    int rear = -1;
    int arr[] = new int[3];

    boolean isFull() {
        if (rear == arr.length - 1) {
            System.out.println("Queue overflow");
            return true;
        }
        return false;

    }

    boolean isEmpty() {
        if (front == -1) {
            System.out.println("Queue underflow");
            return true;
        }
        return false;
    }

    void dequeue() {
        if (isEmpty()) {
            return;
        }
        int ele = arr[front];
        front++;
        System.out.println("Item : " + ele + " is dequed");
        if (front > rear) {
            front = rear = -1;
        }

    }

    void enqueue(int a) {
        if (isFull()) {
            return;
        }
        if (front == -1) {
            front++;
        }
        rear++;
        arr[rear] = a;
        System.out.println("Item :  " + a + " is enqued");

    }

    public static void main(String[] args) {
        QueueImplementation1 myQueue = new QueueImplementation1();
        boolean keepRunning = true;
        Scanner sc = new Scanner(System.in);
        while (keepRunning) {
            System.out.println("\nSelect which operation you want to perform");
            System.out.println("enter 1 for enqueue: ");
            System.out.println("enter 2 for dequeue: ");
            System.out.println("enter 3 to display: ");

            System.out.println("enter 0 for exit ");
            int userinput = sc.nextInt();
            switch (userinput) {
                case 1:
                    if (!myQueue.isFull()) {
                        System.out.println("Enter the item in queue : ");
                        int uservalue = sc.nextInt();
                        myQueue.enqueue(uservalue);
                    }
                    break;
                case 2:
                    myQueue.dequeue();
                    break;
                case 3:
                    if(!myQueue.isEmpty()){
                        System.out.println("Here are the elements");
                        for(int i =myQueue.front;i<=myQueue.rear;i++){
                            System.out.println(myQueue.arr[i]);
                        }
                    }
                    break;
                case 0:
                    System.out.println("Good bye have a nice day");
                    keepRunning = false;
                    break;

                default:
                    System.out.println("Wrong input enter 1 ,2 or 0 ");
                    break;
            }

        }
        sc.close();

    }
}