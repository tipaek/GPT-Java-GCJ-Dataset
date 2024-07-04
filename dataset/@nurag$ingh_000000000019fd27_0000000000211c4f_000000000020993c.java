import java.util.*;

public class Solution
{
   public static void main(String args[])
   {
      Scanner in=new Scanner(System.in);
      int t=in.nextInt();
      for(int l=0;l<t;l++)
      {
         int n=in.nextInt();
         int arr[][]=new int[n][n];
         HashSet r=new HashSet();
         HashSet c=new HashSet();
         int sum=0;
         int Rcount=0;
         int Ccount=0;
         for(int i=0;i<n;i++)
         {
           for(int j=0;j<n;j++)
           {
               arr[i][j]=in.nextInt();
               if(i==j)
               {
                  sum+=arr[i][j];
               }
           }
           
           r=new HashSet();
         }
         
         
         for(int i=0;i<n;i++)
         {
            for(int j=0;j<n;j++)
            {
               if(c.contains(arr[j][i])==true)
               {
                  Ccount++;
                  break;
               }
               else
               {
                c.add(arr[j][i]);
               }
            }
            c=new HashSet();
         }
         
         
         
         for(int i=0;i<n;i++)
         {
            for(int j=0;j<n;j++)
            {
               if(r.contains(arr[i][j])==true)
               {
                  Rcount++;
                  break;
               }
               else
               {
                 r.add(arr[i][j]);
               }
            }
            r=new HashSet();
         }
         
         System.out.println("Case #"+(l+1)+": "+sum+" "+Rcount+" "+Ccount);
      }
   }
}