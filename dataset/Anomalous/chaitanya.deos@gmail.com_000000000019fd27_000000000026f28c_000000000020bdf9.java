import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        // Scanner scanner = new Scanner(new BufferedReader(new FileReader("test.in")));
        Solution solution = new Solution();
        while (scanner.hasNext()) {
            int T = scanner.nextInt();
            
            for (int i = 0; i < T; i++) {
                int N = scanner.nextInt();
                List<Interval> intervals = new ArrayList<>(N);
                for (int j = 0; j < N; j++) {
                    intervals.add(new Interval(scanner.nextInt(), scanner.nextInt()));
                }
                intervals.sort(Comparator.comparingInt(Interval::getStart));
                
                StringBuilder builder = new StringBuilder();
                if (N > 1) {
                    Interval cameron = intervals.get(0);
                    Interval jamie = intervals.get(1);
                    builder.append("JC");
                    boolean possible = true;
                    
                    for (int k = 2; k < intervals.size(); k++) {
                        Interval interval = intervals.get(k);
                        if (interval.getStart() >= cameron.getEnd()) {
                            builder.append('C');
                            cameron = interval;
                        } else if (interval.getStart() >= jamie.getEnd()) {
                            builder.append('J');
                            jamie = interval;
                        } else {
                            builder.setLength(0);
                            builder.append("IMPOSSIBLE");
                            possible = false;
                            break;
                        }
                    }
                    
                    if (possible) {
                        System.out.println(String.format("Case #%d: %s", (i + 1), builder.toString()));
                    } else {
                        System.out.println(String.format("Case #%d: IMPOSSIBLE", (i + 1)));
                    }
                } else {
                    builder.append("C");
                    System.out.println(String.format("Case #%d: %s", (i + 1), builder.toString()));
                }
            }
        }
        scanner.close();
    }
    
    static class Interval {
        private int start;
        private int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }
}