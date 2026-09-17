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
class TreeInfo{
    int height;
    int diameter;
    TreeInfo(int height , int diameter){
        this.height= height;
        this.diameter=diameter;
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
    int sumOfAllNode(Tree node){
        if(node ==null){
            return 0;
        }
        int result = node.data+sumOfAllNode(node.left)+sumOfAllNode(node.right);
        return result;
    }
    //Downward accumulator
    int maxElem(Tree node , int max){
        if(node == null){
            return  max;
        }else if(node.data>max){
           return maxElem(node.right,maxElem(node.left, node.data) );
            
        }else{
            
            return maxElem(node.right, maxElem(node.left, max));
            
        }
    }
    //Downward accumulator
    int minElem(Tree node , int min){
        if(node == null){
            return  min;
        }else if(node.data<min){
           return minElem(node.right,minElem(node.left, node.data) );
            
        }else{
            
            return minElem(node.right, minElem(node.left, min)); 
            
        }
    }
    //Return-upward
    int maxElemUpward(Tree node){
        if(node == null){
            return Integer.MIN_VALUE;
        }
        int leftMax = maxElemUpward(node.left);
        int rightMax = maxElemUpward(node.right);
        return Math.max(node.data, Math.max(leftMax, rightMax));
    }
    //Return-upward
    int minElemUpward(Tree node){
        if(node == null){
            return Integer.MAX_VALUE;
        }
        int leftMin = minElemUpward(node.left);
        int rightMin = minElemUpward(node.right);
        return Math.min(node.data, Math.min(leftMin, rightMin));
    }
    //No of leaf node
    int noOfLeafNode(Tree node){
        if(node ==null){
            return 0;
        }
        if(node.left==null && node.right==null){
            return 1;
        }
        return  noOfLeafNode(node.left)+noOfLeafNode(node.right);
    }
    //height of the tree 
    int heightOfTree(Tree node){
        if(node ==null){
            return 0;
        }
        int leftheight =heightOfTree(node.left);
        int rightheight = heightOfTree(node.right);
        return 1+Math.max(leftheight, rightheight);

    }
    //searching target in tree
    boolean searchTree(Tree node , int target){
        if(node==null){
            return false;
        }
        if(target==node.data){
            return true;
        }
        return searchTree(node.left, target) || searchTree(node.right, target);
    }
    //number node having only one child.
    int nodeHaveSingleChild(Tree node){
        if(node ==null){
            return  0 ;
        }
        if((node.left!=null && node.right==null)||(node.left==null && node.right!=null)){
             return 1+nodeHaveSingleChild(node.left)+nodeHaveSingleChild(node.right);
        }
        return nodeHaveSingleChild(node.left)+nodeHaveSingleChild(node.right);
    }
    //no of node at a particular level 
    int noOfNodeAtLevel(Tree node , int target , int currentlevel){
        if(node ==null){
            return 0;
        }
        if(target==currentlevel){
            return 1;
        }
        return noOfNodeAtLevel(node.left, target, currentlevel+1)+noOfNodeAtLevel(node.right, target, currentlevel+1);

    }
    //Level-order traversal
    void levelByLevelTraversal(Queue<Tree> queue,int currentlevel){
        while (!queue.isEmpty()) {
            int size = queue.size();
             System.out.print("Level "+currentlevel+ " :");
            for(int i = 0 ; i<size ;i++){
                Tree currentNodeData = queue.poll();
                System.out.print( " "+currentNodeData.data);
             if(currentNodeData.left!=null){
            queue.offer(currentNodeData.left);
            }
            if(currentNodeData.right!=null){
                queue.offer(currentNodeData.right);
            }
                
            }
            System.out.println();
            ++currentlevel;
        }
    }
    TreeInfo diameter(Tree node){
        if(node==null){
            return new TreeInfo(0, 0);
        }
        TreeInfo left = diameter(node.left);
        TreeInfo right = diameter(node.right);
        int height = 1+Math.max(left.height, right.height);
        int throughcurrent = 1+left.height+right.height;
        int diameter = Math.max(throughcurrent,Math.max(left.height, right.height));
        return new TreeInfo(height, diameter);

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
        System.out.println("Sum of all node is : "+creation.sumOfAllNode(newnode));
        System.out.println("Maximum ELement in the Tree : "+creation.maxElem(newnode,newnode.data));
        System.out.println("Minimum ELement in the Tree : "+creation.minElem(newnode,newnode.data));
        System.out.println("Maximum ELement in the Tree using upward traversal : "+creation.maxElemUpward(newnode));
        System.out.println("Minimun ELement in the Tree using upward traversal : "+creation.minElemUpward(newnode));
        System.out.println("Number of the leaf node : "+creation.noOfLeafNode(newnode)) ;
        System.out.println("Height of the tree : "+creation.heightOfTree(newnode));
        System.out.println("Enter the target value you want to search for the availability : ");
        int target = sc.nextInt();
        boolean answer = creation.searchTree(newnode, target);
        if(answer){ 
            System.out.println("Element "+target+" is avaliable in the tree ");

        }else{
            System.out.println("Element "+target+" is not available in the tree");
        }
        System.out.println("No of node having single child : "+creation.nodeHaveSingleChild(newnode));
        System.out.println("Enter the level at which you want to know number of nodes : ");
        int targetlevel = sc.nextInt();
        int height = creation.heightOfTree(newnode);
        if(targetlevel<0 || targetlevel >height-1){
            System.out.println("The level "+targetlevel+" does not in the tree ");
        }else{
            System.out.println("Numberof node at level "+targetlevel+" is : "+creation.noOfNodeAtLevel(newnode, targetlevel, 0));
        }
        queue.offer(newnode);
        creation.levelByLevelTraversal(queue,0);
        System.out.println("Diameter of the tree is : "+creation.diameter(newnode).diameter) ;
        sc.close() ;
        
    }
}