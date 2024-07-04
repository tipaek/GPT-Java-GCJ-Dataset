import java.util.*;

public class Solution {

    private static class Node {
        public int start, end, index;

        Node(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    private static int[] C, S;
    private static int N;
    private static PriorityQueue<Node> pq;
    private static StringBuilder ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            N = sc.nextInt();
            pq = new PriorityQueue<>(N, Comparator.comparingInt(n -> n.start));
            C = new int[1445];
            S = new int[1445];

            for (int j = 0; j < N; j++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                Node node = new Node(start, end, j);
                pq.add(node);
            }

            Node firstNode = pq.poll();
            for (int k = firstNode.start; k < firstNode.end; k++) {
                C[k] = 1;
            }
            ans = new StringBuilder(N);
            ans.setLength(N);
            ans.setCharAt(firstNode.index, 'C');

            scheduleTasks(2);
            String result = "";
            for (int j = 0; j < ans.length(); j++) {
                if (ans.charAt(j) != '\0') {
                    result += ans.charAt(j);
                }
            }

            if (result.length() != N) {
                result = "IMPOSSIBLE";
            } else {
                StringBuilder solution = new StringBuilder();
                for (int j = 0; j < N; j++) {
                    solution.append(ans.charAt(j));
                }
                result = solution.toString();
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static void scheduleTasks(int i) {
        if (i == N + 1) {
            return;
        }

        Node currentNode = pq.peek();
        int cFree = findFirstFreeTime(C, currentNode.start, currentNode.end);
        int sFree = findFirstFreeTime(S, currentNode.start, currentNode.end);

        if (cFree < currentNode.end && sFree < currentNode.end) {
            return;
        } else if (cFree < currentNode.end) {
            markTimeSlots(S, currentNode.start, currentNode.end, 1);
            ans.setCharAt(currentNode.index, 'J');
            pq.poll();
            scheduleTasks(i + 1);
        } else if (sFree < currentNode.end) {
            markTimeSlots(C, currentNode.start, currentNode.end, 1);
            ans.setCharAt(currentNode.index, 'C');
            pq.poll();
            scheduleTasks(i + 1);
        } else {
            markTimeSlots(C, currentNode.start, currentNode.end, 1);
            ans.setCharAt(currentNode.index, 'C');
            pq.poll();
            scheduleTasks(i + 1);
            pq.add(currentNode);
            markTimeSlots(C, currentNode.start, currentNode.end, 0);
            markTimeSlots(S, currentNode.start, currentNode.end, 1);
            ans.setCharAt(currentNode.index, 'J');
            scheduleTasks(i + 1);
        }
    }

    private static int findFirstFreeTime(int[] array, int start, int end) {
        for (int i = start; i < end; i++) {
            if (array[i] == 1) {
                return i;
            }
        }
        return end;
    }

    private static void markTimeSlots(int[] array, int start, int end, int value) {
        for (int i = start; i < end; i++) {
            array[i] = value;
        }
    }
}