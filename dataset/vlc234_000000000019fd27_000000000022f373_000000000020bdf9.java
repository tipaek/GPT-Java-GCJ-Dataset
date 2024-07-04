import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= t; ++i) {
            int n = Integer.parseInt(in.nextLine());
            List<Range> ranges = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                String row = in.nextLine();
                String[] params = row.split(" ");
                ranges.add(new Range(Integer.parseInt(params[0]), Integer.parseInt(params[1])));
            }
            solve(i, n, ranges);
        }
    }

    private static void solve(int index, int n, List<Range> ranges) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Range> rangeC = new ArrayList<>();
        List<Range> rangeJ = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Range range = ranges.get(i);
            if (!range.isOverlap(rangeC)) {
                stringBuilder.append("C");
                rangeC.add(range);
            } else if (!range.isOverlap(rangeJ)) {
                stringBuilder.append("J");
                rangeJ.add(range);
            } else {
                break;
            }
        }
        String result = "IMPOSSIBLE";
        if (rangeC.size() + rangeJ.size() == n) {
            result = stringBuilder.toString();
        }
        System.out.println("Case #" + index + ": " + result);
    }

    public static class Range {

        public final int min;
        public final int max;

        public Range(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public boolean isAbsoluteOverlap(Range another) {
            if (this.min == another.max || this.max == another.min) {
                return false;
            }
            return this.min <= another.max && another.min <= this.max;
        }

        public boolean isOverlap(List<Range> ranges) {
            int size = ranges.size();
            if (size == 0) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (ranges.get(i).isAbsoluteOverlap(this)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public String toString() {
            return "(" + min + "," + max + ")";
        }
    }
}