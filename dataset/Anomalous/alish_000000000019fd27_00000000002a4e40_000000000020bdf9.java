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

                boolean stopCameron, stopJamie;
                for (int j = 3; j <= activities; j++) {
                    stopCameron = stopJamie = false;
                    int start = input.nextInt();
                    int finish = input.nextInt();

                    if (canAssignActivity(cameron, start, finish)) {
                        result.append("C");
                    } else if (canAssignActivity(jamie, start, finish)) {
                        result.append("J");
                    } else {
                        // Skip remaining inputs for this case
                        for (; j < activities; j++) {
                            input.nextInt();
                            input.nextInt();
                        }
                        result = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }

                System.out.println("Case #" + i + ": " + result.toString());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean canAssignActivity(LinkedList<Integer> schedule, int start, int finish) {
        for (int k = 0; k < schedule.size(); k += 2) {
            int scheduledStart = schedule.get(k);
            int scheduledFinish = schedule.get(k + 1);

            if ((start >= scheduledStart && start < scheduledFinish) || (finish > scheduledStart && finish <= scheduledFinish)) {
                return false;
            } else if (finish == scheduledStart) {
                schedule.set(k, start);
                return true;
            } else if (finish < scheduledStart) {
                schedule.add(k, finish);
                schedule.add(k, start);
                return true;
            } else if (start == scheduledFinish) {
                schedule.set(k + 1, finish);
                return true;
            } else if (k + 2 == schedule.size() && start > scheduledFinish) {
                schedule.addLast(start);
                schedule.addLast(finish);
                return true;
            }
        }
        return false;
    }
}