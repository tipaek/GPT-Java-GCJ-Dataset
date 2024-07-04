import java.util.Scanner;
public class Solution{
   public static void main(String args[])
   {
       Scanner sc = new Scanner(System.in);
       int t=sc.nextInt();
       for(int w=0;w<t;w++)
       {
          int n=sc.nextInt(); 
          int k=sc.nextInt();
          int a[][]=new int[n][n];
          int f=2;
          int y=w+1;
          
          if((k%n!=0)&&(k>=n)&&(k<=(n*n)))
              f=0;
          
          
          else if((k%n==0)&&(k>=n)&&(k<=(n*n)))
          {
              f=1;
              int s;
              
              for(int i=0;i<n;i++)
              {
                  s=k/n;
                  for(int j=i,x=0;x<n;x++,s++,j++)
                  {
                      if(s%(n+1)==0)
                          s=1;
                      if(j>=n)
                          j=j%n;
                      
                      a[i][j]=s;
                  }
              }   
          }
          System.out.print("Case #"+y+": ");
          if(f==0)
              System.out.print("IMPOSSIBLE\n");
          else if(f==1)
          {
              System.out.print("POSSIBLE\n");
               for(int i=0;i<n;i++)
              {
                  for(int j=0;j<n;j++)
                  {
                      System.out.print(a[i][j]+" ");
                  }
                  System.out.println();
              }
          }
       }
   }
}
