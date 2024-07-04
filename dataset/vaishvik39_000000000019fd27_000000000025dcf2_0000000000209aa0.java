import java.util.Scanner;
public class MyClass {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      int i,j,k,l=0,m,n,sum=0,s;
      int t = sc.nextInt();
      for(i=0;i<t;i++)
      {
          n=sc.nextInt();
          int a[] = new int[n];
          k=sc.nextInt();
          
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
          else
          {
              System.out.println("Case"+" "+"#"+(i+1)+": "+"IMPOSSIBLE");
          }
      }
    }
}