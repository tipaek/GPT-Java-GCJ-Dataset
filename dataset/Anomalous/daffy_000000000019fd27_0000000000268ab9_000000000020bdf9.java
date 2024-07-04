import java.util.Scanner;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Solution {

    public static int maxOverlap(Interval[] intervals, int n) {
        int maxOverlap = 0;
        int maxEnd = 0;

        for (int i = 0; i < n; i++) {
            if (maxEnd < intervals[i].end) {
                maxEnd = intervals[i].end;
            }
        }

        int[] aux = new int[maxEnd + 1];
        for (int i = 0; i < n; i++) {
            aux[intervals[i].start]++;
            aux[intervals[i].end]--;
        }

        for (int i = 1; i <= maxEnd; i++) {
            aux[i] += aux[i - 1];
            if (aux[i] > maxOverlap) {
                maxOverlap = aux[i];
            }
        }

        return maxOverlap;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            Interval[] intervals = new Interval[n];

            for (int j = 0; j < n; j++) {
                String[] input = scanner.nextLine().split(" ");
                intervals[j] = new Interval(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            }

            String result = "IMPOSSIBLE";
            int maxOverlap = maxOverlap(intervals, n);

            if (maxOverlap == 1) {
                result = "C".repeat(n);
            } else if (maxOverlap == 2) {
                result = "C";
                for (int x = 1; x < n; x++) {
                    Interval[] temp = {intervals[0], intervals[x]};
                    if (maxOverlap(temp, 2) == 1) {
                        result += "C";
                    } else {
                        result += "J";
                    }
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }

        scanner.close();
    }
}