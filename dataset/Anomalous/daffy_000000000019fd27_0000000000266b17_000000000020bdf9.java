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
        int maxElement = 0;

        for (int i = 0; i < n; i++) {
            if (maxElement < intervals[i].end) {
                maxElement = intervals[i].end;
            }
        }

        int[] aux = new int[maxElement + 1];
        for (int i = 0; i < n; i++) {
            aux[intervals[i].start]++;
            aux[intervals[i].end]--;
        }

        for (int i = 1; i <= maxElement; i++) {
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
                StringBuilder resultBuilder = new StringBuilder("C");
                for (int x = 1; x < n; x++) {
                    Interval[] temp = {intervals[x - 1], intervals[x]};
                    if (maxOverlap(temp, 2) == 1) {
                        resultBuilder.append(resultBuilder.charAt(resultBuilder.length() - 1) == 'C' ? 'C' : 'J');
                    } else {
                        resultBuilder.append(resultBuilder.charAt(resultBuilder.length() - 1) == 'C' ? 'J' : 'C');
                    }
                }
                result = resultBuilder.toString();
            }

            System.out.println("Case #" + i + ": " + result);
        }

        scanner.close();
    }
}