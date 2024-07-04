package dev.garrido;

import java.util.Scanner;
import java.util.HashSet;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int caseIndex =1; caseIndex<=testCases; caseIndex++){
            int matrixSize = scanner.nextInt();
            int [][] matrix = new int[matrixSize][matrixSize];
            int repeatedCols = 0;
            int repeatedRows = 0;
            int trace = 0;
            for(int rowIndex=0; rowIndex<matrixSize; rowIndex++){
                HashSet<Integer> numberSetRows = new HashSet<>();
                for(int colIndex=0; colIndex<matrixSize; colIndex++){
                    matrix[rowIndex][colIndex] = scanner.nextInt();
                    numberSetRows.add(matrix[rowIndex][colIndex]);
                }
                if(numberSetRows.size()<matrixSize)
                    repeatedRows++;
            }
            for(int colIndex=0; colIndex<matrixSize; colIndex++){
                HashSet<Integer> numberSetCols = new HashSet<>();
                for(int rowIndex=0; rowIndex<matrixSize; rowIndex++){
                    numberSetCols.add(matrix[rowIndex][colIndex]);
                    if(colIndex==rowIndex)
                        trace+= matrix[rowIndex][colIndex];
                }
                if(numberSetCols.size()<matrixSize)
                    repeatedCols++;
            }
            System.out.println(String.format("Case #%s: %s %s %s", caseIndex, trace, repeatedRows, repeatedCols));
        }
    }
}