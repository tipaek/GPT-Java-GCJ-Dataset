import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int size = Integer.parseInt(scanner.nextLine());
            String[] matrix = new String[size];
            
            for (int i = 0; i < size; i++) {
                matrix[i] = scanner.nextLine();
            }
            
            System.out.print("Case #" + caseNum + ": ");
            processMatrix(matrix, size);
            System.out.println();
        }
    }

    private static void processMatrix(String[] matrix, int size) {
        int diagonalSum = 0;
        int rowRepeats = 0;
        int colRepeats = 0;
        
        for (int i = 0; i < size; i++) {
            String[] rowValues = matrix[i].split(" ");
            diagonalSum += Integer.parseInt(rowValues[i]);
        }
        
        System.out.print(diagonalSum + " ");
        
        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            String[] rowValues = matrix[i].split(" ");
            
            for (int j = 0; j < size; j++) {
                rowSet.add(Integer.parseInt(rowValues[j]));
            }
            
            if (rowSet.size() != size) {
                rowRepeats++;
            }
        }
        
        System.out.print(rowRepeats + " ");
        
        for (int i = 0; i < size; i++) {
            Set<Integer> colSet = new HashSet<>();
            
            for (int j = 0; j < size; j++) {
                String[] rowValues = matrix[j].split(" ");
                colSet.add(Integer.parseInt(rowValues[i]));
            }
            
            if (colSet.size() != size) {
                colRepeats++;
            }
        }
        
        System.out.print(colRepeats);
    }
}