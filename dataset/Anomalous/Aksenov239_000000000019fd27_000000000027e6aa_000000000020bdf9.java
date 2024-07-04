import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        new Solution().execute();
    }

    private BufferedReader reader;
    private StringTokenizer tokenizer;
    private PrintWriter writer;

    private String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private class TimeSlot implements Comparable<TimeSlot> {
        int start, end, index;

        TimeSlot(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(TimeSlot other) {
            return Integer.compare(this.start, other.start);
        }
    }

    private void solve() throws IOException {
        int n = nextInt();
        TimeSlot[] timeSlots = new TimeSlot[n];
        
        for (int i = 0; i < n; i++) {
            timeSlots[i] = new TimeSlot(nextInt(), nextInt(), i);
        }

        Arrays.sort(timeSlots);
        char[] result = new char[n];
        int[] lastEndTimes = {-1, -1};

        for (TimeSlot timeSlot : timeSlots) {
            if (lastEndTimes[0] <= timeSlot.start) {
                lastEndTimes[0] = timeSlot.end;
                result[timeSlot.index] = 'C';
            } else if (lastEndTimes[1] <= timeSlot.start) {
                lastEndTimes[1] = timeSlot.end;
                result[timeSlot.index] = 'J';
            } else {
                writer.println("IMPOSSIBLE");
                return;
            }
        }
        
        writer.println(new String(result));
    }

    private void execute() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            writer = new PrintWriter(System.out);

            int testCases = nextInt();
            for (int i = 0; i < testCases; i++) {
                writer.printf("Case #%d: ", i + 1);
                solve();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}