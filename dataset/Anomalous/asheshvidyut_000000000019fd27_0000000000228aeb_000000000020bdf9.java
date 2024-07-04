import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputReader in = new InputReader(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCases = in.readInt();

        for (int t = 0; t < testCases; t++) {
            boolean isPossible = true;
            int n = in.readInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            char[] assignments = new char[n];
            Arrays.fill(assignments, '#');
            HashSet<Integer>[] timeSlots = new HashSet[24 * 60 + 1];

            for (int i = 0; i < timeSlots.length; i++) {
                timeSlots[i] = new HashSet<>();
            }

            for (int i = 0; i < n; i++) {
                startTimes[i] = in.readInt();
                endTimes[i] = in.readInt();
                for (int j = startTimes[i]; j < endTimes[i]; j++) {
                    timeSlots[j].add(i);
                    if (timeSlots[j].size() >= 3) {
                        isPossible = false;
                    }
                }
            }

            if (isPossible) {
                assignTasks(n, assignments, timeSlots);
                out.write("Case #" + (t + 1) + ": " + new String(assignments));
            } else {
                out.write("Case #" + (t + 1) + ": IMPOSSIBLE");
            }
            out.newLine();
        }
        out.close();
    }

    private static void assignTasks(int n, char[] assignments, HashSet<Integer>[] timeSlots) {
        for (int i = 0; i < timeSlots.length; i++) {
            if (timeSlots[i].size() >= 2) {
                Iterator<Integer> iterator = timeSlots[i].iterator();
                int id1 = iterator.next();
                int id2 = iterator.next();
                if (assignments[id1] == '#' && assignments[id2] == '#') {
                    assignments[id1] = 'C';
                    assignments[id2] = 'J';
                } else if (assignments[id1] == '#') {
                    assignments[id1] = (assignments[id2] == 'C') ? 'J' : 'C';
                } else if (assignments[id2] == '#') {
                    assignments[id2] = (assignments[id1] == 'C') ? 'J' : 'C';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (assignments[i] != '#') continue;
            char previousAssignment = '#';
            for (int j = i - 1; j >= 0; j--) {
                if (assignments[j] != '#') {
                    previousAssignment = assignments[j];
                    break;
                }
            }
            assignments[i] = (previousAssignment == 'C') ? 'J' : 'C';
        }
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
        if (numChars == -1) throw new InputMismatchException();
        if (currentChar >= numChars) {
            currentChar = 0;
            try {
                numChars = stream.read(buffer);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0) return -1;
        }
        return buffer[currentChar++];
    }

    public int readInt() {
        int c = read();
        while (isSpaceChar(c)) c = read();
        int sign = 1;
        if (c == '-') {
            sign = -1;
            c = read();
        }
        int result = 0;
        do {
            if (c < '0' || c > '9') throw new InputMismatchException();
            result = result * 10 + (c - '0');
            c = read();
        } while (!isSpaceChar(c));
        return result * sign;
    }

    public static boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
}