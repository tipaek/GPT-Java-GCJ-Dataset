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
            long trace = 0;

            // i is row number
            for (int i = 0; i < N; ++i) {
                // j is column number
                for (int j = 0; j < N; ++j) {
                    int cellValue = in.nextInt();
                    if(i == j) {
                        trace += cellValue;
                    }
                    //columnSums[j] ^= (cellValue ^ (i + 1));
                    //rowSums[i] ^= (cellValue ^ (j + 1));
                    columnSums[j] += cellValue;
                    rowSums[i] += cellValue;
                }
            }

            int numDuplColumns = 0;
            int numDuplRows = 0;
            int gaus = ((N*N) + N)/2;
            for (int i = 0; i < N; ++i) {
                if (columnSums[i] != gaus) {
                    numDuplColumns++;
                }
                if (rowSums[i] != gaus) {
                    numDuplRows++;
                }
            }
            System.out.println("Case #" + (numTestCase+1) + ": " + trace + " " + numDuplRows + " " + numDuplColumns);
        }
    }

}