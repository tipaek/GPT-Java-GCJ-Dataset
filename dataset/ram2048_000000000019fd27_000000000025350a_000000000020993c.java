import java.util.*;
import java.io.*;

public class Solution {

  public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            int trace = 0;
            int repeatingRow = 0;
            int repeatingCol = 0;
            Set[] colSets = new Set[n];
            for (int c = 0; c < n; c++) {
                colSets[c] = new HashSet<Integer>();
            }
            for (int j = 0; j < n; j++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    int v = in.nextInt();
                    
                    if (rowSet != null) {
                        if (rowSet.contains(v)) {
                            rowSet = null;
                            repeatingRow++;
                        } else {
                            rowSet.add(v);
                        }
                    }
                    
                    Set<Integer> colSet = (Set<Integer>) colSets[k];
                    if (colSet != null) {
                        if (colSet.contains(v)) {
                            repeatingCol++;
                            colSets[k] = null;
                        } else {
                            colSet.add(v);
                        }
                    }
                    
                    if (j == k) {
                        trace += v;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + repeatingRow + " " + repeatingCol);
        }
    }

}