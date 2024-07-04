
import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();

            int trace = 0;

            Map<Integer, TreeSet<Integer>> column = new HashMap<Integer, TreeSet<Integer>>();
            Map<Integer, TreeSet<Integer>> row = new HashMap<Integer, TreeSet<Integer>>();
            for (int index = 0; index < n; index++) {
                column.put(index, new TreeSet<Integer>());
                row.put(index, new TreeSet<Integer>());
                for (int j = 1; j <= n; j++) {
                    column.get(index).add(j);
                    row.get(index).add(j);
                }
            }

            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    Integer a = in.nextInt();

                    column.get(c).remove(a);
                    row.get(r).remove(a);

                    if (r == c) {
                        trace += a;
                    }

                }
            }

            int c = 0;
            int r = 0;
            for (int index = 0; index < n; index++) {
                if (row.get(index).size() > 0){
                    r++;
                }
                if (column.get(index).size() > 0){
                    c++;
                }
            }


            System.out.println("Case #" + i + ": " + trace + " " + (r) + " " + (c));
        }
    }
}