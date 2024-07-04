import java.util.HashSet;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int p = 0; p < t; p++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int k = 0;
            for (int i = 0; i < n; i++) {
                k += arr[i][i];
            }

            int r = 0, c = 0;
            HashSet<Integer> rowSet = new HashSet<>();
            HashSet<Integer> colSet = new HashSet<>();

            for (int i = 0; i < n; i++) {
                rowSet.clear();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(arr[i][j])) {
                        r++;
                        break;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                colSet.clear();
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(arr[j][i])) {
                        c++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + (p + 1) + ": " + k + " " + r + " " + c);
        }
    }
}