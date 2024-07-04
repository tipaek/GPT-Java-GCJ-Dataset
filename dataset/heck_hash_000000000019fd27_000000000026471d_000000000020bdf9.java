import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Node{
    int open,close,height;
    Node l,r;
    Node(String S[]){
        open = Integer.parseInt(S[0]);
        close = Integer.parseInt(S[1]);
        height = 1;
    }
}
class Tree{
    Node root;
    boolean b;
    Tree(){
        b = true;
    }
    int getBalance(Node N){
        if (N == null) return 0;
        return height(N.l) - height(N.r);
    }
    int height(Node N){
        if (N == null) return 0;
        return N.height;
    }
    int max(int a, int b){
        return (a > b) ? a : b; 
    }
    Node leftRotate(Node x){
        Node y = x.r;
        Node T2 = y.l;
        y.l = x;
        x.r = T2;
        x.height = max(height(x.l), height(x.r)) + 1;
        y.height = max(height(y.l), height(y.r)) + 1;
        return y;
    }
    Node rightRotate(Node y){
        Node x = y.l;
        Node T2 = x.r;
        x.r = y;
        y.l = T2;
        y.height = max(height(y.l), height(y.r)) + 1;
        x.height = max(height(x.l), height(x.r)) + 1;
        return x;
    }
    private Node add(Node node,Node a){
        if(node==null) return a;
        else if(a.close<=node.open) node.l = add(node.l,a);
        else if(a.open>=node.close) node.r = add(node.r,a);
        else b = false;
        node.height = 1 + max(height(node.l),height(node.r)); 
        int balance = getBalance(node);
        if (balance > 1 && a.close <= node.l.open)
            return rightRotate(node);
        if (balance < -1 && a.open >= node.r.close)
            return leftRotate(node);
        if (balance > 1 && a.open >= node.l.close){
            node.l = leftRotate(node.l);
            return rightRotate(node);
        }
        if (balance < -1 && a.close <= node.r.open){
            node.r = rightRotate(node.r);
            return leftRotate(node);
        }
        return node;
    }
    public boolean add(String S[]){
    	b = true;
        root = add(root,new Node(S));
        return b;
    }
}
public class Solution{
	public static void main(String args[]) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine().trim()),n,i;
		for(i=1;i<=t;++i) {
			Tree C  = new Tree(),J = new Tree();
			String A = "Case #"+String.valueOf(i)+": ";
			n = Integer.parseInt(in.readLine().trim());
			boolean b = true;
			while(n-->0) {
				String S[] = in.readLine().trim().split(" ");
				if(b) {
					if(C.add(S)) A+="C";
					else if(J.add(S)) A+="J";
					else {
						A = "Case #"+String.valueOf(i)+": IMPOSSIBLE";
						b = false;
					}
				}
			}
			System.out.println(A);
		}
		in.close();
	}
}