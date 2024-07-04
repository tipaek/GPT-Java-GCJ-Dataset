import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Solution {

    private static class InputReader {
        private final InputStream stream;
        private final byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) return -1;
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                res = res * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public double readDouble() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E') return res * Math.pow(10, readInt());
                if (c < '0' || c > '9') throw new InputMismatchException();
                res = res * 10 + (c - '0');
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') return res * Math.pow(10, readInt());
                    if (c < '0' || c > '9') throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public long readLong() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                res = res * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            boolean isSpaceChar(int ch);
        }
    }

    public static long getRandomIntInRange(long startInclusive, long endExclusive) {
        return ThreadLocalRandom.current().nextLong(startInclusive, endExclusive);
    }

    public static void util() {
        int[] freq = new int[10];
        for (int i = 0; i < 10000; i++) {
            long up = getRandomIntInRange(1, Long.MAX_VALUE);
            long realNumb = getRandomIntInRange(1, up);
            String s = String.valueOf(realNumb);
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                freq[Character.getNumericValue(c)]++;
            }
        }
        for (int i = 0; i < freq.length; i++) {
            System.out.println(i + " is present " + freq[i] + " times");
        }
    }

    public static void attempt1(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        StringBuilder sb = new StringBuilder();
        int test = in.readInt();
        for (int t = 0; t < test; t++) {
            StringBuilder ans = new StringBuilder();
            HashSet<Character> usedChars = new HashSet<>();
            HashSet<Character> usedCharsFirstPlace = new HashSet<>();
            HashMap<Integer, ArrayList<String>> mapping = new HashMap<>();
            int u = in.readInt();
            String[] res = new String[10000];
            int[] q = new int[10000];
            for (int i = 0; i < res.length; i++) {
                q[i] = in.readInt();
                res[i] = in.readString();
                for (char c : res[i].toCharArray()) {
                    usedChars.add(c);
                }
                usedCharsFirstPlace.add(res[i].charAt(0));
                if (q[i] != -1) {
                    mapping.computeIfAbsent(q[i], k -> new ArrayList<>()).add(res[i]);
                }
            }

            // Find zero
            usedChars.removeAll(usedCharsFirstPlace);
            Iterator<Character> iter = usedChars.iterator();
            ans.append(iter.next());

            ArrayList<String> ones = mapping.get(1);
            ans.append(ones.get(0));

            ArrayList<String> two = mapping.get(2);
            for (String ts : two) {
                if (ts.charAt(0) != ans.charAt(1)) {
                    ans.append(ts.charAt(0));
                    break;
                }
            }
            for (int i = 3; i < 10; i++) {
                ArrayList<String> numb = mapping.get(i);
                for (String s : numb) {
                    char c = s.charAt(0);
                    if (ans.chars().noneMatch(ch -> ch == c)) {
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

    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        StringBuilder sb = new StringBuilder();
        int test = in.readInt();
        for (int t = 0; t < test; t++) {
            StringBuilder ans = new StringBuilder();
            HashSet<Character> usedChars = new HashSet<>();
            HashSet<Character> usedCharsFirstPlace = new HashSet<>();
            int u = in.readInt();
            String[] res = new String[10000];
            int[] q = new int[10000];
            int valueA = 'A';
            int[] freq = new int[26];
            for (int i = 0; i < res.length; i++) {
                q[i] = in.readInt();
                res[i] = in.readString();
                for (char c : res[i].toCharArray()) {
                    usedChars.add(c);
                    freq[c - valueA]++;
                }
                usedCharsFirstPlace.add(res[i].charAt(0));
            }

            // Find zero
            usedChars.removeAll(usedCharsFirstPlace);
            Iterator<Character> iter = usedChars.iterator();
            ans.append(iter.next());

            char zeroChar = ans.charAt(0);

            int beforeMax = Integer.MAX_VALUE;
            for (int i = 0; i < 9; i++) {
                int max = 0;
                int indexMax = -1;
                for (int j = 0; j < freq.length; j++) {
                    if (((char) ('A' + indexMax)) == zeroChar) continue;
                    if (freq[j] >= max && freq[j] < beforeMax) {
                        max = freq[j];
                        indexMax = j;
                    }
                }
                ans.append((char) ('A' + indexMax));
                beforeMax = max;
            }
            sb.append("Case #").append(t + 1).append(": ").append(ans.toString()).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}