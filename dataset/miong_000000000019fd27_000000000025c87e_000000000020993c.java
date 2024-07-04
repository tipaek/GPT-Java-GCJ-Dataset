import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int[][] res = new int[t][3];

        for (int ti = 0; ti < t; ti++) {
            int n = sc.nextInt();
            int[][] m = new int[n][n];
            List<Integer> row = new ArrayList<>();
            List<Integer> col = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    m[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < n; i++) {
                row.clear();
                col.clear();
                for (int j = 0; j < n; j++) {
                    if (i == j)
                        res[ti][0] += m[i][j];
                    row.add(m[i][j]);
                    col.add(m[j][i]);
                }

                if (checkForDuplicates(row))
                    res[ti][1]++;
                if (checkForDuplicates(col))
                    res[ti][2]++;
            }
        }

        for (int i = 0; i < t; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            for (int j = 0; j < 3; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean checkForDuplicates(List<Integer> array) {
        HashSet<Integer> set = new HashSet<Integer>(array);

        return array.size() != set.size();
    }
}
