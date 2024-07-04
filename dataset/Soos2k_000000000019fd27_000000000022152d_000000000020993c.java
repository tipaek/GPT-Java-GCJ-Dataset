import java.util.*;
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        String[] results = new String[cases];
        for (int i = 0; i < cases; i++){
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for (int j = 0; j < n; j++){
                for (int k = 0; k < n; k++){
                    arr[j][k] = sc.nextInt();
                }
            }
            results[i] = "Case #" + (i+1) + ": " + findRepeatedAndTrace(arr);
        }
        sc.close();
        for (String str : results){
            System.out.println(str);
        }
    }
    public static String findRepeatedAndTrace(int[][] arr){
        int n = arr.length;
        int trace = 0;
        int rowRepeated = 0;
        int colRepeated = 0;
        boolean[][] markRow = new boolean[n][n];
        boolean[][] markCol = new boolean[n][n];
        for (int i = 0; i < n; i++){
            int indexRow = 0;
            int indexCol = 0;
            while (indexCol < n){
                int mark = arr[i][indexCol] - 1;
                if (markRow[i][mark]) {
                    rowRepeated++;
                    break;
                }
                markRow[i][mark] = true;
                indexCol++;
            }
            while (indexRow < n){
                int mark = arr[indexRow][i] - 1;
                if (markCol[mark][i]) {
                    colRepeated++;
                    break;
                }
                markCol[mark][i] = true;
                indexRow++;
            }
            trace += arr[i][i];
        }
        return trace + " " + rowRepeated + " " + colRepeated;
    }
}