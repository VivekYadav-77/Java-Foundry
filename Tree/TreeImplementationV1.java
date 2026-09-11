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
    Tree create(Scanner sc , String direction , int PreviousElement){
        while(true){
            System.out.println("\nSelect which operation you want to perform in the "+direction+" branch of the elemnt : "+PreviousElement);
            System.out.println("Enter 1 to insert the element in the "+direction+"branch");
            System.out.println("Enter 0 for the exit");
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    System.out.println("Enter the data to be inserted in tree : ");
                    int data = sc.nextInt();
                    Tree newnode = new Tree( data) ;
                    newnode.left = create(sc,"Left",data);
                    newnode.right = create(sc,"Right",data );
                    return newnode;
                case 0:
                    return null ;

            
                default:
                    System.out.println("Invalid input enter the 0 or 1");
                    break;
            }



        }
        
       


    }
    void display(Tree value){
        if(value==null){
            return ;
        }
        System.out.println("Element  "+value.data);
        display(value.left);
        display(value.right);

    }
    
}
public class TreeImplementationV1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeCreation creation = new TreeCreation();
        System.out.println("Enter the element in the root node : ");
        int rootelemnt = sc.nextInt();
        Tree newnode = new Tree(rootelemnt);
        newnode.left = creation.create(sc, "LEFT", rootelemnt);
        newnode.right = creation.create(sc, "RIGHT", rootelemnt);
        
        creation.display(newnode);
        sc.close() ;

        
    }
}