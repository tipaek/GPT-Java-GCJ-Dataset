import java.io.*;
import java.util.*;
public class Solution{
    static String ans;
    static boolean flag;
	public static void main(String[]args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		int tc=sc.nextInt();
		for(int t=0;t<tc;t++)
		{
    		int x=sc.nextInt();
    	    int y=sc.nextInt();
    		
    		if((Math.abs(x)%2==1) && (Math.abs(y)%2==1))
    		{
    		    System.out.println("Case #"+(t+1)+": "+"IMPOSSIBLE");
    		    continue;
    		}
    		ans="AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
    		flag=false;
    		
    	    Find(0,0,x,y," ",1);
    	    
    	    if(flag==true)
    	    System.out.println("Case #"+(t+1)+": "+ans);
    	    else
    	    System.out.println("Case #"+(t+1)+": "+"IMPOSSIBLE");


    	}
    }
    
   private static void Find(int i, int j, int x, int y, 
                           String asf,int step)
   {
       if(i==x && j==y)
       {
           if(asf.length()<ans.length())
           {
               ans=new String(asf);
               flag=true;
               return;
           }
       }
       
       if(step>=9)
       {
           return;
       }
       
       int stepsize=(1<<(step-1));
       Find(i-stepsize,j,x,y,asf+"W",step+1);
       
       Find(i+stepsize,j,x,y,asf+"E",step+1);
       
       Find(i,j-stepsize,x,y,asf+"S",step+1);
       
       Find(i,j+stepsize,x,y,asf+"N",step+1);
       
   }
}
         