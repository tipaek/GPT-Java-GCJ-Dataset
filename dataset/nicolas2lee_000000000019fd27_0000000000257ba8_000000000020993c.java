

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution {
    int[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution s = new Solution();
        final int cas = scanner.nextInt();
        for (int ca=1; ca<=cas; ca++){
            final int n = scanner.nextInt();
            s.matrix = new int[n][n];
            for (int r=0; r < n;r++){
                for(int c=0; c<n; c++){
                    s.matrix[r][c] = scanner.nextInt();
                }
            }
            int repeatR=0;
            for (int r=0; r<n;r++){
                int rowNumber = (int) Arrays.stream(s.matrix[r]).distinct().count();
                repeatR+= rowNumber == n ? 0:1;
            }
            int repeatC=0;
            for (int c=0; c<n;c++){
                List<Integer> columnList = new ArrayList<>();
                for (int i=0; i<n;i++){
                    columnList.add(s.matrix[i][c]);
                }
                int colNumber = (int) columnList.stream().distinct().count();
                repeatC+= colNumber == n ? 0:1;
            }
            int trace =0;
            for (int i=0; i<n;i++){
                trace+=s.matrix[i][i];
            }
            System.out.println( String.format("Case #%d: %d %d %d", ca, trace, repeatR, repeatC));
        }
    }
}
