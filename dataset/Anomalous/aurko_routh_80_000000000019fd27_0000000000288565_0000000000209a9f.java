import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String inputString = scanner.next();
            int length = inputString.length();
            
            int[] digits = new int[length];
            Map<Integer, List<Integer>> digitIndicesMap = new HashMap<>();
            
            for (int i = 0; i < length; i++) {
                digits[i] = inputString.charAt(i) - '0';
                digitIndicesMap.computeIfAbsent(digits[i], k -> new ArrayList<>()).add(i);
            }
            
            int[] openBrackets = new int[length];
            int[] closeBrackets = new int[length];
            
            for (int i = 1; i <= 9; i++) {
                boolean[] visited = new boolean[length];
                for (int index : digitIndicesMap.getOrDefault(i, Collections.emptyList())) {
                    if (visited[index]) continue;
                    
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(index);
                    int left = index, right = index;
                    
                    while (!queue.isEmpty()) {
                        int current = queue.poll();
                        if (visited[current] || current < 0 || current >= length) continue;
                        
                        visited[current] = true;
                        left = Math.min(left, current);
                        right = Math.max(right, current);
                        
                        if (current + 1 < length && !visited[current + 1] && digits[current + 1] >= i) {
                            queue.add(current + 1);
                        }
                        if (current - 1 >= 0 && !visited[current - 1] && digits[current - 1] >= i) {
                            queue.add(current - 1);
                        }
                    }
                    
                    openBrackets[left]++;
                    closeBrackets[right]++;
                }
            }
            
            StringBuilder result = new StringBuilder();
            
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < openBrackets[i]; j++) {
                    result.append("(");
                }
                result.append(digits[i]);
                for (int j = 0; j < closeBrackets[i]; j++) {
                    result.append(")");
                }
            }
            
            System.out.printf("Case #%d: %s%n", caseNum, result.toString());
        }
    }

    static class FastScanner {
        private InputStream stream;
        private byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;

        public FastScanner(InputStream stream) {
            this.stream = stream;
        }

        private int read() {
            if (numChars == -1) throw new InputMismatchException();
            if (currentChar >= numChars) {
                currentChar = 0;
                try {
                    numChars = stream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) return -1;
            }
            return buffer[currentChar++];
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndline(int c) {
            return c == '\n' || c == '\r' || c == -1;
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

        public String next() {
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

        public String nextLine() {
            int c = read();
            while (isEndline(c)) {
                c = read();
            }
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isEndline(c));
            return result.toString();
        }
    }
}