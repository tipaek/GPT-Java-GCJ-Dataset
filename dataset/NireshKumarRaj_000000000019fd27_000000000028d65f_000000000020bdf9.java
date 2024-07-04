import java.util.*;

public class Solution {

    int start, end;
    int ind;
    String person;
    public Solution(int start, int end, int ind){
        this.start = start;
        this.end = end;
        this.ind = ind;
    }

    public static void main(String[] args) {
        activitiesProblem();
    }

    private static void activitiesProblem() {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int eachTestCase = 1; eachTestCase <= t; eachTestCase++) {
            int n = scan.nextInt();
            List<Solution> activitiesTimingsList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int start = scan.nextInt();
                int end = scan.nextInt();
                activitiesTimingsList.add(new Solution(start, end, i));
            }
            System.out.println(processActivities(eachTestCase, activitiesTimingsList));
        }
        scan.close();
    }

    private static String processActivities(int testCase, List<Solution> activitiesTimingsList) {
        Comparator<Solution> timingsComparator = (activity1, activity2) -> {
            if (activity1.start < activity2.start){
                return -1;
            } else if (activity1.start > activity2.start){
                return 1;
            } else {
                return Integer.compare(activity1.end, activity2.end);
            }
        };
        activitiesTimingsList.sort(timingsComparator);
        StringBuilder result = new StringBuilder();
        boolean flag = allotActivities(activitiesTimingsList);
        if (!flag){
            result.append("IMPOSSIBLE");
        } else {
            Comparator<Solution> indComparator = Comparator.comparingInt(activity -> activity.ind);
            activitiesTimingsList.sort(indComparator);

            for (Solution solution : activitiesTimingsList) {
                result.append(solution.person);
            }
        }
        return String.format("Case #%d: %s", testCase, result.toString());
    }

    private static boolean allotActivities(List<Solution> activitiesTimingsList) {
        String currPerson = "J";
        Solution currCActivity = null;
        Solution prevActivity = activitiesTimingsList.get(0);
        prevActivity.person = currPerson;
        Solution currJActivity = prevActivity;
        for (int i = 1; i < activitiesTimingsList.size(); i++) {
            int preEnd = prevActivity.end;
            Solution currentActivity = activitiesTimingsList.get(i);
            int currStart = currentActivity.start;
            if (currStart < preEnd) {
                if (currPerson.equals("J")){
                    if (currCActivity != null) {
                        int currCEnd = currCActivity.end;
                        if (currCEnd > currStart) {
                            return false;
                        }
                    }
                    currCActivity = currentActivity;
                    currPerson = "C";
                } else {
                    int currJEnd = currJActivity.end;
                    if (currJEnd > currStart) {
                        return false;
                    }
                    currJActivity = currentActivity;
                    currPerson = "J";
                }
            }
            currentActivity.person = currPerson;
            prevActivity = currentActivity;
        }
        return true;
    }
}
