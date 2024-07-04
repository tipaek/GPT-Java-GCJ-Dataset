import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ParentingPartneringReturns solver = new ParentingPartneringReturns();
        solver.solve(in, out);
        out.close();
    }

    static class ParentingPartneringReturns {
        public void solve(InputReader in, PrintWriter out) {
            int t = in.nextInt();
            for (int testCase = 1; testCase <= t; testCase++) {
                int n = in.nextInt();
                Activity[] activities = new Activity[n];
                int[] timeSlots = new int[24 * 60 + 1];

                for (int i = 0; i < n; i++) {
                    int start = in.nextInt();
                    int end = in.nextInt();
                    activities[i] = new Activity(start, end, i);
                    for (int j = start; j < end; j++) {
                        timeSlots[j]++;
                    }
                }

                Arrays.sort(activities, (a, b) -> {
                    if (a.start != b.start) {
                        return Integer.compare(a.start, b.start);
                    } else {
                        return Integer.compare(a.end, b.end);
                    }
                });

                boolean possible = Arrays.stream(timeSlots).allMatch(count -> count <= 2);

                if (!possible) {
                    out.println("Case #" + testCase + ": IMPOSSIBLE");
                } else {
                    int[] assignments = new int[n];
                    int cameronEnd = -1;
                    int jamieEnd = -1;

                    for (Activity activity : activities) {
                        if (activity.start >= cameronEnd) {
                            assignments[activity.index] = 1;
                            cameronEnd = activity.end;
                        } else if (activity.start >= jamieEnd) {
                            assignments[activity.index] = 2;
                            jamieEnd = activity.end;
                        } else {
                            possible = false;
                            break;
                        }
                    }

                    if (!possible) {
                        out.println("Case #" + testCase + ": IMPOSSIBLE");
                    } else {
                        out.print("Case #" + testCase + ": ");
                        for (int assignment : assignments) {
                            out.print(assignment == 1 ? "C" : "J");
                        }
                        out.println();
                    }
                }
            }
        }

        private static class Activity {
            int start, end, index;

            Activity(int start, int end, int index) {
                this.start = start;
                this.end = end;
                this.index = index;
            }
        }
    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}