import java.util.*;
import java.io.*;
public class Solution{
	static Scanner sc=new Scanner(System.in);
	static PrintWriter out=new PrintWriter(System.out);
	static boolean check(StringBuilder s1,StringBuilder s2) {
		int M = s1.length(); 
        int N = s2.length(); 
        for (int i = 0; i <= N - M; i++) { 
            int j; 
            for (j = 0; j < M; j++) 
                if (s2.charAt(i + j) != s1.charAt(j)) 
                    break; 
      
            if (j == M) 
                return true; 
        }
        return false;
	}
	public static void main(String args[]) {
		int testCases=sc.nextInt();
		for(int test=1;test<=testCases;test++) {
			//Write your code here
			int n=sc.nextInt();
			sc.nextLine();
			String s[]=new String[n];
			for(int i=0;i<n;i++) s[i]=sc.nextLine();
			Arrays.parallelSort(s,(s1,s2)->(s2.length()-s1.length()));
			StringBuilder sb=new StringBuilder(s[0]);
			sb=sb.replace(0, 1, "");
			String ans=sb.toString();
			int f=0;
			for(String str: s) {
				StringBuilder pat=new StringBuilder(str);
				pat=pat.replace(0, 1, "");
				if(!ans.contains(pat)) f=1;
			}
			if(f==1) ans="*";
			out.println("Case #"+test+": "+ans);
		}
		out.flush();
		out.close();
	}
}