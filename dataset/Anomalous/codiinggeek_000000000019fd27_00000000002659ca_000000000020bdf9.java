import java.io.*;
import java.util.*;

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
            int testCases = reader.nextInt();
            int caseNumber = 1;

            while (testCases-- > 0) {
                int n = reader.nextInt();
                long l = reader.nextLong();
                long r = reader.nextLong();

                Map<Long, Long> cameronSchedule = new HashMap<>();
                Map<Long, Long> jamieSchedule = new HashMap<>();

                cameronSchedule.put(l, r);
                StringBuilder schedule = new StringBuilder("C");

                boolean isImpossible = false;

                for (int i = 1; i < n; i++) {
                    long start = reader.nextLong();
                    long end = reader.nextLong();

                    if (isImpossible) continue;

                    boolean canCameronTake = canTakeShift(cameronSchedule, start, end);
                    boolean canJamieTake = canTakeShift(jamieSchedule, start, end);

                    if (canCameronTake) {
                        schedule.append("C");
                        cameronSchedule.put(start, end);
                    } else if (canJamieTake) {
                        schedule.append("J");
                        jamieSchedule.put(start, end);
                    } else {
                        isImpossible = true;
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

    private static boolean canTakeShift(Map<Long, Long> schedule, long start, long end) {
        for (Map.Entry<Long, Long> entry : schedule.entrySet()) {
            if ((entry.getKey() <= start && start < entry.getValue()) || (entry.getKey() < end && end <= entry.getValue())) {
                return false;
            }
        }
        return true;
    }
}