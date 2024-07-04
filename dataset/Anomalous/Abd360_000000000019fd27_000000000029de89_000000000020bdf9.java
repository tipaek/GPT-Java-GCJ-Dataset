import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            int[][] originalIntervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    intervals[i][j] = scanner.nextInt();
                    originalIntervals[i][j] = intervals[i][j];
                }
            }

            Arrays.sort(intervals, new IntervalComparator());

            StringBuilder schedule = new StringBuilder();
            int lastCameron = -1, lastJamie = -1;
            boolean impossible = false;

            for (int i = 0; i < n; i++) {
                if (lastCameron == -1 || intervals[i][0] >= intervals[lastCameron][1]) {
                    schedule.append('C');
                    lastCameron = i;
                } else if (lastJamie == -1 || intervals[i][0] >= intervals[lastJamie][1]) {
                    schedule.append('J');
                    lastJamie = i;
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                char[] result = new char[n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (originalIntervals[i][0] == intervals[j][0] && originalIntervals[i][1] == intervals[j][1]) {
                            result[i] = schedule.charAt(j);
                            break;
                        }
                    }
                }
                System.out.println(new String(result));
            }
        }
    }
}

class IntervalComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] a, int[] b) {
        return Integer.compare(a[1], b[1]);
    }
}