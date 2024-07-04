import java.util.*;
import java.io.*;
public class Solution{
	static Scanner sc=new Scanner(System.in);
	static PrintWriter out=new PrintWriter(System.out);
	static class obj{
		int x,y,id;
		obj(int x,int y,int id){
			this.x=x;
			this.y=y;
			this.id=id;
		}
	}
	static boolean overlap(obj a,obj b) {
		if(b.x<a.y) return true;
		return false;
	}
	public static void main(String args[]) {
		int testCases=sc.nextInt();
		for(int test=1;test<=testCases;test++) {
			//Write your code here
			int n=sc.nextInt();
			obj a[]=new obj[n];
			for(int i=0;i<n;i++) a[i]=new obj(sc.nextInt(),sc.nextInt(),i);
			Arrays.sort(a,(p1,p2)->p1.x-p2.x);
			int ok=1,res[]=new int[n];
			obj pJ=new obj(-1,-1,-1),pC=new obj(-1,-1,-1);
			for(int i=0;i<n;i++) {
				if(!overlap(pJ,a[i])) {
					res[a[i].id]=0;
					pJ=a[i];
				}
				else if(!overlap(pC,a[i])) {
					res[a[i].id]=1;
					pC=a[i];
				}
				else {
					ok=0;
					break;
				}
			}
			StringBuilder ans=new StringBuilder();
			if(ok==0) ans.append("IMPOSSIBLE");
			else for(int x: res) ans.append(x==0?'J':'C');
			out.println("Case #"+test+": "+ans);
		}
		out.flush();
		out.close();
	}
}