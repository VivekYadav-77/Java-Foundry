import java.util.Scanner;
class TreeNode{
    TreeNode left ; 
    int data ; 
    TreeNode right ; 
    TreeNode(int data){
        this.left = null;
        this.data = data;
        this.right = null;
    }
}

class TreeCreation{
    private  Scanner sc ;
    public TreeCreation(Scanner sc){
        this.sc =sc;
    }
    public TreeNode createTree(){
        System.out.print("Enter node value (or -1 for null): ");
         int data = sc.nextInt();
         if(data == -1 ){
            return null;
         }
         TreeNode newNode = new TreeNode(data);
         System.out.println("Enter LEFT child of " + data);
         newNode.left =createTree();
         System.out.println("Enter RIGHT child of " + data);
         newNode.right=createTree();
         return  newNode;
         

    }
    void display(TreeNode node){
        if(node ==null){
            return ;
        }
        System.out.print(node.data+" ");
        display(node.left);
        display(node.right);

    }
}

public class TwoTreesAreEqual{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeCreation newnode = new TreeCreation(sc);
        TreeNode root  = newnode.createTree();
        newnode.display(root);
        sc.close();


        


        
    }
}