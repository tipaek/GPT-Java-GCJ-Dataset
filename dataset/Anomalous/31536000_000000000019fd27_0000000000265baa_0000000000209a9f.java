public class Solution {

    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        FastScanner scanner = new FastScanner();
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.next();
            processCase(caseNumber, input);
        }
    }

    private void processCase(int caseNumber, String input) {
        StringBuilder result = new StringBuilder();
        result.append("Case #").append(caseNumber).append(": ");
        int currentDepth = 0;

        for (char ch : input.toCharArray()) {
            int digit = Character.digit(ch, 10);
            while (currentDepth < digit) {
                result.append('(');
                currentDepth++;
            }
            while (currentDepth > digit) {
                result.append(')');
                currentDepth--;
            }
            result.append(ch);
        }

        while (currentDepth > 0) {
            result.append(')');
            currentDepth--;
        }

        System.out.println(result.toString());
    }

    static class FastScanner {
        private final java.io.InputStream inputStream = System.in;
        private final byte[] buffer = new byte[1024];
        private int bufferPointer = 0;
        private int bytesRead = 0;

        private boolean hasNextByte() {
            if (bufferPointer < bytesRead) return true;
            bufferPointer = 0;
            try {
                bytesRead = inputStream.read(buffer);
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
            return bytesRead > 0;
        }

        private int readByte() {
            if (hasNextByte()) return buffer[bufferPointer++];
            return -1;
        }

        private static boolean isPrintableChar(int c) {
            return 33 <= c && c <= 126;
        }

        public boolean hasNext() {
            while (hasNextByte() && !isPrintableChar(buffer[bufferPointer])) bufferPointer++;
            return hasNextByte();
        }

        public String next() {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            StringBuilder sb = new StringBuilder();
            int b = readByte();
            while (isPrintableChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public long nextLong() {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            long number = 0;
            boolean negative = false;
            int b = readByte();
            if (b == '-') {
                negative = true;
                b = readByte();
            }
            if (b < '0' || b > '9') throw new NumberFormatException();
            while (true) {
                if ('0' <= b && b <= '9') {
                    number = number * 10 + (b - '0');
                } else if (b == -1 || !isPrintableChar(b)) {
                    return negative ? -number : number;
                } else {
                    throw new NumberFormatException();
                }
                b = readByte();
            }
        }

        public int nextInt() {
            long number = nextLong();
            if (number < Integer.MIN_VALUE || number > Integer.MAX_VALUE) throw new NumberFormatException();
            return (int) number;
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}