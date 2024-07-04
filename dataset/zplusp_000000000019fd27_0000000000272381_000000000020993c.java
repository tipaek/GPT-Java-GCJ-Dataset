import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            List<Set<Integer>> rowsSet = new ArrayList<>();
            List<Set<Integer>> colsSet = new ArrayList<>();

            List<String[]> nRows = new ArrayList<>();
            for (int n = 0; n < N; n++) {
                nRows.add(br.readLine().split(" "));
                rowsSet.add(new HashSet<>());
                colsSet.add(new HashSet<>());
            }

            int trace = 0;
            int dupRow = 0;
            int dupCol = 0;

            boolean[] rowFlag = new boolean[N];
            boolean[] colFlag = new boolean[N];

            for (int i = 0; i < N; i++) {
                String[] row = nRows.get(i);
                Set<Integer> rowSet = rowsSet.get(i);

                for (int j = 0; j < N; j++) {
                    int element = Integer.parseInt(row[j]);
                    if (i == j) {
                        trace += element;
                    }

                    if (rowSet.contains(element)) {
                        if (!rowFlag[i]) {
                            dupRow++;
                            rowFlag[i] = true;
                        }
                    } else {
                        rowSet.add(element);
                    }

                    Set<Integer> colSet = colsSet.get(j);
                    if (colSet.contains(element)) {
                        if (!colFlag[j]) {
                            dupCol++;
                            colFlag[j] = true;
                        }
                    } else {
                        colSet.add(element);
                    }

                }
            }

            output.append("Case #").append(t).append(": ").append(trace).append(" ").append(dupRow).append(" ")
                    .append(dupCol).append("\n");
        }

        System.out.print(output);
    }
}