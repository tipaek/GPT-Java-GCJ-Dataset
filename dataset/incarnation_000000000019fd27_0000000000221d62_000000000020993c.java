
import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        
        for (int i = 0; i < t; i++) {

            int matrixSize = in.nextInt();

            int[][] arr = new int[matrixSize][matrixSize];
            int diaSum = 0;
            Set<Integer> set = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            int numRepeatRow = 0;
            int numRepeatCol = 0;
            boolean addRowFlag = true;
            boolean addColFlag = true;

            for(int k = 0; k < matrixSize; k++){
                for (int j = 0; j < matrixSize; j++) {
                    arr[k][j] = in.nextInt();
                    if(k == j)
                        diaSum += arr[k][j];

                    if(set.contains(arr[k][j]) && addRowFlag){
                        numRepeatRow++;
                        addRowFlag = false;
                    }
                    set.add(arr[k][j]);
                }
                addRowFlag = true;
                set.clear();
            }

            for(int k = 0; k < matrixSize; k++){
                for (int j = 0; j < matrixSize; j++) {
                    
                    if(set2.contains(arr[j][k]) && addColFlag){
                        numRepeatCol++;
                        addColFlag = false;
                    }
                    set2.add(arr[j][k]);
                }
                set2.clear();
                addColFlag = true;
            }
            

            System.out.println("Case #" + (i+1) + ": " + diaSum + " " + numRepeatRow + " " + numRepeatCol);
        }
    }

}
