import java.io.*;
import java.util.*;

class Solution {

    public static class Node implements Comparable<Node> {
        int start;
        int end;
        int index;

        Node(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Node other) {
            return this.start - other.start;
        }
    }

    public static void getAnswer(Node[] activities, int caseNumber) {
        int cEnd = 0;
        int jEnd = 0;
        char[] schedule = new char[activities.length];
        StringBuilder result = new StringBuilder();

        // Assign the first activity to C
        schedule[activities[0].index] = 'C';
        cEnd = activities[0].end;

        for (int i = 1; i < activities.length; i++) {
            if (activities[i].start >= cEnd) {
                // Assign to C
                cEnd = activities[i].end;
                schedule[activities[i].index] = 'C';
            } else if (activities[i].start >= jEnd) {
                // Assign to J
                jEnd = activities[i].end;
                schedule[activities[i].index] = 'J';
            } else {
                // Impossible to schedule
                result.append("IMPOSSIBLE");
                break;
            }
        }

        if (result.length() == 0) {
            for (char c : schedule) {
                result.append(c);
            }
        }

        System.out.println("Case #" + caseNumber + ": " + result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            Node[] activities = new Node[n];

            for (int j = 0; j < n; j++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                activities[j] = new Node(start, end, j);
            }

            Arrays.sort(activities);
            getAnswer(activities, i);
        }
    }
}