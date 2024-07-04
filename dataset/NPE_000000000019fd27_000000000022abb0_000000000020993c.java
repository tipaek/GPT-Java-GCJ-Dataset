import java.util.HashSet;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = scanner.nextInt();
                }
            }

            int k = 0, r = 0, c = 0;
            for (int j = 0; j < n; j++) {
                k += matrix[j][j];
            }

            HashSet<Integer> hashSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                hashSet.clear();
                for (int l = 0; l < n; l++) {
                    if (hashSet.contains(matrix[j][l])){
                        r++;
                        break;
                    }
                    else hashSet.add(matrix[j][l]);
                }
            }

            for (int j = 0; j < n; j++) {
                hashSet.clear();
                for (int l = 0; l < n; l++) {
                    if (hashSet.contains(matrix[l][j])){
                        c++;
                        break;
                    }
                    else hashSet.add(matrix[l][j]);
                }
            }

            System.out.printf("Case #%d: %d %d %d\n", t, k, r, c);

        }
    }
}
