/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author yoovraj.shinde
 */
public class Solution {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            int taskRegister[][] = new int[N][2];
            for (int j = 0; j <  N; j++) {
                taskRegister[j][0] = in.nextInt();
                taskRegister[j][1] = in.nextInt();
            }
            solve(taskRegister, N, i);
        }
    }    
    public static void solve(final int[][] taskRegister, final int N, int testCaseNumber) {
        // validate that sum of tasks should not exceed 1440
        int[] taskDuration = new int[N];
        int totalWorkHours = 0;
        for (int i = 0; i < N; i++) {
            taskDuration[i] = taskRegister[i][1] - taskRegister[i][0];
            totalWorkHours += taskDuration[i];
        }
        if (totalWorkHours > 24*60) {
            System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
            return;
        }
        char[] taskAssignment = new char[N];
        int CFreeAt = 0, JFreeAt = 0;
        for (int i = 0 ; i < N; i++) {

            // check who is free now 
            if (CFreeAt - JFreeAt > 0) {
                // means C is not available yet
                JFreeAt = taskRegister[i][1];
                taskAssignment[i] = 'J';
            } else {
                // means C is available now 
                CFreeAt = taskRegister[i][1];
                taskAssignment[i] = 'C';
            }
                
        }
        
        System.out.println("Case #" + testCaseNumber + ": " + new String(taskAssignment));
    }
    
}
