import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    static class Pair {
        int start, end;
        char assignedTo;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
            this.assignedTo = 0;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int i = 1; i <= testCases; ++i) {
                System.out.printf("Case #%d: ", i);
                solve(scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        Pair[] intervals = new Pair[n];
        for (int i = 0; i < n; i++) {
            intervals[i] = new Pair(scanner.nextInt(), scanner.nextInt());
        }

        Arrays.sort(intervals, Comparator.comparingInt(p -> p.start));

        ArrayList<Pair> cameron = new ArrayList<>();
        ArrayList<Pair> jamie = new ArrayList<>();

        for (Pair interval : intervals) {
            if (canAssign(cameron, interval)) {
                interval.assignedTo = 'C';
                cameron.add(interval);
            } else if (canAssign(jamie, interval)) {
                interval.assignedTo = 'J';
                jamie.add(interval);
            } else {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }

        for (Pair interval : intervals) {
            System.out.print(interval.assignedTo);
        }
        System.out.println();
    }

    private static boolean canAssign(ArrayList<Pair> list, Pair interval) {
        for (Pair assigned : list) {
            if (intervalsOverlap(assigned, interval)) {
                return false;
            }
        }
        return true;
    }

    private static boolean intervalsOverlap(Pair a, Pair b) {
        return (a.start < b.end && a.end > b.start);
    }
}