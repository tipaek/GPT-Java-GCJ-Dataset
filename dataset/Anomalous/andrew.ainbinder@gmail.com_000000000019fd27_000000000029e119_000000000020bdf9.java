package Parenting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        
        for (int i = 1; i <= cases; i++) {
            int[] cameronSchedule = new int[1500];
            int[] jamieSchedule = new int[1500];
            int activities = in.nextInt();
            boolean isImpossible = false;
            StringBuilder solution = new StringBuilder();
            
            for (int j = 0; j < activities; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                boolean assignedToCameron = false;
                
                if (isAvailable(cameronSchedule, start, end)) {
                    fillSchedule(cameronSchedule, start, end);
                    solution.append("C");
                    assignedToCameron = true;
                }
                
                if (!assignedToCameron) {
                    if (isAvailable(jamieSchedule, start, end)) {
                        fillSchedule(jamieSchedule, start, end);
                        solution.append("J");
                    } else {
                        solution = new StringBuilder("IMPOSSIBLE");
                        isImpossible = true;
                        break;
                    }
                }
            }
            
            System.out.println("Case #" + i + ": " + solution.toString());
        }
    }
    
    private static boolean isAvailable(int[] schedule, int start, int end) {
        for (int k = start; k < end; k++) {
            if (schedule[k] == 1) {
                return false;
            }
        }
        return true;
    }
    
    private static void fillSchedule(int[] schedule, int start, int end) {
        for (int k = start; k < end; k++) {
            schedule[k] = 1;
        }
    }
}