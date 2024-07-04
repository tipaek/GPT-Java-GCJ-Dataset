import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = sc.nextInt();
    int[][] arr;
    HashSet<Integer> hs = new HashSet<Integer>();
    int N, R, C, trace;
    for (int i = 1; i <= t; ++i) {
        N = sc.nextInt();
        R = 0;
        C = 0;
        trace = 0;
        arr = new int[N+1][N+1];
        for(int j=1; j<=N; j++) {
            for(int k=1; k<=N; k++) {
                arr[j][k] = sc.nextInt();
                if(j==k)
                    trace += arr[j][k];
            }
        }
        for(int j=1; j<=N; j++) {
            hs.clear();
            for(int k=1; k<=N; k++) {
                if(hs.contains(arr[j][k])) {
                    R++;
                    break;
                } else
                    hs.add(arr[j][k]);
            }
        }
        for(int j=1; j<=N; j++) {
            hs.clear();
            for(int k=1; k<=N; k++) {
                if(hs.contains(arr[k][j])) {
                    C++;
                    break;
                } else
                    hs.add(arr[k][j]);
            }
        }
        System.out.println("Case #" + i + ": " + trace + " " + R + " " + C);
    }
  }
}