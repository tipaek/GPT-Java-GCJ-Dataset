import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    static final int MOD = 1000000007;
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    static class Wrapper {
        int start;
        int end;
        int index;
        
        Wrapper(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Wrapper wrapper = (Wrapper) o;
            return start == wrapper.start && end == wrapper.end && index == wrapper.index;
        }
        
        @Override
        public int hashCode() {
            return 31 * start + 31 * end + index;
        }
    }
    
    public static void main(String[] args) throws IOException {
        int testCaseCount = Integer.parseInt(in.readLine());
        for (int i = 1; i <= testCaseCount; i++) {
            int n = Integer.parseInt(in.readLine());
            int[][] intervals = new int[n][2];
            List<Wrapper> cList = new ArrayList<>();
            List<Wrapper> jList = new ArrayList<>();
            List<Wrapper> wList = new ArrayList<>();
            Map<Wrapper, Character> map = new HashMap<>();
            StringBuilder resultBuilder = new StringBuilder();
            
            for (int j = 0; j < n; j++) {
                String[] input = in.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                intervals[j][0] = start;
                intervals[j][1] = end;
                wList.add(new Wrapper(start, end, j));
            }
            
            wList.sort(Comparator.comparingInt((Wrapper w) -> w.start).thenComparingInt(w -> w.end));
            
            for (Wrapper w : wList) {
                if (isAllowed(cList, w.start, w.end)) {
                    cList.add(new Wrapper(w.start, w.end, w.index));
                    map.put(w, 'C');
                } else if (isAllowed(jList, w.start, w.end)) {
                    jList.add(new Wrapper(w.start, w.end, w.index));
                    map.put(w, 'J');
                } else {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                    continue;
                }
            }
            
            for (int j = 0; j < n; j++) {
                Wrapper w = new Wrapper(intervals[j][0], intervals[j][1], j);
                resultBuilder.append(map.get(w));
            }
            
            System.out.println("Case #" + i + ": " + resultBuilder.toString());
        }
        in.close();
    }

    private static boolean isAllowed(List<Wrapper> data, int start, int end) {
        for (Wrapper w : data) {
            if (w.end > start && w.start < end) {
                return false;
            }
        }
        return true;
    }
}