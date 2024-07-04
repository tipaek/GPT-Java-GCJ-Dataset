import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    static char[] sol;

    public static void main(String[] args) throws Exception {
        InputReader in = new InputReader(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = in.readInt();
        
        for (int t = 0; t < tc; t++) {
            boolean isPossible = true;
            int n = in.readInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            sol = new char[n];
            Arrays.fill(sol, '#');
            HashSet<Integer>[] timeSlots = new HashSet[24 * 60 + 1];
            
            for (int i = 0; i < timeSlots.length; i++) {
                timeSlots[i] = new HashSet<>();
            }
            
            for (int i = 0; i < n; i++) {
                startTimes[i] = in.readInt();
                endTimes[i] = in.readInt();
                for (int j = startTimes[i] + 1; j <= endTimes[i]; j++) {
                    timeSlots[j].add(i);
                    if (timeSlots[j].size() >= 3) {
                        isPossible = false;
                    }
                }
            }
            
            if (isPossible) {
                boolean toggle = true;
                for (HashSet<Integer> slot : timeSlots) {
                    boolean setFlag = false;
                    for (int id : slot) {
                        if (sol[id] != '#') {
                            continue;
                        }
                        setFlag = true;
                        sol[id] = toggle ? 'C' : 'J';
                    }
                    if (!slot.isEmpty() && setFlag) {
                        toggle = !toggle;
                    }
                }
                out.write("Case #" + (t + 1) + ": " + new String(sol));
            } else {
                out.write("Case #" + (t + 1) + ": IMPOSSIBLE");
            }
            out.newLine();
        }
        out.close();
    }
}

class InputReader {
    private InputStream stream;
    private byte[] buffer = new byte[1024];
    private int currentChar;
    private int numChars;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (numChars == -1) {
            throw new InputMismatchException();
        }
        if (currentChar >= numChars) {
            currentChar = 0;
            try {
                numChars = stream.read(buffer);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buffer[currentChar++];
    }

    public int readInt() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sign = 1;
        if (c == '-') {
            sign = -1;
            c = read();
        }
        int result = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            result = result * 10 + (c - '0');
            c = read();
        } while (!isSpaceChar(c));
        return result * sign;
    }

    public String readString() {
        int length = readInt();
        if (length < 0) {
            return null;
        }
        byte[] bytes = new byte[length];
        for (int i = 0; i < length; i++) {
            bytes[i] = (byte) read();
        }
        try {
            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return new String(bytes);
        }
    }

    public static boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
}