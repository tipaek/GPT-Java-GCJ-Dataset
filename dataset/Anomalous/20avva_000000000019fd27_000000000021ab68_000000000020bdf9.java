import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int numActivities = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            
            for (int i = 0; i < numActivities; i++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt()));
            }

            activities.sort((a1, a2) -> {
                if (a1.start != a2.start) {
                    return Integer.compare(a1.start, a2.start);
                } else {
                    return Integer.compare(a1.end, a2.end);
                }
            });

            String order = generateAgenda(activities);
            System.out.println("Case #" + caseNum + ": " + order);
        }
    }

    private static String generateAgenda(List<Activity> activities) {
        StringBuilder order = new StringBuilder();
        Person cameron = new Person();
        Person jaime = new Person();

        for (Activity activity : activities) {
            if (activity.start < cameron.nextAvailability && activity.start < jaime.nextAvailability) {
                return "IMPOSSIBLE";
            } else if (activity.start >= cameron.nextAvailability) {
                order.append("C");
                cameron.nextAvailability = activity.end;
            } else if (activity.start >= jaime.nextAvailability) {
                order.append("J");
                jaime.nextAvailability = activity.end;
            }
        }

        return order.toString();
    }

    private static class Activity {
        int start;
        int end;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static class Person {
        int nextAvailability;

        Person() {
            this.nextAvailability = 0;
        }
    }
}