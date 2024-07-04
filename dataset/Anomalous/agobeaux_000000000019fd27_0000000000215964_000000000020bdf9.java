import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    
    private static class Node implements Comparable<Node> {
        int index;
        int time;
        boolean isStart;

        public Node(int index, int time, boolean isStart) {
            this.index = index;
            this.time = time;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Node other) {
            if (this.time == other.time) {
                return Boolean.compare(this.isStart, other.isStart);
            }
            return Integer.compare(this.time, other.time);
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for (int i = 1; i <= T; i++) {
            int N = scanner.nextInt();
            PriorityQueue<Node> events = new PriorityQueue<>(2 * N);
            
            for (int j = 0; j < N; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                events.add(new Node(j, start, true));
                events.add(new Node(j, end, false));
            }
            
            int activeTasks = 0;
            boolean isImpossible = false;
            char[] result = new char[N];
            
            while (!events.isEmpty() && !isImpossible) {
                Node event = events.poll();
                
                if (event.isStart) {
                    activeTasks++;
                    if (activeTasks > 2) {
                        isImpossible = true;
                        break;
                    }
                    result[event.index] = (activeTasks == 1) ? 'C' : 'J';
                } else {
                    activeTasks--;
                }
            }
            
            if (isImpossible) {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", i));
            } else {
                System.out.println(String.format("Case #%d: %s", i, new String(result)));
            }
        }
        
        scanner.close();
    }
}