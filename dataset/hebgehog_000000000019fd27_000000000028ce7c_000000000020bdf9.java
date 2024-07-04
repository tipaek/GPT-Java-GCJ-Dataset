

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        for (int c = 1; c <= t; c++) {
            System.out.println("Case #" + c + ": " + getSolution(scanner));
            if (c < t) {
                scanner.nextLine();
            }
        }
    }

    private static String getSolution(Scanner scanner) {
        int n = scanner.nextInt();
        scanner.nextLine();
        List<List<Integer>> intervals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> interval = new ArrayList<>();
            interval.add(scanner.nextInt());
            interval.add(scanner.nextInt());
//            scanner.nextLine();
            intervals.add(interval);
        }
        Collections.sort(intervals, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> interval1, List<Integer> interval2) {
                return interval1.get(0).compareTo(interval2.get(0));
            }
        });
        char[] assignments = new char[n];
        int jFreeAt = 0;
        int cFreeAt = 0;
        int start;
        int end;
        int i = 0;
        for (List<Integer> interval : intervals) {
            start = interval.get(0);
            end = interval.get(1);
            if (start < jFreeAt && start < cFreeAt) {
                return "IMPOSSIBLE";
            }
            if (start < jFreeAt) {
                assignments[i] = 'C';
                cFreeAt = end;
            } else {
                assignments[i] = 'J';
                jFreeAt = end;
            }
            i++;
        }
        return new String(assignments);
    }
}
