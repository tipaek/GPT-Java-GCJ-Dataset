import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int numCases = keyboard.nextInt();
        for (int i = 1; i <= numCases; i++) {
            int numAct = keyboard.nextInt();
            String order = "";
            String[] cTime = new String[1000];
            String[] jTime = new String[1000];
            int cNum = 0;
            int jNum = 0;
            for (int j = 0; j < numAct; j++) {
                int start = keyboard.nextInt();
                int end = keyboard.nextInt();
                if (isAvailiable(start, end, cTime, cNum)) {
                    order += "C";
                    cTime[cNum] = start + "," + end;
                    cNum++;
                }
                else if (isAvailiable(start, end, jTime, jNum)) {
                    order += "J";
                    jTime[jNum] = start + "," + end;
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

    public static boolean isAvailiable(int start, int end, String[] schedule, int num) {
        for (int i = 0; i < num; i++) {
            //System.out.println(schedule.get(i).substring(0, schedule.get(i).indexOf(",")));
            //System.out.println(schedule.get(i).substring(schedule.get(i).indexOf(",") + 1));
            int tempStart = Integer.parseInt(schedule[i].substring(0, schedule[i].indexOf(",")));
            int tempEnd = Integer.parseInt(schedule[i].substring(schedule[i].indexOf(",") + 1));
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