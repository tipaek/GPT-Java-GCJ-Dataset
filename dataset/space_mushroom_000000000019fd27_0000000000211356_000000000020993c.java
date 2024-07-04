import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution{
    private static Scanner input = new Scanner(
            new BufferedReader(new InputStreamReader(System.in)));

    private static String solve(int[][] matrix){
        int n = matrix.length;
        int trace = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j)
                    trace+=matrix[i][j];
            }
        }

        int repeatedRows = 0;
        for(int i=0; i<n; i++){
            Set<Integer> set = new HashSet<>();
            for(int j=0; j<n; j++){
                if(set.contains(matrix[i][j])){
                    repeatedRows++;
                    break;
                }
                set.add(matrix[i][j]);
            }
        }

        int repeatedColumns = 0;
        for(int i=0; i<n; i++){
            Set<Integer> set = new HashSet<>();
            for(int j=0; j<n; j++){
                if(set.contains(matrix[j][i])){
                    repeatedColumns++;
                    break;
                }
                set.add(matrix[j][i]);
            }
        }

        return ""+trace+" "+repeatedRows+" "+repeatedColumns;
    }

    public static void main(String[] args){
        int t = input.nextInt();
        for(int i = 0; i < t; i++){
            int n = input.nextInt();
            int[][] matrix = new int[n][n];
            for (int j = 0; j < n; j++){
                for (int k = 0; k < n; k++){
                    matrix[j][k] = input.nextInt();
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + solve(matrix));
        }
    }
}