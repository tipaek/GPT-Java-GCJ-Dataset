import java.io.*;
import java.util.*;

class Pair {
    int start, end;

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        
        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            Pair[] pairs = new Pair[n];
            
            for (int i = 0; i < n; i++) {
                pairs[i] = new Pair(sc.nextInt(), sc.nextInt());
            }

            Pair[] sortedPairs = pairs.clone();
            Arrays.sort(sortedPairs, Comparator.comparingInt(p -> p.end));

            int cameronEnd = 0, jamieEnd = 0;
            Map<Pair, Character> assignment = new HashMap<>();
            boolean isPossible = true;

            for (Pair p : sortedPairs) {
                if (p.start >= cameronEnd) {
                    assignment.put(p, 'C');
                    cameronEnd = p.end;
                } else if (p.start >= jamieEnd) {
                    assignment.put(p, 'J');
                    jamieEnd = p.end;
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (!isPossible) {
                sb.append("Case #").append(t).append(": IMPOSSIBLE\n");
            } else {
                StringBuilder result = new StringBuilder();
                for (Pair p : pairs) {
                    result.append(assignment.get(p));
                }
                sb.append("Case #").append(t).append(": ").append(result).append("\n");
            }
        }
        
        System.out.print(sb.toString());
        sc.close();
    }
}