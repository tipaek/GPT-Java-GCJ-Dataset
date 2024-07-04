import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder result = new StringBuilder();

        for (int caseNum = 1; caseNum <= t; caseNum++) {
            result.append("Case #").append(caseNum).append(": ");
            int n = Integer.parseInt(br.readLine());
            Map<Integer, TreeSet<Integer>> rowMap = new HashMap<>();
            Map<Integer, TreeSet<Integer>> colMap = new HashMap<>();
            int trace = 0;

            for (int i = 1; i <= n; i++) {
                String[] input = br.readLine().split(" ");
                TreeSet<Integer> rowSet = rowMap.getOrDefault(i, new TreeSet<>());

                for (int j = 1; j <= n; j++) {
                    int value = Integer.parseInt(input[j - 1]);
                    rowSet.add(value);
                    TreeSet<Integer> colSet = colMap.getOrDefault(j, new TreeSet<>());
                    colSet.add(value);
                    colMap.put(j, colSet);

                    if (i == j) {
                        trace += value;
                    }
                }
                rowMap.put(i, rowSet);
            }

            int duplicateRows = 0;
            int duplicateCols = 0;

            for (int i = 1; i <= n; i++) {
                if (rowMap.getOrDefault(i, new TreeSet<>()).size() != n) {
                    duplicateRows++;
                }
                if (colMap.getOrDefault(i, new TreeSet<>()).size() != n) {
                    duplicateCols++;
                }
            }

            result.append(trace).append(" ").append(duplicateRows).append(" ").append(duplicateCols).append("\n");
        }

        out.print(result);
        out.flush();
        br.close();
    }
}