import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scan = new Scanner(System.in);
        int totalTests = scan.nextInt();
        boolean[] cs = new boolean[1441];
        boolean[] js = new boolean[1441];
        boolean isCameronAvailable = true;
        for(int test = 0; test<totalTests; test++){
            resetSchedule(cs);
            resetSchedule(js);
            StringBuilder result = new StringBuilder();
            int activities = scan.nextInt();
            for(int x=0; x<activities; x++) {
                int start = scan.nextInt();
                int end = scan.nextInt();
                if(!"IMPOSSIBLE".equals(result.toString())) {
                    isCameronAvailable = true;
                    for (int i = start; i < end; i++) {
                        if (cs[i]) {
                            isCameronAvailable = false;
                            break;
                        }
                    }
                    if (isCameronAvailable) {
                        for (int i = start; i < end; i++) {
                            cs[i] = true;
                        }
                        result.append('C');
                    } else {
                        for (int i = start; i < end; i++) {
                            if (js[i]) {
                                result.setLength(0);
                                result.append("IMPOSSIBLE");
                                break;
                            } else {
                                js[i] = true;
                            }
                        }
                        if(!"IMPOSSIBLE".equals(result.toString())) {
                            result.append("J");
                        }
                    }
                }
            }
            System.out.printf("Case #%d: %s%n", test+1, result.toString());
        }
    }

    private static void resetSchedule(boolean[] arr) {
        for(int i=0; i<arr.length; i++) arr[i] = false;
    }
}