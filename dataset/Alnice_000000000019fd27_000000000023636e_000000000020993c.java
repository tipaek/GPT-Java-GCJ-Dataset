import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numTestCases = in.nextInt();
        for (int numTestCase = 0; numTestCase < numTestCases; ++numTestCase) {
            int N = in.nextInt();
            int[] columnSums = new int[N];
            int[] rowSums = new int[N];
            int trace = 0;
            // i is column number
            for (int i = 0; i < N; ++i) {
                // j is row number
                for (int j = 0; j < N; ++j) {
                    int cellValue = in.nextInt();
                    if(i == j) {
                        trace += cellValue;
                    }
                    columnSums[i] ^= (cellValue ^ (j + 1));
                    rowSums[j] ^= (cellValue ^ (i + 1));
                }
            }
            int numDuplColumns = 0;
            int numDuplRows = 0;
            for (int i = 0; i < N; ++i) {
                if (columnSums[i] != 0) {
                    numDuplColumns++;
                }
                if (rowSums[i] != 0) {
                    numDuplRows++;
                }
            }
            System.out.println("Case #" + (numTestCase+1) + ": " + trace + " " + numDuplColumns + " " + numDuplRows);
        }
    }

}