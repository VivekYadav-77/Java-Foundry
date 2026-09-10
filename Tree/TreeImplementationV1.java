import java.util.Scanner;
class Tree{
    Tree left;
    int data;
    Tree right;
    Tree(int data){
        this.left = null;
        this.data = data;
        this.right = null;

    }
}
class TreeCreation{
    Tree create(Scanner sc){
        while(true){
            System.out.println("\nSelect which operation you want to perform");
            System.out.println("Enter 1 to insert the element in tree : ");
            System.out.println("Enter 0 for the exit");
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    System.out.println("Enter the data to be inserted in tree : ");
                    int data = sc.nextInt();
                    Tree newnode = new Tree( data) ;
                    System.out.println("Enter the data in the LEFT branch of the "+data);
                    newnode.left = create(sc);
                    System.out.println("Enter the data in the RIGHT branch of the "+data);
                    newnode.right = create(sc);
                    return newnode;
                case 0:
                    return null ;

            
                default:
                    System.out.println("Invalid input enter the 0 or 1");
                    break;
            }



        }
        
       


    }
    
}
public class TreeImplementationV1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeCreation creation = new TreeCreation();
        Tree root = creation.create(sc);
        sc.close() ;

        
    }
}