import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scan = new Scanner(System.in);
        int totalTests = scan.nextInt();
        boolean[] cs = new boolean[1440];
        boolean[] js = new boolean[1440];
        boolean isCameronAvailable;
        boolean isJamieAvailable;
        for(int test = 1; test<=totalTests; test++){
            resetSchedule(cs);
            resetSchedule(js);
            String result = "";
            int activities = scan.nextInt();
            int[] start = new int[activities];
            int[] end = new int[activities];

            for(int x=0; x<activities; x++) {
                start[x] = scan.nextInt();
                end[x] = scan.nextInt();
            }
            for(int x=0; x<activities; x++) {
                int startTime = start[x];
                int endTime = end[x];
                isCameronAvailable = true;
                isJamieAvailable = true;
                for (int i = startTime; i < endTime; i++) {
                    if (cs[i]) {
                        isCameronAvailable = false;
                    }
                    if (js[i]) {
                        isJamieAvailable = false;
                    }
                }
                if (isCameronAvailable) {
                    for (int i = startTime; i < endTime; i++) {
                        cs[i] = true;
                    }
                    result = result + "C";
                } else if (isJamieAvailable) {
                    for (int i = startTime; i < endTime; i++) {
                        js[i] = true;
                    }
                    result = result + "J";
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }
            System.out.printf("Case #%d: %s", test, result);
            if(test < totalTests) System.out.printf("%n");
        }
    }

    private static void resetSchedule(boolean[] arr) {
        for(int i=0; i<arr.length; i++) arr[i] = false;
    }
}