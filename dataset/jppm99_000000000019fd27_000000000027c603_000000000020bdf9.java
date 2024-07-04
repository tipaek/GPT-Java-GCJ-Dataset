package app;

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for(int i = 0; i < cases; i++){
            solve(in, i+1);
        }
    }

    private static void solve(Scanner in, int caseN) {
        int nActivities = in.nextInt();
        
        List<int[]> activities = new ArrayList<>();
        
        for(int i = 0; i < nActivities; i++) {
            int[] boas = new int[4];
            boas[0] = in.nextInt();
            boas[1] = in.nextInt();
            boas[2] = i;

            activities.add( boas );
        }

        activities.sort((o1, o2) -> o1[0] - o2[0]);

        boolean possible = true;
        String output = "";

        int j_busy_until = 0;
        int c_busy_until = 0;

        for(int i = 0; i < activities.size(); i++) {
            if(activities.get(i)[0] >= c_busy_until) {
                activities.get(i)[3] = 0; // 0 will be parsed as C
                c_busy_until = activities.get(i)[1];
            }
            else if(activities.get(i)[0] >= j_busy_until) {
                activities.get(i)[3] = 1; // 1 will be parsed as J
                j_busy_until = activities.get(i)[1];
            }
            else {
                possible = false;
                output = "IMPOSSIBLE";
                break;
            }
        }

        if(possible) {        
            activities.sort((o1, o2) -> o1[2] - o2[2]); //restore initial order

            for(int i = 0; i < activities.size(); i++) {
                if(activities.get(i)[3] == 0)
                    output += "C";
                else if(activities.get(i)[3] == 1)
                    output += "J";
            }
        }

        System.out.println("Case #" + caseN + ": " + output);
    }
}
