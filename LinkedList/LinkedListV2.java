package LinkedList;
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

        public void insert(int data){
            Node newnode = new Node(data);
            if(head == null){
                head = newnode;
                tail = newnode;
            }else{
                tail.next = newnode;
                tail = newnode;
            }

        }

        public void display(){
            Node curr = head;
            while(curr != null){
                System.out.println(curr.data);
                curr = curr.next;

            }
        }
}

public class LinkedListV2{
    public static void main(String args[]){
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