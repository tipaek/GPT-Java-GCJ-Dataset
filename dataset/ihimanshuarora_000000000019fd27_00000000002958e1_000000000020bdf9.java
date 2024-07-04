/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
    static class Node {
        int i, S, E;
        String a;
        
        public Node(int i, int S, int E, String c) {
            this.i=i;
            this.S=S;
            this.E=E;
            this.a=c;
        }
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		int t = 1;
		while(t <= T) {
		    int N = sc.nextInt();
		    
		    List<Node> L = new ArrayList<>();
		    
		    for(int i=0;i<N;i++) {
		        int S=sc.nextInt();
		        int E=sc.nextInt();
                Node n = new Node(i, S, E, null);
                L.add(n);
		    }
		    
		    Collections.sort(L, (x, y) -> x.E - y.E);
		    
		    L.get(0).a = "C";
		    Node prev = L.get(0);
		    
		    for(int i=1;i<N;i++) {
		        Node p = prev;
		        Node q = L.get(i);
		        if (q.S >= p.E) {
		            q.a = "C";
                    prev = q;
		        }
		    }
		    
		    List<Node> C = new ArrayList<>();
		    List<Node> J = new ArrayList<>();
		    
		    for(Node i : L) {
		        if (i.a == null) {
                    J.add(i);
	            } else {
                    C.add(i);
                }
		    }
		    
		    if (J.size()>0){
		        J.get(0).a = "J";
                prev = J.get(0);
		    }
		    
		    for(int i=1;i<J.size();i++) {
		        Node p = prev;
		        Node q = J.get(i);
		        if (q.S >= p.E) {
		            q.a = "J";
                    prev = q;
		        }
		    }
		    
		    C.addAll(J);
		    Collections.sort(C, (x, y) -> x.i - y.i);
		    
		    System.out.print("Case #" + t + ": ");
		    
		    boolean flag = true;
		    List<String> output = new ArrayList<>();
		    for(Node i:C) {
		        if (i.a == null) {
		            flag =false;
		            break;
		        }
		        output.add(i.a);
		    }
		    
		    if(flag) {
		        for(String s:output) {
		            System.out.print(s);
		        }
		    } else {
		        System.out.print("IMPOSSIBLE");
		    }
		    
		    System.out.println();
		    t++;
		}
	}
}
