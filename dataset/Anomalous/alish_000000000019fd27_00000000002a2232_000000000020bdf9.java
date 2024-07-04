import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int cases = input.nextInt();

            for (int i = 1; i <= cases; i++) {
                int activities = input.nextInt();
                StringBuilder result = new StringBuilder();
                LinkedList<Integer> cameron = new LinkedList<>();
                LinkedList<Integer> jamie = new LinkedList<>();

                cameron.add(input.nextInt());
                cameron.add(input.nextInt());
                jamie.add(input.nextInt());
                jamie.add(input.nextInt());
                result.append("CJ");

                boolean isImpossible = false;

                for (int j = 3; j <= activities; j++) {
                    int start = input.nextInt();
                    int finish = input.nextInt();
                    boolean stopCameron = isOverlapping(cameron, start, finish);
                    boolean stopJamie = false;

                    if (!stopCameron) {
                        updateSchedule(cameron, start, finish);
                        result.append("C");
                    } else {
                        stopJamie = isOverlapping(jamie, start, finish);

                        if (!stopJamie) {
                            updateSchedule(jamie, start, finish);
                            result.append("J");
                        } else {
                            isImpossible = true;
                            input.nextLine(); // Skip the remaining input for this case
                            break;
                        }
                    }
                }

                if (isImpossible) {
                    result = new StringBuilder("IMPOSSIBLE");
                }

                System.out.println("Case #" + i + ": " + result);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean isOverlapping(LinkedList<Integer> schedule, int start, int finish) {
        for (int k = 0; k < schedule.size(); k += 2) {
            int s = schedule.get(k);
            int f = schedule.get(k + 1);
            if ((start >= s && start < f) || (finish > s && finish <= f)) {
                return true;
            }
        }
        return false;
    }

    private static void updateSchedule(LinkedList<Integer> schedule, int start, int finish) {
        for (int k = 0; k < schedule.size(); k += 2) {
            int s = schedule.get(k);
            int f = schedule.get(k + 1);
            if (finish == s) {
                schedule.set(k, start);
                return;
            } else if (finish < s) {
                schedule.add(k, start);
                schedule.add(k + 1, finish);
                return;
            } else if (start == f) {
                schedule.set(k + 1, finish);
                return;
            } else if (k + 2 == schedule.size() && start > f) {
                schedule.add(start);
                schedule.add(finish);
                return;
            }
        }
    }
}