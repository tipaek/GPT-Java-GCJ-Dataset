import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numTestCases = in.nextInt();
        for (int numTestCase = 0; numTestCase < numTestCases; ++numTestCase) {
            int N = in.nextInt();
            List<Set<Integer>> columnValues = new ArrayList<>();
            List<Set<Integer>> rowValues = new ArrayList<>();
            for (int i = 0; i < N; ++i) {
                columnValues.add(new HashSet<>());
                rowValues.add(new HashSet<>());
            }
            //int[] columnSums = new int[N];
            //int[] rowSums = new int[N];
            long trace = 0;
            int numDuplColumns = 0;
            int numDuplRows = 0;
            // i is row number
            for (int i = 0; i < N; ++i) {
                // j is column number
                for (int j = 0; j < N; ++j) {
                    int cellValue = in.nextInt();
                    if (i == j) {
                        trace += cellValue;
                    }
                    Set<Integer> columnSet = columnValues.get(j);
                    if (columnSet != null && !columnSet.add(cellValue)) {
                        numDuplColumns++;
                        columnValues.set(j, null);
                    }

                    Set<Integer> rowSet = rowValues.get(i);
                    if (rowSet != null && !rowSet.add(cellValue)) {
                        numDuplRows++;
                        rowValues.set(i, null);
                    }
                    //columnSums[j] ^= (cellValue ^ (i + 1));
                    //rowSums[i] ^= (cellValue ^ (j + 1));
                }
            }


            /*for (int i = 0; i < N; ++i) {
                if (columnSums[i] != 0) {
                    numDuplColumns++;
                }
                if (rowSums[i] != 0) {
                    numDuplRows++;
                }
            }*/
            System.out.println("Case #" + (numTestCase + 1) + ": " + trace + " " + numDuplRows + " " + numDuplColumns);
        }
    }

}