import java.util.LinkedList;
import java.util.Scanner;

public class ParentingPartneringReturns {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();

        for (int i = 1; i <= cases; i++) {
            int activities = input.nextInt();
            StringBuilder result = new StringBuilder();
            LinkedList<int[]> cameron = new LinkedList<>();
            LinkedList<int[]> jamie = new LinkedList<>();

            cameron.add(new int[]{input.nextInt(), input.nextInt()});
            jamie.add(new int[]{input.nextInt(), input.nextInt()});
            result.append("CJ");

            boolean stopCameron, stopJamie;
            for (int j = 3; j <= activities; j++) {
                stopCameron = stopJamie = false;
                int start = input.nextInt();
                int finish = input.nextInt();

                if (!assignActivity(cameron, start, finish, 'C', result)) {
                    stopCameron = true;
                }

                if (stopCameron && !assignActivity(jamie, start, finish, 'J', result)) {
                    stopJamie = true;
                }

                if (stopCameron && stopJamie) {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static boolean assignActivity(LinkedList<int[]> schedule, int start, int finish, char person, StringBuilder result) {
        for (int k = 0; k < schedule.size(); k++) {
            int[] interval = schedule.get(k);
            if ((start >= interval[0] && start < interval[1]) || (finish > interval[0] && finish <= interval[1])) {
                return false;
            }

            if (finish == interval[0]) {
                interval[0] = start;
                result.append(person);
                return true;
            }

            if (finish < interval[0]) {
                schedule.add(k, new int[]{start, finish});
                result.append(person);
                return true;
            }

            if (start == interval[1]) {
                interval[1] = finish;
                result.append(person);
                return true;
            }

            if (k + 1 == schedule.size() && start > interval[1]) {
                schedule.add(new int[]{start, finish});
                result.append(person);
                return true;
            }
        }
        return false;
    }
}