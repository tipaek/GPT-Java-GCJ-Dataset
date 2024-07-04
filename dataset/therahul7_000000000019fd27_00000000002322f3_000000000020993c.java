import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public void createTargetArray(int[] nums, int[] index) {

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); //test
        for (int i = 1; i <= t; ++i) {
            int deg=in.nextInt();
            int trace=0;
            int[][] mat = new int[deg][deg];
            int rowDup=0;
            int colDup=0;
            for (int j = 0; j < deg; j++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < deg; k++) {
                    mat[j][k] = in.nextInt();
                    rowSet.add(mat[j][k]);
                }
                if (rowSet.size() != deg) {
                    rowDup++;
                }
                trace += mat[j][j];
            }
            for (int col = 0; col < deg; col++) {
                Set<Integer> colSet = new HashSet<>();
                for (int row = 0; row < deg; row++) {
                    colSet.add(mat[row][col]);
                }
                if (colSet.size() != deg) {
                    colDup++;
                }
            }

            System.out.println("Case #"+i+": "+trace+" "+rowDup+" "+colDup);
        }
    }
}