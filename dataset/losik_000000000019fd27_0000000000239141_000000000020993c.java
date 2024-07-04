
import java.util.*;
import java.io.*;

public class Solution {

    private static final int[][] data = new int[100][100];
    static int N;
    private static Set<Integer> uniq = new HashSet<>(200);

    public static void main(String[] args) {
        main(System.in);
    }

    public static void main(InputStream is) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(is)));
        int t = in.nextInt();
        for (int run = 1; run <= t; ++run) {
            Solution solution = new Solution();
            solution.N = in.nextInt();
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    data[row][col] = in.nextInt();
                }
            }
            long diag = 0;
            for (int i = 0; i < N; i++) {
                diag = diag + data[i][i];
            }
            int wrongRow = 0;
            int wrongCol = 0;

            for (int row = 0; row < N; row++) {
                uniq.clear();
                for (int col = 0; col < N; col++) {
                    if (!uniq.add(data[row][col])) {
                        wrongRow++;
                        break;
                    }
                }
            }

            for (int col = 0; col < N; col++) {
                uniq.clear();
                for (int row = 0; row < N; row++) {
                    if (!uniq.add(data[row][col])) {
                        wrongCol++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + run + ": " + diag + " " + wrongRow + " " + wrongCol);
            //in.nextLine();
        }
    }

}
