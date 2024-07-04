import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Round 1a - A
 *
 * @author Bohdan
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int t = 1; t <= test; ++t) {
            int r = in.nextInt();
            int c = in.nextInt();
            
            int interest = 0;
            int result = 0;
            
            int[][] skill = new int[r + 2][c + 2];
            for (int i = 0; i < r+2; i++) {
                for (int j = 0; j < c+2; j++) {
                    skill[i][j] = 0;
                }
            }
            for (int i = 1; i < r + 1; i++) {
                for (int j = 1; j < c + 1; j++) {
                    skill[i][j] = in.nextInt();
                    interest+=skill[i][j];
                }
            }
            int elim = 1;
            boolean[][] removed = new boolean[r+2][c+2];
            int[][] up = new int[r + 2][c + 2];
            int[][] down = new int[r + 2][c + 2];
            int[][] right = new int[r + 2][c + 2];
            int[][] left = new int[r + 2][c + 2];
            for (int i = 1; i < r + 1; i++) {
                for (int j = 1; j < c + 1; j++) {
                    up[i][j] = i - 1;
                    down[i][j] = i + 1;
                    right[i][j] = j + 1;
                    left[i][j] = j - 1;
                }
            }
            while (elim != 0) {
                elim = 0;
                for (int i = 1; i < r+1; i++) {
                    for (int j = 1; j < c+1; j++) {
                        removed[i][j] = false;
                    }
                }
                for (int i = 1; i < r+1; i++) {
                    for (int j = 1; j < c+1; j++) {
                        if (skill[i][j] > 0) {
                            int neib = 0;
                            int total = skill[up[i][j]][j];
                            if (skill[up[i][j]][j] > 0) {
                                neib++;
                            }
                            total += skill[down[i][j]][j];
                            if (skill[down[i][j]][j] > 0) {
                                neib++;
                            }
                            total += skill[i][left[i][j]];
                            if (skill[i][left[i][j]] > 0) {
                                neib++;
                            }
                            total += skill[i][right[i][j]];
                            if (skill[i][right[i][j]] > 0) {
                                neib++;
                            }
                            if ((neib > 0) && (skill[i][j] * neib - total < 0)){
                                removed[i][j] = true;
                                elim = 1;
                                
                                
                            }
                            
                        }
                    }
                    
                }
                
                result = result+interest;
                for (int i = 1; i < r+1; i++) {
                    for (int j = 1; j < c+1; j++) {
                        if (removed[i][j]){
                            left[i][right[i][j]] = left[i][j];
                            interest-=skill[i][j];
                            skill[i][j] = 0;
                        }                        
                    }
                    for (int j = r; j > 0; j--) {
                        if (removed[i][j]){
                            right[i][left[i][j]] = right[i][j];
                        }                        
                    }
                }
                for (int j = 1; j < c+1; j++) {
                    for (int i = 1; i < r+1; i++) {
                        if (removed[i][j]){
                            up[down[i][j]][j] = up[i][j];
                        }                        
                    }
                    for (int i = r; i > 0; i--) {
                        if (removed[i][j]){
                            down[up[i][j]][j] = down[i][j];
                        }                        
                    }
                }
            }

            System.out.println("Case #" + t + ": " + result);
        }
    }

}
