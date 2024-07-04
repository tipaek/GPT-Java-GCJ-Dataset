import java.util.*;
import java.io.*;

public class Solution {

    public static int maximizeFun(int p, int n, int[][] a, int[][] dp) {
        if (p == 0 || n < 0)
            return 0;
        if (dp[p][n] > 0)
            return dp[p][n];
        
        int maxVal = Math.max(maximizeFun(p, n - 1, a, dp), 0);
        for (int i = 0; i < a[n].length; i++) {
            if (p - i - 1 >= 0)
                maxVal = Math.max(a[n][i] + maximizeFun(p - i - 1, n - 1, a, dp), maxVal);
            else
                break;
        }
        return dp[p][n] = maxVal;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int q = sc.nextInt();
        sc.nextLine();

        for (int p = 1; p <= q; p++) {
            int n = sc.nextInt();
            Integer[][] activities = new Integer[n][3];
            for (int i = 0; i < n; i++) {
                activities[i][0] = sc.nextInt();
                activities[i][1] = sc.nextInt();
                activities[i][2] = i;
            }

            Arrays.sort(activities, Comparator.comparing((Integer[] arr) -> arr[0]).thenComparing(arr -> arr[1]));

            int cEnd = -1, jEnd = -1;
            char[] result = new char[n];
            boolean impossible = false;

            for (int i = 0; i < n; i++) {
                if (cEnd <= activities[i][0]) {
                    cEnd = activities[i][1];
                    result[activities[i][2]] = 'C';
                } else if (jEnd <= activities[i][0]) {
                    jEnd = activities[i][1];
                    result[activities[i][2]] = 'J';
                } else {
                    impossible = true;
                    break;
                }
            }

            String output = impossible ? "IMPOSSIBLE" : new String(result);
            System.out.println("Case #" + p + ": " + output);
        }
    }

    public static Comparator<Integer[]> columnComparator(int index) {
        return (o1, o2) -> {
            int result = o1[0].compareTo(o2[0]);
            if (result == 0)
                result = o1[1].compareTo(o2[1]);
            return result;
        };
    }

    public static Comparator<Pair> pairComparator() {
        return (o1, o2) -> {
            int result = o2.a.compareTo(o1.a);
            if (result == 0)
                result = o2.in.compareTo(o1.in);
            return result;
        };
    }
}

class Pair {
    Integer a;
    Integer in;

    Pair(int a, int in) {
        this.a = a;
        this.in = in;
    }
}

class SegmentTree {
    int[] segmentArray;
    int n;

    SegmentTree(int[] arr) {
        n = arr.length;
        int size = (int) (2 * Math.pow(2, Math.ceil(Math.log(n) / Math.log(2))) - 1);
        segmentArray = new int[size];
        buildSegmentTree(arr, 0, 0, n - 1);
    }

    void buildSegmentTree(int[] arr, int root, int start, int end) {
        if (start == end) {
            segmentArray[root] = arr[start];
        } else {
            int mid = (start + end) / 2;
            segmentArray[root] = Math.min(buildSegmentTree(arr, 2 * root + 1, start, mid),
                                          buildSegmentTree(arr, 2 * root + 2, mid + 1, end));
        }
    }

    int getValue(int left, int right) {
        return getValueUtil(0, 0, n - 1, left, right);
    }

    int getValueUtil(int root, int start, int end, int left, int right) {
        if (start >= left && end <= right) {
            return segmentArray[root];
        }
        if (start > right || end < left) {
            return Integer.MAX_VALUE;
        }
        int mid = (start + end) / 2;
        return Math.min(getValueUtil(2 * root + 1, start, mid, left, right),
                        getValueUtil(2 * root + 2, mid + 1, end, left, right));
    }

    void update(int index, int value) {
        updateUtil(index, value, 0, 0, n - 1);
    }

    void updateUtil(int index, int value, int root, int start, int end) {
        if (start == end && start == index) {
            segmentArray[root] = value;
        } else if (start > index || end < index) {
            return;
        } else {
            int mid = (start + end) / 2;
            segmentArray[root] = Math.min(updateUtil(index, value, 2 * root + 1, start, mid),
                                          updateUtil(index, value, 2 * root + 2, mid + 1, end));
        }
    }
}