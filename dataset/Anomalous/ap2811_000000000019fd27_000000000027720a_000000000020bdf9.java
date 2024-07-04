import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int o = 1; o <= t; o++) {
            int n = sc.nextInt();
            Interval[] intervals = new Interval[n];
            
            for (int i = 0; i < n; i++) {
                intervals[i] = new Interval(sc.nextInt(), sc.nextInt(), i);
            }
            
            Arrays.sort(intervals, (a, b) -> a.end - b.end);
            
            char[] result = new char[n];
            Arrays.fill(result, 'x');
            
            int cEnd = 0, jEnd = 0;
            boolean isPossible = true;
            
            for (Interval interval : intervals) {
                if (interval.start >= cEnd) {
                    result[interval.index] = 'C';
                    cEnd = interval.end;
                } else if (interval.start >= jEnd) {
                    result[interval.index] = 'J';
                    jEnd = interval.end;
                } else {
                    isPossible = false;
                    break;
                }
            }
            
            StringBuilder output = new StringBuilder("Case #").append(o).append(": ");
            if (isPossible) {
                for (char ch : result) {
                    output.append(ch);
                }
            } else {
                output.append("IMPOSSIBLE");
            }
            
            System.out.println(output);
        }
        
        sc.close();
    }
}

class Interval {
    int start, end, index;
    
    Interval(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}