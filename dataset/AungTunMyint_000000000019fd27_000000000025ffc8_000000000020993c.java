
import java.util.*;
import java.io.*;

 public class Solution {


    public static void main(String[] args) {
        
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int tc = Integer.parseInt(sc.nextLine());

        
        for (int t = 1; t <= tc; ++t) {

            int N = Integer.parseInt(sc.nextLine());
            long sum = 0, r = 0, c= 0;

            int[][] mat = new int[N][N];

            for ( int row = 0; row < N; ++row) {
                String[] s = sc.nextLine().split(" ");
                for (int col = 0; col < s.length; ++col) {
                    mat[row][col] = Integer.parseInt(s[col]);

                    if ( row == col ) sum += mat[row][col];
                }
            }

            HashSet<Integer> rowDup = new HashSet<>();
            
            HashSet<Integer> colDup = new HashSet<>();

            
            for (int row = 0; row < N; ++row) {

                for (int col = 0; col < N; ++col) {


                    if ( rowDup.contains(mat[row][col]) ) {
                        r++;
                        break;
                    }
                    rowDup.add(mat[row][col]);

                }
                rowDup.clear();
            }

            for (int col = 0; col < N; ++col) {

                for (int row = 0; row < N; ++row) {

                    if ( colDup.contains(mat[row][col]) ) {
                        c++;
                        break;
                    }
                    colDup.add(mat[row][col]);

                }
                colDup.clear();
            }

            System.out.printf("Case #%d: %d %d %d\n",t, sum, r,c);
        }



        sc.close();
    }
}