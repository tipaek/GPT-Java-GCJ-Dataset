import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();

        for (int i = 1; i <= cases; i++) {
            int activities = input.nextInt();
            StringBuilder result = new StringBuilder();

            ArrayList<Integer> cameron = new ArrayList<>();
            ArrayList<Integer> jamie = new ArrayList<>();
            boolean isPossible = true;

            for (int j = 0; j < activities; j++) {
                int start = input.nextInt();
                int finish = input.nextInt();
                boolean assigned = false;

                // Try to assign to Cameron
                if (canAssign(cameron, start, finish)) {
                    cameron.add(start);
                    cameron.add(finish);
                    result.append('C');
                    assigned = true;
                } else if (canAssign(jamie, start, finish)) { // Try to assign to Jamie
                    jamie.add(start);
                    jamie.add(finish);
                    result.append('J');
                    assigned = true;
                }

                if (!assigned) {
                    isPossible = false;
                    // Skip the rest of the input for this case
                    for (int k = j + 1; k < activities; k++) {
                        input.nextInt();
                        input.nextInt();
                    }
                    break;
                }
            }

            if (!isPossible) {
                result = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static boolean canAssign(ArrayList<Integer> schedule, int start, int finish) {
        for (int k = 0; k < schedule.size(); k += 2) {
            int scheduledStart = schedule.get(k);
            int scheduledFinish = schedule.get(k + 1);

            if ((start < scheduledFinish && finish > scheduledStart) || 
                (start == scheduledStart && finish == scheduledFinish)) {
                return false;
            }
        }
        return true;
    }
}