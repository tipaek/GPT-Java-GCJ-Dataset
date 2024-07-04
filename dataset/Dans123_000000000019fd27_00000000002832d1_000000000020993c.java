import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        Scanner in = createScanner();
        int t = in.nextInt();
	   // Integer bt = new BigInteger(in.nextLine());
	   // int t = bt.intValue();
	    latinTrace sol = new latinTrace();
	    for(int i=0; i<t; ++i){
	        int nxn = in.nextInt();
            int matrix[][] = new int[nxn][nxn];
            for(int j=0;j<nxn;++j){
                for(int c =0; c<nxn;++c){
                    matrix[j][c] = in.nextInt();
                }
            }
            sol.solve(matrix);
        }
    }

    public static Scanner createScanner(){
        return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    }

}
 class latinTrace {
    public static int test_case = 1;
    public static void solve(int matrix[][]) {
        int k = 0; //sum trace;
        int r = 0; //rows with repeating digits
        int c = 0; //columns with repeating digits
        k = compute_trace(matrix);
        r = compute_r(matrix);
        c = compute_c(matrix);
        System.out.println("Case #" + test_case++ + ": " + k + " " + r + " " + c );
    }

    public static int compute_trace(int matrix[][]){
        int trace = 0;
        for(int i=0;i<matrix.length;++i){
            trace += matrix[i][i];
        }
        return trace;
    }

    public static int compute_r(int matrix[][]){
        int r = 0;
        HashSet<Integer> row = new HashSet<>();
        boolean flag = false;
        for(int i=0;i<matrix.length;++i) {
            for(int j=0; j<matrix.length; ++j){
                if(row.contains(matrix[i][j]))
                    flag = true;
                else
                row.add(matrix[i][j]);
            }
            if(flag == true){
                ++r;
                flag = false;
            }
            row.clear();
        }
        return r;
    }
    public static int compute_c(int matrix[][]){
        int c = 0;
        HashSet<Integer> col_set = new HashSet<>();
        boolean flag = false;
        for(int i=0;i<matrix.length;++i) {
            for(int j=0; j<matrix.length; ++j){
                if(col_set.contains(matrix[j][i]))
                    flag = true;
                else
                    col_set.add(matrix[j][i]);
            }
            if(flag == true){
                ++c;
                flag = false;
            }
            col_set.clear();
        }
        return c;
    }
    public static void print_matrix(int matrix[][]) {
        for (int j = 0; j < matrix.length; ++j) {
            for (int c = 0; c < matrix[0].length; ++c) {
                System.out.println(matrix[j][c]);
            }
        }
    }
}