/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LUCIANO.
 */
import java.util.*;

public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int tt = 0; tt < t; tt++) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }
            int r = 0;
            for(int i = 0; i < n; i++) {
                int[] rowcnt = new int[n];
                for(int j = 0; j < n; j++) {
                    if(rowcnt[matrix[i][j] - 1] == 1) {
                        r += 1;
                        break;
                    }else rowcnt[matrix[i][j] - 1] = 1;
                }
            }
            int c = 0;
            for(int i = 0; i < n; i++) {
                int[] rowcnt = new int[n];
                for(int j = 0; j < n; j++) {
                    if(rowcnt[matrix[j][i] - 1] == 1) {
                        c += 1;
                        break;
                    }else rowcnt[matrix[j][i] - 1] = 1;
                }
            }
            int l = 0;
            for(int i = 0; i < n; i++) {
                l += matrix[i][i];
            }
            System.out.println("Case #" + (tt + 1) + ": " + l + " " + r + " " + c);
        }
    }
}