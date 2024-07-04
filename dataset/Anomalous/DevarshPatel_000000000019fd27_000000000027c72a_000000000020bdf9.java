import java.util.ArrayList;
import java.util.Scanner;

class Cameron {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        ArrayList<String> results = new ArrayList<>();
        
        for (int i = 0; i < numberOfCases; i++) {
            int numberOfActivities = scanner.nextInt();
            int[][] activities = new int[numberOfActivities][2];
            
            for (int j = 0; j < numberOfActivities; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
            }
            
            results.add(new ActivityScheduler().schedule(activities, numberOfActivities));
        }
        
        int caseNumber = 1;
        for (String result : results) {
            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }
    }
}

class ActivityScheduler {
    public String schedule(int[][] activities, int numberOfActivities) {
        StringBuilder result = new StringBuilder();
        int cameronEndTime = 0;
        int jamieEndTime = 0;
        
        for (int[] activity : activities) {
            if (activity[0] >= cameronEndTime) {
                result.append("C");
                cameronEndTime = activity[1];
            } else if (activity[0] >= jamieEndTime) {
                result.append("J");
                jamieEndTime = activity[1];
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return result.toString();
    }
}