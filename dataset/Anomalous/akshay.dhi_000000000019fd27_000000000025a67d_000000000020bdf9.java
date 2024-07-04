import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        int caseNumber = 0;

        while (testCases-- > 0) {
            caseNumber++;
            int numberOfIntervals = Integer.parseInt(br.readLine());
            List<Interval> intervals = new ArrayList<>();

            for (int i = 0; i < numberOfIntervals; i++) {
                StringTokenizer tokenizer = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(tokenizer.nextToken());
                int end = Integer.parseInt(tokenizer.nextToken());
                intervals.add(new Interval(start, end));
            }

            intervals.sort(Comparator.comparingInt(interval -> interval.start));

            int endC = -1;
            int endJ = -1;
            StringBuilder schedule = new StringBuilder();
            boolean isImpossible = false;

            for (int t = 0; t < 3600; t++) {
                if (endC == t) endC = -1;
                if (endJ == t) endJ = -1;

                if (!intervals.isEmpty() && intervals.get(0).start == t) {
                    Interval current = intervals.remove(0);

                    if (endC == -1) {
                        endC = current.end;
                        schedule.append("C");
                    } else if (endJ == -1) {
                        endJ = current.end;
                        schedule.append("J");
                    } else {
                        isImpossible = true;
                        break;
                    }
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + schedule.toString());
            }
        }
    }
}

class Interval {
    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}