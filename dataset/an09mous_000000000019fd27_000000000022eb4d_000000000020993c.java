import java.util.*;
import java.io.*;
public class Solution{
	static Scanner sc=new Scanner(System.in);
	static PrintWriter out=new PrintWriter(System.out);
	public static void main(String args[]) {
		int testCases=sc.nextInt();
		for(int test=1;test<=testCases;test++) {
			//Write your code here
			int n=sc.nextInt(),a[][]=new int[n][n];
			int t=0,r=0,c=0;
			for(int i=0;i<n;i++) {
				HashSet<Integer> set=new HashSet<>();
				for(int j=0;j<n;j++) {
					a[i][j]=sc.nextInt();
					if(i==j) t+=a[i][j];
					set.add(a[i][j]);
				}
				if(set.size()!=n) r++;
			}
			for(int j=0;j<n;j++) {
				HashSet<Integer> set=new HashSet<>();
				for(int i=0;i<n;i++) set.add(a[i][j]);
				if(set.size()!=n) c++;
			}
			out.println("Case #"+test+": "+t+" "+r+" "+c);
		}
		out.flush();
		out.close();
	}
}