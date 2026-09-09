import java.util.Scanner;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
class  LinkedList{
    Node head = null;
    Node tail = null;
    void insert(int data){
        Node newnode = new Node(data) ;
        if(head == null){
            head = newnode;
            tail = newnode;
            newnode.next= newnode;
        }
        else{
            tail.next = newnode;
            tail = newnode;
            tail.next = head;


        }
    }
    public void display(){
        if(head ==null){
            System.out.println("Linked List is empty");
            return ; 
        }else{
            Node current = head;
            do {
                System.out.printf("linked list element : %d\n",current.data);
                current = current.next;

            }while(current!=head);
           

        }
    }
}
public class SinglycircularLinkedList{
    public static void main(String[] args) {
        LinkedList List = new LinkedList();
         Scanner sc = new Scanner(System.in);
        boolean flage = true;
        while(flage){
            System.out.println("Enter the data to be inserted in the linked list");
            int input = sc.nextInt();
            List.insert(input);
            System.out.println("Do you want to continue? (true/false)");
            flage = sc.nextBoolean();
        }
        System.out.println("The linked list is created successfully");
        sc.close();
        System.out.println("The linked list is :");
        List.display();
        
    }
}