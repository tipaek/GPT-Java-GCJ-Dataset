package qualification;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {

    public String solve(Scanner scanner) {
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        int trace = 0, rowRepeats = 0, colRepeats = 0;

        // Calculate trace
        for (int i = 0; i < n; ++i) {
            trace += matrix[i][i];
        }

        // Check for repeated elements in rows
        for (int i = 0; i < n; ++i) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < n; ++j) {
                uniqueElements.add(matrix[i][j]);
            }
            if (uniqueElements.size() < n) {
                rowRepeats++;
            }
        }

        // Check for repeated elements in columns
        for (int j = 0; j < n; ++j) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int i = 0; i < n; ++i) {
                uniqueElements.add(matrix[i][j]);
            }
            if (uniqueElements.size() < n) {
                colRepeats++;
            }
        }

        return trace + " " + rowRepeats + " " + colRepeats;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        Vestigium solution = new Vestigium();
        
        for (int i = 1; i <= testCases; ++i) {
            System.out.println("Case #" + i + ": " + solution.solve(scanner));
        }
    }
}