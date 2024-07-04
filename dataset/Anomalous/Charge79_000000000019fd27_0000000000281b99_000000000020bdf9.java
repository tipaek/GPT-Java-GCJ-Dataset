package codeJam2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader kbd = new BufferedReader(new InputStreamReader(System.in));
        int times = Integer.parseInt(kbd.readLine());
        
        for (int i = 1; i <= times; i++) {
            StringBuilder output = new StringBuilder();
            boolean[] cTime = new boolean[1440];
            boolean[] jTime = new boolean[1440];
            int n = Integer.parseInt(kbd.readLine());
            boolean impossible = false;
            
            for (int j = 0; j < n; j++) {
                String[] timeRange = kbd.readLine().split(" ");
                int startIn = Integer.parseInt(timeRange[0]);
                int endIn = Integer.parseInt(timeRange[1]);

                boolean cCheck = canAssign(cTime, startIn, endIn);
                boolean jCheck = canAssign(jTime, startIn, endIn);

                if (cCheck) {
                    output.append("C");
                    assignTime(cTime, startIn, endIn);
                } else if (jCheck) {
                    output.append("J");
                    assignTime(jTime, startIn, endIn);
                } else {
                    output.setLength(0); // Clear the output
                    output.append("IMPOSSIBLE");
                    impossible = true;
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + output);
        }
        kbd.close();
    }

    private static boolean canAssign(boolean[] timeArray, int start, int end) {
        for (int k = start; k < end; k++) {
            if (timeArray[k]) {
                return false;
            }
        }
        return true;
    }

    private static void assignTime(boolean[] timeArray, int start, int end) {
        Arrays.fill(timeArray, start, end, true);
    }
}