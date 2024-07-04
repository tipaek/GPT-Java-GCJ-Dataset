import java.util.*;
class Solution
{
    static int min=Integer.MAX_VALUE;
	static String p="";
    public static void method(int s,int e,int n,int m,int i,String b)
	{
	   if( Math.abs(n)<Math.abs(s) || Math.abs(m)<Math.abs(e))
	  {
	   	  return;
	   }
	   if(n==s && e==m)
	   {
	   
	   if(min>i)
	   {
	   	min=i;
		p=b;
	   }
		return;
	   }
		method(s+(int)Math.pow(2,i),e,n,m,i+1,b+"E");
		method(s-(int)Math.pow(2,i),e,n,m,i+1,b+"W");
		method(s,e+(int)Math.pow(2,i),n,m,i+1,b+"N");
		method(s,e-(int)Math.pow(2,i),n,m,i+1,b+"S");
	}
	public static void main(String[]args)
	{
     Scanner sc=new Scanner(System.in);
	 int t=sc.nextInt();
	 int c=0;
	 while(t-->0)
	 {
	 	c++;
		p="";
		min=Integer.MAX_VALUE;
		int n=sc.nextInt();
		int m=sc.nextInt();
		String b="";
		method(0,0,n,m,0,b);
		if(p.equals(""))
		{
			System.out.println("Case #"+c+": "+"IMPOSSIBLE");
		}
		else
		{

			System.out.println("Case #"+c+": "+p);
		}
		
	 }
	}
}