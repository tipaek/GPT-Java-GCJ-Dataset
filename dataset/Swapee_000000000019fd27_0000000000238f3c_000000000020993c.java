import java.util.*;
import java.io.*;
public class Solution {
    public static int countR(int arr[][], int N) {
        int count=0;
        for (int i=0; i<N; i++)
        {
            for (int j=0; j<N-1; j++)
            {
                for (int k=j+1; k<N; k++)
                {
                    if(arr[i][j]==arr[i][k]) {
                    count++;
                    k=N;
                    j=N;
                    }
                }
            }
        }
        return count;
    }
    public static int countC(int arr[][], int N) {
        int count=0;
        for (int i=0; i<N; i++)
        {
            for (int j=0; j<N-1; j++)
            {
                for (int k=j+1; k<N; k++)
                {
                    if(arr[j][i]==arr[k][i]) {
                    count++;
                    k=N;
                    j=N;
                    }
                }
            }
        }
        return count;
    }
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= T; ++i) {
        int N=in.nextInt();
        int arr[][]=new int[N][N];
        int sum=0;
        for (int j=1; j<=N; j++) {
            for (int k=1; k<=N; k++) {
                arr[j-1][k-1]=in.nextInt();
                if((j-1)==(k-1))
                {
                    sum=sum+arr[j-1][k-1];
                }
            }
        }
      int row=countR(arr,N);
      int col=countC(arr,N);
      System.out.println("Case #" + i + ": " + sum + " " + row + " " + col);
    }
  }
}