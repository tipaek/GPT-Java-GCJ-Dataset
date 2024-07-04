import java.io.*;
import java.util.*;
public class Solution
{
    static long power[];
    static int r[]={1,-1,0,0};
    static int c[]={0,0,1,-1};
    static char dir[]={'S','N','E','W'};
    static boolean ans;
    static int num=100;
    static int k=1;
    public static void main(String ag[])
    {
        Scanner sc=new Scanner(System.in);
        int i,j,k;
        int T=sc.nextInt();
        k=1;
        int X=sc.nextInt();
	    int Y=sc.nextInt();
        while(T-- >0)
        {
	        boolean flag=false;
	        for(i=-5;i<=5;i++)
	        {
	            for(j=-5;j<=5;j++)
	            {
	                System.out.println(i+" "+j);
	                System.out.flush();
	                String s=sc.next();
	                if(s.equals("CENTER"))
	                {
	                    flag=true;
	                    break;
	                }
	            }
	            if(flag)
	            break;
	        }
	        if(flag&&T==0)
	        System.exit(0);
        }
    }
    
    
}