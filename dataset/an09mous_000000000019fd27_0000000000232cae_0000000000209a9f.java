import java.util.*;
import java.io.*;
public class Solution{
	static Scanner sc=new Scanner(System.in);
	static PrintWriter out=new PrintWriter(System.out);
	public static void main(String args[]) {
		int testCases=sc.nextInt();
		sc.nextLine();
		for(int test=1;test<=testCases;test++) {
			//Write your code here
			char s[]=sc.nextLine().toCharArray();
			int n=s.length,op[]=new int[105],cl[]=new int[105];
			for(char d='1';d<='9';d++) {
				for(int i=0;i<n;i++) {
					if(s[i]>=d) {
						int j=i;
						while(j<n && s[j]>=d) j++;
						op[i]++;
						cl[j]++;
						i=j-1;
					}
				}
			}
			StringBuilder ans=new StringBuilder();
			for(int i=0;i<=n;i++) {
				for(int j=0;j<op[i];j++) ans.append('(');
				for(int j=0;j<cl[i];j++) ans.append(')');
				if(i<n)ans.append(s[i]);
			}
			out.println("Case #"+test+": "+ans);
		}
		out.flush();
		out.close();
	}
}