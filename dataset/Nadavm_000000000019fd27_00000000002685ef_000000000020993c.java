import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int[][] arr;
        int T = in.nextInt();
        for (int K = 1; K <= T; K++) {
            int N = in.nextInt();
            arr = new int[N][N];
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                    arr[i][j] = in.nextInt();
            }
            System.out.print("Case #" + K + ": ");
            func(arr, N);
        }
    }
    public static void func(int[][] arr, int N)
    {
        int[] row = new int[N], col = new int[N];
        int sum = 0, imbR = 0, imbC = 0;
        boolean rf, cf;
        for (int i = 0; i < N; i++)
        {
            sum = sum + arr[i][i];
            cf = true;
            rf = true;
            for (int a = 0; a < N; a++)
            {
                row[a] = 0;
                col[a] = 0;
            }
            for (int j = 0; j < N; j++) {
                if (row[arr[i][j] - 1] != 0 && rf) {
                    imbR++;
                    rf = false;
                } else
                    row[arr[i][j] - 1]++;
                if (col[arr[j][i] - 1] != 0 && cf){
                    imbC++;
                    cf = false;
                }
                else {
                    col[arr[j][i] - 1]++;
                }
            }
        }
        System.out.println(sum + " " + imbR + " " + imbC);
    }
}