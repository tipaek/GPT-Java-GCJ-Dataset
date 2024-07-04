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
            
            String result = "";
            boolean possible = true;
            List<Interval> jArray = new ArrayList<Interval>();
            List<Interval> cArray = new ArrayList<Interval>();
            int start=0, end=0;
            
            for(int i=0; i<n; i++) {
                start = intervals[i].start;
                end = intervals[i].end;
                
                if (!addSuccessfully(cArray, start, end) && 
                    !(addSuccessfully(jArray, start, end))) {
                    result = "IMPOSSIBLE";
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                int jIndex=0, cIndex=0;
                
                while(jIndex < jArray.size() && cIndex < cArray.size()) {
                    if (jArray.get(jIndex).start <= cArray.get(cIndex).start) {
                        result += "J";
                        jIndex++;
                    }
                    else {
                        result += "C";
                        cIndex++;
                    }
                }
                
                while(jIndex < jArray.size()) {
                    result += "J";
                    jIndex++;
                } 
                
                while(cIndex < cArray.size()) {
                    result += "C";
                    cIndex++;
                }
            }
            
            System.out.println("Case #" + tc + ": " + result);
        }
    }
    
    public static boolean addSuccessfully(List<Interval> array, int start, int end) {
        if (array.size() == 0 || array.get(array.size()-1).end <= start) {
            array.add(new Interval(start, end));
            return true;
        }
        
        if (array.get(0).start >= end) {
            array.add(0, new Interval(start, end));
            return true;
        }
        
        if (array.size() >= 1) {
            for (int i=0; i<array.size()-1; i++) {
                if (array.get(i).end <= start && array.get(i+1).start >= end) {
                    array.add(i+1, new Interval(start, end));
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public static class Interval {
        public int start; 
        public int end; 
        
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}