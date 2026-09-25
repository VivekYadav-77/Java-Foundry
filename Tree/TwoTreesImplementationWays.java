

//Class-Level Field Tree implementation 
// import java.util.Scanner;
// class TreeNode{
//     TreeNode left ; 
//     int data ; 
//     TreeNode right ; 
//     TreeNode(int data){
//         this.left = null;
//         this.data = data;
//         this.right = null;
//     }
// }

// class TreeCreation{
//     private  Scanner sc ;
//     public TreeCreation(Scanner sc){
//         this.sc =sc;
//     }
//     public TreeNode createTree(){
//         System.out.print("Enter node value (or -1 for null): ");
//          int data = sc.nextInt();
//          if(data == -1 ){
//             return null;
//          }
//          TreeNode newNode = new TreeNode(data);
//          System.out.println("Enter LEFT child of " + data);
//          newNode.left =createTree();
//          System.out.println("Enter RIGHT child of " + data);
//          newNode.right=createTree();
//          return  newNode;
         

//     }
//     void display(TreeNode node){
//         if(node ==null){
//             return ;
//         }
//         System.out.print(node.data+" ");
//         display(node.left);
//         display(node.right);

//     }
// }

// public class TwoTreesImplementationWays{
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         TreeCreation newnode = new TreeCreation(sc);
//         TreeNode root  = newnode.createTree();
//         newnode.display(root);
//         sc.close();


        


        
//     }
// }

//Array Parsing 
class TreeNode{
    int data;
    TreeNode left ;
    TreeNode right;

    public TreeNode(int data){
        this.data = data;
        this.left = null;
        this.right=null;

    }
}

class TreeCreation{
    private int index = 0 ;
    TreeNode createTree(int arr[]){
        if(index >=arr.length || arr[index] ==-1){
            index ++;

            return  null;
        }
        TreeNode root = new TreeNode(arr[index++]);
        root.left = createTree(arr);
        root.right = createTree(arr);
        return root;

    }
    void display(TreeNode root ){
        if(root == null){
            return ;
        }
        System.out.println(root.data);
        display(root.left);
        display(root.right);

    }

}

public class TwoTreesImplementationWays{
    public static void main(String[] args) {
        TreeCreation tree = new TreeCreation();
        int treeData[]={1, 2, 3, -1, 4,-1,-1,-1, 3, -1, -1};
        TreeNode root = tree.createTree(treeData);
        tree.display(root); 
        

        
    }
}

