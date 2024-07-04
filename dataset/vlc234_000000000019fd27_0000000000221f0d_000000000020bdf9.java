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
            List<Range> ranges = new ArrayList<>();
            int min = 0;
            for (int j = 0; j < n * 2; j ++) {
                if (j % 2 == 0) {
                    min = in.nextInt();
                } else {
                    ranges.add(new Range(min, in.nextInt()));
                }
            }
            solve(i, ranges);
        }

    }

    private static void solve(int index, List<Range> ranges) {
        int count = ranges.size();
        if (count == 1) {
            System.out.println("Case #" + index + ": IMPOSSIBLE");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        List<Range> rangeC = new ArrayList<>();
        List<Range> rangeJ = new ArrayList<>();
        boolean hasSolution = true;
        for (int i = 0; i < count; i++) {
            Range range = ranges.get(i);
            if (!range.isOverlapAny(rangeC)) {
                stringBuilder.append("C");
                rangeC.add(range);
            } else if (!range.isOverlapAny(rangeJ)) {
                stringBuilder.append("J");
                rangeJ.add(range);
            } else {
                hasSolution = false;
                break;
            }
        }
        System.out.println("Case #" + index + ": " + (hasSolution ? stringBuilder.toString() : "IMPOSSIBLE"));
    }
    
    public static class Range {
        public final int min;
        public final int max;
        
        public Range(int min, int max) {
            this.min = min;
            this.max = max;
        }
        
        public boolean isAbsoluteOverlap(Range another) {
            if (this.min == another.min && this.max == another.max)
                return true;
            return this.min < another.max && another.min < this.max;
        }
        
        public boolean isOverlapAny(List<Range> ranges) {
            int size = ranges.size();
            if (size == 0) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (ranges.get(i).isAbsoluteOverlap(this))
                    return true;
            }
            return false;
        }
        
        @Override
        public String toString() {
            return "(" + min + "," + max + ")";
        }
    }
}