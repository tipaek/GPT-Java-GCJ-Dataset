import java.util.*;
class Matrix
{
    
    String cheak(int a[][],int n, int k)
    {
        int sum =0;
        for(int i =0 ;i<n;i++)
        {
            for(int j =0 ;j<n;j++)
            {
                if(i==j)
                {
                   sum =sum+a[i][j]; 
                }
            }
        }
        if(sum==k)
        {
            return "POSSIBLE";
        }
        return "IMPOSSIBLE";
    }
    
  public static void main(String []args)
  {
      Scanner sc = new Scanner(System.in);
      Matrix m = new Matrix();
      int t;
      t=sc.nextInt();
      
      for(int i =1;i<=t;i++)
      {
         int n,k;
         n=sc.nextInt();
         k=sc.nextInt();
         int [][] a= new int[n][n];
         String s = m.cheak(a,n,k);
         System.out.println("Case #"+i+":"+" "+s);
      }
  }
}
