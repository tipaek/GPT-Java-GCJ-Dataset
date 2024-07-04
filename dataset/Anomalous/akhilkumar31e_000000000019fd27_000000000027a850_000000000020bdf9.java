import java.util.*;
import java.io.*;

class Pair {
    int start;
    int end;
    int idx;

    Pair(int start, int end, int idx) {
        this.start = start;
        this.end = end;
        this.idx = idx;
    }
}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(br.readLine());
            List<Pair> intervals = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                intervals.add(new Pair(start, end, i));
            }

            intervals.sort(Comparator.comparingInt(p -> p.end));

            int cEnd = intervals.get(0).end;
            int jEnd = 0;
            char[] result = new char[n];
            result[intervals.get(0).idx] = 'C';

            boolean possible = true;

            for (int i = 1; i < n; i++) {
                Pair current = intervals.get(i);

                if (current.start >= cEnd) {
                    result[current.idx] = 'C';
                    cEnd = current.end;
                } else if (current.start >= jEnd) {
                    result[current.idx] = 'J';
                    jEnd = current.end;
                } else {
                    System.out.println("Case #" + t + ": IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + t + ": " + new String(result));
            }
        }
    }
}