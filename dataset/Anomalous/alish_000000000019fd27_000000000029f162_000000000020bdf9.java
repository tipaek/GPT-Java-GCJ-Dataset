import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();

        for (int i = 1; i <= cases; i++) {
            int activities = input.nextInt();
            String result = "";
            LinkedList<Integer> cameron = new LinkedList<>();
            LinkedList<Integer> jamie = new LinkedList<>();

            cameron.add(input.nextInt());
            cameron.add(input.nextInt());
            jamie.add(input.nextInt());
            jamie.add(input.nextInt());
            result += "CJ";

            boolean stopCameron, stopJamie;
            for (int j = 3; j <= activities; j++) {
                stopCameron = stopJamie = false;
                int start = input.nextInt(), finish = input.nextInt();

                if (!assignTask(cameron, start, finish, 'C')) {
                    stopCameron = true;
                } else {
                    result += 'C';
                }

                if (stopCameron) {
                    if (!assignTask(jamie, start, finish, 'J')) {
                        stopJamie = true;
                    } else {
                        result += 'J';
                    }
                }

                if (stopCameron && stopJamie) {
                    result = "IMPOSSIBLE";
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static boolean assignTask(LinkedList<Integer> schedule, int start, int finish, char person) {
        for (int k = 0; k < schedule.size(); k += 2) {
            if ((start > schedule.get(k) && start < schedule.get(k + 1)) || 
                (finish > schedule.get(k) && finish < schedule.get(k + 1))) {
                return false;
            } else if (finish == schedule.get(k)) {
                schedule.set(k, start);
                return true;
            } else if (finish < schedule.get(k)) {
                schedule.add(k, finish);
                schedule.add(k, start);
                return true;
            } else if (start == schedule.get(k + 1)) {
                schedule.set(k + 1, finish);
                return true;
            } else if (k + 2 == schedule.size() && start > schedule.get(k + 1)) {
                schedule.addLast(start);
                schedule.addLast(finish);
                return true;
            }
        }
        return true;
    }
}