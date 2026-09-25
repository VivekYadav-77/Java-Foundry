class Node{
    Node left;
    int data ; 
    Node right;

    public Node(int data){
        this.left = null;
        this.data = data;
        this.right = null;
    }
}

class TreeCreation{
     public int index = 0;

     Node create(int arr[]){
        if(index>=arr.length){
            
            return null ;
        }
        if(arr[index]==-1){
            index++;
            return null;
        }
        Node newnode = new Node(arr[index++]);
        newnode.left = create(arr);
        newnode.right = create(arr);
        return newnode;


     }



}
class TreesCheck{
    boolean isTreesEqual(Node tree1 , Node tree2){
        if(tree1 ==null && tree2 ==null){
            return  true;
        }
        if((tree1 !=null && tree2==null)||(tree1 ==null && tree2 !=null)){
            return false;
        }
        if(tree1 .data != tree2.data){
            return false;
        }
        return ((isTreesEqual(tree1.left, tree2.left))&&isTreesEqual(tree1.right , tree2.right));

    }
}

public class TwoTreesEqual{
    public static void main(String[] args) {
        TreeCreation node = new TreeCreation();
        int tree1[] = {1, 2, 3, 4, 5, -1, 6};
        int tree2[]={1, 2, 3, 4, 5, -1, 6};
        Node root1 = node.create(tree1);
        node.index = 0;
        Node root2 = node.create(tree2);
        TreesCheck check = new TreesCheck();
        System.out.println("Is tree1 and tree2 is equal : "+check.isTreesEqual(root1, root2));

        


        
    }
}