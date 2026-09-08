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
    public void insertAtPosition(int data, int position){
        int length = length();
        if(position < 1 || position > length+1){
            System.out.println("Invalid position");
            return;
        }
        if(position == 1){
            insertAtBeginning(data);
        }else if(position == length+1){
            insertAtend(data);
        }else{
            Node newnode = new Node(data);
            Node current = head;
            for(int i = 1 ; i<position-1; i++){
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
    public void deletionAtBeginning(){
        if(head ==null){
            System.out.println("Linked list is empty");
            return;
        }
        else if(head == tail){
            System.out.println("hi");
            System.out.printf("Element %d is deleted\n ", head.data);
            head =null;
            tail = null;
        }
        else{
           System.out.printf("Element %d is deleted\n ", head.data);
            head = head.next;
        }
    }
    public void deletionAtEnd(){
        int lenght = length();
        if(head ==null){
            System.out.println("LinkedList is empty");
        }else if(head == tail){
            System.out.printf("Element %d is deleted\n", head.data);
            head = null;
            tail =null;
        }else{
            Node current = head ; 
                        System.out.printf("Element %d is deleted\n", tail.data);
            while(current.next!=tail){
                current = current.next;
            }
            current.next = null ;
            tail = current;
        }
    }

    public void deletionAtpos(int pos){
        int lenght = length();
        if(pos <0 || pos >lenght){
            System.out.println("Invalid Position");
            return;
        }
        if(pos == 1){
            deletionAtBeginning();
        }
        else if (pos == lenght){
            deletionAtEnd();
        }
        else{
            Node current = head;
            Node temp ; 
            for(int i  =1 ; i<pos-1 ; i++){
                current = current.next;

            }
            temp = current.next;
                                    System.out.printf("Element %d is deleted\n", temp.data);

            current.next = temp.next; 

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
         System.out.println("enter 4 for deletion at beginning: ");
        System.out.println("enter 5 for deletion at end: ");
        System.out.println("enter 6 for deletion at position: ");
                System.out.println("enter 7 to see the linkedlist: ");

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
                List.insertAtPosition(input3, position);
                List.display();
                break;
            case 4:
                List.deletionAtBeginning();
                List.display();
                break;
            case 5: 
                List.deletionAtEnd();
                                List.display();

                break;
            case 6:
                System.out.println("Enter the position of  the data you want to delete");
                int elepostion = sc.nextInt();
                List.deletionAtpos(elepostion); 
                                List.display();

                break;
            case 7:
                List.display();
                break ;
            case 0:
                keepRunning = false;
                break;
        }
    }
    System.out.println("The final linked list is :");
    List.display();
    sc.close();
}
}