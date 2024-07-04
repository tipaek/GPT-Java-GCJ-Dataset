import java.util.*;
import java.io.*;

class Solution {
    public static int countRowDuplicates(int[] matrix, int n) {
        int duplicates = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = i * n; j < (i + 1) * n; j++) {
                if (seen.contains(matrix[j])) {
                    duplicates++;
                    break;
                }
                seen.add(matrix[j]);
            }
        }
        return duplicates;
    }

    public static int countColumnDuplicates(int[] matrix, int n) {
        int duplicates = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = i; j < n * n; j += n) {
                if (seen.contains(matrix[j])) {
                    duplicates++;
                    break;
                }
                seen.add(matrix[j]);
            }
        }
        return duplicates;
    }

    public static int calculateTrace(int[] matrix, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i * n + i];
        }
        return trace;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = scanner.nextInt();
            int[] matrix = new int[n * n];
            for (int i = 0; i < n * n; i++) {
                matrix[i] = scanner.nextInt();
            }

            int trace = calculateTrace(matrix, n);
            int rowDuplicates = countRowDuplicates(matrix, n);
            int columnDuplicates = countColumnDuplicates(matrix, n);

            System.out.println("Case #" + caseNum + ": " + trace + " " + rowDuplicates + " " + columnDuplicates);
        }
    }
}