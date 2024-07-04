import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        HashMap<Integer, ArrayList<Integer>> row = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> col = new HashMap<>();
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int trace = 0;
        ArrayList<Integer> rowVal;
        ArrayList<Integer> colVal;
        ArrayList<Integer> repeatedRow = new ArrayList<>();
        ArrayList<Integer> repeatedCol = new ArrayList<>();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    Integer m = in.nextInt();
                    if (!row.containsKey(j)) {
                        rowVal = new ArrayList<>();
                        rowVal.add(m);
                        row.put(j, rowVal);
                    } else {
                        rowVal = row.get(j);
                        if (rowVal.contains(m) && !repeatedRow.contains(j)) {
                            repeatedRow.add(j);
                        }
                        rowVal.add(m);
                    }
                    if (!col.containsKey(k)) {
                        colVal = new ArrayList<>();
                        colVal.add(m);
                        col.put(k, colVal);
                    } else {
                        colVal = col.get(k);
                        if (colVal.contains(m)  && !repeatedCol.contains(k)) {
                            repeatedCol.add(k);
                        }
                        colVal.add(m);
                    }
                    if (j == k) {
                        trace += m;
                    }
                }
                row.clear();
            }
            System.out.println("Case #" + i + ": " + trace + " " + repeatedRow.size() + " " + repeatedCol.size());
            trace=0;
            repeatedCol.clear();
            repeatedRow.clear();
            col.clear();
            row.clear();
        }
    }

}
