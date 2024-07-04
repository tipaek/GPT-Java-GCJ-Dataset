import java.util.*;

class Solution {

    private static class Node {
        public int start, end;

        Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int N = sc.nextInt();
            PriorityQueue<Node> pq = new PriorityQueue<>(N, Comparator.comparingInt(n -> n.start));
            int[] C = new int[1445];
            int[] J = new int[1445];

            for (int j = 0; j < N; j++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                pq.add(new Node(start, end));
            }

            StringBuilder ans = new StringBuilder();

            while (!pq.isEmpty()) {
                Node n = pq.poll();
                boolean cFree = isFree(C, n.start, n.end);
                boolean jFree = isFree(J, n.start, n.end);

                if (!cFree && !jFree) {
                    ans = new StringBuilder("IMPOSSIBLE");
                    break;
                } else if (cFree) {
                    markBusy(C, n.start, n.end);
                    ans.append('C');
                } else {
                    markBusy(J, n.start, n.end);
                    ans.append('J');
                }
            }

            System.out.println("Case #" + i + ": " + ans);
        }
    }

    private static boolean isFree(int[] schedule, int start, int end) {
        for (int k = start; k < end; k++) {
            if (schedule[k] == 1) {
                return false;
            }
        }
        return true;
    }

    private static void markBusy(int[] schedule, int start, int end) {
        for (int k = start; k < end; k++) {
            schedule[k] = 1;
        }
    }
}