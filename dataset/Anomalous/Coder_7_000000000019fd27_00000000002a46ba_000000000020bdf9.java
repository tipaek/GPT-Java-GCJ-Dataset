import java.util.*;

class Solution {
    static class Pair {
        int start;
        int end;
        int index;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(scanner.nextLine());
            Pair[] intervals = new Pair[n];

            for (int i = 0; i < n; i++) {
                String[] input = scanner.nextLine().split(" ");
                Pair pair = new Pair();
                pair.start = Integer.parseInt(input[0]);
                pair.end = Integer.parseInt(input[1]);
                pair.index = i;
                intervals[i] = pair;
            }

            Arrays.sort(intervals, Comparator.comparingInt(p -> p.start));

            int cEnd = 0;
            int jEnd = 0;
            String[] result = new String[n];
            boolean possible = true;

            for (Pair interval : intervals) {
                if (interval.start >= cEnd) {
                    cEnd = interval.end;
                    result[interval.index] = "C";
                } else if (interval.start >= jEnd) {
                    jEnd = interval.end;
                    result[interval.index] = "J";
                } else {
                    possible = false;
                    break;
                }
            }

            System.out.print("Case #" + t + ": ");
            if (possible) {
                for (String res : result) {
                    System.out.print(res);
                }
            } else {
                System.out.print("IMPOSSIBLE");
            }
            System.out.println();
        }
    }
}