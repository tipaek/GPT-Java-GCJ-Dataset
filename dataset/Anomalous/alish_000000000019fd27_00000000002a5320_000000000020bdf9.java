import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();

        for (int i = 1; i <= cases; i++) {
            int activities = input.nextInt();
            String result = "CJ";
            LinkedList<Integer> cameron = new LinkedList<>();
            LinkedList<Integer> jamie = new LinkedList<>();

            cameron.add(input.nextInt());
            cameron.add(input.nextInt());
            jamie.add(input.nextInt());
            jamie.add(input.nextInt());

            boolean conflictCameron, conflictJamie;
            for (int j = 3; j <= activities; j++) {
                conflictCameron = conflictJamie = false;
                int start = input.nextInt();
                int finish = input.nextInt();

                if (!assignTask(cameron, start, finish, 'C')) {
                    conflictCameron = true;
                } else {
                    result += "C";
                }

                if (conflictCameron && !assignTask(jamie, start, finish, 'J')) {
                    conflictJamie = true;
                } else if (conflictCameron) {
                    result += "J";
                }

                if (conflictCameron && conflictJamie) {
                    for (int k = j + 1; k <= activities; k++) {
                        input.nextInt(); // skip start
                        input.nextInt(); // skip finish
                    }
                    result = "Case #" + i + ": IMPOSSIBLE";
                    break;
                }
            }

            if (!result.contains("IMPOSSIBLE")) {
                result = "Case #" + i + ": " + result;
            }
            System.out.println(result);
        }
        input.close();
    }

    private static boolean assignTask(LinkedList<Integer> schedule, int start, int finish, char person) {
        for (int k = 0; k < schedule.size(); k += 2) {
            int existingStart = schedule.get(k);
            int existingFinish = schedule.get(k + 1);

            if ((start > existingStart && start < existingFinish) || (finish > existingStart && finish < existingFinish)) {
                return false;
            }
            if (finish == existingStart) {
                schedule.set(k, start);
                return true;
            }
            if (finish < existingStart) {
                schedule.add(k, start);
                schedule.add(k + 1, finish);
                return true;
            }
            if (start == existingFinish) {
                schedule.set(k + 1, finish);
                return true;
            }
            if (k + 2 == schedule.size() && start > existingFinish) {
                schedule.add(start);
                schedule.add(finish);
                return true;
            }
        }
        return false;
    }
}