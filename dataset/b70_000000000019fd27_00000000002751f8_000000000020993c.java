import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int n = 0; n < T; n ++) {
            int N = in.nextInt();
            int[][] array = new int[N][N];
            int r = 0; int c = 0; int sum = 0;
            for (int i = 0; i < N; i ++) {
                for (int j = 0; j < N; j ++) {
                    array[i][j] = in.nextInt();
                }
                sum = traceArray(array, N);
                r = findRepeatRow(array, N);
                c = findRepeatCol(array, N);
            }
            System.out.println("Case #" + (n + 1) + ": " + sum + " " + r + " " + c);
        }
    }
    
    public static int traceArray(int[][] array, int n) {
        int a = 0;
        for (int i = 0; i < n; i ++) {
            a += array[i][i];
        }
        return a;
    }
    
    public static int findRepeatRow(int[][] array, int n) {
        int r = 0;
        for (int[] arr: array) {
            int[] count = new int[n + 1];
            for (int i = 0; i < n; i ++) {
                if (count[arr[i]] == 1) {
                    r += 1;
                    break;
                }
                else count[arr[i]]++;
            }
        }
        return r;
    }
    
    public static int findRepeatCol(int[][] array, int n) {
        int c = 0;
        for (int i = 0; i < n; i ++) {
            int[] count = new int[n + 1];
            for (int j = 0; j < n; j ++) {
                if (count[array[j][i]] == 1) {
                    c += 1;
                    break;
                }
                else count[array[j][i]]++;
            }
        }
        return c;
    }
}