import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Solution solution = new Solution();
        
        while (scanner.hasNext()) {
            int T = scanner.nextInt();
            
            for (int i = 0; i < T; i++) {
                int N = scanner.nextInt();
                List<Interval> intervals = new ArrayList<>(N);
                
                for (int j = 0; j < N; j++) {
                    intervals.add(solution.new Interval(scanner.nextInt(), scanner.nextInt()));
                }
                
                StringBuilder result = new StringBuilder();
                PriorityQueue<Interval> camQueue = new PriorityQueue<>(Comparator.comparingInt(Interval::getStart));
                PriorityQueue<Interval> jaimeQueue = new PriorityQueue<>(Comparator.comparingInt(Interval::getStart));
                
                boolean isPossible = true;
                
                for (Interval interval : intervals) {
                    if (canTakeTask(camQueue, interval)) {
                        camQueue.add(interval);
                        result.append('C');
                    } else if (canTakeTask(jaimeQueue, interval)) {
                        jaimeQueue.add(interval);
                        result.append('J');
                    } else {
                        result.setLength(0);
                        result.append("IMPOSSIBLE");
                        isPossible = false;
                        break;
                    }
                }
                
                System.out.printf("Case #%d: %s%n", i + 1, result.toString());
            }
        }
        scanner.close();
    }

    private static boolean canTakeTask(PriorityQueue<Interval> pq, Interval interval) {
        if (pq.isEmpty()) return true;
        
        List<Interval> list = new ArrayList<>();
        boolean canAdd = true;
        
        while (!pq.isEmpty()) {
            Interval item = pq.poll();
            list.add(item);
            
            if (isOverlapping(interval, item)) {
                canAdd = false;
                break;
            }
        }
        pq.addAll(list);
        return canAdd;
    }

    private static boolean isOverlapping(Interval a, Interval b) {
        return a.getStart() < b.getEnd() && a.getEnd() > b.getStart();
    }

    class Interval {
        private int start;
        private int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj instanceof Interval) {
                Interval other = (Interval) obj;
                return start == other.start && end == other.end;
            }
            return false;
        }

        @Override
        public String toString() {
            return "[start=" + start + ", end=" + end + "]";
        }
    }
}