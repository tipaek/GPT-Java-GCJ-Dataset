import java.util.*;
import java.io.*;
public class Solution{
	static Scanner sc=new Scanner(System.in);
	//static PrintWriter out=new PrintWriter(System.out);
	public static void main(String args[]) {
		int testCases=sc.nextInt(),n=sc.nextInt();
		for(int test=1;test<=testCases;test++) {
			//Write your code here
			int a[]=new int[n];
			int i=1,cnt=0;
			for(;i<=n;i++) {
				System.out.println(i);
				int res=sc.nextInt();
				if(i%10==1) {
					a[i-1]=-1;
					cnt++;
				}
				else a[i-1]=res;
			}
			int pos=1;
			while(cnt>0) {
				System.out.println(pos);
				int res=sc.nextInt();
				if(i%10!=1) {
					a[pos-1]=res;
					pos+=10;
					cnt--;
				}
				i++;
			}
			StringBuilder ans=new StringBuilder();
			for(int x:a) ans.append(x);
			System.out.println(ans);
			String o=sc.next();
			if(o.equals("N")) System.exit(0);
		}
		//out.flush();
		//out.close();
	}
}