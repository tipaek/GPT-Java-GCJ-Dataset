import java.io.*;
import java.util.*;

public class Solution {
    public static Print print = new Print();
    public static Scan scan = new Scan();

    public static void solve(String s, int t) throws Exception {
        Stack<Character> stack = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            stack.push(s.charAt(i));
        }

        StringBuilder ans = new StringBuilder();
        int nOpen = 0;

        while (!stack.isEmpty()) {
            char temp = stack.pop();
            int num = Character.getNumericValue(temp);

            if (nOpen < num) {
                for (int i = 0; i < num - nOpen; i++) {
                    ans.append('(');
                }
                nOpen = num;
            } else {
                for (int i = 0; i < nOpen - num; i++) {
                    ans.append(')');
                }
                nOpen = num;
            }
            ans.append(num);
        }

        for (int i = 0; i < nOpen; i++) {
            ans.append(')');
        }

        print.println("Case #" + (t + 1) + ": " + ans.toString());
    }

    public static void main(String[] args) throws Exception {
        int t = scan.scanInt();
        for (int i = 0; i < t; i++) {
            String s = scan.scanString();
            solve(s, i);
        }
        print.close();
    }
}

class Scan {
    private byte[] buf = new byte[1024];
    private int index;
    private InputStream in;
    private int total;

    public Scan() {
        in = System.in;
    }

    public int scan() throws IOException {
        if (total < 0)
            throw new InputMismatchException();
        if (index >= total) {
            index = 0;
            total = in.read(buf);
            if (total <= 0)
                return -1;
        }
        return buf[index++];
    }

    public int scanInt() throws IOException {
        int integer = 0;
        int n = scan();
        while (isWhiteSpace(n))
            n = scan();
        int neg = 1;
        if (n == '-') {
            neg = -1;
            n = scan();
        }
        while (!isWhiteSpace(n)) {
            if (n >= '0' && n <= '9') {
                integer = integer * 10 + (n - '0');
                n = scan();
            } else {
                throw new InputMismatchException();
            }
        }
        return neg * integer;
    }

    public double scanDouble() throws IOException {
        double doub = 0;
        int n = scan();
        while (isWhiteSpace(n))
            n = scan();
        int neg = 1;
        if (n == '-') {
            neg = -1;
            n = scan();
        }
        while (!isWhiteSpace(n) && n != '.') {
            if (n >= '0' && n <= '9') {
                doub = doub * 10 + (n - '0');
                n = scan();
            } else {
                throw new InputMismatchException();
            }
        }
        if (n == '.') {
            n = scan();
            double temp = 1;
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    temp /= 10;
                    doub += (n - '0') * temp;
                    n = scan();
                } else {
                    throw new InputMismatchException();
                }
            }
        }
        return doub * neg;
    }

    public String scanString() throws IOException {
        StringBuilder sb = new StringBuilder();
        int n = scan();
        while (isWhiteSpace(n))
            n = scan();
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