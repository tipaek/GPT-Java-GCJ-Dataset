import java.util.*;

class Solution {

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
    private static StringBuilder answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            N = sc.nextInt();
            pq = new PriorityQueue<>(N, Comparator.comparingInt(n -> n.start));
            C = new int[1440];
            S = new int[1440];

            for (int j = 0; j < N; j++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                pq.add(new Node(start, end, j));
            }

            Node firstNode = pq.poll();
            for (int k = firstNode.start; k < firstNode.end; k++) {
                C[k] = 1;
            }
            answer = new StringBuilder(N);
            for (int j = 0; j < N; j++) {
                answer.append('\0');
            }
            answer.setCharAt(firstNode.index, 'C');

            binarySearch(2);

            String result = "";
            for (int j = 0; j < answer.length(); j++) {
                if (answer.charAt(j) != '\0') {
                    result += answer.charAt(j);
                }
            }

            if (result.length() != N) {
                result = "IMPOSSIBLE";
            } else {
                result = answer.toString();
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static void binarySearch(int i) {
        if (i == N + 1) return;

        Node currentNode = pq.poll();
        int cFree = findFreeTimeSlot(C, currentNode.start, currentNode.end);
        int sFree = findFreeTimeSlot(S, currentNode.start, currentNode.end);

        if (cFree < currentNode.end && sFree < currentNode.end) {
            pq.add(currentNode);
            return;
        } else if (cFree < currentNode.end) {
            markTimeSlot(S, currentNode.start, currentNode.end, 1);
            answer.setCharAt(currentNode.index, 'J');
            binarySearch(i + 1);
        } else if (sFree < currentNode.end) {
            markTimeSlot(C, currentNode.start, currentNode.end, 1);
            answer.setCharAt(currentNode.index, 'C');
            binarySearch(i + 1);
        } else {
            markTimeSlot(C, currentNode.start, currentNode.end, 1);
            answer.setCharAt(currentNode.index, 'C');
            binarySearch(i + 1);
            markTimeSlot(C, currentNode.start, currentNode.end, 0);
            markTimeSlot(S, currentNode.start, currentNode.end, 1);
            answer.setCharAt(currentNode.index, 'J');
            binarySearch(i + 1);
        }
    }

    private static int findFreeTimeSlot(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] == 1) return i;
        }
        return end;
    }

    private static void markTimeSlot(int[] schedule, int start, int end, int value) {
        for (int i = start; i < end; i++) {
            schedule[i] = value;
        }
    }
}