import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Solution {

    private static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res = res * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
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

    static int[] processQueries(int b, int offset, Character[] arr, int[] ss, ArrayList<ArrayList<Integer>> startOneCouplesSlices, InputReader in) throws Exception {
        int startEqual = -1;
        int startDiff = -1;
        ArrayList<Integer> startOneCouples = new ArrayList<>();
        for (int i = offset; i < 5 + offset; i++) {
            System.out.println(i + 1);
            String s = in.readString();
            if (s.equals("N")) {
                throw new Exception();
            }
            arr[i] = s.equals("1") ? '1' : '0';
            if (arr[i] == '1') {
                startOneCouples.add(i);
            }
            System.out.println(b - i);
            s = in.readString();
            if (s.equals("N")) {
                throw new Exception();
            }
            arr[b - i - 1] = s.equals("1") ? '1' : '0';
            if (arr[b - i - 1] == '1') {
                startOneCouples.add(b - i - 1);
            }
            if (!arr[i].equals(arr[b - i - 1])) {
                startDiff = i;
            } else {
                startEqual = i;
            }
        }

        if (startDiff != -1 && startEqual != -1) {
            handleQuanticMutation(b, arr, startEqual, startDiff, in);
            return new int[]{startEqual, startDiff};
        } else if (startOneCouples.size() == 5 || startOneCouples.isEmpty()) {
            handleUniformCouples(b, arr, ss, startOneCouplesSlices, in, offset);
            return ss;
        } else {
            handleDifferentCouples(b, arr, ss, startOneCouplesSlices, in, startOneCouples);
            return ss;
        }
    }

    private static void handleQuanticMutation(int b, Character[] arr, int startEqual, int startDiff, InputReader in) throws Exception {
        System.out.println(startEqual + 1);
        String s1 = in.readString();
        if (s1.equals("N")) {
            throw new Exception();
        }
        System.out.println(b - startEqual);
        String s2 = in.readString();
        if (s2.equals("N")) {
            throw new Exception();
        }
        System.out.println(startDiff + 1);
        String s3 = in.readString();
        if (s3.equals("N")) {
            throw new Exception();
        }
        System.out.println(b - startDiff);
        String s4 = in.readString();
        if (s4.equals("N")) {
            throw new Exception();
        }
        applyQuanticMutation(b, arr, startEqual, startDiff, s1, s2, s3, s4);
    }

    private static void handleUniformCouples(int b, Character[] arr, int[] ss, ArrayList<ArrayList<Integer>> startOneCouplesSlices, InputReader in, int offset) throws Exception {
        if (ss != null && ss[0] != -1 && ss[1] != -1) {
            applyQuanticMutation(b, arr, ss[0], ss[1], in);
        }
        System.out.println(offset + 1);
        String s1 = in.readString();
        if (s1.equals("N")) {
            throw new Exception();
        }
        for (int i = offset; i < 5 + offset; i++) {
            arr[i] = s1.charAt(0);
            arr[b - i - 1] = s1.charAt(0);
        }
        startOneCouplesSlices.add(new ArrayList<>());
    }

    private static void handleDifferentCouples(int b, Character[] arr, int[] ss, ArrayList<ArrayList<Integer>> startOneCouplesSlices, InputReader in, ArrayList<Integer> startOneCouples) throws Exception {
        if (ss != null && ss[0] != -1 && ss[1] != -1) {
            applyQuanticMutation(b, arr, ss[0], ss[1], in);
        }
        System.out.println(startOneCouples.get(0) + 1);
        String s1 = in.readString();
        if (s1.equals("N")) {
            throw new Exception();
        }
        if (arr[startOneCouples.get(0)] != s1.charAt(0)) {
            for (int i = 0; i < b; i++) {
                arr[i] = arr[i] == '1' ? '0' : '1';
                arr[b - i - 1] = arr[b - i - 1] == '1' ? '0' : '1';
            }
        }
        startOneCouplesSlices.add(startOneCouples);
    }

    private static void applyQuanticMutation(int b, Character[] arr, int startEqual, int startDiff, String s1, String s2, String s3, String s4) {
        if (s1.charAt(0) != arr[startEqual] && s2.charAt(0) != arr[b - startEqual - 1] && s3.charAt(0) == arr[b - startDiff - 1] && s4.charAt(0) == arr[startDiff]) {
            for (int i = 0; i < b; i++) {
                arr[i] = arr[i] == '1' ? '0' : '1';
                arr[b - i - 1] = arr[b - i - 1] == '1' ? '0' : '1';
            }
        } else if (s1.charAt(0) == arr[startEqual] && s2.charAt(0) == arr[b - startEqual - 1] && s3.charAt(0) == arr[b - startDiff - 1] && s4.charAt(0) == arr[startDiff]) {
            for (int i = 0; i < b; i++) {
                char tmp = arr[i];
                arr[i] = arr[b - i - 1];
                arr[b - i - 1] = tmp;
            }
        } else if (s1.charAt(0) != arr[startEqual] && s2.charAt(0) != arr[b - startEqual - 1] && s3.charAt(0) == arr[startDiff] && s4.charAt(0) == arr[b - startDiff - 1]) {
            for (int i = 0; i < b; i++) {
                arr[i] = arr[i] == '1' ? '0' : '1';
                arr[b - i - 1] = arr[b - i - 1] == '1' ? '0' : '1';
            }
            for (int i = 0; i < b; i++) {
                char tmp = arr[i];
                arr[i] = arr[b - i - 1];
                arr[b - i - 1] = tmp;
            }
        }
    }

    private static void applyQuanticMutation(int b, Character[] arr, int startEqual, int startDiff, InputReader in) throws Exception {
        System.out.println(startEqual + 1);
        String s1 = in.readString();
        if (s1.equals("N")) {
            throw new Exception();
        }
        System.out.println(b - startEqual);
        String s2 = in.readString();
        if (s2.equals("N")) {
            throw new Exception();
        }
        System.out.println(startDiff + 1);
        String s3 = in.readString();
        if (s3.equals("N")) {
            throw new Exception();
        }
        System.out.println(b - startDiff);
        String s4 = in.readString();
        if (s4.equals("N")) {
            throw new Exception();
        }
        applyQuanticMutation(b, arr, startEqual, startDiff, s1, s2, s3, s4);
    }

    public static void main(String[] args) throws Exception {
        InputReader in = new InputReader(System.in);
        int test = in.readInt();
        int b = in.readInt();

        for (int i = 0; i < test; i++) {
            Character[] arr = new Character[b];
            int[] starts = new int[]{-1, -1};
            ArrayList<ArrayList<Integer>> startOneCouplesSlices = new ArrayList<>();
            int offset = 0;
            while (offset < b / 2) {
                starts = processQueries(b, offset, arr, starts, startOneCouplesSlices, in);
                offset += 5;
            }
            StringBuilder ans = new StringBuilder(b);
            for (Character c : arr) {
                ans.append(c);
            }
            System.out.println(ans.toString());
            String res = in.readString();
            if (res.equals("N")) throw new Exception();
        }
    }
}