package codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= numCases; caseNumber++) {
            int dimension = scanner.nextInt();
            int[][] matrix = new int[dimension][dimension];
            int trace = 0, duplicateRows = 0, duplicateColumns = 0;

            for (int i = 0; i < dimension; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < dimension; j++) {
                    int element = scanner.nextInt();
                    matrix[i][j] = element;
                    if (i == j) {
                        trace += element;
                    }
                    rowSet.add(element);
                }
                if (rowSet.size() != dimension) {
                    duplicateRows++;
                }
            }

            for (int j = 0; j < dimension; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < dimension; i++) {
                    colSet.add(matrix[i][j]);
                }
                if (colSet.size() != dimension) {
                    duplicateColumns++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}