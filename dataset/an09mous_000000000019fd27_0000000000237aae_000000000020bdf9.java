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
			StringBuilder ans=new StringBuilder();
			int ok=1,val=0,res[]=new int[n];
			for(int i=0;i<n;i++) {
				if(i+1<n && overlap(a[i],a[i+1])) {
					if(i+2<n && overlap(a[i+1],a[i+2]) && overlap(a[i],a[i+2])) {
						ok=0;
						break;
					}
					res[a[i].id]=val;
					val^=1;
				}
				else res[a[i].id]=val;
			}
			if(ok==0) ans.append("IMPOSSIBLE");
			else for(int x: res) ans.append((x==0?'C':'J'));
			out.println("Case #"+test+": "+ans);
		}
		out.flush();
		out.close();
	}
}