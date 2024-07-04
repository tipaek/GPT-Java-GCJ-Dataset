import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int caseNumber = 1;

        while (T-- > 0) {
            int N = scanner.nextInt();
            ArrayList<Pair> activities = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                activities.add(new Pair(scanner.nextInt(), scanner.nextInt(), i));
            }

            processActivities(N, activities, caseNumber);
            caseNumber++;
        }
    }

    private static void processActivities(int N, ArrayList<Pair> activities, int caseNumber) {
        Collections.sort(activities, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.start != o2.start) {
                    return Integer.compare(o1.start, o2.start);
                }
                return Integer.compare(o1.end, o2.end);
            }
        });

        HashMap<Character, Integer> schedule = new HashMap<>();
        ArrayList<Assignment> assignments = new ArrayList<>();

        schedule.put('J', activities.get(0).end);
        assignments.add(new Assignment('J', activities.get(0).index));

        for (int i = 1; i < activities.size(); i++) {
            Pair currentActivity = activities.get(i);

            if (schedule.get('J') <= currentActivity.start) {
                schedule.put('J', currentActivity.end);
                assignments.add(new Assignment('J', currentActivity.index));
            } else if (!schedule.containsKey('C') || schedule.get('C') <= currentActivity.start) {
                schedule.put('C', currentActivity.end);
                assignments.add(new Assignment('C', currentActivity.index));
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                return;
            }
        }

        Collections.sort(assignments, new Comparator<Assignment>() {
            @Override
            public int compare(Assignment o1, Assignment o2) {
                return Integer.compare(o1.index, o2.index);
            }
        });

        StringBuilder result = new StringBuilder();
        for (Assignment assignment : assignments) {
            result.append(assignment.worker);
        }

        System.out.println("Case #" + caseNumber + ": " + result.toString());
    }

    static class Pair {
        int start, end, index;

        Pair(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    static class Assignment {
        char worker;
        int index;

        Assignment(char worker, int index) {
            this.worker = worker;
            this.index = index;
        }
    }
}