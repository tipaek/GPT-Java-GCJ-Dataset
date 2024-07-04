import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int numCases = keyboard.nextInt();
        for (int i = 1; i <= numCases; i++) {
            int numAct = keyboard.nextInt();
            String order = "";
            int[] cTimeStart = new int[1000];
            int[] cTimeEnd = new int[1000];
            int[] jTimeStart = new int[1000];
            int[] jTimeEnd = new int[1000];
            int cNum = 0;
            int jNum = 0;
            for (int j = 0; j < numAct; j++) {
                int start = keyboard.nextInt();
                int end = keyboard.nextInt();
                if (isAvailiable(start, end, cTimeStart, cTimeEnd, cNum)) {
                    order += "C";
                    cTimeStart[cNum] = start;
                    cTimeEnd[cNum] = end;
                    cNum++;
                }
                else if (isAvailiable(start, end, jTimeStart, jTimeEnd, jNum)) {
                    order += "J";
                    jTimeStart[jNum] = start;
                    jTimeEnd[jNum] = end;
                    jNum++;
                }
                else {
                    order = "IMPOSSIBLE";
                    break;
                }
            }
            System.out.println("Case #" + i + ": " + order);
        }
    }

    public static boolean isAvailiable(int start, int end, int[] startTimes, int[] endTimes, int num) {
        for (int i = 0; i < num; i++) {
            //System.out.println(schedule.get(i).substring(0, schedule.get(i).indexOf(",")));
            //System.out.println(schedule.get(i).substring(schedule.get(i).indexOf(",") + 1));
            int tempStart = startTimes[i];
            int tempEnd = endTimes[i];
            if (end > tempStart && end <= tempEnd) {
                return false;
            }
            else if (start >= tempStart && start < tempEnd) {
                return false;
            }
        }
        return true;
    }
}