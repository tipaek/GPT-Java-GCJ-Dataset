import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int k = 1; k <= t; k++) {
            String output = "";
            int n = Integer.parseInt(sc.nextLine());
            List<Integer[]> allIntervals = new ArrayList<>();
            List<Integer[]> cIntervals = new ArrayList<>();
            List<Integer[]> jIntervals = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String[] line = sc.nextLine().split(" ");
                int s = Integer.parseInt(line[0]);
                int e = Integer.parseInt(line[1]);
                Integer[] interval = new Integer[2];
                interval[0] = s;
                interval[1] = e;
                allIntervals.add(interval);
            }

            allIntervals.sort(Comparator.comparingInt(i -> i[0]));
            for (int i = 0; i < allIntervals.size(); i++) {
                Integer[] interval = allIntervals.get(i);
                if (!hasOverlappingIntervals(cIntervals, interval)) {
                    cIntervals.add(interval);
                    output += "C";
                } else {
                    if (!hasOverlappingIntervals(jIntervals, interval)) {
                        jIntervals.add(interval);
                        output += "J";
                    } else {
                        output = "IMPOSSIBLE";
                        break;
                    }
                }

            }
            System.out.println("Case #" + k + ": " + output);
        }
    }

    public static boolean activitiesNotOverlap(int s1, int e1, int s2, int e2) {
        return e1 <= s2 || e2 <= s1;
    }

    public static boolean hasOverlappingIntervals(List<Integer[]> intervals, Integer[] interval) {
        boolean hasOverlapping = false;
        for (int i = 0; i < intervals.size(); i++) {
            Integer[] currInterval = intervals.get(i);
            if (!activitiesNotOverlap(currInterval[0], currInterval[1], interval[0], interval[1])) {
                hasOverlapping = true;
                break;
            }
        }

        return hasOverlapping;
    }
}
