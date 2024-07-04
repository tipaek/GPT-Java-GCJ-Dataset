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
        FastReader reader = new FastReader();
        StringBuilder result = new StringBuilder();
        int testCases = reader.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            StringBuilder output = new StringBuilder("Case #" + (caseNumber++) + ": ");
            int x = reader.nextInt();
            int y = reader.nextInt();
            long xorValue = Math.abs(x) ^ Math.abs(y);
            int absX = Math.abs(x);
            int absY = Math.abs(y);
            String binaryXor = Long.toBinaryString(xorValue);
            boolean possible = true;

            for (char c : binaryXor.toCharArray()) {
                if (c == '0') {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                output.append("IMPOSSIBLE");
                result.append(output).append("\n");
                continue;
            }

            String binaryX = Integer.toBinaryString(absX);
            String binaryY = Integer.toBinaryString(absY);
            StringBuilder padding = new StringBuilder();

            for (int i = 0; i < Math.abs(binaryX.length() - binaryY.length()); i++) {
                padding.append('0');
            }

            if (binaryX.length() < binaryY.length()) {
                binaryX = padding.append(binaryX).toString();
            } else {
                binaryY = padding.append(binaryY).toString();
            }

            boolean valid = true;
            for (int i = 0; i < binaryX.length(); i++) {
                if (binaryX.charAt(i) == '0' && binaryY.charAt(i) == '0') {
                    valid = false;
                    break;
                }
            }

            if (!valid) {
                output.append("IMPOSSIBLE");
                result.append(output).append("\n");
                continue;
            }

            if ((absX % 2 == 0 && absY % 2 == 0) || (absX % 2 == 1 && absY % 2 == 1)) {
                output.append("IMPOSSIBLE");
                result.append(output).append("\n");
                continue;
            }

            boolean sameBits = false;
            for (int i = 0; i < binaryX.length(); i++) {
                if (binaryX.charAt(i) == binaryY.charAt(i)) {
                    sameBits = true;
                    break;
                }
            }

            if (sameBits) {
                List<Character> directions = new ArrayList<>();
                int index = -1;

                for (int i = binaryX.length() - 1; i >= 0; i--) {
                    if (binaryX.charAt(i) == binaryY.charAt(i)) {
                        index = i;
                        break;
                    } else if (binaryX.charAt(i) == '1') {
                        directions.add('E');
                    } else if (binaryY.charAt(i) == '1') {
                        directions.add('N');
                    }
                }

                if (index != -1) {
                    if (directions.get(directions.size() - 1) == 'N') {
                        directions.remove(directions.size() - 1);
                        directions.add('S');
                        for (int i = index; i >= 0; i--) {
                            directions.add('E');
                        }
                        directions.add('N');
                    } else {
                        directions.remove(directions.size() - 1);
                        directions.add('W');
                        for (int i = index; i >= 0; i--) {
                            directions.add('N');
                        }
                        directions.add('E');
                    }
                }

                for (int i = 0; i < directions.size(); i++) {
                    if (x < 0) {
                        if (directions.get(i) == 'E') {
                            directions.set(i, 'W');
                        } else if (directions.get(i) == 'W') {
                            directions.set(i, 'E');
                        }
                    }
                    if (y < 0) {
                        if (directions.get(i) == 'N') {
                            directions.set(i, 'S');
                        } else if (directions.get(i) == 'S') {
                            directions.set(i, 'N');
                        }
                    }
                }

                for (char c : directions) {
                    output.append(c);
                }
                result.append(output).append("\n");
            } else {
                List<Character> directions = new ArrayList<>();
                for (int i = binaryX.length() - 1; i >= 0; i--) {
                    if (binaryX.charAt(i) == '1') {
                        directions.add('E');
                    } else {
                        directions.add('N');
                    }
                }

                for (int i = 0; i < directions.size(); i++) {
                    if (x < 0) {
                        if (directions.get(i) == 'E') {
                            directions.set(i, 'W');
                        } else if (directions.get(i) == 'W') {
                            directions.set(i, 'E');
                        }
                    }
                    if (y < 0) {
                        if (directions.get(i) == 'N') {
                            directions.set(i, 'S');
                        } else if (directions.get(i) == 'S') {
                            directions.set(i, 'N');
                        }
                    }
                }

                for (char c : directions) {
                    output.append(c);
                }
                result.append(output).append("\n");
            }
        }
        System.out.print(result);
    }
}