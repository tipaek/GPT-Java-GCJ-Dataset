import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();
        int[] N = new int[tests];
        int[] traces = new int[tests];
        int[] dup_rows = new int[tests];
        int[] dup_cols = new int[tests];
        ArrayList<int[][]> matrices= new ArrayList<int[][]>();
        for(int i = 0; i < tests; i ++){
            N[i] = in.nextInt();
            int[][] temp = new int[N[i]][N[i]];
            for(int j = 0; j < N[i]; j++){
                for(int k = 0; k < N[i]; k++){
                    temp[j][k] = in.nextInt();
                }
            }
            matrices.add(temp);
        }
         for(int j = 0; j < matrices.size(); j ++) {
             int trace = 0;
             for (int i = 0; i < N[j]; i++) {
                 trace += matrices.get(j)[i][i];
             }
             traces[j] = trace;
             System.out.println(trace);
         }

        for(int j = 0; j < matrices.size(); j ++) {
            int[][] matrix = matrices.get(j);
            int dupeRows = 0;
            int dupeCols = 0;
            for(int i = 0; i < N[j]; i++){
                HashSet<Integer> row = new HashSet<Integer>();
                for(int k = 0; k < N[j]; k++){
                    if (!row.contains(matrix[i][k])){
                        row.add(matrix[i][k]);
                    }
                    else{
                        dupeRows +=1;
                        break;
                    }

                }
            }
            for(int i = 0; i < N[j]; i++){
                HashSet<Integer> col = new HashSet<Integer>();
                for(int k = 0; k < N[j]; k++){
                    if (!col.contains(matrix[k][i])){
                        col.add(matrix[k][i]);
                    }
                    else{
                        dupeCols +=1;
                        break;
                    }

                }
            }
        dup_rows[j] = dupeRows;
            dup_cols[j] = dupeCols;
        }
        for(int i = 0; i < tests; i ++){
            int test_case = i+1;
            System.out.println("Case #" + test_case + ": " + traces[i] + " " + dup_rows[i] + " " + dup_cols[i]);
        }

    }
}