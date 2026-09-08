package LinkedList;
import java.util.Scanner;
class Node{

    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null ;
    }
}

public class LinkedListV1{
    public static void main(String args[]){
        Node head = null ;
        Node current = null ;
        System.out.println("Creation of the Linked List");
        Scanner sc = new Scanner(System.in);
        boolean flage = true;
        while(flage){
            System.out.println("Enter the data to be inserted in the linked list");
            int input = sc.nextInt();
            if(current ==null){
                head = new Node(input);
                current = head;

            }
            else{
                current.next = new Node(input);
                current = current.next;
            }
            System.out.println("Do you want to continue? (true/false)");
            flage = sc.nextBoolean();
        }
        System.out.println("The linked list is created successfully");
        sc.close();
        current =head;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
       

    }
    
}