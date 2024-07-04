import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = Integer.parseInt(scanner.nextLine());
            String[] activities = new String[n];
            
            for (int i = 0; i < n; i++) {
                activities[i] = scanner.nextLine();
            }
            
            System.out.print("Case #" + caseNum + ": ");
            assignActivities(activities, n);
            System.out.println();
        }
    }

    private static void assignActivities(String[] activities, int n) {
        NavigableMap<Integer, Integer> endTimeMapJ = new TreeMap<>();
        NavigableMap<Integer, Integer> endTimeMapC = new TreeMap<>();
        NavigableMap<String, String> assignmentMapJ = new TreeMap<>();
        NavigableMap<String, String> assignmentMapC = new TreeMap<>();
        
        for (int i = 0; i < n; i++) {
            String[] times = activities[i].split(" ");
            int startTime = Integer.parseInt(times[0]);
            int endTime = Integer.parseInt(times[1]);
            endTimeMapJ.put(endTime, startTime);
        }
        
        for (Integer endTime : endTimeMapJ.navigableKeySet()) {
            if (assignmentMapJ.isEmpty()) {
                assignmentMapJ.put(endTimeMapJ.get(endTime) + " " + endTime, "J");
            } else {
                String lastActivity = assignmentMapJ.lastKey();
                if (Integer.parseInt(lastActivity.split(" ")[1]) <= endTimeMapJ.get(endTime)) {
                    assignmentMapJ.put(endTimeMapJ.get(endTime) + " " + endTime, "J");
                } else {
                    endTimeMapC.put(endTime, endTimeMapJ.get(endTime));
                }
            }
        }
        
        for (Integer endTime : endTimeMapC.navigableKeySet()) {
            if (assignmentMapC.isEmpty()) {
                assignmentMapC.put(endTimeMapC.get(endTime) + " " + endTime, "C");
            } else {
                String lastActivity = assignmentMapC.lastKey();
                if (Integer.parseInt(lastActivity.split(" ")[1]) <= endTimeMapC.get(endTime)) {
                    assignmentMapC.put(endTimeMapC.get(endTime) + " " + endTime, "C");
                } else {
                    System.out.print("IMPOSSIBLE");
                    return;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (assignmentMapJ.containsKey(activities[i])) {
                System.out.print(assignmentMapJ.get(activities[i]));
            } else {
                System.out.print(assignmentMapC.get(activities[i]));
            }
        }
    }
}