// https://leetcode.com/explore/other/card/30-day-leetcoding-challenge/528/week-1/3284/
// TIME - 

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args)throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(buf.readLine());

        for(int test = 1; test <= t; test++ ) {

            int k = 0, r = 0, c = 0;

            int n = Integer.parseInt(buf.readLine());
            int[][] matrix = new int[n][n];
            // construct matrix
            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(buf.readLine());
                for(int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // check rows
            for(int i = 0; i < n; i++) {
                HashSet<Integer> rowNums = new HashSet<>();
                boolean repeated = false;
                for(int j = 0; j < n; j++) {
                    if(!repeated && !rowNums.add(matrix[i][j]))
                        repeated = true;

                    if(i == j)
                        k += matrix[i][j];
                }
                if(repeated) r++;
            }
             // check rows
            for(int i = 0; i < n; i++) {
                HashSet<Integer> rowNums = new HashSet<>();
                boolean repeated = false;
                for(int j = 0; j < n; j++) {
                    if(!repeated && !rowNums.add(matrix[j][i]))
                        repeated = true;
                }
                if(repeated) c++;
            }

            System.out.println("Case #" + test + ": " + k + " " + r + " " + c);

        }
    }

    
}
