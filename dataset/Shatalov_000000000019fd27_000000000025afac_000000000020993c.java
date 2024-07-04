import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCasesNumb = Integer.parseInt(br.readLine());
        int lineCounter = 0;

        for (int t = 1; t <= testCasesNumb; t++) {
            lineCounter++;
            int matrSize = Integer.parseInt(br.readLine());

            Set<Integer> repeatedRows = new HashSet<>();
            Set<Integer> repeatedCols = new HashSet<>();
            Map<Integer, Set<Integer>> rowUnique = new HashMap<>();
            Map<Integer, Set<Integer>> colUnique = new HashMap<>();
            int traceRow = 0, traceCol = 0, traceSum = 0;

            for (int r = 0; r < matrSize; r++) {
                lineCounter++;
                String rowStr = br.readLine();
                rowStr = rowStr.trim();
                String[] rowArr = rowStr.split(" ");

                for (int c = 0; c < matrSize; c++) {
                    Integer val = Integer.parseInt(rowArr[c]);
                    if (traceRow == r && traceCol == c) {
                        traceSum += val;
                    }

                    Set<Integer> rowSet = rowUnique.getOrDefault(r, new HashSet<>());
                    if (rowSet.contains(val)) {
                        repeatedRows.add(r);
                    } else {
                        rowSet.add(val);
                        rowUnique.put(r, rowSet);
                    }

                    Set<Integer> colSet = colUnique.getOrDefault(c, new HashSet<>());
                    if (colSet.contains(val)) {
                        repeatedCols.add(c);
                    } else {
                        colSet.add(val);
                        colUnique.put(c, colSet);
                    }
                }
                traceRow++;
                traceCol++;
            }
            System.out.println("Case #" + t + ": " + traceSum + " " + repeatedRows.size() + " " + repeatedCols.size());
        }
    }

}