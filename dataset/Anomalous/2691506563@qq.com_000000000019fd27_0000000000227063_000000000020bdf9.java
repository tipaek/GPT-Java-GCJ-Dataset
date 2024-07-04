import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        
        for (int testCase = 0; testCase < testCaseCount; testCase++) {
            int activityCount = scanner.nextInt();
            int[][] activities = new int[activityCount][2];
            
            for (int i = 0; i < activityCount; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
            }
            
            ArrayList<Integer> cActivities = new ArrayList<>();
            ArrayList<Integer> jActivities = new ArrayList<>();
            
            for (int i = 0; i < activityCount; i++) {
                if (!jActivities.contains(i)) {
                    cActivities.add(i);
                    for (int k = i + 1; k < activityCount; k++) {
                        if (!jActivities.contains(k)) {
                            if (!(activities[i][0] >= activities[k][1] || activities[i][1] <= activities[k][0])) {
                                jActivities.add(k);
                            }
                        }
                    }
                }
            }
            
            boolean isImpossible = false;
            for (int i = 0; i < jActivities.size() - 1 && !isImpossible; i++) {
                for (int k = i + 1; k < jActivities.size(); k++) {
                    if (!(activities[jActivities.get(i)][0] >= activities[jActivities.get(k)][1] || activities[jActivities.get(i)][1] <= activities[jActivities.get(k)][0])) {
                        isImpossible = true;
                        break;
                    }
                }
            }
            
            if (isImpossible) {
                System.out.println("Case #" + (testCase + 1) + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + (testCase + 1) + ": ");
                for (int i = 0; i < activityCount; i++) {
                    if (cActivities.contains(i)) {
                        System.out.print("C");
                    } else {
                        System.out.print("J");
                    }
                }
                System.out.println();
            }
        }
        
        scanner.close();
    }
}