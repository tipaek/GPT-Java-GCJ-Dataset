import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
    
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        int testCases = Integer.parseInt(reader.readLine());
        for (int tt = 0; tt < testCases; tt++) {
            int n = Integer.parseInt(reader.readLine());
            Range[] ranges = new Range[n];
            Integer[] indices = new Integer[n];
            for (int i = 0; i < n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                int a = Integer.parseInt(tokenizer.nextToken());
                int b = Integer.parseInt(tokenizer.nextToken());
                ranges[i] = new Range(a, b);
                indices[i] = i;
            }
            Arrays.sort(indices, Comparator.comparingInt(x -> ranges[x].start));
            int[] assigned = new int[n];
            assign(assigned, ranges, indices, 1);
            assign(assigned, ranges, indices, 2);
            StringBuilder builder = new StringBuilder();
            boolean impossible = false;
            for (int i = 0; i < n; i++) {
                if (assigned[i] == 0) {
                    impossible = true;
                    break;
                } else {
                    builder.append(assigned[i] == 1 ? 'C' : 'J');
                }
            }
            if (impossible) {
                writer.printf("Case #%d: IMPOSSIBLE\n", tt + 1);
            } else {
                writer.printf("Case #%d: %s\n", tt + 1, builder.toString());
            }
        }
        reader.close();
        writer.close();
    }
    public static void assign(int[] assigned, Range[] ranges, Integer[] indices, int value) {
        int endTime = 0;
        for (int i = 0; i < indices.length; i++) {
            int index = indices[i];
            if (assigned[index] == 0 && ranges[index].start >= endTime) {
                assigned[index] = value;
                endTime = ranges[index].end;
            }
        }
    }
    static class Range {
        int start;
        int end;
        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}