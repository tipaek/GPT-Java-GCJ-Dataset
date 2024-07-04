import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Expogo
{
   static String calculate(int x,int y)
    {
        int a=x,b=y;
        String s="";
		    x=(int)Math.abs(x);
		    y=(int)Math.abs(y);
		    if((x+y)%2==1)
		    {
		        int p=(int)(Math.log(x+y)/Math.log(2));
		        while(p>-1)
		        {
		        if(Math.abs(a)>Math.abs(b))
		        {
		            if(a>0)
		            {
		                s="E"+s;
		                a=a-(int)Math.pow(2,p);
		            }
		            else
		            {
		                s="W"+s;
		                a=a+(int)Math.pow(2,p);
		            }
		        }
		        else
		        {
		            if(b>0)
		            {
		                s="N"+s;
		                b=b-(int)Math.pow(2,p);
		            }
		            else
		            {
		                s="S"+s;
		                b=b+(int)Math.pow(2,p);
		            }
		        }
		        p--;
		        }
		        
		        
		    }
		    else
		    s="IMPOSSIBLE";
		    return s;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int d=1;
		while(t-->0)
		{
		    int x,y;
		   // String s="";
		    x=sc.nextInt();
		    y=sc.nextInt();
		    String s=calculate(x,y);
		    System.out.println("Case #"+d+": "+s);
		    d++;
		}
	}
}