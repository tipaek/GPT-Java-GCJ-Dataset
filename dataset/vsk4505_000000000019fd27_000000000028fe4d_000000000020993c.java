import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();

            int[][] array = new int[N][N];
            for (int m = 0; m < N; m++) {
                array[m] = new int[N];
                for (int n = 0; n < N; n++) {
                    array[m][n] = scanner.nextInt();
                }
            }

            int dSum = 0;
            int r = 0;
            int c = 0;
            for (int m = 0; m < N; m++) {
                HashSet<Integer> rSet = new HashSet<>();
                HashSet<Integer> cSet = new HashSet<>();
                for (int n = 0; n < N; n++) {
                    rSet.add(array[m][n]);
                    cSet.add(array[n][m]);
                    if (m == n) {
                        dSum += array[m][n];
                    }
                }
                if (rSet.size() < N) {
                    r++;
                }
                if (cSet.size() < N) {
                    c++;
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + dSum + " " + r + " " + c);
        }
    }
}
