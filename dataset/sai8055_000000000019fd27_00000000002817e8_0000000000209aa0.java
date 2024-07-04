import java.util.*;
public class Solution{

  static void construct(int n,int sum){
      int k = sum/n;
      int arr[] =new int[n];
      arr[0] = k;
      for(int i = 1; i<n;i++)
      {
        if(i+1 == k)
          arr[i] = 1;
        else
          arr[i] = i+1;
      }
      for(int i = 0;i<n;i++)
      {
        System.out.print(arr[i]+" ");
      }
      for(int i = 1;i<n;i++)
      {
        int temp = arr[n-1];
        for(int j = n-1; j>0;j--)
          arr[j] = arr[j-1];
        arr[0] = temp;
        System.out.println();
        for(int p = 0;p<n;p++)
        {
          System.out.print(arr[p]+" ");
        }
      }
      System.out.println();

  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for(int i =1;i<=t;i++)
    {
      int n = sc.nextInt();
      int sum = sc.nextInt();
      String res = "";
      if((sum%n) == 0 && sum<=(n*n))
      {
        res="POSSIBLE";
      }
      else{
        res = "IMPOSSIBLE";
      }
      System.out.println("Case #"+i+": "+res);
      if(res == "POSSIBLE")
        construct(n,sum);
    }
  }
}
