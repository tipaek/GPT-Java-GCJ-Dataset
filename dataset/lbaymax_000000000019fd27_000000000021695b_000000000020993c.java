import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    matrix[j][k] = in.nextInt();
                }
            }
            int[] result = vestigium(matrix);
            System.out.println(String.format("Case # %d: %d %d %d", i, result[0], result[1], result[2]));
        }
    }

    public static int[] vestigium(int[][] matrix) {
        int[] result = new int[3];
        for(int i = 0; i < matrix.length; i++){
            Set<Integer> founded = new HashSet<>();
            for(int j = 0; j < matrix[0].length; j++){
                if(founded.contains(matrix[i][j])){
                    result[1] = result[1] + 1;
                    break;
                }
                founded.add(matrix[i][j]);
            }
        }

        for(int i = 0; i < matrix[0].length; i++){
            Set<Integer> founded = new HashSet<>();
            for(int j = 0; j < matrix.length; j++){
                if(founded.contains(matrix[j][i])){
                    result[2] = result[2] + 1;
                    break;
                }
                founded.add(matrix[j][i]);
            }
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(i == j){
                    result[0] = result[0] + matrix[i][j];
                }
            }
        }

        return result;
    }
}