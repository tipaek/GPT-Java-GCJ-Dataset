import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += arr[i][i];
            }
            int row = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> set = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!set.add(arr[i][j])) {
                        row++;
                        break;
                    }
                }
            }
            int col = 0;
            for (int j = 0; j < n; j++) {
                Set<Integer> set = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!set.add(arr[i][j])) {
                        col++;
                        break;
                    }
                }
            }
            System.out.println("Case #" + t + ": " + trace + " " + row + " " + col);
        }
    }

}
