import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; i++) {
            int numActivities = in.nextInt();
            char[] solutionArray = new char[numActivities];
            int[][] activityMatrix = new int[numActivities][2];
            List<List<Integer>> graph = new ArrayList<>();

            for (int activity = 0; activity < numActivities; activity++) {
                List<Integer> neighbours = new ArrayList<>();
                int start = in.nextInt();
                int end = in.nextInt();
                activityMatrix[activity][0] = start;
                activityMatrix[activity][1] = end;
                for (int otherActivity = 0; otherActivity < activity; otherActivity++) {
                    int otherActivityStart = activityMatrix[otherActivity][0];
                    int otherActivityEnd = activityMatrix[otherActivity][1];
                    if ((start >= otherActivityStart && start < otherActivityEnd) ||
                        (end > otherActivityStart && end <= otherActivityEnd) ||
                        (otherActivityStart >= start && otherActivityStart < end) ||
                        (otherActivityEnd > start && otherActivityEnd <= end)) {
                            neighbours.add(otherActivity);
                        }
                }
                graph.add(neighbours);
            }

            int curr = 0;
            while (curr < numActivities) {
                if (solutionArray[curr] == 0) {
                    List<Integer> stack = new ArrayList<>();
                    stack.add(curr);
                    while (!stack.isEmpty()) {
                        int activity = stack.remove(stack.size() - 1);
                        char value = 0;
                        for (Integer neighbour: graph.get(activity)) {
                            if (solutionArray[neighbour] != 0) {
                                if (value == 0) {
                                    value = solutionArray[neighbour];
                                } else {
                                    if (value != solutionArray[neighbour]) {
                                        curr = numActivities;
                                    }
                                }
                            }
                        }
                        if (value == 0) {
                            solutionArray[activity] = 'C';
                        } else {
                            solutionArray[activity] = value == 'C' ? 'J' : 'C';
                        }
                    }
                }
                curr++;
            }
            String solution = (curr == numActivities ? new String(solutionArray) : "IMPOSSIBLE");
            System.out.println("Case #" + i + ": " + solution);
        }
    }
}
