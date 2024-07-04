import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static class Range {
        private int start;
        private int end;

        public Range(int start, int end){
            this.start = start;
            this.end = end;
        }

        public boolean contains(int number){
            return (number > start && number < end);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Tests number
        List<Range> jamie = new LinkedList<>();
        List<Range> cameron = new LinkedList<>();
        Range range;
        for (int i = 0; i < t; i++) {
            jamie.clear();
            cameron.clear();
            boolean possible = true;
            int act = in.nextInt();
            int j = 0;
            StringBuffer output = new StringBuffer();
            while (possible && j < act) {
                String startStr = in.next();
                String endStr = in.next();
                int start = 0;
                int end = 0;
                try {
                    start = Integer.parseInt(startStr);
                } catch (Exception e) {
                }
                try {
                    end = Integer.parseInt(endStr);
                } catch (Exception e) {
                }
                range = new Range(start, end);
                //System.out.println("range: " + range.start + " - " + range.end);
                if (isFree(cameron, range)) {
                    //System.out.println("Assigned Jamie");
                    cameron.add(range);
                    output.append("C");
                } else if (isFree(jamie, range)) {
                    //System.out.println("Assigned Cameron");
                    jamie.add(range);
                    output.append("J");
                } else {
                    //System.out.println("Impossible");
                    possible = false;
                }
                j++;
            }
            if (!possible) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (i + 1) + ": " + output.toString());
            }
        }
    }

    private static boolean isFree(List<Range> rangeslist, Range newRange) {
        for (Range range : rangeslist) {
            if (range.contains(newRange.start)) {
                //System.out.println("Contains Start");
                return false;
            }
            if (range.contains(newRange.end)) {
                //System.out.println("Contains End");
                return false;
            }
            if (newRange.start < range.start && newRange.end > range.end) {
                //System.out.println("Included");
                return false;
            }
        }
        return true;
    }
}
