import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        // For each test case
        for (int i = 1; i <= t; ++i) {
            // read the dimension
            int dimension = in.nextInt();
            int traceSum = 0;

            // create a list of lists to hold each row
            List<List<Integer>> listOfRows = new ArrayList();

            // read each row
            for (int row = 1; row <= dimension; ++row) {
                List<Integer> currentRow = new ArrayList();
                //read each element in the row
                for (int col = 1; col <= dimension; ++col) {
                    int value = in.nextInt();
                    currentRow.add(value);
                    if (row == col) {
                        traceSum += value;
                    }
                } // end of row each element in row
                listOfRows.add(currentRow);
            } // end of for each row

            int badColumns = 0;
            int badRows = 0;

            // Convert each row to a set.  if size is equal, row is good.
            for (List<Integer> row : listOfRows) {
                Set<Integer> rowSet = new HashSet(row);
                if (row.size() != rowSet.size()) {
                    badRows++;
                }
            }

            // build list of columns by transposing the list of rows
            List<List<Integer>> listOfColumns = new ArrayList(transpose(listOfRows));

            // Convert each row to a set.  if size is equal, row is good.
            for (List<Integer> row : listOfColumns) {
                Set<Integer> rowSet = new HashSet(row);
                if (row.size() != rowSet.size()) {
                    badColumns++;
                }
            }

            System.out.println("Case #" + i + ": " + traceSum + " " + badRows + " " + badColumns);
        } // end of for each test case

    }

    // found this online for transposing a list of a list
    static <T> List<List<T>> transpose(List<List<T>> table) {
        List<List<T>> ret = new ArrayList<>();
        final int N = table.get(0).size();
        for (int i = 0; i < N; i++) {
            List<T> col = new ArrayList<>();
            for (List<T> row : table) {
                col.add(row.get(i));
            }
            ret.add(col);
        }
        return ret;
    }
}
