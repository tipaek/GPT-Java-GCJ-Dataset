import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Solution {

    public static void main(String[] args) {
        InputReader inputReader = new InputReader(System.in);
        int testCases = inputReader.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            processTestCase(inputReader, caseNumber);
        }
    }

    private static void processTestCase(InputReader inputReader, int caseNumber) {
        int activityCount = inputReader.nextInt();
        Activity[] activities = new Activity[activityCount];

        for (int i = 0; i < activityCount; ++i) {
            activities[i] = new Activity(inputReader.nextInt(), inputReader.nextInt());
        }

        Arrays.sort(activities);

        Activity cameronActivity = activities[0];
        Activity jamieActivity = null;

        StringBuilder schedule = new StringBuilder().append('C');

        for (int i = 1; i < activityCount; ++i) {
            if (cameronActivity.overlaps(activities[i])) {
                if (jamieActivity == null || !jamieActivity.overlaps(activities[i])) {
                    schedule.append('J');
                    jamieActivity = activities[i];
                } else {
                    System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                    return;
                }
            } else {
                schedule.append('C');
                cameronActivity = activities[i];
            }
        }

        System.out.println("Case #" + caseNumber + ": " + schedule.toString());
    }

    static class Activity implements Comparable<Activity> {
        int start;
        int end;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        boolean overlaps(Activity other) {
            return !(this.start >= other.end || other.start >= this.end);
        }

        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.start, other.start);
        }

        @Override
        public String toString() {
            return "Activity{" + "start=" + start + ", end=" + end + '}';
        }
    }

    static class InputReader {
        private final InputStream stream;
        private final byte[] buffer = new byte[8192];
        private int currentChar, numChars;
        private SpaceCharFilter filter;

        InputReader(InputStream stream) {
            this.stream = stream;
        }

        int next() {
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

        int nextInt() {
            int character = next();
            while (isSpaceChar(character)) {
                character = next();
            }
            int sign = 1;
            if (character == '-') {
                sign = -1;
                character = next();
            }
            int result = 0;
            do {
                if (character < '0' || character > '9') {
                    throw new InputMismatchException();
                }
                result *= 10;
                result += character - '0';
                character = next();
            } while (!isSpaceChar(character));
            return result * sign;
        }

        long nextLong() {
            int character = next();
            while (isSpaceChar(character)) {
                character = next();
            }
            int sign = 1;
            if (character == '-') {
                sign = -1;
                character = next();
            }
            long result = 0;
            do {
                if (character < '0' || character > '9') {
                    throw new InputMismatchException();
                }
                result *= 10;
                result += character - '0';
                character = next();
            } while (!isSpaceChar(character));
            return result * sign;
        }

        int[] nextIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = nextInt();
            }
            return array;
        }

        long[] nextLongArray(int size) {
            long[] array = new long[size];
            for (int i = 0; i < size; i++) {
                array[i] = nextLong();
            }
            return array;
        }

        String readString() {
            int character = next();
            while (isSpaceChar(character)) {
                character = next();
            }
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(character);
                character = next();
            } while (!isSpaceChar(character));
            return result.toString();
        }

        String nextLine() {
            int character = next();
            while (isSpaceChar(character)) {
                character = next();
            }
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(character);
                character = next();
            } while (!isEndOfLine(character));
            return result.toString();
        }

        boolean isSpaceChar(int character) {
            if (filter != null) {
                return filter.isSpaceChar(character);
            }
            return character == ' ' || character == '\n' || character == '\r' || character == '\t' || character == -1;
        }

        private boolean isEndOfLine(int character) {
            return character == '\n' || character == '\r' || character == -1;
        }

        interface SpaceCharFilter {
            boolean isSpaceChar(int character);
        }
    }
}