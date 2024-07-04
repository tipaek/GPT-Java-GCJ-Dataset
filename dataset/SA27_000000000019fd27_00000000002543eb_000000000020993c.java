/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
 class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
	
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int l=0;l<t;l++)
        {
            int sum=0;int rc=0,cc=0;
            int size=in.nextInt();
            int ar[][]=new int[size][size];
            for(int i=0;i<size;i++)
            {
                
                ArrayList<Integer> original=new ArrayList<Integer>();
                
                for(int j=0;j<size;j++)
                {
                    ar[i][j]=in.nextInt();
                    if(i==j)
                    {
                        sum=sum+ar[i][j];
                    }
                    original.add(ar[i][j]);
                    
                    
                }
                Set<Integer> unique = new HashSet<Integer>(original);
                
                if(original.size()!=unique.size())
                {
                    rc++;
                }
            
              
            }
            for(int i=0;i<size;i++)
            {
                 ArrayList<Integer> original=new ArrayList<Integer>();
                 for(int j=0;j<size;j++)
                 {
                     original.add(ar[j][i]);
                 }
                  Set<Integer> unique = new HashSet<Integer>(original);
                   if(original.size()!=unique.size())
                {
                    cc++;
                }
            }
                System.out.println(sum + " " + rc  + " "+ cc);
            
        }
	}
}	


