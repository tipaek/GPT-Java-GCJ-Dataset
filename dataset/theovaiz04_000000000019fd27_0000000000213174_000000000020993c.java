import java.util.*;
class Main
{
 public static void main(String args[])
   {
      try
      {
       Scanner sc=new Scanner(System.in);
      Integer t,x;
      x=1;
      t=sc.nextInt();
      while(x<=t)
       {
         Integer n;
         n=sc.nextInt();
         Integer a[][]=new  Integer[n+1][n+1];
         Integer i,j;
         for(i=0;i<n;i++)
          {
            for(j=0;j<n;j++)
                a[i][j]=sc.nextInt();
          }
         /* for(i=0;i<n;i++)
            {
             for(j=0;j<n;j++)
               System.out.print(a[i]+" ");
             System.out.println();
            }*/
          Integer k,r,c;
          k=0;
          r=0;
          c=0;
          for(i=0;i<n;i++)
            {
             for(j=0;j<n;j++)
               {
                 if(i==j)
                   k=k+a[i][j];
                 if(a[i][j]==a[i][j+1])
                   r=r+1;
                 if(a[i][j]==a[i+1][j+1])
                   c=c+1;
                    
               }
            }
         x++;
       }  }
      catch(Exception e)
      {
          
      }
   }
}