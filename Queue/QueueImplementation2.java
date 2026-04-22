import java.util.ArrayDeque;
import java.util.Scanner;

class QueueImplementation2 {
    static ArrayDeque<Integer> deque = new ArrayDeque<Integer>();

    public static void main(String[] args) 
    {
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
                    System.out.println("Enter the item in queue : ");
                    int uservalue = sc.nextInt();
                    deque.add(uservalue);
                    System.out.println("Element : " + uservalue + " is enqued");
                    break;
                case 2:
                    if (!deque.isEmpty()) {
                        System.out.println("Element : " + deque.poll() + " is dequed");
                        break;
                    }
                    System.out.println("Queue is underflow");
                    break;
                case 3:
                    if (!deque.isEmpty()) {
                        System.out.println("Here are the elements:");
                        for (Integer element : deque) {
                            System.out.println(element);
                        }
                    } else {
                        System.out.println("Queue is empty");
                    }
                    break;
                case 0:
                    System.out.println("Good bye have a nice day");
                    keepRunning = false;
                    break;

                default:
                    System.out.println("Wrong input enter 1, 2, 3 or 0 ");
                    break;
            }
        }
        sc.close();
    }
}