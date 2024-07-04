import java.util.*;
import java.io.*;

public class Solution {

    static class CostPair {
        int first, second, orig;

        CostPair(int first, int second, int orig) {
            this.first = first;
            this.second = second;
            this.orig = orig;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 0; t < testCases; t++) {
            int N = Integer.parseInt(reader.readLine());
            CostPair[] costPairs = new CostPair[N];

            for (int i = 0; i < N; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                int first = Integer.parseInt(tokenizer.nextToken());
                int second = Integer.parseInt(tokenizer.nextToken());
                costPairs[i] = new CostPair(first, second, i);
            }

            Arrays.sort(costPairs, (a, b) -> {
                if (a.first != b.first) {
                    return Integer.compare(a.first, b.first);
                } else {
                    return Integer.compare(a.second, b.second);
                }
            });

            StringBuilder result = new StringBuilder();
            int cEnd = -1, jEnd = -1;
            boolean conflict = false;
            char[] assignments = new char[N];

            for (int i = 0; i < N; i++) {
                if (costPairs[i].first >= cEnd) {
                    cEnd = costPairs[i].second;
                    assignments[costPairs[i].orig] = 'C';
                } else if (costPairs[i].first >= jEnd) {
                    jEnd = costPairs[i].second;
                    assignments[costPairs[i].orig] = 'J';
                } else {
                    conflict = true;
                    break;
                }
            }

            if (conflict) {
                result.append("Case #").append(t + 1).append(": IMPOSSIBLE");
            } else {
                result.append("Case #").append(t + 1).append(": ").append(new String(assignments));
            }

            System.out.println(result.toString());
        }
    }
}