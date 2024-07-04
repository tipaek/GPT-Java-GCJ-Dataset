import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Solution
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scan = new Scanner(System.in);
        int totalTests = scan.nextInt();
        for(int test = 0; test<totalTests; test++){
            boolean[] cameronSchedule = new boolean[1440];
            boolean[] jamieSchedule = new boolean[1440];
            String result = "";
            int activities = scan.nextInt();
            for(int x=0; x<activities; x++) {
                int start = scan.nextInt();
                int end = scan.nextInt();
                if(!result.equals("IMPOSSIBLE")) {
                    boolean isCameronAvailable = true;
                    boolean isJamieAvailable = true;
                    for (int i = start; i < end; i++) {
                        if (cameronSchedule[i]) {
                            isCameronAvailable = false;
                        }
                        if (jamieSchedule[i]) {
                            isJamieAvailable = false;
                        }
                    }
                    if (isCameronAvailable) {
                        for (int i = start; i < end; i++) {
                            cameronSchedule[i] = true;
                        }
                        result = result + "C";
                    } else if (isJamieAvailable) {
                        for (int i = start; i < end; i++) {
                            jamieSchedule[i] = true;
                        }
                        result = result + "J";
                    } else {
                        result = "IMPOSSIBLE";
                    }
                }
            }
            System.out.printf("Case #%d: %s%n", test+1, result);
        }
    }
}