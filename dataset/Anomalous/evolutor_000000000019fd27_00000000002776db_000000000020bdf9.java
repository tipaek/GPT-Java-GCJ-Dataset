import java.util.Scanner;

class Activity {
    int start;
    int end;
    int index;
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 0;

        while (t-- > 0) {
            caseNumber++;
            int n = sc.nextInt();
            Activity[] activities = new Activity[n];

            for (int i = 0; i < n; i++) {
                activities[i] = new Activity();
                activities[i].start = sc.nextInt();
                activities[i].end = sc.nextInt();
                activities[i].index = i;
            }

            Arrays.sort(activities, (a, b) -> Integer.compare(a.start, b.start));

            int freeC = -1;
            int freeJ = -1;
            boolean isPossible = true;
            char[] result = new char[n];

            for (Activity activity : activities) {
                if (freeC <= activity.start) {
                    freeC = activity.end;
                    result[activity.index] = 'C';
                } else if (freeJ <= activity.start) {
                    freeJ = activity.end;
                    result[activity.index] = 'J';
                } else {
                    isPossible = false;
                    break;
                }
            }

            String output = isPossible ? new String(result) : "IMPOSSIBLE";
            System.out.println("Case #" + caseNumber + ": " + output);
        }
    }
}