import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numOfTest = Integer.parseInt(input.nextLine());
        for (int caseIndex = 0; caseIndex < numOfTest; caseIndex++) {
            int numOfActive = Integer.parseInt(input.nextLine());
            String[] activities = new String[numOfActive];
            for (int i = 0; i < numOfActive; i++) {
                activities[i] = input.nextLine();
            }
            solve(caseIndex + 1, numOfActive, activities);
        }
    }

    private static void solve(int caseIndex, int numOfActive, String[] activities) {

        List<String> jCares = new ArrayList<>();
        List<String> cCares = new ArrayList<>();
        String solution = "";
        for (String activity : activities) {
            if (possibleAsign(cCares, activity)) {
                solution += "C";
                continue;
            }
            if (possibleAsign(jCares, activity)) {
                solution += "J";
                continue;
            }
            solution = "IMPOSSIBLE";
            break;
        }

        System.out.println(String.format("Case #%s: %s", caseIndex, solution));
    }

    private static boolean possibleAsign(List<String> takeCare, String activity) {
        long start = Long.parseLong(activity.split(" ")[0]);
        long end = Long.parseLong(activity.split(" ")[1]);
        for (String act : takeCare) {
            long startTmp = Long.parseLong(act.split(" ")[0]);
            long endTmp = Long.parseLong(act.split(" ")[1]);
            if ((startTmp <= start && start < endTmp)
                    || (startTmp < end && end < endTmp)
                    || (start <= startTmp && endTmp <= end)) {
                return false;
            }
        }
        takeCare.add(activity);
        return true;
    }
}