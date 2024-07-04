import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;
        while (testCases > 0) {
            int activities = scanner.nextInt();
            ArrayList<Activity> activityList = new ArrayList<>();
            for (int i = 0; i < activities; i++) {
                activityList.add(new Activity(scanner.nextInt(), scanner.nextInt(), i));
            }
            assignActivities(activities, activityList, caseNumber);
            testCases--;
            caseNumber++;
        }
    }

    static void assignActivities(int activityCount, ArrayList<Activity> activities, int caseNumber) {
        Collections.sort(activities, new Comparator<Activity>() {
            @Override
            public int compare(Activity a1, Activity a2) {
                if (a1.start != a2.start) {
                    return Integer.compare(a1.start, a2.start);
                } else {
                    return Integer.compare(a1.end, a2.end);
                }
            }
        });

        HashMap<Character, Integer> scheduleMap = new HashMap<>();
        ArrayList<Assignment> assignments = new ArrayList<>();
        assignments.add(new Assignment('J', activities.get(0).index));
        scheduleMap.put('J', activities.get(0).end);

        for (int i = 1; i < activities.size(); i++) {
            Activity current = activities.get(i);
            if (scheduleMap.get('J') <= current.start) {
                scheduleMap.put('J', current.end);
                assignments.add(new Assignment('J', current.index));
            } else if (!scheduleMap.containsKey('C') || scheduleMap.get('C') <= current.start) {
                scheduleMap.put('C', current.end);
                assignments.add(new Assignment('C', current.index));
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                return;
            }
        }

        Collections.sort(assignments, new Comparator<Assignment>() {
            @Override
            public int compare(Assignment a1, Assignment a2) {
                return Integer.compare(a1.index, a2.index);
            }
        });

        StringBuilder result = new StringBuilder();
        for (Assignment assignment : assignments) {
            result.append(assignment.assignedTo);
        }
        System.out.println("Case #" + caseNumber + ": " + result);
    }
}

class Activity {
    int start, end, index;

    Activity(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}

class Assignment {
    char assignedTo;
    int index;

    Assignment(char assignedTo, int index) {
        this.assignedTo = assignedTo;
        this.index = index;
    }
}