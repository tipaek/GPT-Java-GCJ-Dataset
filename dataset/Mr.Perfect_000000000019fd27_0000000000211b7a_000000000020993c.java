import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int c = 1; c <= t; ++c) {
            int n = s.nextInt();
            int k = 0;
            int rowC = 0;
            int colC = 0;
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; ++i) {
                HashSet<Integer> seen = new HashSet<>();
                for(int j = 0; j < n; ++j) {
                    int val = s.nextInt();
                    if(i==j) k+=val;
                    matrix[i][j] = val;
                    seen.add(val);
                }
                if(seen.size()!=n) rowC++;
            }

            for(int i = 0; i < n; ++i) {
                HashSet<Integer> seen = new HashSet<>();
                for(int j = 0; j < n; ++j) {
                    int val = matrix[j][i];
                    seen.add(val);
                }
                if(seen.size()!=n) colC++;
            }

            System.out.println("Case #"+c+": " + k + " " + rowC + " " + colC);
        }
    }
}