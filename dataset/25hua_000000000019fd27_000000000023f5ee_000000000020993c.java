import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseCount = sc.nextInt();
        int index = 0;
        while (index < caseCount) {
            index++;
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int k = 0;
            int r = 0;
            int c = 0;

            Set<Integer> exists = new HashSet<>();
            for (int i = 0; i < n; i++) {
                boolean r_flag = false;
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (!r_flag && exists.contains(matrix[i][j])) {
                        r++;
                        r_flag = true;
                    } else {
                        exists.add(matrix[i][j]);
                    }
                    if (i == j) {
                        k += matrix[i][j];
                    }
                }
                exists.clear();
            }

            for (int i = 0; i < n; i++) {
                boolean c_flag = false;
                for (int j = 0; j < n; j++) {
                    if (!c_flag && exists.contains(matrix[j][i])) {
                        c++;
                        c_flag = true;
                    } else {
                        exists.add(matrix[j][i]);
                    }
                }
                exists.clear();
            }
            System.out.printf("Case #%d: %d %d %d\n", index, k, r, c);
        }
    }
}