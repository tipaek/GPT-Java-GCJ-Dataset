import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.


        for (int j = 1; j <= t; j++) {

            int[][] matrix;
            int rows;
            int cols;
            int N;
            int test;
            int rowCount = 0; // repeating no Row
            int colCount = 0; // repeating no Col
            int trace = 0;

            // MATRIX INPUT

            N = in.nextInt();
            rows = cols = N;
            matrix = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int k = 0; k < cols; k++) {
                    int temp = in.nextInt();
                    matrix[i][k] = temp;
                }
            }

            // Main Logic

            for (int i = 0; i < 2; i++) {


                if(i == 0) {
                    for (int k = 0; k < rows; k++) {
                        int[] tempArray = new int[N];
                        int m = 0;
                        boolean breakFlag = false;
                        for (int l = 0; l < cols; l++){
                            if(k == l) {
                                trace = trace + matrix[k][l];
                            }
                            tempArray[l] = matrix[k][l];
                        }
                        
                        Arrays.sort(tempArray);

                        while(!breakFlag && m <= tempArray.length - 2) {
                        if(tempArray[m] == tempArray[++m]) {
                                rowCount++;
                                breakFlag = true;
                            }
                        }
                    }
                } else if(i == 1) {
                    for (int k = 0; k < cols; k++) {
                        int[] tempArray = new int[N];
                        int m = 0;
                        boolean breakFlag = false;
                        for (int l = 0; l < rows; l++){
                            tempArray[l] = matrix[l][k];
                        }
                        
                        Arrays.sort(tempArray);

                        while(!breakFlag && m <= tempArray.length - 2) {
//                            System.out.println("Sorted temp" + Arrays.toString(tempArray));
                            if(tempArray[m] == tempArray[++m]) {
//                                System.out.println("col count ++");
                                colCount++;
                                breakFlag = true;
                            }
                        }
                    }
                }

            }


            System.out.println("Case #" + j + ":" + " " + trace + " " + rowCount + " " + colCount);
        }



    }
}

