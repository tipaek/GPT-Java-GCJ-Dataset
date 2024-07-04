import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numberTests = Integer.parseInt(br.readLine());
            
            for (int testIndex = 1; testIndex <= numberTests; testIndex++) {
                int N = Integer.parseInt(br.readLine());
                int[][] matrix = new int[N][N];
                
                for (int row = 0; row < N; row++) {
                    String[] rowValues = br.readLine().split(" ");
                    for (int col = 0; col < N; col++) {
                        matrix[row][col] = Integer.parseInt(rowValues[col]);
                    }
                }
                
                processMatrix(testIndex, N, matrix);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processMatrix(int testNumber, int N, int[][] matrix) {
        boolean[] rowDuplicates = new boolean[N];
        boolean[] colDuplicates = new boolean[N];
        List<Set<Integer>> rowSets = new ArrayList<>(N);
        List<Set<Integer>> colSets = new ArrayList<>(N);
        int trace = 0;

        for (int i = 0; i < N; i++) {
            rowSets.add(new HashSet<>());
            colSets.add(new HashSet<>());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }

                int value = matrix[i][j];
                
                if (!rowSets.get(i).add(value)) {
                    rowDuplicates[i] = true;
                }
                
                if (!colSets.get(j).add(value)) {
                    colDuplicates[j] = true;
                }
            }
        }

        int duplicateRows = 0;
        int duplicateCols = 0;
        
        for (int i = 0; i < N; i++) {
            if (rowDuplicates[i]) duplicateRows++;
            if (colDuplicates[i]) duplicateCols++;
        }

        System.out.println("Case #" + testNumber + ": " + trace + " " + duplicateRows + " " + duplicateCols);
    }
}