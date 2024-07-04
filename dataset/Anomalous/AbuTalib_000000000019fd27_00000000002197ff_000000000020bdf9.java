import java.util.*;
import java.io.*;

public class Solution {
    public static class Node implements Comparable<Node> {
        int time;
        int index;
        boolean isStartTime;

        public Node(int time, boolean isStartTime, int index) {
            this.time = time;
            this.isStartTime = isStartTime;
            this.index = index;
        }

        @Override
        public int compareTo(Node other) {
            if (this.time == other.time) {
                return this.isStartTime ? 1 : -1;
            }
            return Integer.compare(this.time, other.time);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            PriorityQueue<Node> events = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                events.add(new Node(scanner.nextInt(), true, i));
                events.add(new Node(scanner.nextInt(), false, i));
            }

            boolean isPossible = true;
            int activeTasks = 0;
            char[] assignments = new char[n];
            boolean isCameronFree = true;

            while (!events.isEmpty()) {
                Node currentEvent = events.poll();
                if (currentEvent.isStartTime) {
                    activeTasks++;
                    if (activeTasks == 3) {
                        isPossible = false;
                        break;
                    } else if (isCameronFree) {
                        isCameronFree = false;
                        assignments[currentEvent.index] = 'C';
                    } else {
                        assignments[currentEvent.index] = 'J';
                    }
                } else {
                    activeTasks--;
                    if (assignments[currentEvent.index] == 'C') {
                        isCameronFree = true;
                    }
                }
            }

            String result = isPossible ? new String(assignments) : "IMPOSSIBLE";
            System.out.println("Case #" + caseNum + ": " + result);
        }
    }
}