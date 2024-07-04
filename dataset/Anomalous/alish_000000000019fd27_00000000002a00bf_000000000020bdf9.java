import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParentingPartneringReturns {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();

        for (int i = 1; i <= cases; i++) {
            int activities = input.nextInt();
            StringBuilder result = new StringBuilder();
            List<Integer> cameron = new ArrayList<>();
            List<Integer> jamie = new ArrayList<>();
            
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

                if (!assignActivity(cameron, start, finish, 'C', result)) {
                    stopCameron = true;
                }

                if (stopCameron && !assignActivity(jamie, start, finish, 'J', result)) {
                    stopJamie = true;
                }

                if (stopCameron && stopJamie) {
                    result = new StringBuilder("IMPOSSIBLE");
                    for (int c = j * 2; c < activities * 2; c++) {
                        input.nextInt();
                    }
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static boolean assignActivity(List<Integer> person, int start, int finish, char label, StringBuilder result) {
        for (int k = 0; k < person.size(); k += 2) {
            int startTime = person.get(k);
            int endTime = person.get(k + 1);

            if ((start > startTime && start < endTime) || (finish > startTime && finish < endTime)) {
                return false;
            }

            if (finish == startTime) {
                person.set(k, start);
                result.append(label);
                return true;
            }

            if (finish < startTime) {
                person.add(k, finish);
                person.add(k, start);
                result.append(label);
                return true;
            }

            if (k + 2 == person.size() && start > endTime) {
                person.add(start);
                person.add(finish);
                result.append(label);
                return true;
            }

            if (start == endTime) {
                person.set(k + 1, finish);
                result.append(label);
                return true;
            }
        }

        return false;
    }
}