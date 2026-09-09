import java.util.Scanner;
class Node{
    Node prev;
    int data;
    Node next;
    public Node(int data){
        this.prev = null;
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
            newnode.prev = tail;
            tail = newnode;

        }
    }
    public void display(){
        if(head ==null){
            System.out.println("List is empty");
        }else{
            Node current = head;
            while(current!= null){
                System.out.printf("The Linked List element : %d\n",current.data);
                current = current.next;
            }

        }

    }
    
}
public class DoublyLinkedList{
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        while(flag){
            System.out.println("Enter the data to be inserted in the linked list");
            int input = sc.nextInt();
            list.insert(input);
            System.out.println("Do you want to continue? (true/false)");
            flag = sc.nextBoolean();

        }
        System.out.println("The linked list is created successfully");
        sc.close();
        System.out.println("The linked list is :");
        list.display();


    }
}