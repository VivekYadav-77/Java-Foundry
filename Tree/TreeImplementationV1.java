import java.util.Scanner;

import java.util.LinkedList;
import java.util.Queue;
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
    Tree create(Scanner sc , String direction , int parentele ){
        while(true){
            System.out.println("\nSelect which operation you want to perform in the "+direction+" branch of the Parent elemnt : "+parentele);
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
    void preOrder(Tree value){
        if(value==null){
            return ;
        }
        System.out.println("Element  "+value.data);
        preOrder(value.left);
        preOrder(value.right);

    }

    void postOrder(Tree value){
        if(value==null){
            return;
        }
        postOrder(value.left);
        postOrder(value.right);
        System.out.println("Element  "+value.data);
    }
    void inOrder(Tree value){
        if(value == null){
            return;
        }
        inOrder(value.left);
        System.out.println("Element  "+value.data);
        inOrder(value.right);
    }
    void leveltraversal(Queue<Tree> queue){
       while(!queue.isEmpty()){
        Tree current = queue.poll();
        System.out.println("ELement : "+current.data);
        if(current.left!=null){
            queue.offer(current.left);
        }
        if(current.right!=null){
            queue.offer(current.right);
        }
       }
    }
    int countNode(Tree node){
        if(node == null){
            return 0;
        }
        int total =1+ countNode(node.left)+countNode(node.right) ;
        return total;

    }
    int SumOfAllNode(Tree node){
        if(node ==null){
            return 0;
        }
        int result = node.data+SumOfAllNode(node.left)+SumOfAllNode(node.right);
        return result;
    }
}
public class TreeImplementationV1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeCreation creation = new TreeCreation();
        Queue<Tree> queue = new LinkedList<>();
        System.out.println("Enter the element in the root node : ");
        int rootelemnt = sc.nextInt();
        Tree newnode = new Tree(rootelemnt);
        queue.offer(newnode);
        newnode.left = creation.create(sc, "LEFT", rootelemnt );
        newnode.right = creation.create(sc, "RIGHT", rootelemnt );
        System.out.println("Tree in preOrder Traversal ");
        creation.preOrder(newnode);
        System.out.println("Tree in inOrder Traversal ");
        creation.inOrder(newnode);
        System.out.println("Tree in postOrder Traversal ");
        creation.postOrder(newnode);
        System.out.println("Level Traversal : ");
        creation.leveltraversal(queue);
        System.out.println("Total number of nodes in the tree is :"+creation.countNode(newnode));
        System.out.println("Sum of all node is : "+creation.SumOfAllNode(newnode));
        
        sc.close() ;

        
    }
}