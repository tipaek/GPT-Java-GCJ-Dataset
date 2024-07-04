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
            return (number >= start && number <= end);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Tests number
        List<Range> jamie = new LinkedList<>();
        List<Range> cameron = new LinkedList<>();
        Range duration;
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
                duration = new Range(start, end);
                if (isFree(jamie, duration)) {
                    jamie.add(duration);
                    output.append("J");
                } else if (isFree(cameron, duration)) {
                    cameron.add(duration);
                    output.append("C");
                } else {
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

    private static boolean isFree(List<Range> person, Range newTask) {
        for (Range task : person) {
            if (task.contains(newTask.start)) {
                return false;
            }
            if (task.contains(newTask.end)) {
                return false;
            }
            if (newTask.start < task.start && newTask.end > task.end) {
                return false;
            }
        }
        return true;
    }
}
