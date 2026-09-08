import java.util.Scanner;
class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
class LinkedList{
    Node head = null;
    Node tail = null;


    public int length(){
        Node current = head;
        int count = 0;
        while(current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    public void insert(int data){
        Node newnode = new Node(data);
        if(head ==null){
            head = newnode;
            tail = newnode;
        }else{
            tail.next = newnode;
            tail = tail.next;
        }
    }
    public void insertAtBeginning(int data){
        Node newnode = new Node(data);
        if(head == null){
            insert(data);
        }else{
            newnode.next = head;
            head = newnode;
        }
    }
    public void insertAtend(int data){
        Node newnode = new Node(data);
        if(head == null){
            insert(data);
        }else{
            tail.next = newnode;
            tail = newnode ;
        }
    }
    public void insertAtPosition(int data, int position, int length){
        if(position == 1){
            insertAtBeginning(data);
        }else if(position == length){
            insertAtend(data);
        }else{
            Node newnode = new Node(data);
            Node current = head;
            for(int i = 2 ; i<position; i++){
                current = current.next;

            }
            newnode.next = current.next;
            current.next = newnode;
        }

    }
    public void display(){
        Node current = head;
        System.out.println("The linked list is :");
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }
}
public class LinkedListoperations{
    public static void main(String args[]){
    LinkedList List = new LinkedList();
    Scanner sc = new Scanner(System.in);
    boolean flage = true ;

    while(flage){
            System.out.println("Enter the data to be inserted in the linked list");
            int input = sc.nextInt();
            List.insert(input);
            System.out.println("Do you want to continue? (true/false)");
            flage = sc.nextBoolean();
            
    }
    System.out.println("The linked list is created successfully");
    List.display();
    boolean keepRunning = true;
    while(keepRunning){
        System.out.println("\nSelect which operation you want to perform");
        System.out.println("enter 1 for insert at beginning: ");
        System.out.println("enter 2 for insert at end: ");
        System.out.println("enter 3 for insert at position: ");
        System.out.println("enter 0 for exit ");
        int userinput = sc.nextInt();
        switch(userinput){
            case 1:
                System.out.println("Enter the data to be inserted at beginning");
                int input1 = sc.nextInt();
                List.insertAtBeginning(input1);
                List.display();
                break;
            case 2:
                System.out.println("Enter the data to be inserted at end");
                int input2 = sc.nextInt();
                List.insertAtend(input2);
                List.display();
                break;
            case 3:
                System.out.println("Enter the data to be inserted at position");
                int input3 = sc.nextInt();
                System.out.println("Enter the position where you want to insert the data");
                int position = sc.nextInt();
                List.insertAtPosition(input3, position, List.length());
                List.display();
                break;
            case 0:
                keepRunning = false;
                break;
        }
    }
    System.out.println("The final linked list is :");
    List.display();
}
}