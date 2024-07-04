import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("02.in"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        Scanner in = new Scanner();

        int t = Integer.parseInt(reader.readLine().trim());
        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(reader.readLine().trim());;
            int [][] matrix = new int[n][n];
            for(int j = 0; j < n; j++){
                matrix[j] = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            int [] res = solve(matrix, n);

            System.out.println("Case #" + i + ": " + res[0]+" "+res[1] + " " + res[2]);
        }
    }

    private static int[] solve(int[][] matrix, int n) {
       int trace = 0;
       for(int i =0; i < n; i ++){
           trace += matrix[i][i];
       }
       int rows = 0;
       int cols = 0;

       for(int i = 0; i < n; i++){
           boolean [] exist = new boolean[n];
           for(int j  = 0; j < n; j++){
               if(exist[matrix[i][j] - 1]) {
                   rows++;
                   break;
               } else {
                   exist[matrix[i][j] - 1] = true;
               }
           }
       }
        for(int i = 0; i < n; i++){
            boolean [] exist = new boolean[n];
            for(int j  = 0; j < n; j++){
                if(exist[matrix[j][i] - 1]) {
                    cols++;
                    break;
                } else {
                    exist[matrix[j][i] - 1] = true;
                }
            }
        }
        return new int[]{trace, rows, cols};
    }
}
