package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = scanner.nextInt();
        
        for (int testIndex = 0; testIndex < numberOfTests; testIndex++) {
            int matrixSize = scanner.nextInt();
            boolean[][] rowTracker = new boolean[matrixSize][matrixSize];
            boolean[][] colTracker = new boolean[matrixSize][matrixSize];
            boolean[] rowDuplicates = new boolean[matrixSize];
            boolean[] colDuplicates = new boolean[matrixSize];
            
            int trace = 0, rowRepeats = 0, colRepeats = 0;
            
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();
                    
                    if (row == col) {
                        trace += value;
                    }
                    
                    if (rowTracker[row][value - 1]) {
                        if (!rowDuplicates[row]) {
                            rowDuplicates[row] = true;
                            rowRepeats++;
                        }
                    } else {
                        rowTracker[row][value - 1] = true;
                    }
                    
                    if (colTracker[col][value - 1]) {
                        if (!colDuplicates[col]) {
                            colDuplicates[col] = true;
                            colRepeats++;
                        }
                    } else {
                        colTracker[col][value - 1] = true;
                    }
                }
            }
            
            System.out.println("Case #" + (testIndex + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}