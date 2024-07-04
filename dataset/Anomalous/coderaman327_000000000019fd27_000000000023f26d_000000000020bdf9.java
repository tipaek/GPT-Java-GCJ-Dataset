import java.util.*;

public class Solution {
    private static class Node implements Comparable<Node> {
        int time;
        int task;

        Node(int time, int task) {
            this.time = time;
            this.task = task;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.time, other.time);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int k = 1; k <= t; k++) {
            int n = sc.nextInt();
            List<Node> start = new ArrayList<>();
            List<Node> end = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                start.add(new Node(sc.nextInt(), i));
                end.add(new Node(sc.nextInt(), i));
            }

            Collections.sort(start);
            Collections.sort(end);

            int counter = 0;
            int i = 0, j = 0;
            char[] ans = new char[n];
            LinkedList<Character> queue = new LinkedList<>(Arrays.asList('C', 'J'));
            boolean isPossible = true;

            while (true) {
                int nextStart = (i < n) ? start.get(i).time : Integer.MAX_VALUE;
                int nextEnd = end.get(j).time;

                if (nextEnd <= nextStart) {
                    counter--;
                    char assigned = ans[end.get(j).task];
                    queue.add(assigned);
                    j++;
                    if (j == n) {
                        break;
                    }
                } else {
                    counter++;
                    if (counter == 3) {
                        isPossible = false;
                        break;
                    }
                    char available = queue.poll();
                    ans[start.get(i).task] = available;
                    i++;
                }
            }

            if (!isPossible) {
                System.out.println("Case #" + k + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + k + ": ");
                System.out.println(new String(ans));
            }
        }

        sc.close();
    }
}