import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        StringBuilder result = new StringBuilder();
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            StringBuilder caseResult = new StringBuilder("Case #" + (caseNumber++) + ": ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            long val = Math.abs(x) ^ Math.abs(y);
            int absX = Math.abs(x);
            int absY = Math.abs(y);
            String binaryVal = Long.toBinaryString(val);

            if (binaryVal.contains("0")) {
                caseResult.append("IMPOSSIBLE");
                result.append(caseResult).append("\n");
                continue;
            }

            String binaryX = Integer.toBinaryString(absX);
            String binaryY = Integer.toBinaryString(absY);

            if (binaryX.length() != binaryY.length()) {
                int diff = Math.abs(binaryX.length() - binaryY.length());
                String padding = "0".repeat(diff);

                if (binaryX.length() < binaryY.length()) {
                    binaryX = padding + binaryX;
                } else {
                    binaryY = padding + binaryY;
                }

                if (binaryX.chars().anyMatch(ch -> ch == '0') && binaryY.chars().anyMatch(ch -> ch == '0')) {
                    caseResult.append("IMPOSSIBLE");
                    result.append(caseResult).append("\n");
                    continue;
                }

                List<Character> directions = new ArrayList<>();
                for (int i = binaryX.length() - 1; i >= 0; i--) {
                    directions.add(binaryX.charAt(i) == '1' ? 'E' : 'N');
                }

                if (x < 0) {
                    for (int i = 0; i < directions.size(); i++) {
                        if (directions.get(i) == 'E') {
                            directions.set(i, 'W');
                        } else if (directions.get(i) == 'W') {
                            directions.set(i, 'E');
                        }
                    }
                }

                if (y < 0) {
                    for (int i = 0; i < directions.size(); i++) {
                        if (directions.get(i) == 'N') {
                            directions.set(i, 'S');
                        } else if (directions.get(i) == 'S') {
                            directions.set(i, 'N');
                        }
                    }
                }

                for (char direction : directions) {
                    caseResult.append(direction);
                }
                result.append(caseResult).append("\n");
            } else {
                if (binaryX.chars().anyMatch(ch -> ch == '0') && binaryY.chars().anyMatch(ch -> ch == '0')) {
                    caseResult.append("IMPOSSIBLE");
                    result.append(caseResult).append("\n");
                    continue;
                }

                int mismatchIndex = -1;
                boolean isXOne = false;
                for (int i = 0; i < binaryX.length(); i++) {
                    if (binaryX.charAt(i) != binaryY.charAt(i)) {
                        isXOne = binaryX.charAt(i) == '1';
                        mismatchIndex = i;
                        break;
                    }
                }

                List<Character> directions = new ArrayList<>();
                for (int i = binaryX.length() - 1; i > mismatchIndex; i--) {
                    directions.add(binaryX.charAt(i) == '1' ? 'E' : 'N');
                }

                directions.add(isXOne ? 'W' : 'S');
                for (int i = mismatchIndex - 1; i >= 0; i--) {
                    directions.add(isXOne ? 'N' : 'E');
                }
                directions.add(isXOne ? 'E' : 'N');

                if (x < 0) {
                    for (int i = 0; i < directions.size(); i++) {
                        if (directions.get(i) == 'E') {
                            directions.set(i, 'W');
                        } else if (directions.get(i) == 'W') {
                            directions.set(i, 'E');
                        }
                    }
                }

                if (y < 0) {
                    for (int i = 0; i < directions.size(); i++) {
                        if (directions.get(i) == 'N') {
                            directions.set(i, 'S');
                        } else if (directions.get(i) == 'S') {
                            directions.set(i, 'N');
                        }
                    }
                }

                for (char direction : directions) {
                    caseResult.append(direction);
                }
                result.append(caseResult).append("\n");
            }
        }
        System.out.print(result);
    }
}