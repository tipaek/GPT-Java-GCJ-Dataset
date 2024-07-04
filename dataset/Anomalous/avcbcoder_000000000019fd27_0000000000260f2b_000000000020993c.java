import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            System.out.print("Case #" + i + ": ");
            solve(sc);
        }
    }

    public static void solve(Scanner sc) throws Exception {
        int n = sc.nextInt();
        int trace = 0;
        int[][] matrix = new int[n][n];

        HashSet<Integer>[] rowSets = new HashSet[n];
        HashSet<Integer>[] colSets = new HashSet[n];

        for (int i = 0; i < n; i++) {
            rowSets[i] = new HashSet<>();
            colSets[i] = new HashSet<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = sc.nextInt();
                rowSets[i].add(value);
                colSets[j].add(value);
                if (i == j) {
                    trace += value;
                }
            }
        }

        int rowDuplicates = 0, colDuplicates = 0;
        for (int i = 0; i < n; i++) {
            if (rowSets[i].size() != n) {
                rowDuplicates++;
            }
            if (colSets[i].size() != n) {
                colDuplicates++;
            }
        }

        System.out.println(trace + " " + rowDuplicates + " " + colDuplicates);
    }
}