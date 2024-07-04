import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {

            int trace = 0;
            int row = 0;
            int col = 0;

            int n = in.nextInt();

            List<Set<Integer>> thisColumn = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                thisColumn.add(new HashSet<>(n));
            }


            for (int r = 0; r < n; r++) {
                Set<Integer> thisRow = new HashSet<>(n);

                for (int c = 0; c < n; c++) {
                    int e = in.nextInt();

                    thisColumn.get(c).add(e);
                    thisRow.add(e);

                    if (r == c) {
                        trace += e;
                    }
                }

                if (thisRow.size() < n) {
                    row++;
                }
            }

            for (Set<Integer> s : thisColumn) {
                if (s.size() < n) {
                    col++;
                }
            }


            System.out.println("Case #" + i + ": " + trace + " " + row + " " + col);
        }
    }
}