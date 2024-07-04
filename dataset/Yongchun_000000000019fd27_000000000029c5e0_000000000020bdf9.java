import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            List<Interval> intervals = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int s = in.nextInt();
                int e = in.nextInt();
                intervals.add(new Interval(s, e));
            }
            System.out.println("Case #" + i + ": " + solve(intervals));
        }
    }

    private static String solve(List<Interval> intervals) {
        StringBuilder result = new StringBuilder("CJ");
        IntervalTree cameron = new IntervalTree(intervals.get(0));
        IntervalTree jamie = new IntervalTree(intervals.get(1));
        for (int i = 2; i < intervals.size(); i++) {
            if (cameron.checkOverlap(cameron, intervals.get(i)) &&
                    jamie.checkOverlap(jamie, intervals.get(i))) {
                return "IMPOSSIBLE";
            }
            if (!cameron.checkOverlap(cameron, intervals.get(i))) {
                cameron = cameron.insert(cameron, intervals.get(i));
                result.append("C");
            } else {
                jamie = jamie.insert(jamie, intervals.get(i));
                result.append("J");
            }
        }
        return result.toString();
    }
}

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class IntervalTree {

    Interval i;
    int max;
    IntervalTree left;
    IntervalTree right;

    public IntervalTree(Interval i) {
        this.i = i;
        this.max = i.end;
    }

    IntervalTree insert(IntervalTree root, Interval i) {
        if (root == null) {
            return new IntervalTree(i);
        }

        if (i.start < root.i.start) {
            root.left = insert(root.left, i);
        } else {
            root.right = insert(root.right, i);
        }

        if (root.max < i.end) {
            root.max = i.end;
        }

        return root;
    }

    boolean checkOverlap(IntervalTree root, Interval i) {
        if (root == null) return false;
        if (root.i.start < i.end && i.start < root.i.end) {
            return true;
        }
        if (root.left != null && root.left.max >= i.start) {
            return checkOverlap(root.left, i);
        } else {
            return checkOverlap(root.right, i);
        }
    }
}