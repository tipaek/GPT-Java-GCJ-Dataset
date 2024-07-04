import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        Vestigium solver = new Vestigium();
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            solver.solve(i, scanner, writer);
        }
        writer.close();
    }
}

class Vestigium {
    public void solve(int testCaseNumber, Scanner scanner, PrintWriter writer) {
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        int trace = 0;
        Set<Integer>[] rowSets = new HashSet[n];
        Set<Integer>[] columnSets = new HashSet[n];
        
        for (int i = 0; i < n; i++) {
            rowSets[i] = new HashSet<>();
            columnSets[i] = new HashSet<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = scanner.nextInt();
                matrix[i][j] = value;
                if (i == j) {
                    trace += value;
                }
                rowSets[i].add(value);
                columnSets[j].add(value);
            }
        }

        int rowRepeats = 0, columnRepeats = 0;
        for (int i = 0; i < n; i++) {
            if (rowSets[i].size() != n) {
                rowRepeats++;
            }
            if (columnSets[i].size() != n) {
                columnRepeats++;
            }
        }

        writer.println("Case #" + testCaseNumber + ": " + trace + " " + rowRepeats + " " + columnRepeats);
    }
}