import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int test = 1; test <= T; test++) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<Pair> intervals = new ArrayList<>();
            
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                intervals.add(new Pair(start, end, i));
            }
            
            Collections.sort(intervals, (a, b) -> a.end - b.end);
            
            intervals.get(0).assignee = 'C';
            Pair lastC = intervals.get(0);
            Pair lastJ = new Pair(0, 0, -1);
            
            boolean possible = true;
            
            for (int i = 1; i < N; i++) {
                Pair current = intervals.get(i);
                
                if (current.start >= lastC.end) {
                    current.assignee = 'C';
                    lastC = current;
                } else if (current.start >= lastJ.end) {
                    current.assignee = 'J';
                    lastJ = current;
                } else {
                    System.out.println("Case #" + test + ": IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                Collections.sort(intervals, (a, b) -> a.position - b.position);
                StringBuilder result = new StringBuilder("Case #" + test + ": ");
                
                for (Pair interval : intervals) {
                    result.append(interval.assignee);
                }
                
                System.out.println(result);
            }
        }
    }

    static class Pair {
        int start;
        int end;
        int position;
        char assignee = 'x';
        
        Pair(int start, int end, int position) {
            this.start = start;
            this.end = end;
            this.position = position;
        }
    }
}