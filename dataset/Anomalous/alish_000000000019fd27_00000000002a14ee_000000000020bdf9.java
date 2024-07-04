import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int cases = input.nextInt();

            for (int i = 1; i <= cases; i++) {
                int activities = input.nextInt();
                StringBuilder result = new StringBuilder();
                List<int[]> cameron = new ArrayList<>();
                List<int[]> jamie = new ArrayList<>();

                cameron.add(new int[]{input.nextInt(), input.nextInt()});
                jamie.add(new int[]{input.nextInt(), input.nextInt()});
                result.append("CJ");

                boolean conflictCameron, conflictJamie;
                for (int j = 3; j <= activities; j++) {
                    conflictCameron = conflictJamie = false;
                    int start = input.nextInt(), finish = input.nextInt();

                    if (!addActivity(cameron, start, finish)) {
                        conflictCameron = true;
                    } else {
                        result.append("C");
                    }

                    if (conflictCameron && !addActivity(jamie, start, finish)) {
                        conflictJamie = true;
                    } else if (conflictCameron) {
                        result.append("J");
                    }

                    if (conflictCameron && conflictJamie) {
                        result = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }

                System.out.println("Case #" + i + ": " + result);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean addActivity(List<int[]> schedule, int start, int finish) {
        for (int k = 0; k < schedule.size(); k++) {
            int[] activity = schedule.get(k);
            if ((start > activity[0] && start < activity[1]) || (finish > activity[0] && finish < activity[1])) {
                return false;
            } else if (finish == activity[0]) {
                activity[0] = start;
                return true;
            } else if (finish < activity[0]) {
                schedule.add(k, new int[]{start, finish});
                return true;
            } else if (k + 1 == schedule.size() && start > activity[1]) {
                schedule.add(new int[]{start, finish});
                return true;
            } else if (start == activity[1]) {
                activity[1] = finish;
                return true;
            }
        }
        return false;
    }
}