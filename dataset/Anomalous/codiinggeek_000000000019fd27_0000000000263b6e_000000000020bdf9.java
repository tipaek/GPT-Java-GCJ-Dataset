import java.io.*;
import java.util.*;

public class Solution {
    static class FastReader {
        private BufferedReader br;
        private StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        private String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
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
            int testCases = reader.nextInt();
            int caseNumber = 1;

            while (testCases-- > 0) {
                int intervalsCount = reader.nextInt();
                long start = reader.nextLong();
                long end = reader.nextLong();
                Map<Long, Long> cameronSchedule = new HashMap<>();
                Map<Long, Long> jamieSchedule = new HashMap<>();

                cameronSchedule.put(start, end);
                StringBuilder schedule = new StringBuilder("C");
                boolean isImpossible = false;

                for (int i = 1; i < intervalsCount; i++) {
                    long a = reader.nextLong();
                    long b = reader.nextLong();

                    if (isImpossible) {
                        continue;
                    }

                    boolean canAssignToCameron = true;
                    for (Map.Entry<Long, Long> entry : cameronSchedule.entrySet()) {
                        if ((entry.getKey() <= a && a < entry.getValue()) || (entry.getKey() < b && b <= entry.getValue())) {
                            canAssignToCameron = false;
                            break;
                        }
                    }

                    if (canAssignToCameron) {
                        schedule.append("C");
                        cameronSchedule.put(a, b);
                    } else {
                        boolean canAssignToJamie = true;
                        for (Map.Entry<Long, Long> entry : jamieSchedule.entrySet()) {
                            if ((entry.getKey() <= a && a < entry.getValue()) || (entry.getKey() < b && b <= entry.getValue())) {
                                canAssignToJamie = false;
                                break;
                            }
                        }

                        if (canAssignToJamie) {
                            schedule.append("J");
                            jamieSchedule.put(a, b);
                        } else {
                            isImpossible = true;
                        }
                    }
                }

                if (isImpossible) {
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