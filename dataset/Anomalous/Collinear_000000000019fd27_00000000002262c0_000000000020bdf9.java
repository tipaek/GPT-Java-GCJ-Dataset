import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();
        
        for (int x = 0; x < cases; x++) {
            int times = input.nextInt();
            int[][] intervals = new int[times][2];
            Set<Integer> uniqueTimes = new TreeSet<>();
            List<Integer> startTimes = new ArrayList<>();
            List<Integer> endTimes = new ArrayList<>();
            
            for (int i = 0; i < times; i++) {
                intervals[i][0] = input.nextInt();
                intervals[i][1] = input.nextInt();
                uniqueTimes.add(intervals[i][0]);
                uniqueTimes.add(intervals[i][1]);
                startTimes.add(intervals[i][0]);
                endTimes.add(intervals[i][1]);
            }
            
            Collections.sort(startTimes);
            Collections.sort(endTimes);
            
            Map<Integer, Character> assignment = new TreeMap<>();
            Map<Integer, Integer> endToStart = new TreeMap<>();
            
            for (int[] interval : intervals) {
                endToStart.put(interval[1], interval[0]);
            }
            
            boolean isJAvailable = true;
            boolean isCAvailable = true;
            boolean impossible = false;
            StringBuilder ans = new StringBuilder();
            
            for (int time : uniqueTimes) {
                if (endTimes.contains(time)) {
                    int startTime = endToStart.get(time);
                    if (assignment.get(startTime) == 'J') {
                        isJAvailable = true;
                    } else if (assignment.get(startTime) == 'C') {
                        isCAvailable = true;
                    }
                }
                
                if (startTimes.contains(time)) {
                    if (isJAvailable) {
                        isJAvailable = false;
                        assignment.put(time, 'J');
                    } else if (isCAvailable) {
                        isCAvailable = false;
                        assignment.put(time, 'C');
                    } else {
                        ans = new StringBuilder("IMPOSSIBLE");
                        impossible = true;
                        break;
                    }
                }
            }
            
            if (!impossible) {
                for (int[] interval : intervals) {
                    ans.append(assignment.get(interval[0]));
                }
            }
            
            System.out.println("Case #" + (x + 1) + ": " + ans.toString());
        }
        
        input.close();
    }
}