import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Solution {


    private static Interval[] intervals;
    private static int n;


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            n = Integer.parseInt(in.nextLine());
            intervals = new Interval[n];
//            Map<Interval, Integer> order = new HashMap<>();

            for (int j = 0; j < n; j++) {
                int[] line  = lineToInt(in.nextLine(), " ");
                intervals[j] = new Interval(line[0], line[1]);
//                order.put(intervals[j], j);
            }





            String result = findIntervalPartitions(intervals);

            System.out.println( String.format("Case #%d: %s", i, result));
        }

    }


        public static String findIntervalPartitions(Interval[] arr){
            List<Interval> intervals = Arrays.asList(Solution.intervals);
            Collections.sort(intervals, Comparator.comparing(p -> p.init));

            Set<Interval> cam = new HashSet<>();

            PriorityQueue<Interval> queue =
                    new PriorityQueue<Interval>(intervals.size(), Comparator.comparing(p -> p.end));

            for(Interval currentInterval : intervals) {
                if (queue.isEmpty()) {
                    queue.add(currentInterval);
                    cam.add(currentInterval);
                }
                else {
                    Interval peek = queue.peek();
                    if (peek.end > currentInterval.init) {
                        queue.add(currentInterval);
                        if(!cam.contains(peek)){
                            cam.add(currentInterval);
                        }
                    } else {
                        queue.remove();
                        queue.add(currentInterval);
                        if(cam.contains(peek)) cam.add(currentInterval);
                    }
                }
            }
            if(queue.size() > 2) return "IMPOSSIBLE";

            return Arrays.stream(arr).map(interval -> cam.contains(interval) ? "C" : "J").collect(Collectors.joining());
        }

    private static class Interval{
        int init;
        int end;

        public Interval(int init, int end) {
            this.init = init;
            this.end = end;
        }



        public boolean isOverlapping(Interval other) {
            return init < (other.end) && other.init < end;
        }
    }

    public static int[] lineToInt(String line, String regex) {
        return Stream.of(line.split(regex)).mapToInt(Integer::parseInt).toArray();
    }
}