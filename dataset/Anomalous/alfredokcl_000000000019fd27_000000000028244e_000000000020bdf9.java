import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("C"));
        people.add(new Person("J"));

        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            int totalActivities = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Case #" + i + ": " + determineSchedule(i, people, scanner, totalActivities));
        }
    }

    private static String determineSchedule(int caseNumber, ArrayList<Person> people, Scanner scanner, int totalActivities) {
        StringBuilder schedule = new StringBuilder();

        for (Person person : people) {
            person.clearActivities();
        }

        for (int i = 0; i < totalActivities; i++) {
            String[] timeRange = scanner.nextLine().trim().split("\\s+");
            int startTime = Integer.parseInt(timeRange[0]);
            int endTime = Integer.parseInt(timeRange[1]);

            String assignment = tryAssigningActivity(people, startTime, endTime);
            if (assignment.equals("IMPOSSIBLE")) {
                return "IMPOSSIBLE";
            } else {
                schedule.append(assignment);
            }
        }
        return schedule.toString();
    }

    private static String tryAssigningActivity(ArrayList<Person> people, int start, int end) {
        for (Person person : people) {
            if (person.canAddActivity(start, end)) {
                person.addActivity(start, end);
                return person.getName();
            }
        }
        return "IMPOSSIBLE";
    }

    static class Person {
        private final String name;
        private final HashMap<Integer, Integer> activities;

        public Person(String name) {
            this.name = name;
            this.activities = new HashMap<>();
        }

        public String getName() {
            return name;
        }

        public void addActivity(int start, int end) {
            activities.put(start, end);
        }

        public void clearActivities() {
            activities.clear();
        }

        public boolean canAddActivity(int start, int end) {
            for (HashMap.Entry<Integer, Integer> entry : activities.entrySet()) {
                int existingStart = entry.getKey();
                int existingEnd = entry.getValue();
                if (!(end <= existingStart || start >= existingEnd)) {
                    return false;
                }
            }
            return true;
        }
    }
}