import java.io.*;
import java.nio.CharBuffer;
import java.util.*;

public class Solution {

    private static final int DIGIT_NUM = 10;
    private static char[] ans;

    public static void main(String[] args) {
        SimpleScanner scanner = new SimpleScanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        int caseNum = scanner.nextInt();
        Random random = new Random(System.currentTimeMillis());
        for (int caseNo = 1; caseNo <= caseNum; ++caseNo) {
            writer.print(String.format("Case #%d: ", caseNo));
            int u = scanner.nextInt();
            HashMap<Character, Integer> characterMapping = new HashMap<>();
            HashMap<char[], Long> limits = new HashMap<>();
            HashSet<Character> noZero = new HashSet<>();
            boolean isRandom = false;
            for (int i = 0; i < 10000; ++i) {
                long m = scanner.nextLong();
                char[] s = scanner.next().toCharArray();
                if (m == -1L) {
                    isRandom = true;
                    m = random.nextInt(9) + 1;
                    for (int j = 1; j < s.length; ++j)
                        m = m * 10 + random.nextInt(10);
                }
                if (s.length > 1)
                    noZero.add(s[0]);
                limits.put(s, m);
                for (char c : s)
                    characterMapping.put(c, null);
            }
            ArrayList<Character> characters = new ArrayList<>(characterMapping.keySet());
            char[] digitUsed = new char[DIGIT_NUM];
            ans = null;
            while (ans == null) {
                search(0, characters.size(), characters, characterMapping, digitUsed, noZero, limits);
                if (isRandom) {
                    for (Map.Entry<char[], Long> entry : limits.entrySet()) {
                        char[] s = entry.getKey();
                        long m = random.nextInt(9) + 1;
                        for (int j = 1; j < s.length; ++j)
                            m = m * 10 + random.nextInt(10);
                        entry.setValue(m);
                    }
                }
            }
            char c = 'A';
            for (int i = 0; i < DIGIT_NUM; ++i)
                if (ans[i] != 0)
                    writer.print(ans[i]);
                else {
                    while (characterMapping.containsKey(c))
                        ++c;
                    characterMapping.put(c, i);
                    writer.print(c);
                }
            writer.println();
        }
        writer.close();
    }

    private static void search(int k, int n, List<Character> characters, Map<Character, Integer> characterMapping, char[] digitUsed, Set<Character> noZero, Map<char[], Long> limits) {
        if (k == n) {
            boolean valid = true;
            for (Map.Entry<char[], Long> entry : limits.entrySet()) {
                char[] s = entry.getKey();
                long m = entry.getValue();
                long t = 0;
                for (char c : s)
                    t = t * 10 + characterMapping.get(c);
                if (t > m) {
                    valid = false;
                    break;
                }
            }
            if (valid)
                ans = digitUsed;
        } else {
            for (int i = 0; i < DIGIT_NUM; ++i) {
                if (digitUsed[i] == 0) {
                    if (i == 0 && noZero.contains(characters.get(k)))
                        continue;
                    characterMapping.put(characters.get(k), i);
                    digitUsed[i] = characters.get(k);
                    search(k + 1, n, characters, characterMapping, digitUsed, noZero, limits);
                    if (ans != null)
                        break;
                    digitUsed[i] = 0;
                    characterMapping.put(characters.get(k), null);
                }
            }
        }
    }

    private static class SimpleScanner {

        private static final int BUFFER_SIZE = 10240;

        private Readable in;
        private CharBuffer buffer;
        private boolean eof;

        private SimpleScanner(InputStream in) {
            this.in = new BufferedReader(new InputStreamReader(in));
            buffer = CharBuffer.allocate(BUFFER_SIZE);
            buffer.limit(0);
            eof = false;
        }


        private char read() {
            if (!buffer.hasRemaining()) {
                buffer.clear();
                int n;
                try {
                    n = in.read(buffer);
                } catch (IOException e) {
                    n = -1;
                }
                if (n <= 0) {
                    eof = true;
                    return '\0';
                }
                buffer.flip();
            }
            return buffer.get();
        }

        private void checkEof() {
            if (eof)
                throw new NoSuchElementException();
        }

        private char nextChar() {
            checkEof();
            char b = read();
            checkEof();
            return b;
        }

        private String next() {
            char b;
            do {
                b = read();
                checkEof();
            } while (Character.isWhitespace(b));
            StringBuilder sb = new StringBuilder();
            do {
                sb.append(b);
                b = read();
            } while (!eof && !Character.isWhitespace(b));
            return sb.toString();
        }

        private int nextInt() {
            return Integer.parseInt(next());
        }

        private long nextLong() {
            return Long.parseLong(next());
        }

        private double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}