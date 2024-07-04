import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        List<int[][]> matrixList = new ArrayList<>();
        List<Map<String, Integer>> detailList = new ArrayList<>();
        for (int i = 1; i <= t; ++i) {
            int x = in.nextInt();
            int[][] matrix = new int[x][x];
            Map<String, Integer> details = new HashMap<>();
            details.put("row",0);
            details.put("trace",0);
            for(int j = 0 ; j<x;j++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowFlag = false;
                for(int k = 0;k<x;k++) {
                    int m = in.nextInt();
                    matrix[j][k] = m;
                    if(rowSet.contains(m)) {
                        rowFlag = true;
                    }
                    rowSet.add(m);
                    if(j==k) {
                        details.put("trace", details.get("trace") + m);
                    }
                }
                if(rowFlag) {
                    details.put("row", details.get("row") + 1);
                }
            }
            detailList.add(details);
            matrixList.add(matrix);
        }

        for (int i = 0; i < t; ++i) {
            int[][] matrix = matrixList.get(i);
            int x = matrix.length;
            Map<String, Integer> details = detailList.get(i);
            details.put("column",0);
            for(int j = 0 ; j<x;j++) {
                Set<Integer> columnSet = new HashSet<>();
                boolean columnFlag = false;
                for(int k = 0;k<x;k++) {
                    int m = matrix[k][j];
                    if(columnSet.contains(m)) {
                        columnFlag = true;
                    }
                    columnSet.add(m);
                }
                if(columnFlag) {
                    details.put("column", details.get("column") + 1);
                }
            }
        }

        for (int i = 0; i < t; ++i) {
            Map<String, Integer> details = detailList.get(i);
            System.out.println("Case #" + i+1 + ": " + details.get("trace") + " " + details.get("row") + " " + details.get("column") + " ");
        }
    }
}
