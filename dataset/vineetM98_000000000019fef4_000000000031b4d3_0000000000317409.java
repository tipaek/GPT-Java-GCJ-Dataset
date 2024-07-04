import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=1;i<=t;i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			String m=sc.nextLine();
			//System.out.println(x+" "+y);

			int res=solve(x,y,m);
			if(res==-1)
				System.out.println("Case #"+i+": IMPOSSIBLE");
			else
				System.out.println("Case #"+i+": "+res);
		}
		sc.close();
	}
	public static int solve(int x,int y,String m) {
		//System.out.println(x+" "+y);
		m=m.trim();
		int n=m.length(),time=0,res=Integer.MAX_VALUE,trav=0;
		for(int i=0;i<n;i++) {
			char ch=m.charAt(i);
			if(ch=='N')
				y++;
			else if(ch=='S')
				y--;
			else if(ch=='E')
				x++;
			else if(ch=='W')
				x--;
			time++;
			//System.out.println(x+" "+y);
			if(x==0 && y==0 && time<res)
				res=time;
			else {
				trav=(int)(Math.abs(x))+(int)(Math.abs(y));
				if(trav<=time && time<res)
					res=time;
			}
		}
		if(res==Integer.MAX_VALUE)
			return -1;
		return res;
	}
}