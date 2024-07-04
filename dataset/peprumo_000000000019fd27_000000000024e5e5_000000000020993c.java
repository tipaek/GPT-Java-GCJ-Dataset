import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tc = in.nextInt();
        for (int i = 0; i < tc; i++) {
            int ms = in.nextInt();
            int t = 0;
            int r = 0;
            int c = 0;
            List<Set<Integer>> cols = new ArrayList<>();
            Boolean[] repeatedCol = new Boolean[ms];
            Arrays.fill(repeatedCol, Boolean.FALSE);
            for (int j = 0; j < ms; ++j) {
                Set<Integer> rowNums = new HashSet<>();
                boolean repeatedRow = false;
                for (int k = 0; k < ms; ++k) {
                    if (j == 0) {
                        cols.add(new HashSet<>());
                    }
                    int n = in.nextInt();
                    if (j == k) {
                        t += n;
                    }
                    if (!repeatedRow && rowNums.contains(n)) {
                        r++;
                        repeatedRow = true;
                    } else {
                        rowNums.add(n);
                    }

                    if (!repeatedCol[k] && cols.get(k).contains(n)) {
                        c++;
                        repeatedCol[k] = true;
                    } else {
                        cols.get(k).add(n);
                    }
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + t + " " + r + " " + c);
        }
    }
}
