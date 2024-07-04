import java.io.*;
import java.math.*;
import java.util.*;


public class Solution {

	String res="";
	Set<Integer> setx;
	Set<Integer> sety;
	void dfs(int x,int y,int i,int j,Set<Integer> setx,Set<Integer> sety,String t,int jump,int b)
	{
		int f=b*(-1);
		//int g=y*(-1);
		
		if(i>b||j>b||(setx.contains(i)&&sety.contains(j))||i<f||j<f)
			{
			//
			
			return;
			}
		
		//System.out.println(i+" "+j);
		setx.add(i);
		sety.add(j);
		
		if(i==x&&j==y)
		{
			if(res.length()>t.length()||res.equals(""))
				res=t;
			return;
		}
		int newjump=(int) Math.pow(2,(jump-1));
		
		
		
		dfs(x,y,i+newjump,j,setx,sety,t+"E",jump+1,b);
		dfs(x,y,i-newjump,j,setx,sety,t+"W",jump+1,b);
		dfs(x,y,i,j+newjump,setx,sety,t+"N",jump+1,b);
		dfs(x,y,i,j-newjump,setx,sety,t+"S",jump+1,b);
		
		
		setx.remove(i);
		sety.remove(j);
	}

	public static void main(String args[])
	{
		
		Scanner in = new Scanner(System.in);
		
		int test=in.nextInt();
		
		for(int c=1;c<=test;c++)
		{
			
			int x=in.nextInt();
			int y=in.nextInt();
			String ans="";
			
			
			Solution ts=new Solution();
			
			ts.setx=new HashSet<>();
			ts.sety=new HashSet<>();
			
			int a=x;
			int b=y;
			if(a<0)
				a=a*(-1);
			if(b<0)
				b=b*(1);
			
			int cb=Math.max(a,b);
			ts.dfs( x, y, 0,0,ts.setx,ts.sety,ans,1,cb+1);
			
			
			if(ts.res.equals(""))
				ts.res="IMPOSSIBLE";
			System.out.println("Case #"+c+": "+ts.res);
		}
	}
}
