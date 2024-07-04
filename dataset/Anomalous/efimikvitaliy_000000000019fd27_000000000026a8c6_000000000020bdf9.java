import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    
    static class Pair {
        int start;
        int end;
        int index;
        
        Pair(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; ++t) {
            int n = scanner.nextInt();
            Pair[] pairs = new Pair[n];
            
            for (int i = 0; i < n; ++i) {
                pairs[i] = new Pair(scanner.nextInt(), scanner.nextInt(), i);
            }
            
            Arrays.sort(pairs, (p1, p2) -> Integer.compare(p1.start, p2.start));
            
            int cameronEnd = 0;
            int jamieEnd = 0;
            
            char[] schedule = new char[n];
            boolean isPossible = true;
            
            for (int i = 0; i < n; ++i) {
                if (cameronEnd <= pairs[i].start) {
                    schedule[pairs[i].index] = 'C';
                    cameronEnd = pairs[i].end;
                } else if (jamieEnd <= pairs[i].start) {
                    schedule[pairs[i].index] = 'J';
                    jamieEnd = pairs[i].end;
                } else {
                    isPossible = false;
                    break;
                }
            }
            
            String result = isPossible ? new String(schedule) : "IMPOSSIBLE";
            System.out.println(String.format("Case #%d: %s", t, result));
        }
        
        scanner.close();
    }
}