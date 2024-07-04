import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int arr[][] = new int[n][n];
            int r = 0;

            for (int y = 0; y < n; y++) {
                Map<Integer, Integer> m = new HashMap<Integer, Integer>();
                for (int x = 0; x < n; x++) {
                    arr[x][y] = in.nextInt();
                    m.put(arr[x][y], arr[x][y]);
                }
                if (n > m.size()) {
                    r++;
                }
            }
            int k = calculationTrace(arr, n);
            int c = duplicatCntColumn(arr, n);

            System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
        }
        in.close();
    }

    private static int calculationTrace(int arr[][], int n) {

        int result = 0;

        for (int i = 0; i < n; i++) {
            result += arr[i][i];
        }
        return result;
    }

    private static int duplicatCntColumn(int arr[][], int n) {

        int result = 0;

        for (int x = 0; x < n; x++) {
            Map<Integer, Integer> m = new HashMap<Integer, Integer>();
            for (int y = 0; y < n; y++) {
                m.put(arr[x][y], arr[x][y]);
            }
            if (n > m.size()) {
                result++;
            }
        }
        return result;
    }

}
