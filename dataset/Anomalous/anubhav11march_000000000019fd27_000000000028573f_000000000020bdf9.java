import java.util.*;

public class Solution {
    static class Activity {
        int startTime, endTime;
        char doer;

        Activity(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.doer = 'N';
        }
    }

    static class Moment {
        boolean cOccupied, jOccupied;

        Moment() {
            this.cOccupied = false;
            this.jOccupied = false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int activitiesCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            Moment[] day = new Moment[1441];

            for (int i = 0; i < 1441; i++) {
                day[i] = new Moment();
            }

            for (int i = 0; i < activitiesCount; i++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                activities.add(new Activity(startTime, endTime));
            }

            boolean possible = true;

            for (Activity activity : activities) {
                int startTime = activity.startTime;
                int endTime = activity.endTime;

                if (isTimeSlotAvailable(day, startTime, endTime, 'C')) {
                    markTimeSlot(day, startTime, endTime, 'C');
                    activity.doer = 'C';
                } else if (isTimeSlotAvailable(day, startTime, endTime, 'J')) {
                    markTimeSlot(day, startTime, endTime, 'J');
                    activity.doer = 'J';
                } else {
                    possible = false;
                    break;
                }
            }

            System.out.print("Case #" + t + ": ");
            if (possible) {
                for (Activity activity : activities) {
                    System.out.print(activity.doer);
                }
                System.out.println();
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    private static boolean isTimeSlotAvailable(Moment[] day, int startTime, int endTime, char doer) {
        for (int i = startTime; i < endTime; i++) {
            if ((doer == 'C' && day[i].cOccupied) || (doer == 'J' && day[i].jOccupied)) {
                return false;
            }
        }
        return true;
    }

    private static void markTimeSlot(Moment[] day, int startTime, int endTime, char doer) {
        for (int i = startTime; i < endTime; i++) {
            if (doer == 'C') {
                day[i].cOccupied = true;
            } else if (doer == 'J') {
                day[i].jOccupied = true;
            }
        }
    }
}