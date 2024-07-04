import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    private static final String RESULT_PATTERN = "Case #%d: %s";

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int testCasesNumber = Integer.parseInt(tokenizer.nextToken());
            for (int t = 1; t <= testCasesNumber; ++t) {
                tokenizer = new StringTokenizer(reader.readLine());
                int n = Integer.parseInt(tokenizer.nextToken());
                List<Triple> duties = new ArrayList<>(n);
                for (int i = 0; i < n; ++i) {
                    tokenizer = new StringTokenizer(reader.readLine());
                    duties.add(new Triple(
                            i,
                            Integer.parseInt(tokenizer.nextToken()),
                            Integer.parseInt(tokenizer.nextToken()))
                    );
                }
                solve(t, duties);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve(int testCaseId, List<Triple> duties) {
        char[] result = new char[duties.size()];
        duties.sort(Comparator.comparing(Triple::getStartTime));
        int cameronTime = 0;
        int jamieTime = 0;
        for (Triple duty : duties) {
            int startTime = duty.getStartTime();
            int endTime = duty.getEndTime();
            int id = duty.getId();
            if (jamieTime <= startTime) {
                jamieTime = endTime;
                result[id] = 'J';
            } else if (cameronTime <= startTime) {
                cameronTime = endTime;
                result[id] = 'C';
            } else {
                System.out.println(String.format(RESULT_PATTERN, testCaseId, "IMPOSSIBLE"));
                return;
            }
        }
        System.out.println(String.format(RESULT_PATTERN, testCaseId, String.valueOf(result)));
    }

    static class Triple {
        int id;
        int startTime;
        int endTime;

        public Triple(int id, int startTime, int endTime) {
            this.id = id;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getId() {
            return id;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }
    }
}
