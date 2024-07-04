import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int numCases = keyboard.nextInt();
        for (int i = 1; i <= numCases; i++) {
            int numAct = keyboard.nextInt();
            String order = "";
            ArrayList<String> cTimes = new ArrayList<>();
            ArrayList<String> jTimes = new ArrayList<>();
            for (int j = 0; j < numAct; j++) {
                int start = keyboard.nextInt();
                int end = keyboard.nextInt();
                if (isAvailiable(start, end, cTimes)) {
                    order += "C";
                    cTimes.add(start + "," + end);
                }
                else if (isAvailiable(start, end, jTimes)) {
                    order += "J";
                    jTimes.add(start + "," + end);
                }
                else {
                    order = "IMPOSSIBLE";
                    break;
                }
            }
            System.out.println("Case #" + i + ": " + order);
        }
    }

    public static boolean isAvailiable(int start, int end, ArrayList<String> schedule) {
        int length = end - start;
        for (int i = 0; i < schedule.size(); i++) {
            int tempStart = Integer.parseInt(schedule.get(i).substring(0, schedule.get(i).indexOf(",")));
            int tempEnd = Integer.parseInt(schedule.get(i).substring(schedule.get(i).indexOf(",") + 1));
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