
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = scanner.nextInt();//test cases
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();//Matrix width
            int[][] matrix = new int[N][N];
            for(int j=0; j< N;j++){
                for(int k=0;k<N;k++){
                    matrix[j][k] = scanner.nextInt();
                }
            }
            System.out.print("Case #"+(i+1)+": ");
            System.out.println(calculate(matrix));

        }
    }

    private static String calculate(int[][] matrix) {
        int k=0;
        int cols = 0;
        int rows = 0;
        for(int i=0;i<matrix.length;i++){
            k+=matrix[i][i];
        }
        for(int i=0;i<matrix.length;i++){
            HashMap<Integer,Integer> map_rows = new HashMap<Integer, Integer>();
            HashMap<Integer,Integer> map_cols = new HashMap<Integer, Integer>();
            for(int j=0;j<matrix.length;j++){
                int colval=map_cols.get(matrix[i][j]) == null? 0 : map_cols.get(matrix[i][j]);
                int rowval=map_rows.get(matrix[j][i]) == null? 0 : map_rows.get(matrix[j][i]);

                map_cols.put(matrix[i][j],colval+1);
                map_rows.put(matrix[j][i],rowval+1);
            }
            cols+=map_cols.values().stream().filter(a -> a>1).count()>0?1:0;
            rows+=map_rows.values().stream().filter(a -> a>1).count()>0?1:0;

        }
        String  s = k+" "+cols+ " "+ rows;
        return s;
    }
}
