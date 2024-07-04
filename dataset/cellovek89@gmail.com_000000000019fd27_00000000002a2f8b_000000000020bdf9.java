import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main (String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] toks = reader.readLine().split(" ");
        int t = Integer.parseInt(toks[0]);
        for (int test = 0; test < t; test++) {
            toks = reader.readLine().split(" ");
            int n = Integer.parseInt(toks[0]);
            int[] time = new int[1440];
            int index = 0;
            int[][] matrix = new int[n][4];
            for (int i = 0; i < n; i++) {
                toks = reader.readLine().split(" ");
                int start = Integer.parseInt(toks[0]);
                int finish = Integer.parseInt(toks[1]);
                matrix[i][0] = start;
                matrix[i][1] = finish;
                matrix[i][2] = 10;
                matrix[i][3] = i;
                for (int j = start; j < finish; j++) {
                    time[j]++;
                    if (time[j] > 2) index = 1;
                }
                if (index == 1) {
                    System.out.println("Case #" + (test + 1) + ": IMPOSSIBLE");
                    break;
                }
            }
            if (index == 0) {
                StringBuilder sb = new StringBuilder("");
                sb.append("Case #");
                sb.append(test + 1);
                sb.append(": ");
                Arrays.sort(matrix, Comparator.comparingInt(a -> a[0]));
                matrix[0][2] = 0;
                int current = 0;
                for (int i = 0; i < n; i++) {
                    if (time[matrix[i][0]] == 1) {
                        matrix[i][2] = current;
                    } else {
                        for (int k = 0; k < i; k++) {
                            if ((matrix[k][1] > matrix[i][0]) && (matrix[k][2] == current)) {
                                current = current ^ 1;
                                break;
                            }
                        }
                        matrix[i][2] = current;
                    }
                }
                Arrays.sort(matrix, Comparator.comparingInt(a -> a[3]));
                for (int i = 0; i < n; i++) {
                    if (matrix[i][2] == 0) sb.append('C');
                    else sb.append('J');
                }
                System.out.println(sb);

            }

        }
    }
}
