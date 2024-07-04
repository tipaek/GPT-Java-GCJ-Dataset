/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Vestigium
{
	public static void main (String[] args) throws java.lang.Exception
	{
     int t=0;
     Scanner s=new Scanner(System.in);
     if(s.hasNext())
     t=s.nextInt();
     while(t>0 && t<=100)
     {
       int r=0,i=0,j=0;
       int rsum=0;
       int csum=0;
       int[][] arr;
       int trace=0;
       boolean barf=true;
       if(s.hasNext())
       r=s.nextInt();
       if(r>=2 && r<=100)
       {
         arr=new int[r][r];
         for(i=0;i<r;i++)
         {
             for(j=0;j<r;j++)
             {
                if(s.hasNext())
                 arr[i][j]=s.nextInt();
             }
         }
         
         for(i=0;i<r;i++)
         {  
             for(j=0;j<r;j++)
             {
                 if(arr[i][j]>r && arr[i][j]<=0)
                {
                    barf=false;
                }
             }
         }
         if(barf)
         {
         for(i=0;i<r;i++)
         {
            for(j=0;j<r;j++)
            {
                if(j==i)
                {
                    trace+=arr[i][j];
                }
            }
         }
         for(i=0;i<r;i++)
         {
             outer:
             for(j=0;j<r;j++)
             {
                 for(int cntr=j+1;cntr<r;cntr++)
                 {
                 if(arr[i][j]==arr[i][cntr])
                 {
                         rsum++;
                        break outer;
                 }
                 }
             }
         }
         for(i=0;i<r;i++)
         {
             inner:
             for(j=0;j<r;j++)
             {
                 for(int cntr1=j+1;cntr1<r;cntr1++)
                 {
                     if(arr[j][i]==arr[cntr1][i])
                     {
                            csum++;
                            break inner;
                     }
                 }
             }
         }
          System.out.println(trace + " " + rsum + " " +csum);
         }
       }
       t--;
     }
 }
}
