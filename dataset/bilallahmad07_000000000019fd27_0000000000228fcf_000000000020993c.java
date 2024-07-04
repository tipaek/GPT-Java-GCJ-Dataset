import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		for(int T=1;T<=t;T++){
			int n = Integer.parseInt(in.readLine());
			int a[][] = new int[n][n];
			int rc = 0, cc = 0, tr = 0;
			for(int i=0;i<n;i++){
				String s[] = in.readLine().split(" ");
				int flag = 0;
				LinkedList<Integer> l = new LinkedList<Integer>();
				for(int j=0;j<n;j++){
					a[i][j] = Integer.parseInt(s[j]);
					if(i == j)
						tr += a[i][j];
					if(l.contains(a[i][j]))
						flag = 1;
					else l.add(a[i][j]);
				}
				if(flag == 1)
					rc ++;
			}
			for(int j=0;j<n;j++){
				LinkedList<Integer> l = new LinkedList<Integer>();
				l1: for(int i=0;i<n;i++){
					if(l.contains(a[i][j])){
						cc ++;
						break l1;
					}
					l.add(a[i][j]);
				}
			}
			System.out.println("Case #" + T +": " + tr + " " + rc + " " + cc);
		}
	}
}