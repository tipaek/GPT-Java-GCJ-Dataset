import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.IntStream;
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

            for (int j = 0; j < n; j++) {
                int[] line  = lineToInt(in.nextLine(), " ");
                intervals[j] = new Interval(line[0], line[1]);
            }

            String result = null;
            for (int j = 0; j < 1 << n; j++) {
                String check = check(j);
                if(check != null){

                    result = check;
                    break;
                }
            }

            System.out.println( String.format("Case #%d: %s", i, result != null? result : "IMPOSSIBLE"));
        }

    }

    private static String check(int j){
        String s = Integer.toBinaryString(1 << n | j).substring(1, n + 1);
        List<Interval> cam = new ArrayList<>();
        List<Interval> jam = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') cam.add(intervals[i]);
            else jam.add(intervals[i]);
        }

        if(!check(cam)) return null;
        if(!check(jam)) return null;

        String result = s.replaceAll("0", "C").replaceAll("1", "J");
        return result;
    }


    private static boolean check(List<Interval> intervals){
        for (Interval interval : intervals) {
            for (Interval other : intervals) {
                if(interval == other) continue;
                if(interval.isOverlapping(other)) return false;
            }
        }
        return true;
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