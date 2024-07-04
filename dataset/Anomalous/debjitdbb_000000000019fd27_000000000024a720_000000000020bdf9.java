import java.util.*;
import java.io.*;

public class Scheduler {
    static class Task implements Comparable<Task> {
        int start;
        int end;
        int index;
        char assignedTo;

        Task(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
            this.assignedTo = 'A';
        }

        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.start, other.start);
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader(System.in);
        int testCases = reader.nextInt();
        StringBuilder result = new StringBuilder();

        for (int t = 1; t <= testCases; t++) {
            int numTasks = reader.nextInt();
            Task[] tasks = new Task[numTasks];

            for (int i = 0; i < numTasks; i++) {
                tasks[i] = new Task(reader.nextInt(), reader.nextInt(), i);
            }

            Arrays.sort(tasks);

            boolean possible = true;
            for (int i = 0; i < numTasks; i++) {
                int countC = 0;
                int countJ = 0;

                for (int j = 0; j < i; j++) {
                    if (tasks[j].end > tasks[i].start) {
                        if (tasks[j].assignedTo == 'C') {
                            countC++;
                        } else {
                            countJ++;
                        }
                    }
                }

                if (countC != 0 && countJ != 0) {
                    possible = false;
                    break;
                } else {
                    tasks[i].assignedTo = (countC == 0) ? 'C' : 'J';
                }
            }

            StringBuilder taskAssignment = new StringBuilder(numTasks);
            if (!possible) {
                taskAssignment.append("IMPOSSIBLE");
            } else {
                for (int i = 0; i < numTasks; i++) {
                    taskAssignment.append('A');
                }
                for (int i = 0; i < numTasks; i++) {
                    taskAssignment.setCharAt(tasks[i].index, tasks[i].assignedTo);
                }
            }

            result.append("Case #").append(t).append(": ").append(taskAssignment).append("\n");
        }

        System.out.print(result);
    }
}

class FastReader {
    private InputStream stream;
    private byte[] buffer = new byte[1024];
    private int currentChar;
    private int numChars;

    public FastReader(InputStream stream) {
        this.stream = stream;
    }

    private int read() {
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

    private int peek() {
        if (numChars == -1) {
            return -1;
        }
        if (currentChar >= numChars) {
            currentChar = 0;
            try {
                numChars = stream.read(buffer);
            } catch (IOException e) {
                return -1;
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buffer[currentChar];
    }

    public int nextInt() {
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

    public long nextLong() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sign = 1;
        if (c == '-') {
            sign = -1;
            c = read();
        }
        long result = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            result = result * 10 + (c - '0');
            c = read();
        } while (!isSpaceChar(c));
        return result * sign;
    }

    public String next() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder result = new StringBuilder();
        do {
            result.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return result.toString();
    }

    public String nextLine() {
        StringBuilder result = new StringBuilder();
        int c = read();
        while (c != '\n' && c != -1) {
            if (c != '\r') {
                result.appendCodePoint(c);
            }
            c = read();
        }
        return result.toString();
    }

    public double nextDouble() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sign = 1;
        if (c == '-') {
            sign = -1;
            c = read();
        }
        double result = 0;
        while (!isSpaceChar(c) && c != '.') {
            if (c == 'e' || c == 'E') {
                return result * Math.pow(10, nextInt());
            }
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            result = result * 10 + (c - '0');
            c = read();
        }
        if (c == '.') {
            c = read();
            double fraction = 1;
            while (!isSpaceChar(c)) {
                if (c == 'e' || c == 'E') {
                    return result * Math.pow(10, nextInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                fraction /= 10;
                result += (c - '0') * fraction;
                c = read();
            }
        }
        return result * sign;
    }

    public boolean hasNext() {
        int value;
        while (isSpaceChar(value = peek()) && value != -1) {
            read();
        }
        return value != -1;
    }

    private boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
}