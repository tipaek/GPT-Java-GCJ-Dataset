import java.util.*;
import java.io.*;
public class Solution
{
    public static String sequence(int arr[][], int N) {
        int ar[]=new int[N];
        ar[0]=1;
        
        for(int i=1;i<N;i++)
        {
            int c=1;
            int j1=1;
            for(int j=0; j<i; j++)
            {
                if((arr[i][0]>arr[j][0] && arr[i][0]<arr[j][1]) || (arr[i][1]>arr[j][0] && arr[i][1]<arr[j][1]))
                {
                    if(ar[j]==1)
                    {
                        c--;
                    }
                    else if(ar[j]==0)
                    {
                        j1--;
                    }
                }
                else if(arr[i][0]<=arr[j][0] && arr[i][1]>=arr[i][1])
                {
                    if(ar[j]==1)
                    {
                        c--;
                    }
                    else if(ar[j]==0)
                    {
                        j1--;
                    }
                }
            }
            if (c==1)
            {
                ar[i]=1;
            }
            else if(j1==1)
            {
                ar[i]=0;
            }
            else
            {
                return "IMPOSSIBLE";
            }
        }
        String seq="C";
        for (int k=1;k<N;k++)
        {
            if(ar[k]==1)
            {
                seq=seq+"C";
            }
            else
            {
                seq=seq+"J";
            }
        }
        return seq;
    }
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= T; ++i) {
        int N=in.nextInt();
        int arr[][]=new int[N][2];
        for (int j=1; j<=N; j++) {
            for (int k=1; k<=2; k++) {
                arr[j-1][k-1]=in.nextInt();
            }
        }
        String seq=sequence(arr, N);
      System.out.println("Case #" + i + ": " + seq);
    }
  }
}