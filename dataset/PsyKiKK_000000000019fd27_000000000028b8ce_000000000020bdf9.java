import java.util.Scanner;
import java.util.ArrayList;
// import java.io.*;

class Solution{
    class Node
    {
        int key;
        Node left, right;
        ArrayList<int[]> tasks = new ArrayList<int[]>();

        public Node(int[] item)
        {
            key = item[0];
            tasks.add(item);
            left = right = null;
        }
    }

    // Root of BST
    Node root;
    int cLast;
    int jLast;
    char[] nA;
    boolean isImp;
    // Constructor
    Solution(int N)
    {
        root = null;
        cLast = 0;
        jLast = 0;
        nA = new char[N];
        isImp = false;
    }

    void insert(int[] item)
    {
        root = insertRec(root, item);
    }

    /* A recursive function to
    insert a new key in BST */
    Node insertRec(Node root, int[] item)
    {

        /* If the tree is empty,
        return a new node */
        if (root == null)
        {
            root = new Node(item);
            return root;
        }

        /* Otherwise, recur
        down the tree */
        if (item[0] < root.key){
            root.left = insertRec(root.left, item);
        }
        else if (item[0] > root.key){
            root.right = insertRec(root.right, item);
        } else {
            root.tasks.add(item);
        }
        /* return the root */
        return root;
    }

    void inorderRec(Node root)
    {
        if (root != null)
        {
            inorderRec(root.left);
            for (int[] task : root.tasks) {
                if( task[0] >= this.cLast ){
                    this.cLast = task[1];
                    this.nA[task[2]] = 'C';
                } else if ( task[0] >= this.jLast ) {
                    this.jLast = task[1];
                    this.nA[task[2]] = 'J';
                } else {
                    this.isImp = true;
                }
            }
            inorderRec(root.right);
        }
    }

    String getTask(){
        if (this.isImp){
            return "IMPOSSIBLE";
        }
        String str = "";
        for(int i =0; i< this.nA.length ; i++){
            str += this.nA[i];
        }
        return str;
    }

   	public static void main (String[] ar) throws Exception{
	  	//FileInputStream fi =new FileInputStream(ar[0]);
      	Scanner sc=new Scanner(System.in);
      	int T=sc.nextInt();
        sc.nextLine();
		for(int i=1;i<=T;i++){
			System.out.println("Case #"+i+": "+ans(sc));
		}
 	}

	static String ans(Scanner sc){
        String str = "";
        int tN = sc.nextInt();
        Solution tree = new Solution(tN);
        for(int i =0 ; i < tN ; i++ ){
            tree.insert(new int[]{ sc.nextInt(), sc.nextInt(), i });
        }
        tree.inorderRec(tree.root);
        return tree.getTask();
	}
}

