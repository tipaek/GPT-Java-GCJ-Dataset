import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution{
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for(int i=0;i<tc;i++){
            Set<Integer> rowCheck = new HashSet<>();
            int trace_sum = 0;
            int N = sc.nextInt();
            int[][] mat = new int[N][N];
            int r_rows = 0;
            boolean repeat = false;
            
            for(int j=0;j<N;j++) {
                for(int k=0;k<N;k++) {
                    int next_num = sc.nextInt();
                    if(j == k) trace_sum += next_num;
                    if(rowCheck.contains(next_num)) repeat = true;
                    rowCheck.add(next_num);
                    mat[j][k] = next_num;
                }
                if(repeat) r_rows++;
                repeat = false;
                rowCheck = new HashSet<>();
            }
            int r_cols = get_r_cols(mat, N);
            System.out.println("Case #" + (i+1) + ": " + trace_sum + " " 
            + r_rows + " " + r_cols);
        }
    }
    
    static int get_r_cols(int[][] mat, int N) {
        Set<Integer> colCheck = new HashSet<>();
        int r_cols = 0;
        boolean repeat = false;
        
        for(int j=0;j<N;j++) {
            for(int k=0;k<N;k++) {
                if(colCheck.contains(mat[k][j])) {
                    repeat = true;
                    break;
                }
                colCheck.add(mat[k][j]);
            }
            if(repeat) r_cols++;
            repeat = false;
            colCheck = new HashSet<>();
        }
        return r_cols;
    }
}