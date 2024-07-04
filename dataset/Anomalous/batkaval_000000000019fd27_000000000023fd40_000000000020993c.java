package cz.li.codejam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vestigium {
    public static void main(String[] args) {
        int caseNumber = 1;
        int index = 1;
        while (index < args.length) {
            int n = Integer.parseInt(args[index]);
            TC testCase = new TC(args, index);
            System.out.println("Case #" + caseNumber + ": " + testCase.calculateVestigium());
            index += n + 1;
            caseNumber++;
        }
    }

    public static class TC {
        private int[][] matrix;
        private int n;

        public TC(String[] args, int startIndex) {
            n = Integer.parseInt(args[startIndex]);
            matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] rowValues = args[startIndex + 1 + i].split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(rowValues[j]);
                }
            }
        }

        public String calculateVestigium() {
            int trace = 0;
            int repeatedRows = 0;
            int repeatedColumns = 0;

            for (int i = 0; i < n; i++) {
                Map<Integer, Integer> rowMap = new HashMap<>();
                Map<Integer, Integer> columnMap = new HashMap<>();
                trace += matrix[i][i];

                for (int j = 0; j < n; j++) {
                    rowMap.put(matrix[i][j], rowMap.getOrDefault(matrix[i][j], 0) + 1);
                    columnMap.put(matrix[j][i], columnMap.getOrDefault(matrix[j][i], 0) + 1);
                }

                if (rowMap.values().stream().anyMatch(count -> count > 1)) {
                    repeatedRows++;
                }
                if (columnMap.values().stream().anyMatch(count -> count > 1)) {
                    repeatedColumns++;
                }
            }

            return trace + " " + repeatedRows + " " + repeatedColumns;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(matrix[i][j]).append(" ");
                }
                sb.append("\n");
            }
            return sb.toString();
        }
    }
}