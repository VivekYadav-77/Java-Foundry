import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListCollectionFramework {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        
        boolean flag = true;
        while (flag) {
            System.out.println("Enter the data to be inserted in the linked list:");
            if (sc.hasNextInt()) {
                int input = sc.nextInt();
                list.add(input);
            } else {
                System.out.println("Invalid number. Skipping.");
                sc.next(); 
                continue;
            }
            
            System.out.println("Do you want to continue adding? (y/n)");
            String choice = sc.next();
            flag = choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes");
        }
        
        System.out.println("The linked list is created successfully");
        System.out.println("Linked list: " + list);
        
        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println("\nSelect which operation you want to perform:");
            System.out.println("1: Insert at beginning");
            System.out.println("2: Insert at end");
            System.out.println("3: Insert at position");
            System.out.println("4: Deletion at beginning");
            System.out.println("5: Deletion at end");
            System.out.println("6: Deletion at position");
            System.out.println("7: Display the linked list");
            System.out.println("0: Exit");
            
            int userInput = sc.nextInt();
            
            switch (userInput) {
                case 1:
                    System.out.println("Enter data to insert at beginning:");
                    list.addFirst(sc.nextInt());
                    System.out.println("Linked list: " + list);
                    break;
                    
                case 2:
                    System.out.println("Enter data to insert at end:");
                    list.addLast(sc.nextInt());
                    System.out.println("Linked list: " + list);
                    break;
                    
                case 3:
                    System.out.println("Enter data to insert:");
                    int data3 = sc.nextInt();
                    System.out.println("Enter position (0 to " + list.size() + "):");
                    int pos3 = sc.nextInt();
                    
                    if (pos3 >= 0 && pos3 <= list.size()) {
                        list.add(pos3, data3);
                        System.out.println("Linked list: " + list);
                    } else {
                        System.out.println("Invalid position!");
                    }
                    break;
                    
                case 4:
                    if (!list.isEmpty()) {
                        list.removeFirst();
                        System.out.println("Linked list: " + list);
                    } else {
                        System.out.println("List is empty! Nothing to delete.");
                    }
                    break;
                    
                case 5:
                    if (!list.isEmpty()) {
                        list.removeLast();
                        System.out.println("Linked list: " + list);
                    } else {
                        System.out.println("List is empty! Nothing to delete.");
                    }
                    break;
                    
                case 6:
                    if (list.isEmpty()) {
                        System.out.println("List is empty! Nothing to delete.");
                        break;
                    }
                    System.out.println("Enter position to delete (0 to " + (list.size() - 1) + "):");
                    int pos6 = sc.nextInt();
                    
                    if (pos6 >= 0 && pos6 < list.size()) {
                        list.remove(pos6);
                        System.out.println("Linked list: " + list);
                    } else {
                        System.out.println("Invalid position!");
                    }
                    break;
                    
                case 7:
                    System.out.println("Linked list: " + list);
                    break;
                    
                case 0:
                    keepRunning = false;
                    break;
                    
                default:
                    System.out.println("Invalid option selected. Please choose between 0 and 7.");
            }
        }
        
        System.out.println("\nThe final linked list is: " + list);
        sc.close();
    }
}
