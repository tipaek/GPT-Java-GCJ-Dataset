import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner reader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = reader.nextInt();
        for (int i = 1; i <= testCases; i++){
            int N = reader.nextInt();
            int[][] matrix = new int[N][N];
            for (int j = 0; j < N; j++){
                for(int k = 0; k < N; k++){
                    matrix[j][k] = reader.nextInt();
                }
            }
            int trace = 0, col = 0, rows = 0;
            for (int j = 0; j < N; j++){
                trace += matrix[j][j];
            }
            for (int j = 0; j < N; j++) {
                Set<Integer> setRow = new HashSet<>();
                Set<Integer> setCol = new HashSet<>();
                for(int k = 0; k < N; k++){
                    setRow.add(matrix[j][k]);
                    setCol.add(matrix[k][j]);
                }
                if(setRow.size() != N)
                    rows++;
                if(setCol.size() != N)
                    col++;
                setRow.clear();
                setCol.clear();
            }
            System.out.println("Case #" + i + ": " + trace + " " + rows + " " + col);
        }
    }
}