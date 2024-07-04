
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
                res *= 10;
                res += c - '0';
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

        public double readDouble() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, readInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return res * Math.pow(10, readInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public long readLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }

    static class Util {
        ArrayList<Integer> indexesGroup1;
        ArrayList<Integer> indexesGroup2;
    }

    static void queries(int b, int offset, Character arr[], ArrayList<Util> utils,
                        ArrayList<Integer> allEqualsOffsets, InputReader in) throws Exception {
        int startEqual = -1;
        int startDiff = -1;
        ArrayList<Integer> startOneCouples = new ArrayList<>();
        ArrayList<Integer> startZeroCouples = new ArrayList<>();
        for (int i = offset; i < 5 + offset; i++) {
            System.out.println(i+1);
            String s = in.readString();
            if (s.equals("N")) {
                throw new Exception();
            }
            if (s.equals("1")) {
                arr[i] = '1';
            } else {
                arr[i] = '0';
            }
            if (arr[i] == '1') {
                startOneCouples.add(i);
            } else {
                startZeroCouples.add(i);
            }
            System.out.println(b - i);
            s = in.readString();
            if (s.equals("N")) {
                throw new Exception();
            }
            if (s.equals("1")) {
                arr[b - i - 1] = '1';
            } else {
                arr[b - i - 1] = '0';
            }
            if (arr[b - i - 1] == '1') {
                startOneCouples.add(b - i - 1);
            } else {
                startZeroCouples.add(b - i - 1);
            }
            if (arr[i] != arr[b - i - 1]) {
                startDiff = i;
            } else if (arr[i] == arr[b - i - 1]) {
                startEqual = i;
            }
        }

        if (startDiff != -1 && startEqual != -1) {
            System.out.println(startEqual+1);
            String s1 = in.readString();
            if (s1.equals("N")) {
                throw new Exception();
            }
            System.out.println(b - startEqual);
            String s2 = in.readString();
            if (s2.equals("N")) {
                throw new Exception();
            }

            System.out.println(startDiff+1);
            String s3 = in.readString();
            if (s3.equals("N")) {
                throw new Exception();
            }
            System.out.println(b - startDiff);
            String s4 = in.readString();
            if (s4.equals("N")) {
                throw new Exception();
            }

            quanticMutation(b, arr, startEqual, startDiff, s1, s2, s3, s4);
        } else if (startOneCouples.size() == 10 || startOneCouples.size() == 0) {
            //tutti uguali
            allEqualsOffsets.add(offset);
        } else {
            //in coppia uguali ma coppie diverse
            Util util = new Util();
            util.indexesGroup1 = startOneCouples;
            util.indexesGroup2 = startZeroCouples;
            utils.add(util);
        }

    }

    private static void quanticMutation(int b, Character[] arr, int startEqual, int startDiff, String s1, String s2, String s3, String s4) {
        if (s1.charAt(0) != arr[startEqual] && s2.charAt(0) != arr[b - startEqual - 1] && s3.charAt(0) == arr[b - startDiff - 1] && s4.charAt(0) == arr[startDiff]) {
            // complemento
            for (int i = 0; i < b; i++) {
                if (arr[i] == '1') {
                    arr[i] = '0';
                } else {
                    arr[i] = '1';
                }
                if (arr[b - i - 1] == '1') {
                    arr[b - i - 1] = '0';
                } else {
                    arr[b - i - 1] = '1';
                }
            }
        } else if (s1.charAt(0) == arr[startEqual] && s2.charAt(0) == arr[b - startEqual - 1] && s3.charAt(0) == arr[b - startDiff - 1] && s4.charAt(0) == arr[startDiff]) {
            // swap
            for (int i = 0; i < b; i++) {
                char tmp = arr[i];
                arr[i] = arr[b - 1 - 1];
                arr[b - 1 - 1] = tmp;
            }
        } else if (s1.charAt(0) != arr[startEqual] && s2.charAt(0) != arr[b - startEqual - 1] && s3.charAt(0) == arr[startDiff] && s4.charAt(0) == arr[b - startDiff - 1]) {
            // complemento e swap
            for (int i = 0; i < b; i++) {
                if (arr[i] == '1') {
                    arr[i] = '0';
                } else {
                    arr[i] = '1';
                }
                if (arr[b - i - 1] == '1') {
                    arr[b - i - 1] = '0';
                } else {
                    arr[b - i - 1] = '1';
                }
            }
            for (int i = 0; i < b; i++) {
                char tmp = arr[i];
                arr[i] = arr[b - 1 - 1];
                arr[b - 1 - 1] = tmp;
            }
        } else {
            // niente
        }
    }


    public static void main(String[] args) throws Exception {
        InputReader in = new InputReader(System.in);
        StringBuilder sb = new StringBuilder();
        int test = in.readInt();
        int b = in.readInt();

        for (int i = 0; i < test; i++) {
            Character arr[] = new Character[b];
            ArrayList<Util> utils = new ArrayList<>();
            ArrayList<Integer> allEqualsOffsets = new ArrayList<>();
            int offset = 0;
            while (offset < b/2) {
                queries(b, offset, arr, utils, allEqualsOffsets, in);
                offset+=5;
            }
            // solve all equals
            for (int j = 0; j < allEqualsOffsets.size(); j++) {
                int off = allEqualsOffsets.get(j);
                System.out.println(off+1);
                String s = in.readString();
                if (s.equals("N")) throw new Exception();
                for (int k = off; k < 5 + off; k++) {
                    arr[k] = s.charAt(0);
                    arr[b - k - 1] = s.charAt(0);
                }
            }
            // solve equals 2
            for (int j = 0; j < utils.size(); j++) {
                Util util = utils.get(j);
                System.out.println(util.indexesGroup1.get(0)+1);
                String s = in.readString();
                if (s.equals("N")) throw new Exception();
                for (int k = 0; k < util.indexesGroup1.size(); k++) {
                    arr[util.indexesGroup1.get(k)] = s.charAt(0);
                }
                System.out.println(util.indexesGroup2.get(0)+1);
                s = in.readString();
                if (s.equals("N")) throw new Exception();
                for (int k = 0; k < util.indexesGroup2.size(); k++) {
                    arr[util.indexesGroup2.get(k)] = s.charAt(0);
                }
            }
            StringBuilder ans = new StringBuilder(b);
            for (int j = 0; j < b; j++) {
                ans.append(arr[j]);
            }
            System.out.println(ans.toString());
            String res = in.readString();
            if (res.equals("N")) throw new Exception();
        }
        //sb.deleteCharAt(sb.length() - 1);
        //System.out.println(sb.toString());
    }

}

/*
00000000001000000000
11111111110111111111
 */

