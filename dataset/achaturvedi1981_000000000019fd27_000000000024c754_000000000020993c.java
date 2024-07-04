import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new    InputStreamReader(System.in)));
        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for(int i=0; i<T; i++){
            int N = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            System.out.println("Case #"+(i + 1)+": "+ analyzeMatrix(N, scanner));
        }
        scanner.close();
    }

    private static String analyzeMatrix(int n, Scanner scanner) {
        int trace = 0;
        int badCols[] = new int[n];
        int badRows[] = new int[n];
        Set<Integer> colSets[] = new HashSet[n];
        for (int row=0; row<n; row++) {
            String data[] = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            Set<Integer> rowSet = new HashSet<>();
            for(int col=0; col<n; col++) {
                int value = Integer.parseInt(data[col]);
                if(row == col){
                    trace += value;
                }
                if(badRows[row] == 0) {
                    if (rowSet.contains(value)) {
                        badRows[row] = 1;
                    } else {
                        rowSet.add(value);
                    }
                }

                if(badCols[col] == 0) {
                    processCols(badCols, colSets, col, value);
                }
            }
        }
        return prepareResponse(n, trace, badCols, badRows);
    }

    private static void processCols(int[] badCols, Set<Integer>[] colSets, int col, int value) {
        Set colSet = colSets[col];
        if (colSet == null) {
            colSet = new HashSet();
            colSet.add(value);
            colSets[col] = colSet;
        } else if (colSet.contains(value)) {
            badCols[col] = 1;
        } else {
            colSet.add(value);
        }
    }

    private static String prepareResponse(int n, int trace, int[] badCols, int[] badRows) {
        int rowNums = 0, colNums = 0;
        for (int i=0; i<n; i++) {
            if(badRows[i] == 1){
                rowNums++;
            }
            if(badCols[i] == 1){
                colNums++;
            }
        }
        return trace + " " + rowNums + " " + colNums;
    }

}