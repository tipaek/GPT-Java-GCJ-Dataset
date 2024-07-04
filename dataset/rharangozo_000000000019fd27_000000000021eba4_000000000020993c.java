import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws RuntimeException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();
//        System.out.println(t);
        for (int c = 0; c < t; ++c) {
            int numRow = 0;
            int numCol = 0;
            int n = in.nextInt();
            in.nextLine();
//            System.out.println(n);
            String[][] matrix = new String[n][n]; //col-row
            for (int i = 0; i < n; ++i) {
                String line = in.nextLine().trim();
                String[] row = line.split(" ");
                for (int z = 0; z < n; ++z) {
                    if (i == 0) {
                        matrix[z] = new String[n];
                    }
                    matrix[z][i] = row[z];
                }
                if (hasDupes(row)) {
                    numRow++;
                }
            }
            int trace =0;
            for (int i = 0; i < n; ++i) {
                if (hasDupes(matrix[i])) {
                    numCol++;
                }
                trace += Integer.parseInt(matrix[i][i]);
            }



            System.out.println("Case #" + (c+1) + ": " + trace + " " + numRow + " " + numCol);
        }
    }

    private static boolean hasDupes(String[] a) {
        Set<String> s = new HashSet<String>();
        Collections.addAll(s, a);
        return a.length != s.size();
    }
}
