package Vestigium;

import java.util.ArrayList;
import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        sc.nextLine(); // Consume the newline after the number of cases
        for (int i = 0; i < cases; i++) {
            int matrixSize = sc.nextInt();
            sc.nextLine(); // Consume the newline after the matrix size
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int j = 0; j < matrixSize; j++) {
                String[] rowItems = sc.nextLine().split(" ");
                for (int k = 0; k < matrixSize; k++) {
                    matrix[j][k] = Integer.parseInt(rowItems[k]);
                }
            }
            
            // Print the matrix for debugging purposes
            for (int j = 0; j < matrixSize; j++) {
                for (int k = 0; k < matrixSize; k++) {
                    System.out.print(matrix[j][k] + " ");
                }
                System.out.println();
            }
        }
        sc.close();
    }
}