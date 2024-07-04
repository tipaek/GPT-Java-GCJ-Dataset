import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        int t = nextInt();
        for (int cn = 1; cn <= t; cn++) {
            int n = nextInt();

            int[][] mx = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mx[i][j] = nextInt();
                }
            }

            int trace = 0;
            for (int x = 0; x < n; x++) {
                trace += mx[x][x];
            }

            int dup_rows = 0;
            Set<Integer> ints = new HashSet<>();
            for (int row = 0; row < n; row++) {
                ints.clear();
                for (int column = 0; column < n; column++) {
                    if (ints.add(mx[row][column])) continue;
                    dup_rows++;
                    break;
                }
            }

            int dup_columns = 0;
            for (int column = 0; column < n; column++) {
                ints.clear();
                for (int row = 0; row < n; row++) {
                    if (ints.add(mx[row][column])) continue;
                    dup_columns++;
                    break;
                }
            }

            System.out.print("Case #");
            System.out.print(cn);
            System.out.print(": ");

            System.out.print(trace);
            System.out.print(" ");
            System.out.print(dup_rows);
            System.out.print(" ");
            System.out.print(dup_columns);

            System.out.println();
            System.out.flush();
        }
    }


    static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    static String next() throws IOException {
        in.nextToken();
        return in.sval;
    }
}
