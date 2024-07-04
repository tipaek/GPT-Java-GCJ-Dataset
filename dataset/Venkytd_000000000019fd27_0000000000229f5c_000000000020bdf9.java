import java.util.*;
import java.io.*;

class Solution {
    static class Interval implements Comparable<Interval>{
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Interval o) {
            if(o == null) return -1;
            return start-o.start;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int tests =  in.nextInt();

        for(int test = 1; test <= tests; test++) {
            int activities = in.nextInt();
            List<Interval> intervals = new ArrayList<>();
            LinkedHashMap<Interval, String> l_map = new LinkedHashMap<>();

            for(int i = 0; i < activities; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                Interval interval = new Interval(start, end);
                intervals.add(interval);
                l_map.put(interval, "");
            }

            Collections.sort(intervals);

            Map<String, Integer> map = new HashMap<>();
            map.put("C", 0);
            map.put("J", 0);
            
            boolean isPossible = true;

            for(Interval interval : intervals) {
                if(map.get("C") <= interval.start) {
                    map.put("C", interval.end);
                    l_map.put(interval, "C");
                } else if(map.get("J") <= interval.start){
                    map.put("J", interval.end);
                    l_map.put(interval, "J");
                } else {
                    isPossible = false;
                    System.out.println("Case #" + test + ": IMPOSSIBLE");
                    break;
                }
            }
            
            if(isPossible) {
                StringBuilder _S = new StringBuilder();
                for(Map.Entry<Interval, String> linkedHashMap : l_map.entrySet()) {
                    _S.append(linkedHashMap.getValue());
                }
                System.out.println("Case #" + test + ": " + _S.toString());
            }

        }
    }
}