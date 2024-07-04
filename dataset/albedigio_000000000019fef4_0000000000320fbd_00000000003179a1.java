
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.*;

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


    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        StringBuilder sb = new StringBuilder();
        int test = in.readInt();
        for (int t = 0; t < test; t++) {
            StringBuilder ans = new StringBuilder();
            HashSet<Character> usedChars = new HashSet<>();
            HashSet<Character> usedCharsFirstPlace = new HashSet<>();
            HashMap<Integer, ArrayList<String>> mapping = new HashMap();
            int u = in.readInt();
            String res[] = new String[10000];
            int q[] = new int[10000];
            int valueA = (int)'A';
            for (int i = 0; i < res.length; i++) {
                q[i] = in.readInt();
                res[i] = in.readString();
                for (int j = 0; j < res[i].length(); j++) {
                    usedChars.add(res[i].charAt(j));
                }
                usedCharsFirstPlace.add(res[i].charAt(0));
                if (q[i] != -1) {
                    if (mapping.containsKey(q[i])) {
                        ArrayList<String> arrayList = mapping.get(q[i]);
                        arrayList.add(res[i]);
                    } else {
                        ArrayList<String> arrayList = new ArrayList<>();
                        arrayList.add(res[i]);
                        mapping.put(q[i], arrayList);
                    }
                }
            }

            //find zero
            usedChars.removeAll(usedCharsFirstPlace);
            Iterator<Character> iter = usedChars.iterator();
            ans.append(iter.next());

            ArrayList<String> ones = mapping.get(1);
            ans.append(ones.get(0));

            ArrayList<String> two = mapping.get(2);
            for (int i = 0; i < two.size(); i++) {
                String ts = two.get(i);
                if (ts.charAt(0) != ans.charAt(1)) {
                    ans.append(ts.charAt(0));
                    break;
                }
            }
            for (int i = 3; i < 10; i++) {
                ArrayList<String> numb = mapping.get(i);
                for (int j = 0; j < numb.size(); j++) {
                    char c = numb.get(j).charAt(0);
                    int diffs = 0;
                    for (int k = 0; k < ans.length(); k++) {
                        if (c != ans.charAt(k)) {
                            diffs++;
                        }
                    }
                    if (diffs == ans.length()) {
                        ans.append(c);
                        break;
                    }
                }
            }

            sb.append("Case #").append(t + 1).append(": ").append(ans.toString()).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());

    }
}
