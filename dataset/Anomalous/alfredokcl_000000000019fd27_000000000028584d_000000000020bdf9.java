import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Person personC = new Person("C");
        Person personJ = new Person("J");
        ArrayList<Person> people = new ArrayList<>();
        people.add(personC);
        people.add(personJ);

        int testCases = scanner.nextInt();
        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            int totalActivities = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Case #" + caseNum + ": " + calculateSchedule(caseNum, people, scanner, totalActivities));
        }
    }

    private static String calculateSchedule(int caseNum, ArrayList<Person> people, Scanner scanner, int totalActivities) {
        StringBuilder schedule = new StringBuilder();
        for (Person person : people) {
            person.clearActivities();
        }

        for (int index = 0; index < totalActivities; index++) {
            String[] timeRange = scanner.nextLine().trim().split("\\s+");
            int startTime = Integer.parseInt(timeRange[0]);
            int endTime = Integer.parseInt(timeRange[1]);

            boolean assigned = false;
            for (Person person : people) {
                String result = assignActivity(person, startTime, endTime);
                if (!result.equals("IMPOSSIBLE")) {
                    schedule.append(result);
                    assigned = true;
                    break;
                }
            }
            if (!assigned) {
                return "IMPOSSIBLE";
            }
        }
        return schedule.toString();
    }

    private static String assignActivity(Person person, int start, int end) {
        if (person.getActivities().isEmpty() || isActivityAssignable(person, start, end)) {
            person.addActivity(start, end);
            return person.getName();
        }
        return "IMPOSSIBLE";
    }

    private static boolean isActivityAssignable(Person person, int start, int end) {
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