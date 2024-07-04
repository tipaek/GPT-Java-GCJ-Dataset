import java.util.*;
import java.io.*;
class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        solve(in);
    }

    public static void solve(Scanner scanner) {
        int numberOfCase = scanner.nextInt();

        for (int ca = 1; ca <= numberOfCase; ca++) {
            int size = scanner.nextInt();
            int k = 0;
            int r = 0;
            int c = 0;
            int[][] matrix = new int[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) k += matrix[i][j];
                }
            }

            for (int i = 0; i < size; i++) {
                HashSet<Integer> set = new HashSet<Integer>();
                for (int j = 0; j < size; j++) {
                    if (set.contains(matrix[i][j])) {
                        r++;
                        break;
                    } else {
                        set.add(matrix[i][j]);
                    }
                }
            }

            for (int j = 0; j < size; j++) {
                HashSet<Integer> set = new HashSet<Integer>();
                for (int i = 0; i < size; i++) {
                    if (set.contains(matrix[i][j])) {
                        c++;
                        break;
                    } else {
                        set.add(matrix[i][j]);
                    }
                }
            }

            System.out.println("Case #" + ca + ":" + k + r + c);
        }
    }

}
