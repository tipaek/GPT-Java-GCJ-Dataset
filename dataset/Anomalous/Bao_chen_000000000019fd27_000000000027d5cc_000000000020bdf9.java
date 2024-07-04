import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int activityCount = scanner.nextInt();
            int[][] activities = new int[activityCount][2];
            
            for (int i = 0; i < activityCount; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
            }
            
            solve(activities, testCase);
        }
        
        scanner.close();
    }
    
    private static boolean canAssignToC(int[] activity, int start, int end) {
        if (cSchedule.isEmpty()) {
            cSchedule.add(activity);
            return true;
        } 
        
        if (cSchedule.size() == 1) {
            int[] existingActivity = cSchedule.get(0);
            if (start >= existingActivity[1] || end <= existingActivity[0]) {
                cSchedule.add(0, activity);
                return true;
            }
            return false;
        }
        
        if (cSchedule.get(0)[0] >= end) {
            cSchedule.add(0, activity);
            return true;
        }
        
        if (cSchedule.get(cSchedule.size() - 1)[1] <= start) {
            cSchedule.add(activity);
            return true;
        }
        
        for (int i = 0; i < cSchedule.size(); i++) {
            int right = cSchedule.get(i)[1];
            if (start >= right && (i == cSchedule.size() - 1 || cSchedule.get(i + 1)[0] >= end)) {
                cSchedule.add(i + 1, activity);
                return true;
            }
        }
        
        return false;
    }

    private static boolean canAssignToJ(int[] activity, int start, int end) {
        if (jSchedule.isEmpty()) {
            jSchedule.add(activity);
            return true;
        } 
        
        if (jSchedule.size() == 1) {
            int[] existingActivity = jSchedule.get(0);
            if (start >= existingActivity[1] || end <= existingActivity[0]) {
                jSchedule.add(0, activity);
                return true;
            }
            return false;
        }
        
        if (jSchedule.get(0)[0] >= end) {
            jSchedule.add(0, activity);
            return true;
        }
        
        if (jSchedule.get(jSchedule.size() - 1)[1] <= start) {
            jSchedule.add(activity);
            return true;
        }
        
        for (int i = 0; i < jSchedule.size(); i++) {
            int right = jSchedule.get(i)[1];
            if (start >= right && (i == jSchedule.size() - 1 || jSchedule.get(i + 1)[0] >= end)) {
                jSchedule.add(i + 1, activity);
                return true;
            }
        }
        
        return false;
    }

    static List<int[]> jSchedule = new ArrayList<>();
    static List<int[]> cSchedule = new ArrayList<>();

    private static void solve(int[][] activities, int caseNumber) {
        jSchedule.clear();
        cSchedule.clear();
        StringBuilder result = new StringBuilder();
        
        for (int[] activity : activities) {
            int start = activity[0];
            int end = activity[1];
            
            if (canAssignToJ(activity, start, end)) {
                result.append("J");
            } else if (canAssignToC(activity, start, end)) {
                result.append("C");
            } else {
                result.setLength(0);
                result.append("IMPOSSIBLE");
                break;
            }
        }
        
        System.out.println("Case #" + caseNumber + ": " + result.toString());
    }
}