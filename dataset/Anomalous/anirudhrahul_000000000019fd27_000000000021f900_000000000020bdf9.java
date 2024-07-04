import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
    static class Range implements Comparable<Range> {
        int start, end, originalIndex;
        char assignedPerson;

        public Range(int start, int end, int originalIndex) {
            this.start = start;
            this.end = end;
            this.originalIndex = originalIndex;
        }

        @Override
        public int compareTo(Range other) {
            return Integer.compare(this.start, other.start);
        }

        @Override
        public String toString() {
            return "(" + start + ", " + end + ")";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int numberOfCases = Integer.parseInt(reader.readLine());

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            writer.write("Case #" + caseNumber + ": ");
            int numberOfActivities = Integer.parseInt(reader.readLine());
            ArrayList<Range> activities = new ArrayList<>(numberOfActivities);

            for (int i = 0; i < numberOfActivities; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                int start = Integer.parseInt(tokenizer.nextToken());
                int end = Integer.parseInt(tokenizer.nextToken());
                activities.add(new Range(start, end, i));
            }

            Collections.sort(activities);
            int cEnd = 0, jEnd = 0;
            boolean isPossible = true;

            for (Range activity : activities) {
                if (cEnd <= activity.start) {
                    cEnd = activity.end;
                    activity.assignedPerson = 'C';
                } else if (jEnd <= activity.start) {
                    jEnd = activity.end;
                    activity.assignedPerson = 'J';
                } else {
                    writer.write("IMPOSSIBLE\n");
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                char[] result = new char[numberOfActivities];
                for (Range activity : activities) {
                    result[activity.originalIndex] = activity.assignedPerson;
                }
                writer.write(new String(result) + "\n");
            }
        }

        writer.close();
    }
}