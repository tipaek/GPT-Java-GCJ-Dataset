import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nTestCases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 0; i < nTestCases; i++) {
            int N = in.nextInt();
            int inArr[][] = new int[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    inArr[j][k] = in.nextInt();
                }
            }
            checkLatinArray(i+1, inArr, N);
        }
    }

    private static void checkLatinArray(int nCase, int[][] inArr, int arrSize) {
        String columnCalc[] = new String[arrSize];
        boolean columnCheck[] = new boolean[arrSize];
        String fillString = String.format("%" + arrSize + "s", "").replace(' ', '0');
        Arrays.fill(columnCalc, fillString);
        Arrays.fill(columnCheck, false);

        int nColNonLatin = 0;
        int nRowNonLatin = 0;
        int trace = 0;
        boolean rowCheckDone = false;
        for (int i = 0; i < arrSize; i++) {
            Set rolSet = new HashSet<Integer>();
            for (int j = 0; j < arrSize; j++) {

                if ( i == j) {
                    trace += inArr[i][j];
                }

                if (!rowCheckDone && rolSet.contains(inArr[i][j])) {
                    nRowNonLatin++;
                    rowCheckDone = true;
                } else {
                    rolSet.add(inArr[i][j]);
                }

                if (!columnCheck[j] && columnCalc[j].charAt(inArr[i][j] - 1) == '1') {
                    nColNonLatin++;
                    columnCheck[j] = true;
                } else {
                    StringBuilder builder = new StringBuilder(columnCalc[j]);
                    builder.setCharAt(inArr[i][j] - 1, '1');
                    columnCalc[j] = builder.toString();
                }
            }
            rowCheckDone = false;
        }
        System.out.println("Case #" + nCase + ": " + trace + " " + nRowNonLatin + " " + nColNonLatin);
    }
}