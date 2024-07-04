import java.util.*;
import java.io.*;
public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int testCase = 0; testCase < T; testCase++) {
            int N = in.nextInt();
            int numRepeatedRows = 0;
            int numRepeatedCols = 0;
            int trace = 0;
            HashSet<Integer>[] rows = new HashSet[N];
            HashSet<Integer>[] cols = new HashSet[N];
            for (int i = 0; i < N; i++) {
                rows[i] = new HashSet<Integer>();
                cols[i] = new HashSet<Integer>();
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int current = in.nextInt();
                    if (i == j) {
                        trace += current;
                    }
                    if (rows[i].contains(current) && !rows[i].contains(0)) {
                        rows[i].add(0);
                        numRepeatedRows++;
                    }
                    if (cols[j].contains(current) && !cols[j].contains(0)) {
                        cols[j].add(0);
                        numRepeatedCols++;
                    }
                    rows[i].add(current);
                    cols[j].add(current);
                }
            }
            System.out.println("Case #" + (testCase + 1) + ": " + trace + " " + numRepeatedRows + " " + numRepeatedCols);
        }
    }

}
