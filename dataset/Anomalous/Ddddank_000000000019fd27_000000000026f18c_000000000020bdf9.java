import java.io.*;
import java.util.*;

class Activity implements Comparable<Activity> {
    public int start;
    public int end;
    public int id;

    public Activity(int start, int end, int id) {
        this.start = start;
        this.end = end;
        this.id = id;
    }

    @Override
    public int compareTo(Activity other) {
        if (this.start != other.start) return this.start - other.start;
        return this.end - other.end;
    }
}

public class Solution {
    public static Print print = new Print();
    public static Scan scan = new Scan();

    public static boolean overlap(int s1, int e1, int s2, int e2) {
        return !(e1 <= s2 || s1 >= e2);
    }

    public static void solve(Activity[] activities, int n, int t) throws Exception {
        Arrays.sort(activities);
        String[] result = new String[n];
        Stack<Activity> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            stack.push(activities[i]);
        }

        boolean impossible = false;
        Activity currentC = null;
        Activity currentJ = null;

        while (!stack.isEmpty()) {
            Activity temp = stack.pop();
            if (currentC == null) {
                result[temp.id] = "C";
                currentC = temp;
            } else if (currentJ == null) {
                result[temp.id] = "J";
                currentJ = temp;
            } else {
                if (overlap(currentC.start, currentC.end, temp.start, temp.end)) {
                    if (overlap(currentJ.start, currentJ.end, temp.start, temp.end)) {
                        impossible = true;
                        break;
                    } else {
                        currentJ = temp;
                        result[temp.id] = "J";
                    }
                } else {
                    currentC = temp;
                    result[temp.id] = "C";
                }
            }
        }

        if (impossible) {
            print.println("Case #" + t + ": IMPOSSIBLE");
        } else {
            StringBuilder finalResult = new StringBuilder();
            for (String res : result) {
                finalResult.append(res);
            }
            print.println("Case #" + t + ": " + finalResult);
        }
    }

    public static void main(String[] args) throws Exception {
        int t = scan.scanInt();
        for (int i = 0; i < t; i++) {
            int n = scan.scanInt();
            Activity[] activities = new Activity[n];
            for (int y = 0; y < n; y++) {
                int start = scan.scanInt();
                int end = scan.scanInt();
                activities[y] = new Activity(start, end, y);
            }
            solve(activities, n, i + 1);
        }
        print.close();
    }
}

class Scan {
    private byte[] buffer = new byte[1024];
    private int index;
    private InputStream in;
    private int total;

    public Scan() {
        in = System.in;
    }

    public int scan() throws IOException {
        if (total < 0) throw new InputMismatchException();
        if (index >= total) {
            index = 0;
            total = in.read(buffer);
            if (total <= 0) return -1;
        }
        return buffer[index++];
    }

    public int scanInt() throws IOException {
        int number = 0;
        int n = scan();
        while (isWhiteSpace(n)) n = scan();
        int negative = 1;
        if (n == '-') {
            negative = -1;
            n = scan();
        }
        while (!isWhiteSpace(n)) {
            if (n >= '0' && n <= '9') {
                number = number * 10 + (n - '0');
                n = scan();
            } else throw new InputMismatchException();
        }
        return negative * number;
    }

    public double scanDouble() throws IOException {
        double number = 0;
        int n = scan();
        while (isWhiteSpace(n)) n = scan();
        int negative = 1;
        if (n == '-') {
            negative = -1;
            n = scan();
        }
        while (!isWhiteSpace(n) && n != '.') {
            if (n >= '0' && n <= '9') {
                number = number * 10 + (n - '0');
                n = scan();
            } else throw new InputMismatchException();
        }
        if (n == '.') {
            n = scan();
            double fraction = 1;
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    fraction /= 10;
                    number += (n - '0') * fraction;
                    n = scan();
                } else throw new InputMismatchException();
            }
        }
        return number * negative;
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