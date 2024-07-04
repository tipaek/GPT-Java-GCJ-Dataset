import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.*;

public class Solution { 
    public static void main(String[] args) throws IOException { 
        BufferedReader reader =  
                   new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int x = 1; x <= T; ++x) {
            solve(x, reader);
        }
    }
    
    private static void solve(int x, BufferedReader reader) throws IOException {
        int N = Integer.parseInt(reader.readLine());
        int[][] matrix = new int[N][];
        for (int i=0; i<N; ++i){
            String[] row = reader.readLine().split(" ");
            matrix[i] = new int[N];
            for (int j=0; j<N; ++j) {
                matrix[i][j] = Integer.parseInt(row[j]);
            }
        }
        
        long k = trace(matrix);
        int r = rowsDups(matrix);
        int c = colsDups(matrix);
        System.out.println("Case #"+x+": "+k+" "+r+" "+c);
    }
    
    private static long trace(int[][] matrix) {
        long tot = 0;
        for (int i = 0; i < matrix.length; ++i) {
            tot += matrix[i][i];
        }
        return tot;
    }
    
    private static int rowsDups(int[][] matrix) {
        int r = 0;
        for (int i=0; i<matrix.length; ++i) {
            Set<Integer> validator = new HashSet<Integer>();
            for (int v : matrix[i]) {
                validator.add(v);
            }
            if (validator.size() != matrix.length){
                r += 1;
            }
        }
        return r;
    }
    
    private static int colsDups(int[][] matrix) {
        int r = 0;
        for (int i=0; i<matrix.length; ++i) {
            Set<Integer> validator = new HashSet<Integer>();
            for (int j=0; j<matrix.length; ++j) {
                int v = matrix[j][i];
                validator.add(v);
            }
            if (validator.size() != matrix.length){
                r += 1;
            }
        }
        return r;
    }
} 