import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();

        for(int i = 1; i <= cases; i++) {
            int n = sc.nextInt();
            int[] starts = new int[n];
            int[] endings = new int[n];
            for(int j = 0; j < n; j++) {
                int start = sc.nextInt();
                int end = sc.nextInt();

                starts[j] = start;
                endings[j] = end;
            }

            simpleSort(starts, endings);
            String solution = solve(starts, endings);
            System.out.println("Case #" + i + ": " + solution);
            
        }
    }

    public static void simpleSort(int[] s, int[] e) {
        int n = s.length;
        for(int i = 0; i < n-1; i++) {
            for(int j = 0; j < n-i-1; j++) {
                if(s[j] > s[j+1]) {
                    int tempS = s[j];
                    int tempE = e[j];
                    s[j] = s[j+1];
                    e[j] = e[j+1];
                    s[j+1] = tempS;
                    e[j+1] = tempE;
                }
            }
        }
    }

    public static String solve(int[] s, int[] e) {
        String toReturn = "";

        // Used to store when C or J is available again
        int cEnd = 0;
        int jEnd = 0;


        for(int i = 0; i < s.length; i++) {
            if(s[i] >= cEnd) {
                cEnd = e[i];
                toReturn += "C";
                continue;
            } else if (s[i] >= jEnd) {
                jEnd = e[i];
                toReturn += "J";
                continue;
            } else {
                return "IMPOSSIBLE";
            }



        }
        return toReturn;
    }
}