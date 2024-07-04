
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution {

    public class Schedule {
        int start;
        int end;
        int pos;
        char c;

        public Schedule(int start, int end, int pos) {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public char getC() {
            return c;
        }

        public void setC(char c) {
            this.c = c;
        }

        public int getPos() {
            return pos;
        }

        public void setPos(int pos) {
            this.pos = pos;
        }
    }

    Solution() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public void solve() {
        int t = nextInt();
        int index = 1;

        while (t-- > 0) {
            int N = nextInt();
            Schedule[] schedules = new Schedule[N];

            for (int itr = 0; itr < N; itr++) {
                schedules[itr] = new Schedule(nextInt(), nextInt(), itr);
            }

            Arrays.sort(schedules, (a,b) -> {
                if (a.getStart() == b.getStart()) return a.getEnd() - b.getEnd();

                return a.getStart() - b.getStart();
            });

            Map<Character, Schedule> schMap = new HashMap<>();
            boolean flag = true;

            for (int itr = 0; itr < N; itr ++) {
                if (checkChar('C', schMap, schedules[itr])) {
                    schMap.put('C', schedules[itr]);
                    schedules[itr].setC('C');
                } else if (checkChar('J', schMap, schedules[itr])) {
                    schMap.put('J', schedules[itr]);
                    schedules[itr].setC('J');
                } else {
                    flag = false;
                }
            }

            if (flag) {
                Arrays.sort(schedules, Comparator.comparingInt(Schedule::getPos));
                StringBuilder builder = new StringBuilder("");

                for (int itr = 0; itr < N; itr++) {
                    builder.append(schedules[itr].getC());
                }

                System.out.println("Case #"+index+": "+builder.toString());
            } else {
                System.out.println("Case #"+index+": IMPOSSIBLE");
            }

            index++;
        }
    }

    public static boolean checkChar(Character chr, Map<Character, Schedule> scheduleMap, Schedule cur) {
        if (!scheduleMap.containsKey(chr)) {
            return true;
        } else {
            Schedule schd = scheduleMap.get(chr);

            if (schd.getEnd() <= cur.getStart()) {
                return true;
            }
        }

        return false;

    }

    static final Random rng = new Random();

    static int rand(int l, int r) {
        return l + rng.nextInt(r - l + 1);
    }

    public static void main(String[] args) throws IOException {
        new Solution();
    }

    BufferedReader br;
    PrintWriter out;
    StringTokenizer st;

    String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return st.nextToken();
    }

    String nextString() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    int nextInt() {
        return Integer.parseInt(nextToken());
    }

    long nextLong() {
        return Long.parseLong(nextToken());
    }

    double nextDouble() {
        return Double.parseDouble(nextToken());
    }
}

    