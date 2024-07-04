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
        for(int test = 1; test<=totalTests; test++){
            Map<Integer, Integer> cameronSchedule = new TreeMap<>();
            Map<Integer, Integer> jamieSchedule = new TreeMap<>();
            String result = "";
            int activities = scan.nextInt();
            for(int x=0; x<activities; x++) {
                int start = scan.nextInt();
                int end = scan.nextInt();
                if(!result.equals("IMPOSSIBLE")) {
                    boolean isCameronAvailable = true;
                    boolean isJamieAvailable = true;
                    for (Map.Entry<Integer, Integer> cameronTask : cameronSchedule.entrySet()) {
                        if(cameronTask.getValue() <= start) continue;
                        if(cameronTask.getKey() >= end) break;
                        if(cameronTask.getValue() > start) {
                            isCameronAvailable = false;
                            break;
                        }
                    }
                    for (Map.Entry<Integer, Integer> jamieTask : jamieSchedule.entrySet()) {
                        if(jamieTask.getValue() <= start) continue;
                        if(jamieTask.getKey() >= end) break;
                        if(jamieTask.getValue() > start) {
                            isJamieAvailable = false;
                            break;
                        }
                    }
                    if (isCameronAvailable) {
                        cameronSchedule.put(start, end);
                        result = result + "C";
                    } else if (isJamieAvailable) {
                        jamieSchedule.put(start, end);
                        result = result + "J";
                    } else {
                        result = "IMPOSSIBLE";
                    }
                }
            }
            System.out.printf("Case #%d: %s%n", test, result);
        }
    }
}