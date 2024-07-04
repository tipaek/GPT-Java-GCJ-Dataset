import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int numCases = keyboard.nextInt();
        for (int i = 1; i <= numCases; i++) {
            int numAct = keyboard.nextInt();
            String order = "";
            ArrayList<Integer> cTimes = new ArrayList<>();
            ArrayList<Integer> jTimes = new ArrayList<>();
            for (int j = 0; j < numAct; j++) {
                int start = keyboard.nextInt();
                int end = keyboard.nextInt();
                if (isAvailiable(start, end, cTimes)) {
                    order += "C";
                    cTimes.add(new Integer(5));
                }
                else if (isAvailiable(start, end, jTimes)) {
                    order += "J";
                    jTimes.add(new Integer(4));
                }
                else {
                    order = "IMPOSSIBLE";
                    break;
                }
            }
            System.out.println("Case #" + i + ": " + order);
        }
    }
    
    public static boolean isAvailiable(int start, int end, ArrayList<Integer> schedule) {
        int length = end - start;
        for (int i = 0; i < schedule.size(); i++) {
            int tempStart = schedule.get(i);
            int tempEnd = schedule.get(i);
            if (end > tempStart && end < tempEnd) {
                return false;
            }
            else if (start > tempStart && start < tempEnd) {
                return false;
            }
        }
        return true;
    }
}