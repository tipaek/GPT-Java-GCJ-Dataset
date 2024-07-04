import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution{
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int z=1;z<=t;z++)
        {
           int n=in.nextInt();
           int k=in.nextInt();
           boolean isPos=false;
           if(k%n==0 && k<=n*n)
           {
               isPos=true;
           }
           if(!isPos)
           {
               System.out.println("Case #"+z+": "+"IMPOSSIBLE");
           }
           else
           {
               System.out.println("Case #"+z+": "+"POSSIBLE");
               int arr[][]=new int[n][n];
               ArrayList<Integer> li=new ArrayList<Integer>();
               int ans=k/n;
               for(int i=0;i<n;i++)
               {
                    arr[i][i]=ans;
                    if(i+1!=ans)
                    {
                        li.add(i+1);
                    }
               }
               int x=0;
               int size=li.size();
               
               for(int i=0;i<n;i++)
               {
                   x=0;
                   for(int j=(i+1)%n;j<n;j=(j+1)%n)
                   {
                       if(i==j)
                       {
                           break;
                       }
                       else
                       {
                           arr[i][j]=li.get(x);
                           x=(x+1)%size;
                       }
                   }
               }
               for(int i=0;i<n;i++)
               {
                   for(int j=0;j<n;j++)
                   {
                       System.out.print(arr[i][j]+" ");
                   }
                   System.out.println();
               }
           }
        }
    }
}