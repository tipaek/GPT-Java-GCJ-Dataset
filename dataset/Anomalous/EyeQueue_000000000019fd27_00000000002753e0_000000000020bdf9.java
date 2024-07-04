import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int numActivities = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            
            for (int i = 0; i < numActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(i, start, end));
            }

            activities.sort(Comparator.comparingInt(a -> a.end));
            int currentC = 0, currentJ = 0;
            boolean isPossible = true;

            for (Activity activity : activities) {
                if (activity.start >= currentC) {
                    currentC = activity.end;
                    activity.setPerson('C');
                } else if (activity.start >= currentJ) {
                    currentJ = activity.end;
                    activity.setPerson('J');
                } else {
                    isPossible = false;
                    break;
                }
            }

            activities.sort(Comparator.comparingInt(a -> a.index));
            StringBuilder result = new StringBuilder();
            for (Activity activity : activities) {
                result.append(activity.person);
            }

            if (isPossible) {
                System.out.println("Case #" + caseNum + ": " + result);
            } else {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
    }

    static class Activity {
        int index, start, end;
        char person;

        Activity(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }

        void setPerson(char person) {
            this.person = person;
        }
    }
}