import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
      public static void main(String[] args) {
          Vestigium.Run();
      }
}
class Vestigium {
    public static void Run() {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int i=0; i<t; i++) {
            int n = sc.nextInt();
            int arr[][]= new int[n][n];
            for (int j=0; j<n; j++) {
                for (int k=0; k<n; k++) {
                    arr[j][k] = sc.nextInt();
                }
            }
            int ans = 0;
            for (int j=0; j<n; j++) {
                ans += arr[j][j];
            }
            int rows = 0, cols = 0;
            boolean present[] = new boolean[n+1];
            for (int j=0; j<n; j++) {
                initBooleanArray(n, present);
                for (int k=0; k<n; k++) {
                    if (present[arr[j][k]]) {
                        rows++;
                        break;
                    }
                    present[arr[j][k]] = true;
                }
            }
            for (int j=0; j<n; j++) {
                initBooleanArray(n, present);
                for (int k=0; k<n; k++) {
                    if (present[arr[k][j]]) {
                        cols++;
                        break;
                    }
                    present[arr[k][j]] = true;
                }
            }
            printOutput(i+1, ans, rows, cols);
        }
    }

    private static void initBooleanArray(int n, boolean[] present) {
        for (int k = 0; k <= n; k++)
            present[k] = false;
    }

    private static void printOutput(int testCase, int ans, int rows, int cols) {
        System.out.printf("Case #%d: %d %d %d\n", testCase, ans, rows, cols);
    }
}