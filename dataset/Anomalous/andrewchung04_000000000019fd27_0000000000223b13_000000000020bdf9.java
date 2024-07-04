import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int activities = scanner.nextInt();
            ArrayList<Activity> schedule = new ArrayList<>();

            for (int j = 0; j < activities; j++) {
                schedule.add(new Activity(scanner.nextInt(), 1, j));
                schedule.add(new Activity(scanner.nextInt(), -1, j));
            }

            Collections.sort(schedule);

            int cCount = 0;
            int jCount = 0;
            boolean[] assignedToJ = new boolean[activities];
            boolean isImpossible = false;

            for (Activity current : schedule) {
                if (current.factor == 1) {
                    if (cCount == 0 && jCount == 0) {
                        cCount++;
                    } else if (cCount == 1 && jCount == 0) {
                        assignedToJ[current.index] = true;
                        jCount++;
                    } else if (cCount == 0 && jCount == 1) {
                        cCount++;
                    } else {
                        System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                        isImpossible = true;
                        break;
                    }
                } else {
                    if (assignedToJ[current.index]) {
                        jCount--;
                    } else {
                        cCount--;
                    }
                }
            }

            if (!isImpossible) {
                StringBuilder result = new StringBuilder();
                for (boolean isJ : assignedToJ) {
                    result.append(isJ ? "J" : "C");
                }
                System.out.println("Case #" + (i + 1) + ": " + result);
            }
        }
    }
}

class Activity implements Comparable<Activity> {
    public int time;
    public int factor;
    public int index;

    public Activity(int time, int factor, int index) {
        this.time = time;
        this.factor = factor;
        this.index = index;
    }

    @Override
    public int compareTo(Activity other) {
        if (this.time == other.time) {
            return this.index - other.index;
        }
        return this.time - other.time;
    }
}