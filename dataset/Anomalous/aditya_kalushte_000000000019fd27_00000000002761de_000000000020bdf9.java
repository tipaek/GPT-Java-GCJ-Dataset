import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testcases = sc.nextInt();
        
        for (int t = 0; t < testcases; t++) {
            int N = sc.nextInt();
            Map<Integer, List<Integer>> activities = new TreeMap<>();
            List<Integer> originalStartTimes = new ArrayList<>();
            
            for (int i = 0; i < N; i++) {
                int startTime = sc.nextInt();
                int endTime = sc.nextInt();
                activities.computeIfAbsent(startTime, k -> new ArrayList<>()).add(endTime);
                originalStartTimes.add(startTime);
            }
            
            int CEndtime = 0;
            int JEndTime = 0;
            boolean impossible = false;
            Map<Integer, List<Character>> assignMap = new TreeMap<>();
            
            outer: for (Map.Entry<Integer, List<Integer>> activity : activities.entrySet()) {
                int actStartTime = activity.getKey();
                List<Integer> actEndTimeList = activity.getValue();
                
                if (actEndTimeList.size() <= 2) {
                    for (int endTime : actEndTimeList) {
                        List<Character> charList = assignMap.computeIfAbsent(actStartTime, k -> new ArrayList<>());
                        
                        if (actStartTime >= CEndtime) {
                            charList.add('C');
                            CEndtime = endTime;
                        } else if (actStartTime >= JEndTime) {
                            charList.add('J');
                            JEndTime = endTime;
                        } else {
                            impossible = true;
                            break outer;
                        }
                    }
                } else {
                    impossible = true;
                    break;
                }
            }
            
            if (impossible) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                StringBuilder outputStr = new StringBuilder();
                for (int startTime : originalStartTimes) {
                    List<Character> person = assignMap.get(startTime);
                    if (person != null && !person.isEmpty()) {
                        outputStr.append(person.remove(0));
                    }
                }
                System.out.println("Case #" + (t + 1) + ": " + outputStr);
            }
        }
        sc.close();
    }
}