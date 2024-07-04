
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static int ROWS,COLS;
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int testCases = scn.nextInt();
        for(int i=0;i<testCases;i++){
            int matrixL = scn.nextInt();
            int problemD[][] = new int[matrixL][matrixL];
            for(int j=0;j<matrixL;j++){
                for(int k=0;k<matrixL;k++){
                    problemD[j][k] = scn.nextInt();
                }
            }
            getSol(problemD,(i+1));
        }
    }
    static void getSol(int[][] data, int testCaseN){
        int trace = 0;
        ROWS = 0;
        COLS = 0;
        for(int i=0;i<data.length;i++){
            trace+=data[i][i];
            getXY(data, i);
        }
        System.out.println("Case #"+testCaseN+": "+trace+" "+ROWS+" "+COLS);
    }
    static void getXY(int[][] data, int index){
        int X[] = new int[data.length];
        int Y[] = new int[data.length];
        
        for(int i=0;i<data.length;i++){
            X[i] = data[index][i];
            Y[i] = data[i][index];
        }
        
        Arrays.sort(X);
        Arrays.sort(Y);
        
        for(int i=0;i<X.length-1;i++){
            if(X[i]==X[i+1]){
                ROWS++;
                break;
            }
        }
        for(int i=0;i<Y.length-1;i++){
            if(Y[i]==Y[i+1]){
                COLS++;
                break;
            }
        }
    }
}