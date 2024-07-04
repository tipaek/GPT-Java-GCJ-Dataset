import java.util.*;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int testCases = Integer.parseInt(scanner.nextLine());
        int[][][] matrices = new int[testCases][][];
        int[] trace = new int[testCases];
        int[] duplicateRows = new int[testCases];
        int[] duplicateCols = new int[testCases];
        
        for (int t = 0; t < testCases; t++) {
            int size = Integer.parseInt(scanner.nextLine());
            matrices[t] = new int[size][size];
            
            for (int r = 0; r < size; r++) {
                String[] rowInput = scanner.nextLine().split(" ");
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicates = false;
                
                for (int c = 0; c < size; c++) {
                    int value = Integer.parseInt(rowInput[c]);
                    matrices[t][r][c] = value;
                    
                    if (!rowSet.add(value) && !rowHasDuplicates) {
                        rowHasDuplicates = true;
                    }
                    
                    if (r == c) {
                        trace[t] += value;
                    }
                }
                
                if (rowHasDuplicates) {
                    duplicateRows[t]++;
                }
            }
        }
        
        for (int t = 0; t < testCases; t++) {
            for (int c = 0; c < matrices[t].length; c++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colHasDuplicates = false;
                
                for (int r = 0; r < matrices[t][c].length; r++) {
                    int value = matrices[t][r][c];
                    
                    if (!colSet.add(value) && !colHasDuplicates) {
                        colHasDuplicates = true;
                    }
                }
                
                if (colHasDuplicates) {
                    duplicateCols[t]++;
                }
            }
        }
        
        for (int t = 0; t < testCases; t++) {
            System.out.println("Case #" + (t + 1) + ": " + trace[t] + " " + duplicateRows[t] + " " + duplicateCols[t]);
        }
    }
}