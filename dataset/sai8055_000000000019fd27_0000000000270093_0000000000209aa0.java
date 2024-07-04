import java.util.*;
class Solution{
  static void construct(int n,int sum){
      int k = sum/n;
      int mat[][] = new int[n][n];
      for(int i =0;i<n;i++)
      {
        mat[i][i] = k;
      }
      for(int i=0;i<n;i++)
      {
        for(int j = 0;j<n;j++ )
        {
          System.out.print(mat[i][j]+" ");
        }
        System.out.println();
      }
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for(int i =1;i<=t;i++)
    {
      System.out.print("Case #"+i+": ");
      int n = sc.nextInt();
      int sum = sc.nextInt();
      if((sum%n) == 0 && sum<=(n*n))
      {
        System.out.print("POSSIBLE\n");
        construct(n,sum);
      }
      else{
        System.out.println("IMPOSSIBLE\n");
      }
    }
  }
}
