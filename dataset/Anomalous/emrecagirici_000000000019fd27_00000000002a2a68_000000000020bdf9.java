import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner scan = new Scanner(System.in);
        int totalCases = scan.nextInt();
        
        for (int i = 0; i < totalCases; i++) {
            int intervals = scan.nextInt();
            boolean possible = true;
            Interval[] intervalsArray = new Interval[intervals];
            
            for (int j = 0; j < intervals; j++) {
                int start = scan.nextInt();
                int end = scan.nextInt();
                intervalsArray[j] = sol.new Interval(start, end, j);
            }

            Arrays.sort(intervalsArray, sol.new StartTimeComparator());
            PriorityQueue<Interval> pq = new PriorityQueue<>(sol.new EndTimeComparator());
            List<String> available = new ArrayList<>(Arrays.asList("C", "J"));
            
            for (int j = 0; j < intervals; j++) {
                while (!pq.isEmpty() && pq.peek().end <= intervalsArray[j].start) {
                    Interval finished = pq.poll();
                    available.add(finished.assignedTo);
                }

                if (available.isEmpty()) {
                    possible = false;
                    break;
                }

                intervalsArray[j].assignedTo = available.remove(0);
                pq.offer(intervalsArray[j]);
            }

            if (possible) {
                Arrays.sort(intervalsArray, sol.new OriginalOrderComparator());
                StringBuilder result = new StringBuilder();
                for (Interval interval : intervalsArray) {
                    result.append(interval.assignedTo);
                }
                System.out.println("Case #" + (i + 1) + ": " + result.toString());
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }

    class Interval {
        int start;
        int end;
        String assignedTo;
        int originalIndex;

        public Interval(int start, int end, int originalIndex) {
            this.start = start;
            this.end = end;
            this.originalIndex = originalIndex;
        }
    }

    class StartTimeComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return Integer.compare(a.start, b.start);
        }
    }

    class OriginalOrderComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return Integer.compare(a.originalIndex, b.originalIndex);
        }
    }

    class EndTimeComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return Integer.compare(a.end, b.end);
        }
    }
}