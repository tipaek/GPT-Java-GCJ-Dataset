import java.awt.Point;
import java.io.*;
import java.util.*;
class Triple
{
	int x;
	int y;
	int z;
	public Triple(int x, int y, int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public Triple() {
		super();
	}
	
}
 class Solution {
	static int [] res=null;
 public static void main(String[] args) {
	try
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		   Integer T=Integer.parseInt(br.readLine());
		   int x=0;
		   while(T-->0)
		   {
			   x+=1;
			   Integer N=Integer.parseInt(br.readLine());
			   List<Triple> list=new ArrayList<>();
			   for(int i=0;i<N;i++)
			   {
				   String [] strarr=br.readLine().trim().split("\\s+");
				   Triple t=new Triple(Integer.parseInt(strarr[0]),Integer.parseInt(strarr[1]),i);
				   list.add(t);
			   }
			   Collections.sort(list,(a1,a2)->a1.x-a2.x);
			   System.out.println("Case #"+x+": "+util(list));
		   }
	}
	catch(Exception e)
	{
		
	}
}
 public static String util(List<Triple> list)
 {
	  res=new int[2];
	 Arrays.fill(res, Integer.MAX_VALUE);
	 StringBuffer sb=new StringBuffer();
	 int n=list.size();
	 for(int i=n-1;i>=0;i--)
	 {
		 boolean flag=false;
		 if(res[0]> res[1])
			 swap(0,1);
		 if(list.get(i).y<=res[0])
		 {
			 flag=true;
			 sb.append('C');
			 res[0]=list.get(i).x;
		 }
		 if(!flag && list.get(i).y<=res[1])
		 {
			 flag=true;
			 sb.append('J');
			 res[1]=list.get(i).x;
		 }
		 if(!flag)
		 {
			 return "IMPOSSIBLE";
		 }
	 }
	 return sb.toString();
 }
 public static void swap(int m,int n)
 {
	 int t=res[m];
	 res[m]=res[n];
	 res[n]=t;
 }
}
