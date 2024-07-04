import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        List<Case> cases = new ArrayList<>(testCases);
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            List<Activity> activities = new ArrayList<>(n);
            
            for (int i = 0; i < n; i++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                activities.add(new Activity(startTime, endTime));
            }
            cases.add(new Case(activities));
        }
        scanner.close();

        for (int i = 0; i < cases.size(); i++) {
            String result = solveCase(cases.get(i));
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    static class Case {
        List<Activity> activities;

        Case(List<Activity> activities) {
            this.activities = activities;
        }

        List<Activity> getActivities() {
            return activities;
        }
    }

    static class Activity {
        int startTime;
        int endTime;
        String assignedPerson;

        Activity(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.assignedPerson = "";
        }

        int getStartTime() {
            return startTime;
        }

        int getEndTime() {
            return endTime;
        }

        String getAssignedPerson() {
            return assignedPerson;
        }

        void setAssignedPerson(String assignedPerson) {
            this.assignedPerson = assignedPerson;
        }
    }

    private static String solveCase(Case caseData) {
        List<Activity> activities = caseData.getActivities();
        String[] persons = {"C", "J"};
        String currentPerson = persons[0];

        for (Activity activity : activities) {
            if (!canAssignActivity(activity, activities, currentPerson)) {
                currentPerson = currentPerson.equals("C") ? "J" : "C";
                if (!canAssignActivity(activity, activities, currentPerson)) {
                    return "IMPOSSIBLE";
                }
            }
            activity.setAssignedPerson(currentPerson);
        }
        return activities.stream().map(Activity::getAssignedPerson).collect(Collectors.joining());
    }

    private static boolean canAssignActivity(Activity activity, List<Activity> activities, String person) {
        return activities.stream()
                .filter(a -> a.getAssignedPerson().equals(person))
                .noneMatch(a -> isOverlapping(activity.getStartTime(), activity.getEndTime(), a.getStartTime(), a.getEndTime()));
    }

    private static boolean isOverlapping(int start1, int end1, int start2, int end2) {
        return (start1 < end2 && end1 > start2);
    }
}