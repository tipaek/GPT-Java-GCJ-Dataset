import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    int start;
    int end;
    
    public Solution(int s, int e) {
        start = s;
        end = e;
    }
    public int getStart() {
        return start;
    }
    public int getEnd() {
        return end;
    }
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int numCases = keyboard.nextInt();
        for (int i = 1; i <= numCases; i++) {
            int numAct = keyboard.nextInt();
            String order = "";
            ArrayList<Solution> cTimes = new ArrayList<>();
            ArrayList<Solution> jTimes = new ArrayList<>();
            for (int j = 0; j < numAct; j++) {
                int start = keyboard.nextInt();
                int end = keyboard.nextInt();
                if (isAvailiable(start, end, cTimes)) {
                    order += "C";
                    cTimes.add(new Solution(start, end));
                }
                else if (isAvailiable(start, end, jTimes)) {
                    order += "J";
                    jTimes.add(new Solution(start, end));
                }
                else {
                    order = "IMPOSSIBLE";
                    break;
                }
            }
            System.out.println("Case #" + i + ": " + order);
        }
    }
    
    public static boolean isAvailiable(int start, int end, ArrayList<Solution> schedule) {
        int length = end - start;
        for (int i = 0; i < schedule.size(); i++) {
            int tempStart = schedule.get(i).getStart();
            int tempEnd = schedule.get(i).getEnd();
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