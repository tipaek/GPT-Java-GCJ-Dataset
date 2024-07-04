import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

class Solution {
    public void solve(DataReader dr, PrintWriter pw) {
        int n = dr.nextInt();
        dr.nextLine();
        String prefix = "";
        String suffix = "";
        StringBuilder middle = new StringBuilder();
        boolean isValid = true;

        for (int i = 0; i < n; i++) {
            String s = dr.nextLine();
            if (!isValid) continue;
            
            int x = s.indexOf('*');
            int y = s.lastIndexOf('*');
            
            if (x > 0) {
                String t = s.substring(0, x);
                if (!prefix.startsWith(t)) {
                    if (t.startsWith(prefix)) {
                        prefix = t;
                    } else {
                        isValid = false;
                        continue;
                    }
                }
            }
            
            if (y < s.length() - 1) {
                String t = s.substring(y + 1);
                if (!suffix.endsWith(t)) {
                    if (t.endsWith(suffix)) {
                        suffix = t;
                    } else {
                        isValid = false;
                        continue;
                    }
                }
            }
            
            middle.append(s.substring(x, y).replace("*", ""));
        }
        
        pw.println(isValid ? prefix + middle + suffix : "*");
    }

    public static void main(String... args) {
        DataReader dr = new DataReader();
        try (PrintWriter pw = new PrintWriter(System.out)) {
            int t = dr.nextInt();
            dr.nextLine();

            for (int i = 1; i <= t; i++) {
                pw.print("Case #" + i + ": ");
                new Solution().solve(dr, pw);
                System.gc();
            }
        }
    }

    static class DataReader {
        private final Supplier<String> supplier;
        private String line;
        private int currentIndex;
        private boolean started;

        public DataReader(Supplier<String> supplier) {
            this.supplier = supplier;
        }

        public DataReader(BufferedReader br) {
            this(() -> {
                try {
                    return br.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        public DataReader(InputStream is) {
            this(new BufferedReader(new InputStreamReader(is)));
        }

        public DataReader(File file) {
            this(() -> {
                try {
                    return new BufferedReader(new InputStreamReader(new FileInputStream(file))).readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        public DataReader() {
            this(System.in);
        }

        private void readLine() {
            line = supplier.get();
            currentIndex = 0;
        }

        public String next() {
            if (line == null) {
                if (started) throw new NoSuchElementException();
                started = true;
                readLine();
            }

            while (currentIndex < line.length() && line.charAt(currentIndex) == ' ') {
                currentIndex++;
            }

            if (currentIndex < line.length()) {
                int start = currentIndex;
                while (currentIndex < line.length() && line.charAt(currentIndex) != ' ') {
                    currentIndex++;
                }
                return line.substring(start, currentIndex);
            }

            readLine();
            return next();
        }

        public String nextLine() {
            if (line == null) {
                if (started) throw new NoSuchElementException();
                started = true;
                readLine();
            }
            String result = line.substring(currentIndex).trim();
            readLine();
            return result;
        }

        public boolean hasNextLine() {
            if (line != null) return true;
            if (started) return false;
            started = true;
            readLine();
            return line != null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public static int[] parseIntArray(String s, String delimiter) {
            return Arrays.stream(s.split(delimiter)).mapToInt(Integer::parseInt).toArray();
        }

        public int[] intArray(String delimiter) {
            return parseIntArray(nextLine(), delimiter);
        }

        public int[] intArray() {
            return intArray(" ");
        }

        public static long[] parseLongArray(String s, String delimiter) {
            return Arrays.stream(s.split(delimiter)).mapToLong(Long::parseLong).toArray();
        }

        public long[] longArray(String delimiter) {
            return parseLongArray(nextLine(), delimiter);
        }

        public long[] longArray() {
            return longArray(" ");
        }

        public void read(int[] array) {
            for (int i = 0; i < array.length; i++) {
                array[i] = nextInt();
            }
        }

        public int[][] intArray2(int rows, String delimiter) {
            int[][] array = new int[rows][];
            for (int i = 0; i < rows; i++) {
                array[i] = intArray(delimiter);
            }
            return array;
        }

        public int[][] intArray2(int rows) {
            return intArray2(rows, " ");
        }

        public static <T> List<T> parseList(String s, String delimiter, Function<String, T> mapper) {
            return Arrays.stream(s.split(delimiter)).map(mapper).toList();
        }

        public List<Integer> intList(String delimiter) {
            return parseList(nextLine(), delimiter, Integer::parseInt);
        }

        public List<Integer> intList() {
            return intList(" ");
        }
    }
}