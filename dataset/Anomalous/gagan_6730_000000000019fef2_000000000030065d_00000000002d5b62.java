import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static class FastReader {
        private BufferedReader br;
        private StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
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

        public String nextLine() {
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
            StringBuilder caseResult = new StringBuilder("Case #" + (caseNumber++) + ": ");
            int x = reader.nextInt();
            int y = reader.nextInt();
            long xorValue = Math.abs(x) ^ Math.abs(y);
            int absX = Math.abs(x);
            int absY = Math.abs(y);
            String binaryString = Long.toBinaryString(xorValue);

            boolean isImpossible = binaryString.contains("0");
            if (isImpossible) {
                caseResult.append("IMPOSSIBLE");
                result.append(caseResult).append("\n");
                continue;
            }

            String binaryX = Integer.toBinaryString(absX);
            String binaryY = Integer.toBinaryString(absY);
            StringBuilder padding = new StringBuilder();

            for (int i = 0; i < Math.abs(binaryX.length() - binaryY.length()); i++) {
                padding.append('0');
            }

            if (binaryX.length() < binaryY.length()) {
                padding.append(binaryX);
                binaryX = padding.toString();
            } else {
                padding.append(binaryY);
                binaryY = padding.toString();
            }

            boolean hasZeroPair = false;
            for (int i = 0; i < binaryX.length(); i++) {
                if (binaryX.charAt(i) == '0' && binaryY.charAt(i) == '0') {
                    hasZeroPair = true;
                    break;
                }
            }

            if (hasZeroPair || ((absX % 2 == 0 && absY % 2 == 0) || (absX % 2 == 1 && absY % 2 == 1))) {
                caseResult.append("IMPOSSIBLE");
                result.append(caseResult).append("\n");
                continue;
            }

            boolean hasSameBit = false;
            for (int i = 0; i < binaryX.length(); i++) {
                if (binaryX.charAt(i) == binaryY.charAt(i)) {
                    hasSameBit = true;
                    break;
                }
            }

            if (hasSameBit) {
                processCaseWithSameBit(binaryX, binaryY, absX, absY, x, y, caseResult);
            } else {
                processCaseWithoutSameBit(binaryX, binaryY, x, y, caseResult);
            }

            result.append(caseResult).append("\n");
        }

        System.out.print(result);
    }

    private static void processCaseWithSameBit(String binaryX, String binaryY, int absX, int absY, int x, int y, StringBuilder caseResult) {
        String a = binaryY;
        String b = binaryX;
        int odd = absX;
        int v = 0;

        if (absY % 2 == 1) {
            odd = absY;
            b = binaryY;
            a = binaryX;
            v = 1;
        }

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
            adjustDirections(directions, index, binaryX, binaryY);
        }

        adjustDirectionsForNegativeCoordinates(x, y, directions);

        for (char direction : directions) {
            caseResult.append(direction);
        }
    }

    private static void processCaseWithoutSameBit(String binaryX, String binaryY, int x, int y, StringBuilder caseResult) {
        List<Character> directions = new ArrayList<>();

        for (int i = binaryX.length() - 1; i >= 0; i--) {
            if (binaryX.charAt(i) == '1') {
                directions.add('E');
            } else {
                directions.add('N');
            }
        }

        adjustDirectionsForNegativeCoordinates(x, y, directions);

        for (char direction : directions) {
            caseResult.append(direction);
        }
    }

    private static void adjustDirections(List<Character> directions, int index, String binaryX, String binaryY) {
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

    private static void adjustDirectionsForNegativeCoordinates(int x, int y, List<Character> directions) {
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
    }
}