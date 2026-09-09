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

        if(head == null){
            head = newnode;
            tail = newnode;
        }else{
            tail.next = newnode;
            newnode.prev = tail;
            tail = newnode;

        }
    }
    public void insertatStart(int data){
        Node newnode = new Node(data);
        if(head ==null){
            head = newnode;
            tail = newnode;
        }
        else{
            head.prev = newnode;
            newnode.next = head ;
            head = newnode ;
        }

    }
    public void insertatEnd(int data){
        Node newnode = new Node(data);
        if(head == null){
            head = newnode;
            tail = newnode;
        }
        else{
            tail.next = newnode;
            newnode.prev = tail;
            tail = newnode;
        }
    }
    public void insertatPos(int data , int pos){
        int lenght = length();
        if(pos <1 || pos > lenght+1){
            System.out.println("Invalid postition");
            return ;
        }
        else if(pos ==1){
            insertatStart(data);
        }else if(pos ==lenght+1){
            insertatEnd(data);
        }else{
            Node newnode = new Node(data);
            Node current = head;
            for(int i = 1; i<pos;i++){
                current = current.next;
            }
            newnode.next = current;
            newnode.prev = current.prev;
            current.prev.next = newnode;
            current.prev = newnode;
        }
            
    }
     public void deleAtend(){
            if(head==null){
            System.out.println("Linked List is empty");
            }
            else if(head.next == null){
                head = null;
                tail = null;
            }
            else{
                tail = tail.prev;
                tail.next = null;

            }
        }
        public void deleAtStart(){
            if(head ==null){
                System.out.println("Linked List is empty");
            }else if(head.next==null){
                head = null ; 
                tail = null;
            }else{
                head = head.next;
                head.prev = null;

            }

        }
        public void deleAtpos(int pos){
            int lenght = length();
            if(pos<1||pos>lenght){
                System.out.println("Invaliud position");
            }else if(pos == 1){
                deleAtStart();
            }else if(pos == lenght){
                deleAtend();
            }else{
                Node current = head ;
                for(int i =1 ; i<pos;i++){
                    current = current.next;
                }
                current.next.prev = current.prev;
                current.prev.next = current.next;
                
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
                List.insertatStart(input1);
                List.display();
                break;
            case 2:
                System.out.println("Enter the data to be inserted at end");
                int input2 = sc.nextInt();
                List.insertatEnd(input2);
                List.display();
                break;
            case 3:
                System.out.println("Enter the data to be inserted at position");
                int input3 = sc.nextInt();
                System.out.println("Enter the position where you want to insert the data");
                int position = sc.nextInt();
                List.insertatPos(input3, position);
                List.display();
                break;
            case 4:
                List.deleAtStart();
                List.display();
                break;
            case 5: 
                List.deleAtend();
                                List.display();

                break;
            case 6:
                System.out.println("Enter the position of  the data you want to delete");
                int elepostion = sc.nextInt();
                List.deleAtpos(elepostion); 
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