import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

    public static String findSchedule(TreeMap<Integer, ArrayList<Integer>> scheduleMap) {
        StringBuilder result = new StringBuilder();

        boolean isFirst = true;
        PriorityQueue<Integer> cameronQueue = new PriorityQueue<>();
        PriorityQueue<Integer> jamieQueue = new PriorityQueue<>();

        for (Entry<Integer, ArrayList<Integer>> entry : scheduleMap.entrySet()) {
            ArrayList<Integer> endTimes = entry.getValue();

            if (endTimes.size() > 2)
                return "IMPOSSIBLE";

            if (isFirst) {
                isFirst = false;
                cameronQueue.add(endTimes.get(0));
                result.append("C");

                if (endTimes.size() == 2) {
                    jamieQueue.add(endTimes.get(1));
                    result.append("J");
                }

                continue;
            }

            int startTime = entry.getKey();

            for (int endTime : endTimes) {
                if ((!cameronQueue.isEmpty() && startTime < cameronQueue.peek()) &&
                    (!jamieQueue.isEmpty() && startTime < jamieQueue.peek())) {
                    return "IMPOSSIBLE";
                }

                if (cameronQueue.isEmpty() || startTime >= cameronQueue.peek()) {
                    cameronQueue.poll();
                    result.append("C");
                    cameronQueue.offer(endTime);
                } else if (jamieQueue.isEmpty() || startTime >= jamieQueue.peek()) {
                    jamieQueue.poll();
                    result.append("J");
                    jamieQueue.offer(endTime);
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            TreeMap<Integer, ArrayList<Integer>> scheduleMap = new TreeMap<>();
            int n = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < n; ++i) {
                String[] timeRange = scanner.nextLine().split(" ");
                int startTime = Integer.parseInt(timeRange[0]);
                int endTime = Integer.parseInt(timeRange[1]);

                scheduleMap.computeIfAbsent(startTime, k -> new ArrayList<>()).add(endTime);
            }

            System.out.println("Case #" + caseNumber++ + ": " + findSchedule(scheduleMap));
        }
    }
}