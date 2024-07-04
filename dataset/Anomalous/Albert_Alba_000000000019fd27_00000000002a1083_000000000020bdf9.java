import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();
        for (int i = 0; i < testCases; i++) {
            int activitiesCount = sc.nextInt();
            int[][] activities = new int[activitiesCount][2];
            char[] result = new char[activitiesCount];
            boolean isImpossible = false;

            for (int j = 0; j < activitiesCount; j++) {
                activities[j][0] = sc.nextInt();
                activities[j][1] = sc.nextInt();
            }

            int[][] sortedActivities = activities.clone();
            Arrays.sort(sortedActivities, Comparator.comparingInt(a -> a[0]));

            Map<int[], Integer> activityIndexMap = new HashMap<>();
            for (int j = 0; j < activitiesCount; j++) {
                activityIndexMap.put(activities[j], j);
            }

            Stack<int[]> jStack = new Stack<>();
            Stack<int[]> cStack = new Stack<>();
            char currentPerson = 'J';

            for (int j = 0; j < activitiesCount; j++) {
                int[] currentActivity = sortedActivities[j];
                result[activityIndexMap.get(currentActivity)] = currentPerson;

                if (j < activitiesCount - 1 && doesOverlap(currentActivity, sortedActivities[j + 1])) {
                    if (currentPerson == 'J') {
                        jStack.push(currentActivity);
                        currentPerson = switchPerson(currentPerson);

                        if (!cStack.isEmpty() && doesOverlap(cStack.peek(), sortedActivities[j + 1])) {
                            isImpossible = true;
                            break;
                        }
                    } else {
                        cStack.push(currentActivity);
                        currentPerson = switchPerson(currentPerson);

                        if (!jStack.isEmpty() && doesOverlap(jStack.peek(), sortedActivities[j + 1])) {
                            isImpossible = true;
                            break;
                        }
                    }
                } else {
                    if (currentPerson == 'J') {
                        jStack.push(currentActivity);
                    } else {
                        cStack.push(currentActivity);
                    }
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + (isImpossible ? "IMPOSSIBLE" : new String(result)));
        }
    }

    private static char switchPerson(char currentPerson) {
        return currentPerson == 'J' ? 'C' : 'J';
    }

    private static boolean doesOverlap(int[] activity1, int[] activity2) {
        return activity1[1] > activity2[0];
    }
}