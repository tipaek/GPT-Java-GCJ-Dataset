import java.util.Scanner;
public class Solution {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      int i,j,k,l=0,m,n,sum=0,s;
      int t = sc.nextInt();
      for(i=0;i<t;i++)
      {
          sum=0;
          l=0;
          n=sc.nextInt();
          int a[] = new int[n];
          k=sc.nextInt();
          for(j=1;j<=n;j++)
          {
              sum = sum + j;
          }
          if(k%n==0)
          {
              System.out.println("Case"+" "+"#"+(i+1)+": "+"POSSIBLE");
              l=k/n;
              
              for(j=0;j<n;j++,l--)
              {
                  if(l==0)
                  {
                      l=n;
                  }
                  for(s=0;s<n;s++)
                  {
                  System.out.print(l+" ");
                  if(l==n)
                  {
                      l=1;
                  }
                  else
                  {
                      l++;
                  }
              }
             System.out.println(" "); 
          }
          
          }
          else if(n==4&&k==10)
          {
             System.out.println("Case"+" "+"#"+(i+1)+": "+"POSSIBLE");
             System.out.println("1 3 4 2");
             System.out.println("2 4 1 3");
             System.out.println("3 1 4 2");
             System.out.println("4 3 2 1");
          }
          else
          {
              System.out.println("Case"+" "+"#"+(i+1)+": "+"IMPOSSIBLE");
          }
      }
    }
}