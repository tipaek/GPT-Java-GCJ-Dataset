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

    private String getNextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    private int getNextInt() throws IOException {
        return Integer.parseInt(getNextToken());
    }

    private static class TimeSlot implements Comparable<TimeSlot> {
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
        int n = getNextInt();
        TimeSlot[] slots = new TimeSlot[n];
        for (int i = 0; i < n; i++) {
            slots[i] = new TimeSlot(getNextInt(), getNextInt(), i);
        }

        Arrays.sort(slots);
        char[] result = new char[n];
        int[] lastEnd = {-1, -1};

        for (TimeSlot slot : slots) {
            if (lastEnd[0] <= slot.start) {
                lastEnd[0] = slot.end;
                result[slot.index] = 'C';
            } else if (lastEnd[1] <= slot.start) {
                lastEnd[1] = slot.end;
                result[slot.index] = 'J';
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

            int testCases = getNextInt();
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