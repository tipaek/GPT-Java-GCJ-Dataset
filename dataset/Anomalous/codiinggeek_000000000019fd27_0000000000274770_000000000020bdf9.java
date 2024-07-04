import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Solution {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        try {
            FastReader reader = new FastReader();
            int t = reader.nextInt();
            int caseNumber = 1;

            while (t-- > 0) {
                int n = reader.nextInt();
                long start = reader.nextLong();
                long end = reader.nextLong();
                TreeMap<Long, Long> cameron = new TreeMap<>();
                TreeMap<Long, Long> jamie = new TreeMap<>();
                cameron.put(start, end);
                StringBuilder schedule = new StringBuilder("C");
                boolean impossible = false;

                for (int i = 1; i < n; i++) {
                    long a = reader.nextLong();
                    long b = reader.nextLong();

                    if (impossible) {
                        continue;
                    }

                    boolean cameronConflict = false;
                    boolean jamieConflict = false;

                    for (Map.Entry<Long, Long> entry : cameron.entrySet()) {
                        if ((entry.getKey() <= a && a < entry.getValue()) || (entry.getKey() < b && b <= entry.getValue())) {
                            cameronConflict = true;
                            break;
                        }
                    }

                    if (!cameronConflict) {
                        schedule.append("C");
                        cameron.put(a, b);
                    } else {
                        for (Map.Entry<Long, Long> entry : jamie.entrySet()) {
                            if ((entry.getKey() <= a && a < entry.getValue()) || (entry.getKey() < b && b <= entry.getValue())) {
                                jamieConflict = true;
                                break;
                            }
                        }

                        if (jamieConflict) {
                            impossible = true;
                        } else {
                            schedule.append("J");
                            jamie.put(a, b);
                        }
                    }
                }

                if (impossible) {
                    System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                } else {
                    System.out.println("Case #" + caseNumber + ": " + schedule.toString());
                }

                caseNumber++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}