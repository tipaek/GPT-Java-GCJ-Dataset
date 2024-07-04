
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int u=0; u<T; u++) {
			int X = in.nextInt();
			int Y = in.nextInt();
			String M = in.nextLine();
			int P = 0;
			int Q = 0;
			char[] m = M.toCharArray();
			int t=0, flag=0;
			int i=0;
			for (int k=0; k< M.length();k++) {
				// if(P==X && Q==Y) {
				// 	System.out.println("Case #"+(u+1)+ ": "+t);
				// 	flag=1;
				// 	break;
				// }
				
				if(m[k]=='N') {
					Y=Y+1;
				} else if (m[k]=='S') {
					Y=Y-1;
				} else if (m[k]=='E') {
					X=X+1;
				} else if (m[k]=='W') {
					X=X-1;
				}
				// if(P==X && Q==Y) {
				// 	System.out.println("Case #"+(u+1)+ ": "+(t));
				// 	flag=1;
				// 	break;
				// }
				if(P<X) {
					P++;
				} else if (Q<Y) {
					Q++;
				} else if (X<P) {
					P--;
				} else if (Y<Q) {
					Q--;
				}
				t = Math.abs(X)+Math.abs(Y);
			    i = k+1;
			    if(t <= i){
			      System.out.println("Case #"+(u+1)+ ": "+(i));
					flag=1;
					break;
			    }
			}
			if(flag == 0) {
				System.out.println("Case #"+(u+1)+ ": IMPOSSIBLE");
			}
		}
	}
}