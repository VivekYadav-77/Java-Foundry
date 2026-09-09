import java.util.Scanner;

class Node{
    int data ; 
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
class LinkedList{
    Node head = null;
    Node tail = null;
    public void insert(int data){
        Node newnode = new Node(data) ;
        if(head ==  null ){
            head = newnode;
            tail = newnode;
        }else{
            tail.next = newnode;
            tail = newnode;
        }

    }

    public void ReverseList(){
        Node prev = null;
        Node current = head;
        Node nextele = head; 
        if(head ==null){
            System.out.println("linkedlist is empty");
        }
        else if(head.next == null){
            System.out.println("Currently there only a single node in the linkedlist");
            return ;
        }
        else{
            while(nextele!=null){
                nextele = nextele.next;
                current.next = prev;
                prev = current;
                current = nextele;
            }
            tail = head;
            head = prev;
        }
    }

    public void display(){
        if(head==null){
            System.out.println("The list is currently empty") ;
            return;
        }
        Node currNode = head;
        while(currNode!=null){
            System.out.printf("The LinkedList  : %d\n", currNode.data);
            currNode = currNode.next;
        }

    }
}
public class ReverseSinglyLinkedList{
    public static void main(String args[]){
        LinkedList List = new LinkedList();
        Scanner sc = new Scanner(System.in);
        boolean flage = true;
        boolean reverseinp;
        while(flage){
            System.out.println("Enter the data to be inserted in the linked list");
            int input = sc.nextInt();
            List.insert(input);
            System.out.println("Do you want to continue? (true/false)");
            flage = sc.nextBoolean();
        }
        List.display();
        System.out.println("Do you want to reverse you linkedlist? (true/false)");
        reverseinp = sc.nextBoolean();
        if(reverseinp){
            List.ReverseList();

        }

        
        sc.close();
        List.display();
    }
   

}