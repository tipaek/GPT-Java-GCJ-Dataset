
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
/**
 *
 * @author Dave
 */
public class Solution {
    public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
         int n = Integer.parseInt(input.nextLine());
         ArrayList<String[]> matrices = new ArrayList<>();
         for (int i = 0; i < n; i++) {
            int s = Integer.parseInt(input.nextLine());
            String[] matrix = new String[s];
             for (int j = 0; j < s; j++) {
                 matrix[j] = input.nextLine();
             }
            matrices.add(matrix);
        }
         
        Solution sol = new Solution();
        for (int i = 0; i < n; i++) {
            System.out.println(sol.solve(matrices.get(i), i));
        }
    }
    
    public String solve(String[] matrix, int Case){
        int k = 0, r = 0, c = 0;
        ArrayList<HashSet<Integer>> columns = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            columns.add(new HashSet<>());
        }
        for (int i = 0; i < matrix.length; i++) {
            String[] row = matrix[i].split(" ");
            HashSet<Integer> rowValues = new HashSet<>();
            
            for (int j = 0; j < row.length; j++) {
                int x = Integer.parseInt(row[j]);
                if(i == j) k += x;
                if(rowValues != null){
                    if(rowValues.contains(x)){
                        rowValues = null;
                        r++;
                    } else {
                        rowValues.add(x);
                    }
                }
                if(columns.get(j) != null){
                    if(columns.get(j).contains(x)){
                        columns.set(j, null);
                        c++;
                    } else {
                        columns.get(j).add(x);
                    }
                }
            }
        }
        return String.format("Case #%d: %d %d %d", Case, k, r, c);
    }
}
