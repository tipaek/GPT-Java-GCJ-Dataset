import java.util.*;
import java.io.*;

public class Vestigium {
    
    public static void vestigium(int caseNum, Scanner in) {
        int size = in.nextInt();
        int[][] matrix = new int[size][size];
        
        int trace = 0;
        int duplicateRows = 0;
        int duplicateCols = 0;

        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            boolean rowHasDuplicates = false;
            for (int j = 0; j < size; j++) {
                int num = in.nextInt();
                matrix[i][j] = num;
                if (i == j) {
                    trace += num;
                }
                if (!rowSet.add(num)) {
                    rowHasDuplicates = true;
                }
            }
            if (rowHasDuplicates) {
                duplicateRows++;
            }
        }

        for (int j = 0; j < size; j++) {
            Set<Integer> colSet = new HashSet<>();
            boolean colHasDuplicates = false;
            for (int i = 0; i < size; i++) {
                if (!colSet.add(matrix[i][j])) {
                    colHasDuplicates = true;
                }
            }
            if (colHasDuplicates) {
                duplicateCols++;
            }
        }

        System.out.println("Case #" + caseNum + ": " + trace + " " + duplicateRows + " " + duplicateCols);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = in.nextInt();
        for (int i = 1; i <= numberOfCases; i++) {
            vestigium(i, in);
        }
    }
}