import java.io.*;
import java.util.*;

class Activity {
    public int start;
    public int end;

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Solution {
    public static Print print = new Print();
    public static Scan scan = new Scan();

    public static boolean overlap(int s1, int e1, int s2, int e2) {
        return !(e1 <= s2 || s1 >= e2);
    }

    public static void solve(Activity[] activities, int n, int t) throws Exception {
        List<Activity> carla = new ArrayList<>();
        List<Activity> jack = new ArrayList<>();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int start = activities[i].start;
            int end = activities[i].end;
            boolean canAssignToCarla = true;

            for (Activity act : carla) {
                if (overlap(start, end, act.start, act.end)) {
                    canAssignToCarla = false;
                    break;
                }
            }

            if (canAssignToCarla) {
                carla.add(new Activity(start, end));
                ans.append("C");
            } else {
                boolean canAssignToJack = true;
                for (Activity act : jack) {
                    if (overlap(start, end, act.start, act.end)) {
                        canAssignToJack = false;
                        break;
                    }
                }

                if (canAssignToJack) {
                    jack.add(new Activity(start, end));
                    ans.append("J");
                } else {
                    ans = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
        }

        print.println("Case #" + t + ": " + ans.toString());
    }

    public static void main(String[] args) throws Exception {
        int t = scan.scanInt();
        for (int i = 0; i < t; i++) {
            int n = scan.scanInt();
            Activity[] activities = new Activity[n];
            for (int y = 0; y < n; y++) {
                int t1 = scan.scanInt();
                int t2 = scan.scanInt();
                activities[y] = new Activity(t1, t2);
            }
            solve(activities, n, i + 1);
        }
        print.close();
    }
}

class Scan {
    private final byte[] buf = new byte[1024];
    private int index;
    private int total;
    private final InputStream in;

    public Scan() {
        in = System.in;
    }

    public int scan() throws IOException {
        if (total < 0) throw new InputMismatchException();
        if (index >= total) {
            index = 0;
            total = in.read(buf);
            if (total <= 0) return -1;
        }
        return buf[index++];
    }

    public int scanInt() throws IOException {
        int integer = 0;
        int n = scan();
        while (isWhiteSpace(n)) n = scan();
        int neg = 1;
        if (n == '-') {
            neg = -1;
            n = scan();
        }
        while (!isWhiteSpace(n)) {
            if (n >= '0' && n <= '9') {
                integer = integer * 10 + (n - '0');
                n = scan();
            } else throw new InputMismatchException();
        }
        return neg * integer;
    }

    public double scanDouble() throws IOException {
        double doub = 0;
        int n = scan();
        while (isWhiteSpace(n)) n = scan();
        int neg = 1;
        if (n == '-') {
            neg = -1;
            n = scan();
        }
        while (!isWhiteSpace(n) && n != '.') {
            if (n >= '0' && n <= '9') {
                doub = doub * 10 + (n - '0');
                n = scan();
            } else throw new InputMismatchException();
        }
        if (n == '.') {
            n = scan();
            double temp = 1;
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    temp /= 10;
                    doub += (n - '0') * temp;
                    n = scan();
                } else throw new InputMismatchException();
            }
        }
        return doub * neg;
    }

    public String scanString() throws IOException {
        StringBuilder sb = new StringBuilder();
        int n = scan();
        while (isWhiteSpace(n)) n = scan();
        while (!isWhiteSpace(n)) {
            sb.append((char) n);
            n = scan();
        }
        return sb.toString();
    }

    private boolean isWhiteSpace(int n) {
        return n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1;
    }
}

class Print {
    private final BufferedWriter bw;

    public Print() {
        this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public void print(Object object) throws IOException {
        bw.append(String.valueOf(object));
    }

    public void println(Object object) throws IOException {
        print(object);
        bw.append("\n");
    }

    public void close() throws IOException {
        bw.close();
    }
}