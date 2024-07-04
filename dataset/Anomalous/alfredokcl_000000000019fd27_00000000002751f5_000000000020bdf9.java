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
            String result = processActivities(people, scanner, totalActivities);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String processActivities(ArrayList<Person> people, Scanner scanner, int totalActivities) {
        StringBuilder order = new StringBuilder();
        for (Person person : people) {
            person.clearActivities();
        }

        for (int i = 0; i < totalActivities; i++) {
            String[] times = scanner.nextLine().trim().split("\\s+");
            int startTime = Integer.parseInt(times[0]);
            int endTime = Integer.parseInt(times[1]);

            String assigned = assignActivity(people.get(0), startTime, endTime);
            if (assigned.equals("IMPOSSIBLE")) {
                assigned = assignActivity(people.get(1), startTime, endTime);
                if (assigned.equals("IMPOSSIBLE")) {
                    return "IMPOSSIBLE";
                }
            }
            order.append(assigned);
        }
        return order.toString();
    }

    private static String assignActivity(Person person, int start, int end) {
        for (HashMap.Entry<Integer, Integer> entry : person.getActivities().entrySet()) {
            if (!((start < entry.getKey() && end <= entry.getKey()) || (start >= entry.getValue() && end > entry.getValue()))) {
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