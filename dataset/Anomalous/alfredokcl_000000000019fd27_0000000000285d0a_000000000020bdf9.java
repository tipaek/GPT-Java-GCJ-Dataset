import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Person person1 = new Person("C");
        Person person2 = new Person("J");
        ArrayList<Person> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);

        int t = scanner.nextInt();
        for (int i = 1; i <= t; ++i) {
            int totalActivities = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Case #" + i + ": " + processActivities(people, scanner, totalActivities));
        }
    }

    private static String processActivities(ArrayList<Person> people, Scanner scanner, int totalActivities) {
        StringBuilder order = new StringBuilder();
        for (Person person : people) {
            person.clearActivities();
        }

        for (int index = 0; index < totalActivities; index++) {
            String[] time = scanner.nextLine().trim().split("\\s+");
            int startTime = Integer.parseInt(time[0]);
            int endTime = Integer.parseInt(time[1]);

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
        if (person.isAvailable(start, end)) {
            person.addActivity(start, end);
            return person.getName();
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

        public boolean isAvailable(int start, int end) {
            if (activities.isEmpty()) {
                return true;
            }
            ArrayList<Integer> startTimes = new ArrayList<>(activities.keySet());
            ArrayList<Integer> endTimes = new ArrayList<>(activities.values());

            return (start < Collections.min(startTimes) && end <= Collections.max(startTimes)) ||
                   (start >= Collections.min(endTimes) && end > Collections.max(endTimes));
        }
    }
}