import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCases = Integer.parseInt(reader.readLine().trim());
        int caseNumber = 1;

        while (caseNumber <= testCases) {
            int N = Integer.parseInt(reader.readLine().trim());
            int[][] matrix = new int[N][N];
            boolean[] rowFlag = new boolean[N];
            boolean[] colFlag = new boolean[N];
            int trace = 0, duplicateRows = 0, duplicateCols = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    if (!rowSet.add(matrix[i][j]) && !rowFlag[i]) {
                        duplicateRows++;
                        rowFlag[i] = true;
                    }
                    if (!colSet.add(matrix[j][i]) && !colFlag[i]) {
                        duplicateCols++;
                        colFlag[i] = true;
                    }
                }
            }

            writer.write(String.format("Case #%d: %d %d %d%n", caseNumber, trace, duplicateRows, duplicateCols));
            writer.flush();
            caseNumber++;
        }

        writer.close();
        reader.close();
    }
}