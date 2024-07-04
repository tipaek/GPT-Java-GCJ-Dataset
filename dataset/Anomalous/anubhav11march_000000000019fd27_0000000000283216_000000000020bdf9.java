import java.util.*;

public class Solution {
    static class Activity {
        int startTime = -1, endTime = -1;
        char assignedTo = 'N';

        Activity(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    static class Moment {
        int cOccupancy, jOccupancy;

        Moment() {
            this.cOccupancy = 0;
            this.jOccupancy = 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int activitiesCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            Moment[] schedule = new Moment[1441];

            for (int i = 0; i < 1441; i++) {
                schedule[i] = new Moment();
            }

            for (int i = 0; i < activitiesCount; i++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                activities.add(new Activity(startTime, endTime));
            }

            boolean isPossible = true;

            for (Activity activity : activities) {
                int start = activity.startTime;
                int end = activity.endTime;

                if (isAvailable(schedule, start, end, 'C')) {
                    assignTime(schedule, start, end, 'C');
                    activity.assignedTo = 'C';
                } else if (isAvailable(schedule, start, end, 'J')) {
                    assignTime(schedule, start, end, 'J');
                    activity.assignedTo = 'J';
                } else {
                    isPossible = false;
                    break;
                }
            }

            System.out.print("Case #" + (t + 1) + ": ");
            if (isPossible) {
                for (Activity activity : activities) {
                    System.out.print(activity.assignedTo);
                }
                System.out.println();
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    private static boolean isAvailable(Moment[] schedule, int start, int end, char person) {
        for (int i = start; i < end; i++) {
            if (person == 'C' && schedule[i].cOccupancy == 1) {
                return false;
            }
            if (person == 'J' && schedule[i].jOccupancy == 1) {
                return false;
            }
        }
        return true;
    }

    private static void assignTime(Moment[] schedule, int start, int end, char person) {
        for (int i = start; i < end; i++) {
            if (person == 'C') {
                schedule[i].cOccupancy = 1;
            } else if (person == 'J') {
                schedule[i].jOccupancy = 1;
            }
        }
    }
}