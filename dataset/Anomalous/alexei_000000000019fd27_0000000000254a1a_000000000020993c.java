import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int diagonalSum = 0;
            List<Set<Integer>> rowSets = new ArrayList<>();
            List<Set<Integer>> colSets = new ArrayList<>();
            
            for (int i = 0; i < matrixSize; i++) {
                rowSets.add(new HashSet<>());
                colSets.add(new HashSet<>());
            }
            
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    int value = scanner.nextInt();
                    rowSets.get(i).add(value);
                    colSets.get(j).add(value);
                    if (i == j) {
                        diagonalSum += value;
                    }
                }
            }
            
            int duplicateRowCount = 0;
            int duplicateColCount = 0;
            
            for (int i = 0; i < matrixSize; i++) {
                if (rowSets.get(i).size() < matrixSize) {
                    duplicateRowCount++;
                }
                if (colSets.get(i).size() < matrixSize) {
                    duplicateColCount++;
                }
            }
            
            System.out.printf("Case #%d: %d %d %d%n", caseNumber, diagonalSum, duplicateRowCount, duplicateColCount);
        }
    }
}