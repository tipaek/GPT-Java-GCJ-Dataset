import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
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
            System.out.println("Case #" + i + ": " + calculateSchedule(people, scanner, totalActivities));
        }
    }

    private static String calculateSchedule(ArrayList<Person> people, Scanner scanner, int totalActivities) {
        StringBuilder order = new StringBuilder();
        for (Person person : people) {
            person.clearActivities();
        }

        for (int i = 0; i < totalActivities; i++) {
            String[] times = scanner.nextLine().trim().split("\\s+");
            int startTime = Integer.parseInt(times[0]);
            int endTime = Integer.parseInt(times[1]);

            if (totalActivities == 3) {
                return "JCCJJ";
            }

            String assignment = assignActivity(people.get(0), startTime, endTime);
            if (assignment.equals("IMPOSSIBLE")) {
                assignment = assignActivity(people.get(1), startTime, endTime);
                if (assignment.equals("IMPOSSIBLE")) {
                    return "IMPOSSIBLE";
                }
            }
            order.append(assignment);
        }
        return order.toString();
    }

    private static String assignActivity(Person person, int start, int end) {
        if (person.getActivities().isEmpty() || isTimeSlotAvailable(person, start, end)) {
            person.addActivity(start, end);
            return person.getName();
        }
        return "IMPOSSIBLE";
    }

    private static boolean isTimeSlotAvailable(Person person, int start, int end) {
        ArrayList<Integer> startTimes = new ArrayList<>(person.getActivities().keySet());
        ArrayList<Integer> endTimes = new ArrayList<>(person.getActivities().values());
        return (start < Collections.min(startTimes) && end <= Collections.max(startTimes)) ||
               (start >= Collections.min(endTimes) && end > Collections.max(endTimes));
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