import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(System.out)) {
            
            int testCases = Integer.parseInt(reader.readLine());
            for (int tt = 0; tt < testCases; tt++) {
                int n = Integer.parseInt(reader.readLine());
                Range[] ranges = new Range[n];
                Integer[] indices = new Integer[n];
                for (int i = 0; i < n; i++) {
                    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                    int start = Integer.parseInt(tokenizer.nextToken());
                    int end = Integer.parseInt(tokenizer.nextToken());
                    ranges[i] = new Range(start, end);
                    indices[i] = i;
                }
                Arrays.sort(indices, Comparator.comparingInt(index -> ranges[index].start));
                int[] assignments = new int[n];
                assignTasks(assignments, ranges, indices, 1);
                assignTasks(assignments, ranges, indices, 2);
                
                StringBuilder resultBuilder = new StringBuilder();
                boolean isImpossible = false;
                for (int i = 0; i < n; i++) {
                    if (assignments[i] == 0) {
                        isImpossible = true;
                        break;
                    } else {
                        resultBuilder.append(assignments[i] == 1 ? 'C' : 'J');
                    }
                }
                
                if (isImpossible) {
                    writer.printf("Case #%d: IMPOSSIBLE\n", tt + 1);
                } else {
                    writer.printf("Case #%d: %s\n", tt + 1, resultBuilder.toString());
                }
            }
        }
    }

    private static void assignTasks(int[] assignments, Range[] ranges, Integer[] indices, int taskValue) {
        int lastEndTime = 0;
        for (int index : indices) {
            if (assignments[index] == 0 && ranges[index].start >= lastEndTime) {
                assignments[index] = taskValue;
                lastEndTime = ranges[index].end;
            }
        }
    }

    static class Range {
        int start;
        int end;

        Range(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}