import java.util.*;
import java.io.*;

public class Solution{

    public static void solve(int test, int[][] matrix){
        if(matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        List<Set<Integer>>rows = new ArrayList<>();
        List<Set<Integer>> columns = new ArrayList<>();

        for(int i = 0; i < matrix.length; i++){
            rows.add(new HashSet<Integer>());
            columns.add(new HashSet<Integer>());
        }
        
        int count = 0;
        Set<Integer> duplicateRow = new HashSet<>();
        Set<Integer> duplicateColumn = new HashSet<>();

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                int number = matrix[i][j];
                if(i == j){
                    count += number;
                }
                
                if(rows.get(i).contains(number)){
                    duplicateRow.add(i);
                }
                if(columns.get(j).contains(number)){
                    duplicateColumn.add(j);
                }
                
                rows.get(i).add(number);
                columns.get(j).add(number);
            }
        }
        
        System.out.println("Case #" + test + ": " + count + " " + duplicateRow.size() +  " " + duplicateColumn.size());
    }

    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        
        for(int i = 0; i < t; i++){
            int size = in.nextInt();
            int[][] matrix = new int[size][size];
            for(int j = 0; j < size; j++){
                for(int k = 0; k < size; k++){
                    matrix[j][k] = in.nextInt();
                }
            }
            
            solve(i + 1, matrix);
        }
    }

}