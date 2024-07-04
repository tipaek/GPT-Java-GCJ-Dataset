/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int d=1;
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int k=sc.nextInt();
		    if(n==2)
		    {
		        if(k==2)
		        {
		            System.out.println("Case #"+d+": POSSIBLE");
		            System.out.println("1 2\n2 1");
		        }
		        else if(k==4)
		        {
		            System.out.println("Case #"+d+": POSSIBLE");
		            System.out.println("2 1\n1 2");
		        }
		        else
		        System.out.println("Case #"+d+": IMPOSSIBLE");
		    }
		    else if(n==3)
		    {
		        if(k==3)
		        {
		             System.out.println("Case #"+d+": POSSIBLE");
		             System.out.println("1 2 3\n3 1 2\n2 3 1");
		        }
		        else if(k==6)
		        {
		             System.out.println("Case #"+d+": POSSIBLE");
		             System.out.println("1 2 3\n2 3 1\n3 1 2");
		        }
		        else if(k==9)
		        {
		             System.out.println("Case #"+d+": POSSIBLE");
		             System.out.println("3 2 1\n1 3 2\n2 1 3");
		        }
		        else
                     System.out.println("Case #"+d+": IMPOSSIBLE");		   
            }
            else if(n==4)
            {
                if(k==4)
                {
                    System.out.println("Case #"+d+": POSSIBLE");
		             System.out.println("1 2 3 4\n2 1 4 3\n3 4 1 2\n4 3 2 1");
                }
                else if(k==8)
                {
                    System.out.println("Case #"+d+": POSSIBLE");
		             System.out.println("1 2 3 4\n2 3 4 1\n3 4 1 2\n4 1 2 3");
                }
                else if(k==12)
                {
                    System.out.println("Case #"+d+": POSSIBLE");
		             System.out.println("2 3 4 1\n3 4 1 2\n4 1 2 3\n1 2 3 4");
                }
                else if(k==10)
                {
                    System.out.println("Case #"+d+": POSSIBLE");
		             System.out.println("1 2 3 4\n3 4 1 2\n4 3 2 1\n2 1 4 3");
                }
                else if(k==7)
                {
                    System.out.println("Case #"+d+": POSSIBLE");
		             System.out.println("1 2 4 3\n4 3 1 2\n3 1 2 4\n2 4 3 1");
                }
                else if(k==9)
                {
                    System.out.println("Case #"+d+": POSSIBLE");
		             System.out.println("4 1 3 2\n1 3 2 4\n2 4 1 3\n3 2 4 1");
                }
                else if(k==11)
                {
                    System.out.println("Case #"+d+": POSSIBLE");
		             System.out.println("4 2 3 1\n2 3 1 4\n1 4 2 3\n3 1 4 2");
                }
                else if(k==13)
                {
                    System.out.println("Case #"+d+": POSSIBLE");
		             System.out.println("3 4 2 1\n4 2 1 3\n1 3 4 2\n2 1 3 4");
                }
                else if(k==6)
                {
                    System.out.println("Case #"+d+": POSSIBLE");
		             System.out.println("2 1 3 4\n1 2 4 3\n4 3 1 2\n3 4 2 1");
                }
                else if(k==14)
                {
                    System.out.println("Case #"+d+": POSSIBLE");
		             System.out.println("4 3 1 2\n3 4 2 1\n2 1 3 4\n1 2 4 3");
                }
                else if(k==16)
                {
                    System.out.println("Case #"+d+": POSSIBLE");
		             System.out.println("4 1 2 3\n3 4 1 2\n2 3 4 1\n1 2 3 4");
                }
                else
                System.out.println("Case #"+d+": IMPOSSIBLE");	
            }
            else if(n==5)
            {
                if(k==9)
                {
                    System.out.println("Case #"+d+": POSSIBLE");
		             System.out.println("1 4 2 3 5\n2 1 4 5 3\n5 2 3 4 1\n3 5 1 2 4\n4 3 5 1 2");
                }
                else if(k==10)
                {
                    System.out.println("Case #"+d+": POSSIBLE");
		             System.out.println("1 3 2 4 5\n2 1 3 5 4\n5 2 4 3 1\n4 5 1 2 3\n3 4 5 1 2");
                }
                else if(k==11)
                {
                    System.out.println("Case #"+d+": POSSIBLE");
		             System.out.println("1 3 2 5 4\n2 1 3 4 5\n4 2 5 3 1\n5 4 1 2 3\n3 5 4 1 2");
                }
                else if(k==12)
                {
                    System.out.println("Case #"+d+": POSSIBLE");
		             System.out.println("1 2 3 4 5\n3 1 2 5 4\n5 3 4 2 1\n4 5 1 3 2\n2 4 5 1 3");
                }
                else if(k==13)
                {
                    System.out.println("Case #"+d+": POSSIBLE");
		             System.out.println("1 2 3 5 4\n3 1 2 4 5\n4 3 5 2 1\n5 4 1 3 2\n2 5 4 1 3");
                }
                else if(k==15)
                {
                    System.out.println("Case #"+d+": POSSIBLE");
		             System.out.println("1 2 4 5 3\n4 1 2 3 5\n3 4 5 2 1\n5 3 1 4 2\n2 5 3 1 4");
                }
                else if(k==14)
                {
                    System.out.println("Case #"+d+": POSSIBLE");
		             System.out.println("1 3 5 2 4\n5 1 3 4 2\n4 5 2 3 1\n2 4 1 5 3\n3 2 4 1 5");
                }
                else if(k==16)
                {
                    System.out.println("Case #"+d+": POSSIBLE");
		             System.out.println("1 3 5 4 2\n5 1 3 2 4\n2 5 4 3 1\n4 2 1 5 3\n3 4 2 1 5");
                }
                else if(k==17)
                {
                    System.out.println("Case #"+d+": POSSIBLE");
		             System.out.println("4 1 2 5 3\n2 4 1 3 5\n3 2 5 1 4\n5 3 4 2 1\n1 5 3 4 2");
                }
                else if(k==18)
                {
                    System.out.println("Case #"+d+": POSSIBLE");
		             System.out.println("5 1 2 4 3\n2 5 1 3 4\n3 2 4 1 5\n4 3 5 2 1\n1 4 3 5 2");
                }
                else if(k==19)
                {
                    System.out.println("Case #"+d+": POSSIBLE");
		             System.out.println("4 1 3 5 2\n3 4 1 2 5\n2 3 5 1 4\n5 2 4 3 1\n1 5 2 4 3");
                }
                else if(k==20)
                {
                    System.out.println("Case #"+d+": POSSIBLE");
		             System.out.println("5 1 3 4 2\n3 5 1 2 4\n2 3 4 1 5\n4 2 5 3 1\n1 4 2 5 3");
                }
                else if(k==21)
                {
                    System.out.println("Case #"+d+": POSSIBLE");
		             System.out.println("5 1 4 3 2\n4 5 1 2 3\n2 4 3 1 5\n3 2 5 4 1\n1 3 2 5 4");
                }
                else if(k==22)
                {
                    System.out.println("Case #"+d+": POSSIBLE");
		             System.out.println("3 2 4 1 5\n2 5 1 4 3\n4 3 5 2 1\n1 4 3 5 2\n5 1 2 3 4");
                }
                else if(k==5)
                {
                    System.out.println("Case #"+d+": POSSIBLE");
		             System.out.println("1 2 3 4 5\n3 1 5 2 4\n4 3 1 5 2\n2 5 4 1 3\n5 4 2 3 1");
                }
                else if(k==25)
                {
                    System.out.println("Case #"+d+": POSSIBLE");
		             System.out.println("5 1 3 2 4\n3 5 4 1 2\n2 3 5 4 1\n1 4 2 5 3\n4 2 1 3 5");
                }
                else
                System.out.println("Case #"+d+": IMPOSSIBLE");
            }
		}
	}
}
