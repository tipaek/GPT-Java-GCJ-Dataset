import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 1; i <= t; ++i) {
            int arraySize = in.nextInt();
            int trace = 0;
            int repeatRows = 0;
            int repeatCols = 0;
            int tmpRepeatRows = 0;
            Map<Integer, Boolean> tmpRepeatCols = new HashMap<>();

            Map<Integer, Boolean> repeatersRow = new HashMap<Integer, Boolean>();
            List<Map<Integer, Boolean>> columnsTracker = new ArrayList<Map<Integer, Boolean>>();

            for (int j = 0; j < arraySize; j++) {
                for (int k = 0; k < arraySize; k++) {
                    columnsTracker.add(new HashMap<Integer, Boolean>());
                    int m = in.nextInt();
                    if (j == k) {
                        trace += m;
                    }

                    if (repeatersRow.put(m, true) != null) {
                        tmpRepeatRows = 1;
                    }
                    if (columnsTracker.get(k).put(m, true) != null) {
                        tmpRepeatCols.put(k, true);
                    }
                }
                repeatRows += tmpRepeatRows;
                repeatCols += tmpRepeatCols.size();
                tmpRepeatRows = 0;
                //tmpRepeatCols = new HashMap<Integer, Boolean>();
                repeatersRow = new HashMap<Integer, Boolean>();
            }
            System.out.println("Case #" + (i) + ": " + trace + " " + repeatRows + " " + tmpRepeatCols.size());
         // end
        }
    }
}
