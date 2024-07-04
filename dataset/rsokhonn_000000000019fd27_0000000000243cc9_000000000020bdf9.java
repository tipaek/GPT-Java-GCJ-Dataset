import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTC = sc.nextInt();
        
        for(int tc=1; tc<=numTC; tc++) {
            int n = sc.nextInt();
            Interval[] intervals = new Interval[n];
            
            for(int i=0; i<n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                Interval interval = new Interval(start, end);
                intervals[i] = interval;
            }
            
            Interval[] sortedIntervals = intervals.clone();
            
            Arrays.sort(sortedIntervals);
            
            String result = "";
            boolean possible = true;
            List<Interval> jArray = new ArrayList<Interval>();
            HashMap<Integer, Integer> jMap = new HashMap<Integer, Integer>();
            List<Interval> cArray = new ArrayList<Interval>();
            HashMap<Integer, Integer> cMap = new HashMap<Integer, Integer>();
            int start=0, end=0;
            
            for(int i=0; i<n; i++) {
                start = sortedIntervals[i].start;
                end = sortedIntervals[i].end;
                
                if (!addSuccessfully(cArray, cMap, start, end) && 
                    !(addSuccessfully(jArray, jMap, start, end))) {
                    result = "IMPOSSIBLE";
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                for (Interval interval : intervals) {
                    if (jMap.containsKey(interval.start) && jMap.get(interval.start) == interval.end)
                        result += "J";
                    else if (cMap.containsKey(interval.start) && cMap.get(interval.start) == interval.end)
                        result += "C";
                }
            }
            
            System.out.println("Case #" + tc + ": " + result);
        }
    }
    
    public static boolean addSuccessfully(List<Interval> array, HashMap<Integer, Integer> map, int start, int end) {
        if (array.size() == 0 || array.get(array.size()-1).end <= start) {
            Interval interval = new Interval(start, end);
            array.add(interval);
            map.put(start, end);
            return true;
        }
        
        if (array.get(0).start >= end) {
            Interval interval = new Interval(start, end);
            array.add(0, interval);
            map.put(start, end);
            return true;
        }
        
        if (array.size() >= 1) {
            for (int i=0; i<array.size()-1; i++) {
                if (array.get(i).end <= start && array.get(i+1).start >= end) {
                    Interval interval = new Interval(start, end);
                    array.add(i+1, interval);
                    map.put(start, end);
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public static class Interval implements Comparable<Interval> {
        public int start; 
        public int end; 
        
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        @Override
        public int compareTo(Interval interval) {
            return this.start - interval.start;
        }
    }
}