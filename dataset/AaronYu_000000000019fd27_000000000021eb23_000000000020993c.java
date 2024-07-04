

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27/000000000020993c
 *
 * @auther AaronYu
 * @date 2020/4/4 9:11
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        for(int s = 0; s < T; s++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            int k= 0;
            int r =0;
            int c= 0;
            int rows = matrix.length;
            int cols = matrix[0].length;
            Map<Integer,Integer> map = new HashMap<>();
            for(int i = 0; i < matrix.length; i++) {
//                boolean rFlag = true;
                for(int j = 0; j < matrix[0].length;j++) {
                    matrix[i][j] = scanner.nextInt();
                    if(i == j) {
                        k += matrix[i][j];
                    }
                    map.put(i * cols +j,matrix[i][j] );
                }
            }
            for(int i = 0; i < matrix.length; i++) {
//                boolean rFlag = true;
                Main:
                for (int j = 1; j < matrix[0].length; j++) {
                  
                    for(int curRow = i * cols; curRow < (i) * cols + j; curRow++) {
                        if(map.get(curRow) == matrix[i][j]) {
                            r++;
                            break Main;
                        }
                    }
                }
            }

//                boolean rFlag = true;

                for (int j = 0; j < matrix[0].length; j++) {
                    Main:
                    for(int i = 1; i < matrix.length; i++) {
                    int curValue = matrix[i][j];
                    for(int curCols = i * cols+j - cols ; curCols >= 0; curCols-= cols) {
                        if(map.get(curCols) == curValue) {
                            c++;
                            break Main;
                        }
                    }
                }
            }
           

            System.out.println("Case #"+(s+1)+": "+k+" "+r+" "+c);
        }
    }
}
