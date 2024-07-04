import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputReader in = new InputReader(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = in.readInt();
        for (int t = 0; t < tc; t++) {
            boolean isPossible = true;
            int n = in.readInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            char[] schedule = new char[n];
            Arrays.fill(schedule, '#');
            Set<Integer>[] timeSlots = new HashSet[24 * 60 + 1];
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
                char[] assigned = new char[timeSlots.length];
                Arrays.fill(assigned, '#');
                for (int i = 0; i < timeSlots.length; i++) {
                    char previous = '#';
                    for (int j = i - 1; j >= 0; j--) {
                        if (assigned[j] != '#') {
                            previous = assigned[j];
                            break;
                        }
                    }
                    if (timeSlots[i].isEmpty()) continue;
                    char current = previous == '#' ? 'J' : 'C';
                    Iterator<Integer> iterator = timeSlots[i].iterator();
                    int firstId = iterator.next();
                    if (timeSlots[i].size() > 1) {
                        int secondId = iterator.next();
                        char next = current == 'C' ? 'J' : 'C';
                        schedule[firstId] = current;
                        schedule[secondId] = next;
                        for (int j = startTimes[firstId]; j < endTimes[firstId]; j++) {
                            assigned[j] = current;
                        }
                        for (int j = startTimes[secondId]; j < endTimes[secondId]; j++) {
                            assigned[j] = next;
                        }
                    } else {
                        schedule[firstId] = current;
                        for (int j = startTimes[firstId]; j < endTimes[firstId]; j++) {
                            assigned[j] = current;
                        }
                    }
                }
                out.write("Case #" + (t + 1) + ": " + new String(schedule));
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
    private int numberOfChars;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    private int read() {
        if (numberOfChars == -1) throw new InputMismatchException();
        if (currentChar >= numberOfChars) {
            currentChar = 0;
            try {
                numberOfChars = stream.read(buffer);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numberOfChars <= 0) return -1;
        }
        return buffer[currentChar++];
    }

    public int readInt() {
        int character = read();
        while (isSpaceChar(character)) character = read();
        int sign = 1;
        if (character == '-') {
            sign = -1;
            character = read();
        }
        int result = 0;
        do {
            if (character < '0' || character > '9') throw new InputMismatchException();
            result *= 10;
            result += character - '0';
            character = read();
        } while (!isSpaceChar(character));
        return result * sign;
    }

    private static boolean isSpaceChar(int character) {
        return character == ' ' || character == '\n' || character == '\r' || character == '\t' || character == -1;
    }
}