import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        InputReader in = new InputReader(inputStream);
        ParentingSolver solver = new ParentingSolver();
        int testCases = Integer.parseInt(in.next());
        for (int i = 1; i <= testCases; i++) {
            solver.solve(i, in);
        }
    }

    static void printResult(String result) {
        System.out.println(result);
    }

    static class ParentingSolver {
        public void solve(int testCaseNumber, InputReader in) {
            StringBuilder result = new StringBuilder();
            int activitiesCount = in.readInt();
            boolean isPossible = true;
            int cEndTime = 0;
            int jEndTime = 0;
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < activitiesCount; i++) {
                int start = in.readInt();
                int end = in.readInt();
                activities.add(new Activity(i, start, end));
            }

            Collections.sort(activities, Comparator.comparingInt(a -> a.start));

            for (Activity activity : activities) {
                if (activity.start >= cEndTime) {
                    activity.assignTo("C");
                    cEndTime = activity.end;
                } else if (activity.start >= jEndTime) {
                    activity.assignTo("J");
                    jEndTime = activity.end;
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                activities.sort(Comparator.comparingInt(a -> a.position));
                for (Activity activity : activities) {
                    result.append(activity.assignedTo);
                }
            } else {
                result.append("IMPOSSIBLE");
            }

            printResult("Case #" + testCaseNumber + ": " + result.toString());
        }
    }

    static class Activity {
        int position;
        int start;
        int end;
        String assignedTo;

        Activity(int position, int start, int end) {
            this.position = position;
            this.start = start;
            this.end = end;
        }

        void assignTo(String person) {
            this.assignedTo = person;
        }
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;
        private SpaceCharFilter filter;

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
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder result = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    result.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return result.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public BigInteger readBigInteger() {
            try {
                return new BigInteger(readString());
            } catch (NumberFormatException e) {
                throw new InputMismatchException();
            }
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            boolean isSpaceChar(int ch);
        }
    }
}