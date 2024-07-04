import java.util.Random;
import java.util.*;
 import java.io.*;


public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = 0;
        int matrixSize = 0;
        int[][] matrix = null;
        Random rand = new Random();
        int traceValue = 0, colRepeat = 0;
        int rowRepeat = 0;
        int[][] resultArray = null;

//        System.out.println("Enter test case cout : ");
        testCases = sc.nextInt();
        resultArray = new int[testCases][3];


        for (int a = 0; a < testCases; a++) {
//            System.out.println("Enter matrix size : ");
            matrixSize = sc.nextInt();
            matrix = new int[matrixSize][matrixSize];
            for (int b = 0; b < matrixSize; b++) {
                for (int c = 0; c < matrixSize; c++) {
                    matrix[b][c] = (rand.nextInt(matrixSize) + 1);
                }
            }
//            ################

            for (int b = 0; b < matrixSize; b++) {
                for (int c = 0; c < matrixSize; c++) {
                    System.out.print(matrix[b][c] + " ");
                }
                System.out.println();
            }
//          ##################

            for (int b = 0; b < matrixSize; b++) {
                int rowRepeatVal = matrix[b][0];
//                System.out.println("Row repeat value : " + rowRepeatVal);
                for (int c = 0; c < matrixSize; c++) {
//                    System.out.print(matrix[b][c] + " , ");
                    if (c == b) {
                        traceValue += matrix[b][c];
                    }
                    if (matrix[b][c] == rowRepeatVal) {
                        rowRepeat++;
                    }
                }
//                System.out.println();
            }
//            System.out.println("#################");


//            ################
            rowRepeat = 0;
            for (int b = 0; b < matrixSize; b++) {
                for (int c = 0; c < matrixSize; c++) {
                    boolean rowRepeatEnd = false;
                    for (int d = c + 1; d < matrixSize; d++) {
                        if (matrix[b][d] == matrix[b][c]) {
//                            System.out.println("D" + d + "C" + c + "B" + b);
                            rowRepeat++;
                            rowRepeatEnd = true;
//                            System.out.println(rowRepeat);
                            break;
                        }
                    }
                    if (rowRepeatEnd == true) {
//                        System.out.println("CC" + c);
                        break;
                    }
                }
//                System.out.println();
            }


//           #################
            for (int b = 0; b < matrixSize; b++) {
                for (int c = 0; c < matrixSize; c++) {
                    boolean colRepeatEnd = false;
                    for (int d = c + 1; d < matrixSize; d++) {
//                        System.out.println(">>>B"+b+"C"+c+"D"+d);
                        if (matrix[d][b] == matrix[c][b]) {
//                            System.out.println("D" + d + "C" + c + ":" + matrix[d][c]);
//                            System.out.println("C" + c + "B" + b + ":" + matrix[c][b]);
                            colRepeatEnd = true;
                            colRepeat++;
                            break;
                        }
                    }
                    if (colRepeatEnd == true) {
                        break;
                    }
//
                }
//                System.out.println();
            }
//            System.out.println("#################");
//            System.out.println("Col repeat Value : " + colRepeat);

            resultArray[a][0] = traceValue;
            resultArray[a][1] = rowRepeat;
            resultArray[a][2] = colRepeat;

            traceValue = 0;
            rowRepeat = 0;
            colRepeat = 0;


        }
//        ##########

        for (int b = 0; b < testCases; b++) {
            System.out.print("Case #"+(b+1)+": ");
                for (int c = 0; c < 3; c++) {
                    System.out.print(resultArray[b][c] + " ");
                }
                System.out.println();
            }
    }
}

