import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int len = sc.nextInt();
        for (int i = 0; i < len; i++) {
            int totalActivity = sc.nextInt();
            sc.nextLine();
            int[][] activities = new int[totalActivity][2];
            for (int k = 0; k < totalActivity; k++) {
                String[] inputArr = sc.nextLine().split(" ");
                activities[k][0] = Integer.parseInt(inputArr[0]);
                activities[k][1] = Integer.parseInt(inputArr[1]);
            }
            assignActivities(activities, i);
        }
    }

    private static void assignActivities(int[][] activities, int testcase) {
        StringBuilder result = new StringBuilder();
        Set<Integer> cSet = new HashSet<>();
        Set<Integer> jSet = new HashSet<>();
        
        for (int[] activity : activities) {
            boolean isCSelected = true;
            for (int time = activity[0]; time < activity[1]; time++) {
                if (cSet.contains(time)) {
                    if (jSet.contains(time)) {
                        System.out.println("Case #" + (testcase + 1) + ": IMPOSSIBLE");
                        return;
                    }
                    isCSelected = false;
                }
            }
            for (int time = activity[0]; time < activity[1]; time++) {
                if (isCSelected) {
                    cSet.add(time);
                } else {
                    jSet.add(time);
                }
            }
            result.append(isCSelected ? "C" : "J");
        }
        
        System.out.println("Case #" + (testcase + 1) + ": " + result);
    }
}