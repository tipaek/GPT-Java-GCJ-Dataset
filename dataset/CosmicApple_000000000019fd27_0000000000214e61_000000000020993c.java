import java.util.Scanner;

public class Solution {
    public static void main (String args[]) {
        Scanner input = new Scanner (System.in);
        int numOfTests = input.nextInt ();
        for (int currentTest = 1; currentTest <= numOfTests; currentTest++) {
            int N = input.nextInt();
            int[][] arr = new int[N][N];
            for (int row = 0; row < N; row++) {
                for (int column = 0; column < N; column++) {
                   arr[row][column] = input.nextInt(); 
                }
            }
            
            //calculate trace
            int trace = 0;
            for (int i = 0; i < N; i++)
                trace += arr[i][i];
            
            //check rows for repeated values
            int repeatedRows = 0;
            for (int row = 0; row < N; row++) {
                boolean[] occurs = new boolean[N];
                for (int column = 0; column < N; column++) {
                   if (occurs[arr[row][column] - 1]) {
                       repeatedRows++;
                       break;
                   } else {
                       occurs[arr[row][column] - 1] = true;
                   }
                }
            }
            
            //check columns for repeated values
            int repeatedColumns = 0;
            for (int column = 0; column < N; column++) {
                boolean[] occurs = new boolean[N];
                for (int row = 0; row < N; row++) {
                   if (occurs[arr[row][column] - 1]) {
                       repeatedColumns++;
                       break;
                   } else {
                       occurs[arr[row][column] - 1] = true;
                   }
                }
            }
            
            System.out.println("Case #" + currentTest + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
        }
    }
}