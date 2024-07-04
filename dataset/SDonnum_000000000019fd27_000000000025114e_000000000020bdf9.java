import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();

        for(int i = 1; i <= cases; i++) {
            int n = sc.nextInt();
            int[][] infoList = new int[n][4];
            for(int j = 0; j < n; j++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                // Start and end times
                infoList[j][0] = start;
                infoList[j][1] = end;

                // Index of current activity
                infoList[j][2] = j;

                // Used to store who takes actoivity
                // 1=C and 2=J
                infoList[j][3] = 0;       
            }
            
            solution(infoList, i);
            
        }

        
    }

    public static void solution(int[][] a, int i) {
        StringBuilder str = new StringBuilder();
        str.append("Case #" + i + ": ");
        Arrays.sort(a, (x, y) -> x[0] - y[0]);

        boolean possible = true;

        // Both available after time 0 to begin with;
        int cEnd = 0;
        int jEnd = 0;
        
        for(int j = 0; j < a.length; j++) {
            int startTime = a[j][0];
            int endTime = a[j][1];

            if(startTime >= cEnd) {
                // cEnd is now endTime of activity
                cEnd = endTime;

                // Save 1 in 4th index to indicate that C took this activity
                a[j][3] = 1;
            } else if(startTime >= jEnd) {
                // Same procedure if J takes the activity
                jEnd = endTime;
                a[j][3] = 2;
            } else {
                // None can take the activity
               str.append("IMPOSSIBLE");
               possible = false;
            }
        }

        if(possible) {
            Arrays.sort(a, (x, y) -> x[2] - y[2]);
            for(int j = 0; j < a.length; j++) {
                if(a[j][3] == 1) {
                    str.append("C");
                } else {
                    str.append("J");
                }
            }
        }
        System.out.println(str.toString());
        return;
    }

}