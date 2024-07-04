/*
Author:Govind_213
Problem link:

*/
import java.io.*;
import java.io.IOException;
import java.util.*;

public class Solution
{
     
     public static void main(String[]args) throws IOException
     {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tcs=Integer.parseInt(br.readLine());
        int i=0,j=0,k=0;
        for( j=0;j<tcs;j++)
         {
            int n=Integer.parseInt(br.readLine());

            int mat[][]=new int[n][n];
            int l=0,r=0,c=0;
            for( i=0;i<n;i++)
            {
               String s[]=br.readLine().split(" ");
               for(k=0;k<n;k++)
               {
                  mat[i][k]= Integer.parseInt(s[k]);
                  if(i==k)
                  {
                     l+=mat[i][k];
                  }
               }
            }
            // for row
            int maxcount=0;
            for( i=0;i<n;i++)
            { 
               HashMap<Integer,Integer> h=new HashMap<>();
               for(k=0;k<n;k++)
               {
                 if(!h.containsKey(mat[i][k]))
                 {
                     h.put(mat[i][k],1);
                 }
                 else
                 {
                    h.put(mat[i][k],h.get(mat[i][k])+1);
                    if(h.get(mat[i][k])>maxcount)
                    {
                       maxcount=h.get(mat[i][k]);
                    }
                 }
                 if(maxcount>r)
                 {
                    r=maxcount;
                 }
               }
            }
            //for column
            int maxcount_c=0;
            for( i=0;i<n;i++)
            { 
               HashMap<Integer,Integer> h=new HashMap<>();
               for(k=0;k<n;k++)
               {
                 if(!h.containsKey(mat[k][i]))
                 {
                     h.put(mat[k][i],1);
                 }
                 else
                 {
                    h.put(mat[k][i],h.get(mat[k][i])+1);
                    if(h.get(mat[k][i])>maxcount_c)
                    {
                       maxcount_c=h.get(mat[k][i]);
                    }
                 }
                 if(maxcount_c>c)
                 {
                    c=maxcount_c;
                 }
               }
            }
            System.out.println("Case #"+(i+1)+":"+l+" "+r+" "+c);
        }

     }
}