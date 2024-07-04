import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Solution {

    public static void main(String[] args) {
        InputReader inputReader = new InputReader(System.in);
        int testCases = inputReader.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            handleTestCase(inputReader, i);
        }
    }

    private static void handleTestCase(InputReader inputReader, int caseNumber) {
        int n = inputReader.nextInt();
        Activity[] activities = new Activity[n];
        
        for (int i = 0; i < n; ++i) {
            activities[i] = new Activity(inputReader.nextInt(), inputReader.nextInt());
        }
        
        Activity cameronActivity = activities[0];
        Activity jamieActivity = null;
        
        StringBuilder schedule = new StringBuilder().append('C');
        
        for (int i = 1; i < n; ++i) {
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
        
        public InputReader(InputStream stream) {
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
        
        public int nextInt() {
            int character = read();
            while (isSpaceChar(character)) {
                character = read();
            }
            int sign = 1;
            if (character == '-') {
                sign = -1;
                character = read();
            }
            int result = 0;
            do {
                if (character < '0' || character > '9') {
                    throw new InputMismatchException();
                }
                result = result * 10 + character - '0';
                character = read();
            } while (!isSpaceChar(character));
            return result * sign;
        }
        
        public long nextLong() {
            int character = read();
            while (isSpaceChar(character)) {
                character = read();
            }
            int sign = 1;
            if (character == '-') {
                sign = -1;
                character = read();
            }
            long result = 0;
            do {
                if (character < '0' || character > '9') {
                    throw new InputMismatchException();
                }
                result = result * 10 + character - '0';
                character = read();
            } while (!isSpaceChar(character));
            return result * sign;
        }
        
        public int[] nextIntArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextInt();
            }
            return array;
        }
        
        public long[] nextLongArray(int n) {
            long[] array = new long[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextLong();
            }
            return array;
        }
        
        public String readString() {
            int character = read();
            while (isSpaceChar(character)) {
                character = read();
            }
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(character);
                character = read();
            } while (!isSpaceChar(character));
            return result.toString();
        }
        
        public String nextLine() {
            int character = read();
            while (isSpaceChar(character)) {
                character = read();
            }
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(character);
                character = read();
            } while (!isEndOfLine(character));
            return result.toString();
        }
        
        private boolean isSpaceChar(int character) {
            if (filter != null) {
                return filter.isSpaceChar(character);
            }
            return character == ' ' || character == '\n' || character == '\r' || character == '\t' || character == -1;
        }
        
        private boolean isEndOfLine(int character) {
            return character == '\n' || character == '\r' || character == -1;
        }
        
        public interface SpaceCharFilter {
            boolean isSpaceChar(int character);
        }
    }
}