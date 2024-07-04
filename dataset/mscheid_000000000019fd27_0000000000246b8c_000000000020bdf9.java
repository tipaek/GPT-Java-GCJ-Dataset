
import java.util.*;
import java.io.*;
public class Solution {

    static class Interval{
        int start;
        int end;
        public Interval(int _start, int _end){
            start = _start;
            end = _end;
        }
    }

    static class SortByStart implements Comparator<Interval>
    {
        public int compare(Interval intervalOne, Interval intervalTwo)
        {
            return intervalOne.start - intervalTwo.start;
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            ArrayList intervals = new ArrayList<Interval>(n);
            for(int j=0; j<n;j++){
                int start = in.nextInt();
                int end = in.nextInt();
                intervals.add(new Interval(start,end));
            }

            intervals.sort(new SortByStart());
            String order = findNonOverlapOrder(intervals);
            System.out.println("Case #" +i + ": "+order);
        }
    }

    // Input is a list of intervals sorted by start times
    private static String findNonOverlapOrder(ArrayList<Interval> sortedList) {
        StringBuilder order = new StringBuilder();
        /*
        parent array denotes when the parents are free
        parent[0] => C
        parent[1] => J
         */
        int[] parent =  {-1, -1};

        for (Interval interval : sortedList) {
            int start = interval.start;
            int end = interval.end;

            if (parent[0] <= start) {
                parent[0] = end;
                order.append("C");
            } else if (parent[1] <= start) {
                parent[1] = end;
                order.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }
        return order.toString();
    }



}