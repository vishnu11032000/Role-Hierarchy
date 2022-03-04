import java.io.*;
import java.util.*;
class Node{
    String data;
    Node left,right;
    public Node(String d)
    {
        data = d;
        left = right = null;
    }
}
public class Main
{
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    Node root=null;
	    while(true){
	        System.out.println("Do You Want to perform any operation?");
	        System.out.println("If YES (press 1) else (press 0)");
	        int decision=sc.nextInt();
	        if(decision==1){
	            System.out.println("what opeartion do you want to perform");
	            System.out.println("1.add root 2.add subroot 3.Display");
	            int oper=sc.nextInt();
	            if(oper==1){
	                System.out.println("Enter data");
	                String ip=sc.next();
	                root=new Node(ip);
	                display(root);
	            }
	            if(oper==2){
	                System.out.println("Enter root data");
	                String sroot=sc.next();
	                System.out.println("Enter Sub root data");
	                String subroot=sc.next();
	                System.out.println("Enter Sub root data position");
	                String pos=sc.next();
	                Node aroot=root;
	                addroot(root,sroot,subroot,pos);
	                display(aroot);
	            }
	        }
	        else{
	            System.out.println("You entered 0(No operation)");
	            break;
	        }
	    }
	}
	public static void addroot(Node aroot,String sroot,String subroot,String pos){
	    Node temp=find(aroot,sroot);
	    if(pos.equals("left")){
	        temp.left=new Node(subroot);
	    }
	    else if(pos.equals("right")){
	        temp.right=new Node(subroot);
	    }
	}
	public static Node find(Node aroot,String sroot ){
	     if (aroot == null)
	         return null;
	     Queue<Node> q = new LinkedList<>();
	     q.add(aroot);
	     q.add(null);
	     while (!q.isEmpty()) {
	        Node curr = q.poll();
	        if(curr.data.equals(sroot))
	          return curr;
	        if (curr == null){
		       if (!q.isEmpty()) {
                  q.add(null);
		          System.out.println();
		        }
         	}
	       else{
		     if (curr.left != null)
		        q.add(curr.left);
	      	 if (curr.right != null)
		       q.add(curr.right);
            System.out.print(curr.data + " ");
	      }
	    }
	    return null;
	}
	public static void display(Node root){
	    if (root == null)
	         return;
	   System.out.println("===DISPLAYING DATA===");
        Queue<Node> q = new LinkedList<>();
	    q.add(root);
	    q.add(null);
	    while (!q.isEmpty()) {
	        Node curr = q.poll();
	        if (curr == null){
		       if (!q.isEmpty()) {
                  q.add(null);
		          System.out.println();
		        }
         	}
	       else{
		     if (curr.left != null)
		        q.add(curr.left);
	      	 if (curr.right != null)
		       q.add(curr.right);
            System.out.print(curr.data + " ");
	      }
	    }
	    System.out.println("");
	    System.out.println("=======");
	}
}