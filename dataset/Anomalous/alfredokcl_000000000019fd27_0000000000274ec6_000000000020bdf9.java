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
            scanner.nextLine();  // consume the rest of the line

            System.out.println("Case #" + i + ": " + scheduleActivities(people, scanner, totalActivities));
        }
    }

    private static String scheduleActivities(ArrayList<Person> people, Scanner scanner, int totalActivities) {
        StringBuilder schedule = new StringBuilder();
        for (Person person : people) {
            person.clearActivities();
        }

        for (int i = 0; i < totalActivities; i++) {
            String[] times = scanner.nextLine().trim().split("\\s+");
            int start = Integer.parseInt(times[0]);
            int end = Integer.parseInt(times[1]);

            String assignedPerson = assignActivity(people.get(0), start, end);
            if ("IMPOSSIBLE".equals(assignedPerson)) {
                assignedPerson = assignActivity(people.get(1), start, end);
                if ("IMPOSSIBLE".equals(assignedPerson)) {
                    return "IMPOSSIBLE";
                }
            }
            schedule.append(assignedPerson);
        }
        return schedule.toString();
    }

    private static String assignActivity(Person person, int start, int end) {
        for (HashMap.Entry<Integer, Integer> activity : person.getActivities().entrySet()) {
            int activityStart = activity.getKey();
            int activityEnd = activity.getValue();
            if (!(end <= activityStart || start >= activityEnd)) {
                return "IMPOSSIBLE";
            }
        }
        person.addActivity(start, end);
        return person.getName();
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

        public HashMap<Integer, Integer> getActivities() {
            return activities;
        }

        public void clearActivities() {
            activities.clear();
        }
    }
}