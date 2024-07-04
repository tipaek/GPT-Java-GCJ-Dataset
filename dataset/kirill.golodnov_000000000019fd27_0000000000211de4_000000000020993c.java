import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.nio.charset.StandardCharsets.UTF_8;

public class Solution {

    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in, UTF_8), 1 << 15);
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out, UTF_8), 1 << 15)) {
            int tests = parseInt(in.readLine().trim());
            for (int t = 0; t < tests; t++) {
                int n = parseInt(in.readLine().trim());
                int trace = 0;
                Set<Integer>[] rows = new HashSet[n];
                Set<Integer>[] columns = new HashSet[n];
                for (int i = 0; i < n; i++) {
                    StringTokenizer tokens = new StringTokenizer(in.readLine());
                    for (int j = 0; j < n; j++) {
                        int value = parseInt(tokens.nextToken());
                        if (rows[i] == null) {
                            rows[i] = new HashSet<>();
                        }
                        if (columns[j] == null) {
                            columns[j] = new HashSet<>();
                        }
                        rows[i].add(value);
                        columns[j].add(value);
                        if (i == j) {
                            trace += value;
                        }
                    }
                }
                int cr = 0;
                int cc = 0;
                for (int i = 0; i < n; i++) {
                    cr += rows[i].size() < n ? 1 : 0;
                    cc += columns[i].size() < n ? 1 : 0;
                }
                out.write("Case #" + (t + 1) + ": " + trace + " " + cr + " " + cc);
                out.newLine();
            }
        } catch (IOException e) {
            System.exit(1);
        }
    }
}
