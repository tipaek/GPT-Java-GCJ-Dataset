import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

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

                if (!assignActivity(cameron, start, finish)) {
                    stopCameron = true;
                } else {
                    result.append("C");
                }

                if (stopCameron) {
                    if (!assignActivity(jamie, start, finish)) {
                        stopJamie = true;
                    } else {
                        result.append("J");
                    }
                }

                if (stopCameron && stopJamie) {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static boolean assignActivity(LinkedList<int[]> schedule, int start, int finish) {
        for (int[] interval : schedule) {
            if ((start > interval[0] && start < interval[1]) || (finish > interval[0] && finish < interval[1])) {
                return false;
            }
        }

        for (int i = 0; i < schedule.size(); i++) {
            int[] interval = schedule.get(i);
            if (finish == interval[0]) {
                interval[0] = start;
                return true;
            } else if (finish < interval[0]) {
                schedule.add(i, new int[]{start, finish});
                return true;
            } else if (start == interval[1]) {
                interval[1] = finish;
                return true;
            } else if (i + 1 == schedule.size() && start > interval[1]) {
                schedule.add(new int[]{start, finish});
                return true;
            }
        }

        return false;
    }
}