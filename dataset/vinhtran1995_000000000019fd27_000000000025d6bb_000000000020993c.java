package com.mycompany.practice;

import java.util.Scanner;

/**
 *
 * @author vinhtd2
 */
public class practice {

    public static String processMatrix(int caseNum, int[][] matrix) {

        int k = 0;
        int r = 0;
        int c = 0;
        for (int i = 0; i < matrix.length; i++) {
            k = k + matrix[i][i];
            // row
            for (int j = 1; j < matrix[i].length; j++) {
                int key = matrix[i][j];
                int l = j - 1;
                boolean isStop = false;
                while (l >= 0) {
                    if (matrix[i][l] == key) {
                        r = r + 1;
                        isStop = true;
                        break;
                    }
                    l = l - 1;
                }
                if (isStop) {
                    break;
                }

            }
            // column
            for (int j = 1; j < matrix.length; j++) {
                int key = matrix[j][i];
                int l = j - 1;
                boolean isStop = false;
                while (l >= 0) {
                    if (matrix[l][i] == key) {
                        c = c + 1;
                        isStop = true;
                        break;
                    }
                    l = l - 1;
                }
                if (isStop) {
                    break;
                }
            }
        }
        return ("Case #" + (caseNum + 1) + ": " + " " + k + " " + r + " " + c);
    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.print("----- Enter test cases number: ");
        int testCasesNum = myObj.nextInt();
        while (testCasesNum < 1 || testCasesNum > 100) {
            System.out.println("* The condition is: more than or equal 1, less than or equal 100.");
            System.out.print("----- Re-enter test cases number: ");
            testCasesNum = myObj.nextInt();
        }

        String[] results = new String[testCasesNum];
        for (int i = 0; i < testCasesNum; i++) {
            System.out.print("----- Enter the size of the square matrix " + (i + 1) + ": ");
            int size = myObj.nextInt();
            while (size < 2 || size > 100) {
                System.out.println("* The condition is: more than or equal 2, less than or euqal 100");
                System.out.print("----- Re-enter the size of the square matrix " + (i + 1) + ": ");
                size = myObj.nextInt();
            }
            int matrix[][] = new int[size][size];
            for (int j = 0; j < size; j++) {
                System.out.println("+ The column " + (j + 1) + " :");
                for (int k = 0; k < size; k++) {
                    System.out.print("Enter the integer of row " + (k + 1) + " :");
                    int integer = myObj.nextInt();
                    while(integer < 1 || integer > size) {
                        System.out.println("* The condition is: more than or euqal 1. less than or equal " + size);
                        System.out.print("Re-enter the integer of row " + (k + 1) + " :");
                        integer = myObj.nextInt();
                    }
                    matrix[j][k] = integer;
                }
            }
            results[i] = processMatrix(i, matrix);
        }
        System.err.println();
        System.out.println("----- RESULT -----");
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i]);
        }
    }
}
