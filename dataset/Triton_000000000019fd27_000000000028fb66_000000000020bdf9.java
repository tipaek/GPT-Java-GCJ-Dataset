import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    static class Node {
        private int start;
        private int end;
        private int index;

        public Node(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getIndex() {
            return index;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            Node[] activities = new Node[n];
            for (int j = 0; j < n; ++j) {
                int start = in.nextInt();
                int end = in.nextInt();
                activities[j] = new Node(start, end, j);
            }
            String result = String.format("Case #%d: %s", i, sol.schedule(activities));
            System.out.println(result);
        }
    }

    private String schedule(Node[] activities) {
        Arrays.sort(activities, (a, b) -> a.getEnd() - b.getEnd());
        PriorityQueue<Integer> cHeap = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> jHeap = new PriorityQueue<>((a, b) -> b - a);

        char[] chars = new char[activities.length];
        for (int i = 0; i < activities.length; ++i) {
            Node node = activities[i];
            if (cHeap.isEmpty() || node.getStart() >= cHeap.peek()) {
                chars[node.getIndex()] = 'C';
                cHeap.add(node.getEnd());
            }
            else if (jHeap.isEmpty() || node.getStart() >= jHeap.peek()){
                chars[node.getIndex()] = 'J';
                jHeap.add(node.getEnd());
            }
            else {
                return "IMPOSSIBLE";
            }
        }

        return new String(chars);
    }
}