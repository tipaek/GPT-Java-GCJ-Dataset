import java.io.*;
import java.util.*;

public class Solution {

    public static Scan fr = new Scan();
    public static OutputWriter op = new OutputWriter();

    public static void main(String[] args) throws Exception {
        int T = fr.scanInt();
        for (int cs = 1; cs <= T; cs++) {
            int U = fr.scanInt();
            Map<Character, Set<Integer>> map = new HashMap<>();

            for (int i = 0; i < 10000; i++) {
                String M = fr.scanString();
                String R = fr.scanString();
                processInput(M, R, map);
            }

            String ans = findSolution(map);
            System.out.print("Case #" + cs + ": " + ans);
        }
    }

    private static void processInput(String m, String r, Map<Character, Set<Integer>> map) {
        for (char c : r.toCharArray()) {
            map.putIfAbsent(c, new HashSet<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
        }

        if (m.length() == r.length()) {
            Set<Integer> st = map.get(r.charAt(0));
            int k = m.charAt(0) - '0';
            st.remove(0);
            for (int i = k + 1; i <= 9; i++) {
                st.remove(i);
            }
        }
    }

    private static String findSolution(Map<Character, Set<Integer>> map) throws Exception {
        char[] ans = new char[10];
        Set<Integer> taken = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            List<Character> possibleChars = new ArrayList<>();
            for (char cur = 'A'; cur <= 'Z'; cur++) {
                if (map.containsKey(cur)) {
                    Set<Integer> st = map.get(cur);
                    st.removeAll(taken);
                    if (st.contains(i)) {
                        if (st.size() == 1) {
                            possibleChars.clear();
                            possibleChars.add(cur);
                            break;
                        }
                        possibleChars.add(cur);
                    }
                }
            }

            if (possibleChars.size() > 1) {
                throw new Exception();
            }

            taken.add(i);
            ans[i] = possibleChars.get(0);
        }

        return new String(ans);
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter() {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) writer.print(' ');
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

        public void flush() {
            writer.flush();
        }
    }

    static class Scan {
        private final byte[] buf = new byte[1024];
        private int index;
        private InputStream in;
        private int total;

        public Scan() {
            in = System.in;
        }

        public int scan() throws IOException {
            if (total < 0) throw new InputMismatchException();
            if (index >= total) {
                index = 0;
                total = in.read(buf);
                if (total <= 0) return -1;
            }
            return buf[index++];
        }

        public int scanInt() throws IOException {
            int integer = 0;
            int n = scan();
            while (isWhiteSpace(n)) n = scan();
            int neg = 1;
            if (n == '-') {
                neg = -1;
                n = scan();
            }
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    integer *= 10;
                    integer += n - '0';
                    n = scan();
                } else throw new InputMismatchException();
            }
            return neg * integer;
        }

        public long scanLong() throws IOException {
            long integer = 0;
            int n = scan();
            while (isWhiteSpace(n)) n = scan();
            int neg = 1;
            if (n == '-') {
                neg = -1;
                n = scan();
            }
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    integer *= 10;
                    integer += n - '0';
                    n = scan();
                } else throw new InputMismatchException();
            }
            return neg * integer;
        }

        public double scanDouble() throws IOException {
            double doub = 0;
            int n = scan();
            while (isWhiteSpace(n)) n = scan();
            int neg = 1;
            if (n == '-') {
                neg = -1;
                n = scan();
            }
            while (!isWhiteSpace(n) && n != '.') {
                if (n >= '0' && n <= '9') {
                    doub *= 10;
                    doub += n - '0';
                    n = scan();
                } else throw new InputMismatchException();
            }
            if (n == '.') {
                n = scan();
                double temp = 1;
                while (!isWhiteSpace(n)) {
                    if (n >= '0' && n <= '9') {
                        temp /= 10;
                        doub += (n - '0') * temp;
                        n = scan();
                    } else throw new InputMismatchException();
                }
            }
            return doub * neg;
        }

        public String scanString() throws IOException {
            StringBuilder sb = new StringBuilder();
            int n = scan();
            while (isWhiteSpace(n)) n = scan();
            while (!isWhiteSpace(n)) {
                sb.append((char) n);
                n = scan();
            }
            return sb.toString();
        }

        private boolean isWhiteSpace(int n) {
            return n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1;
        }
    }
}