import java.util.*;
import java.lang.*; 

public class Solution{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        List<int[][]> input = new ArrayList<>();
        int testcases = scanner.nextInt();
        int l = 1;
        for(int i=0; i<testcases; i++){
            int dim = scanner.nextInt();
            int[][] matrix = new int[dim][dim];
            for(int j=0; j<dim; j++){
                for(int k=0; k<dim; k++){
                    matrix[j][k] = scanner.nextInt();
                }
            }
            input.add(matrix);
        }
        
        int size = input.size();
        for(int m=0; m<size; m++){
            int[][] matrix = input.get(l-1);
            int n = matrix.length;
            int k = 0, r = 0, c = 0;
            for (int i = 0; i < n; i++) {
                int[] columns = new int[n + 1];
                int[] rows = new int[n + 1];
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        k += matrix[i][j];
                    }
                    columns[matrix[i][j]]++;
                    rows[matrix[j][i]]++;
                }
    
                for (int j = 1; j < n + 1; j++) {
                    if (columns[j] > 1) {
                        c++;
                        break;
                    }
                }
                for (int j = 1; j < n + 1; j++) {
                    if (rows[j] > 1) {
                        r++;
                        break;
                    }
                }
            }
    
            int[] answer = new int[]{k, c, r};
            System.out.println("Case #" + l + ": " + answer[0] + " " + answer[1] + " " + answer[2]);
            l++;
        }
    }
}