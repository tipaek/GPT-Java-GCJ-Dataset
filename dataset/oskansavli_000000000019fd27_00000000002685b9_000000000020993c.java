
import java.util.*;
import java.io.*;

public class Solution {

    static int[][] matrix;
    static HashSet<Integer>[] rowSets;
    static HashSet<Integer>[] colSets;
    static int trace;
    static boolean[] rowContains;
    static boolean[] colContains;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int ti = 1; ti <= t; ++ti) {
            int n = in.nextInt();
            matrix = new int[n][n];
            rowSets = new HashSet[n];
            colSets = new HashSet[n];
            for (int i=0; i<n; i++) {
                rowSets[i] = new HashSet<>();
                colSets[i] = new HashSet<>();
            }
            trace = 0;
            rowContains = new boolean[n];
            colContains = new boolean[n];

            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    int val = in.nextInt();
                    if (i==j) {
                        trace += val;
                    }

                    if (rowSets[i].contains(val)) {
                        rowContains[i] = true;
                    }
                    rowSets[i].add(val);

                    if (colSets[j].contains(val)) {
                        colContains[j] = true;
                    }
                    colSets[j].add(val);
                }
            }

            int r = 0, c = 0;

            for (int i=0; i<n; i++) {
                if (rowContains[i]) {
                    r++;
                }
                if (colContains[i]) {
                    c++;
                }
            }

            System.out.println("Case #" + ti + ": " + trace + " " + r + " " + c);
        }
    }
}
