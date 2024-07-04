import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tN = in.nextInt();
        for(int t = 1;t<=tN;t++) {
        int n = in.nextInt();
        int[][] matrix = new int[n][n];

        for(int i =0; i<n;i++)
            for(int j = 0;j<n;j++)
            matrix[i][j] = in.nextInt();

            int trace = 0;
            int rowCount = 0;
            int columnCount = 0;
            for(int i = 0;i<n;i++)
                trace +=matrix[i][i];

            for(int i =0; i<n;i++) {
                HashSet<Integer> checkDuplicate = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if(!checkDuplicate.add(matrix[i][j])) {
                        rowCount++;
                        break;
                    }
                }
            }

            for(int i =0; i<n;i++) {
                HashSet<Integer> checkDuplicate = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if(!checkDuplicate.add(matrix[j][i])) {
                        columnCount++;
                        break;
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d",t,trace,rowCount,columnCount);
            System.out.println();

        }
    }
}

