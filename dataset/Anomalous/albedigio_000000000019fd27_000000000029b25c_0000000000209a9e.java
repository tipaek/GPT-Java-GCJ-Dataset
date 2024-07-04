import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Solution {

    private static class InputReader {
        private InputStream stream;
        private byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;
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
                result = result * 10 + c - '0';
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
                result.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return result.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            boolean isSpaceChar(int ch);
        }
    }

    static class Util {
        ArrayList<Integer> indexesGroup1 = new ArrayList<>();
        ArrayList<Integer> indexesGroup2 = new ArrayList<>();
    }

    public static void main(String[] args) throws Exception {
        InputReader in = new InputReader(System.in);
        int testCases = in.readInt();
        int b = in.readInt();

        for (int i = 0; i < testCases; i++) {
            Character[] arr = new Character[b];
            ArrayList<Util> utils = new ArrayList<>();
            ArrayList<Integer> allEqualsOffsets = new ArrayList<>();
            int offset = 0;

            while (offset < b / 2) {
                processQueries(b, offset, arr, utils, allEqualsOffsets, in);
                offset += 5;
            }

            handleAllEquals(b, arr, allEqualsOffsets, in);
            handleUtils(b, arr, utils, in);

            StringBuilder answer = new StringBuilder(b);
            for (int j = 0; j < b; j++) {
                answer.append(arr[j]);
            }
            System.out.println(answer.toString());

            String result = in.readString();
            if (result.equals("N")) throw new Exception();
        }
    }

    private static void processQueries(int b, int offset, Character[] arr, ArrayList<Util> utils,
                                       ArrayList<Integer> allEqualsOffsets, InputReader in) throws Exception {
        int startEqual = -1;
        int startDiff = -1;
        ArrayList<Integer> startOneCouples = new ArrayList<>();
        ArrayList<Integer> startZeroCouples = new ArrayList<>();

        for (int i = offset; i < 5 + offset; i++) {
            int index1 = i + 1;
            int index2 = b - i;

            System.out.println(index1);
            String s1 = in.readString();
            validateResponse(s1);

            arr[i] = s1.equals("1") ? '1' : '0';
            if (arr[i] == '1') {
                startOneCouples.add(i);
            } else {
                startZeroCouples.add(i);
            }

            System.out.println(index2);
            String s2 = in.readString();
            validateResponse(s2);

            arr[b - i - 1] = s2.equals("1") ? '1' : '0';
            if (arr[b - i - 1] == '1') {
                startOneCouples.add(b - i - 1);
            } else {
                startZeroCouples.add(b - i - 1);
            }

            if (!arr[i].equals(arr[b - i - 1])) {
                startDiff = i;
            } else {
                startEqual = i;
            }
        }

        if (startDiff != -1 && startEqual != -1) {
            performQuanticMutation(b, arr, startEqual, startDiff, in);
        } else if (startOneCouples.size() == 10 || startOneCouples.size() == 0) {
            allEqualsOffsets.add(offset);
        } else {
            Util util = new Util();
            util.indexesGroup1.addAll(startOneCouples);
            util.indexesGroup2.addAll(startZeroCouples);
            utils.add(util);
        }
    }

    private static void validateResponse(String response) throws Exception {
        if (response.equals("N")) {
            throw new Exception();
        }
    }

    private static void performQuanticMutation(int b, Character[] arr, int startEqual, int startDiff, InputReader in) throws Exception {
        System.out.println(startEqual + 1);
        String s1 = in.readString();
        validateResponse(s1);

        System.out.println(b - startEqual);
        String s2 = in.readString();
        validateResponse(s2);

        System.out.println(startDiff + 1);
        String s3 = in.readString();
        validateResponse(s3);

        System.out.println(b - startDiff);
        String s4 = in.readString();
        validateResponse(s4);

        if (s1.charAt(0) != arr[startEqual] && s2.charAt(0) != arr[b - startEqual - 1] &&
                s3.charAt(0) == arr[b - startDiff - 1] && s4.charAt(0) == arr[startDiff]) {
            complementArray(b, arr);
        } else if (s1.charAt(0) == arr[startEqual] && s2.charAt(0) == arr[b - startEqual - 1] &&
                s3.charAt(0) == arr[b - startDiff - 1] && s4.charAt(0) == arr[startDiff]) {
            swapArray(b, arr);
        } else if (s1.charAt(0) != arr[startEqual] && s2.charAt(0) != arr[b - startEqual - 1] &&
                s3.charAt(0) == arr[startDiff] && s4.charAt(0) == arr[b - startDiff - 1]) {
            complementArray(b, arr);
            swapArray(b, arr);
        }
    }

    private static void complementArray(int b, Character[] arr) {
        for (int i = 0; i < b; i++) {
            arr[i] = arr[i] == '1' ? '0' : '1';
        }
    }

    private static void swapArray(int b, Character[] arr) {
        for (int i = 0; i < b / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[b - i - 1];
            arr[b - i - 1] = temp;
        }
    }

    private static void handleAllEquals(int b, Character[] arr, ArrayList<Integer> allEqualsOffsets, InputReader in) throws Exception {
        for (int offset : allEqualsOffsets) {
            System.out.println(offset + 1);
            String s = in.readString();
            validateResponse(s);

            for (int k = offset; k < 5 + offset; k++) {
                arr[k] = s.charAt(0);
                arr[b - k - 1] = s.charAt(0);
            }
        }
    }

    private static void handleUtils(int b, Character[] arr, ArrayList<Util> utils, InputReader in) throws Exception {
        for (Util util : utils) {
            System.out.println(util.indexesGroup1.get(0) + 1);
            String s = in.readString();
            validateResponse(s);

            for (int index : util.indexesGroup1) {
                arr[index] = s.charAt(0);
            }

            char complementChar = s.charAt(0) == '1' ? '0' : '1';
            for (int index : util.indexesGroup2) {
                arr[index] = complementChar;
            }
        }
    }
}