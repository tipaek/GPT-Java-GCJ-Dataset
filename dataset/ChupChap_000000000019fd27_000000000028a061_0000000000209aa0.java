import java.util.*;
import java.io.*;
public class Solution {
    public static String result(int N, int K)
    {
        int arr[][]= new int[N][N];
        int count=0;
        int sum=0;
        for (int i=1; i<=N; i++)
        {
            int v=i;
            for (int j=0; j<N; j++)
            {
                for (int k=0; k<N; k++)
                {
                    arr[j][k]=((k+v)%N)+1;
                    if(j==k)
                    {
                        sum=sum+arr[j][k];
                    }
                }
                v++;
            }
            //int sum=arr[0][0]+arr[1][1]+arr[2][2];
            if(sum==K)
            {
                
                
                //count++;
                //System.out.println("POSSIBLE");
                
              //  break;
              
              for(int l=0;l<N;l++)
               {
                   for(int m=0;m<N;m++)
                   {
                       System.out.print(arr[l][m]+" ");
                   }
                   System.out.println(" ");
               }
               return "POSSIBLE";
            }
            
        }
        return "IMPOSSIBLE";
       // if (count==0)
        //{
          //  System.out.println("IMPOSSIBLE");
        //}
    }
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= T; ++i) {
      int N = in.nextInt();
      int K = in.nextInt();
      System.out.println("Case #" + i + ": " + result(N,K));
    }
  }
}