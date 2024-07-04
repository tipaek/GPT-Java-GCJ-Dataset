import java.util.*;

class Activity {
    private final int startTime;
    private final int endTime;
    private char owner;

    Activity(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public char getOwner() {
        return owner;
    }

    public void setOwner(char owner) {
        this.owner = owner;
    }
}

public class Solution {

    private static Scanner scanner = new Scanner(System.in);

    private static Comparator<Activity> startComparator = Comparator.comparingInt(Activity::getStartTime);
    private static Comparator<Activity> endComparator = Comparator.comparingInt(Activity::getEndTime);

    public static void main(String[] args) {
        parentingPartneringReturns();
    }

    private static void parentingPartneringReturns() {
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int t = 1; t <= testCases; t++) {
            int activitiesCount = scanner.nextInt();
            Activity[] activities = new Activity[activitiesCount];

            for (int i = 0; i < activitiesCount; i++) {
                activities[i] = new Activity(scanner.nextInt(), scanner.nextInt());
            }

            Activity[] activitiesByStart = activities.clone();
            Activity[] activitiesByEnd = activities.clone();

            Arrays.sort(activitiesByStart, startComparator);
            Arrays.sort(activitiesByEnd, endComparator);

            Stack<Character> availableOwners = new Stack<>();
            availableOwners.push('C');
            availableOwners.push('J');

            boolean isPossible = true;
            int i = 0, j = 0;

            while (i < activitiesCount) {
                if (activitiesByStart[i].getStartTime() < activitiesByEnd[j].getEndTime()) {
                    if (availableOwners.isEmpty()) {
                        isPossible = false;
                        break;
                    }
                    activitiesByStart[i].setOwner(availableOwners.pop());
                    i++;
                } else {
                    availableOwners.push(activitiesByEnd[j].getOwner());
                    j++;
                }
            }

            System.out.print("Case #" + t + ": ");
            if (isPossible) {
                for (Activity activity : activities) {
                    System.out.print(activity.getOwner());
                }
                System.out.println();
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}