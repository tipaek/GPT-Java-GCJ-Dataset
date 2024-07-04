import java.io.*;
import java.util.*;
import java.awt.Point;
 class Solution {
	public static void main(String[] args)
	{
	  try
	   {
	   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	   Integer T=Integer.parseInt(br.readLine());
	   int x=0;
	   while(T-->0)
	   {
		   Integer N=Integer.parseInt(br.readLine());
		  boolean [] jack=new boolean[1441];
		  boolean [] cam=new boolean[1441];
		  boolean flag=false;
		  List<Point> list=new ArrayList<>();
		   for(int i=0;i<N;i++)
		   {
			   String [] strarr=br.readLine().trim().split("\\s+");
			   Point p=new Point(Integer.parseInt(strarr[0]),Integer.parseInt(strarr[1]));
			   list.add(p);
		   }
		   StringBuffer sb=new StringBuffer();
		   for(Point p:list)
		   {
			   if(isValid(jack,p) && !isValid(cam,p))
			   {
				   util(jack,p.x,p.y);
				   sb.append("J");
			   }
			   else if(!isValid(jack,p) && isValid(cam,p))
			   {
				   util(cam,p.x,p.y);

				   sb.append("C");
			   }
			   else if(!isValid(jack,p) && !isValid(cam,p))
			   {
				   //System.out.println("invalid case");
				   System.out.println("IMPOSSIBLE");
				   flag=true;
				   break;
			   }
			   else if(isValid(jack,p) && isValid(cam,p))
			   {				   util(cam,p.x,p.y);

				   sb.append("C");
			   }
		   }
		   if(!flag)
		   {
		   System.out.println(sb.toString());
		   }
	   }
	     
	   }
	   catch(Exception e)
	   {
		   
}
	}
	static boolean  isValid(boolean [] dp,Point p)
	{
		if(dp[p.x] || dp[p.y])
			return false;
		return true;
	}
	static void util(boolean [] dp,int l,int r)
	{
		for(int i=l;i<r;i++)
		{
			dp[i]=true;
		}
	}
}
