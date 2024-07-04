import java.util.Scanner;

public class Solution {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int z = 1; z <= t; z++) {
            int ans = 0;
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int k = 0, r = 0, c = 0;
            int[] rowSum = new int[n];
            int[] colSum = new int[n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(i == j) {
                        k += arr[i][j];
                    }
                    rowSum[i] += arr[i][j];
                    colSum[j] += arr[i][j];
                }
            }
            int excepted = (n * (n + 1)) / 2;
            for(int i = 0; i < n; i++) {
                if(rowSum[i] != excepted) {
                    r++;
                }
                if(colSum[i] != excepted) {
                    c++;
                }
            }
            System.out.println("Case #" + z + ": " + k + " " + r + " " + c);
        }
    }
}
