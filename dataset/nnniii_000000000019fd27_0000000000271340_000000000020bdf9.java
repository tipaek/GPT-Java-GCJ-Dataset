import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(reader.readLine());

            StringBuilder caseResult = new StringBuilder(N);
            caseResult.setLength(N);
            Activity[] activities = new Activity[N];
            int jEnd = 0;
            int cEnd = 0;

            for (int n = 0; n < N; n++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());
                activities[n] = new Activity(n, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            Arrays.sort(activities, (act1, act2) -> act1.end - act2.end == 0 ? act1.start - act2.start : act1.end - act2.end);

            for (int n = 0; n < N; n++) {
                if (activities[n].start >= jEnd) {
                    caseResult.replace(activities[n].index, activities[n].index + 1, "J");
                    jEnd = activities[n].end;
                } else if (activities[n].start >= cEnd) {
                    caseResult.replace(activities[n].index, activities[n].index + 1, "C");
                    cEnd = activities[n].end;
                } else {
                    caseResult.delete(0, caseResult.length());
                    caseResult.append("IMPOSSIBLE");
                    break;
                }
            }

            result.append(String.format("Case #%d: %s\n", i, caseResult.toString()));
        }

        writer.println(result.toString());

        reader.close();
        writer.close();
    }
}

class Activity {
    int index;
    int start;
    int end;

    public Activity(int index, int start, int end) {
        this.index = index;
        this.start = start;
        this.end = end;
    }
}
