import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.processCases();
        solution.closeResources();
    }

    private void processCases() {
        int t = readInt();
        for (int i = 1; i <= t; i++) {
            pw.println("Case #" + i + ": " + solveCase());
        }
    }

    private String solveCase() {
        int[] coordinates = readIntArray();
        long x = coordinates[0];
        long y = coordinates[1];

        boolean negativeX = x < 0;
        boolean negativeY = y < 0;
        x = Math.abs(x);
        y = Math.abs(y);

        StringBuilder path = new StringBuilder();
        int previousDirection = -1;

        while (x > 0 || y > 0) {
            if ((x % 2 + y % 2) != 1) return "IMPOSSIBLE";

            if (x % 2 == 1) {
                if (y > 0 && previousDirection == 1) {
                    path.append("-");
                }
                previousDirection = 0;
                path.append('E');
                x ^= 1;
                y /= 2;
                if (y % 2 == 0) x /= 2;
            } else if (y % 2 == 1) {
                if (x > 0 && previousDirection == 0) {
                    path.append("-");
                }
                previousDirection = 1;
                path.append('N');
                y ^= 1;
                x /= 2;
                if (x % 2 == 0) y /= 2;
            }
        }

        StringBuilder finalPath = new StringBuilder();
        int length = path.length();
        for (int i = 0; i < length; i++) {
            if (path.charAt(i) == '-') continue;
            if (i + 1 < length && path.charAt(i + 1) == '-') {
                finalPath.append(path.charAt(i) == 'E' ? 'W' : 'S');
            } else {
                finalPath.append(path.charAt(i));
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < finalPath.length(); i++) {
            char currentChar = finalPath.charAt(i);
            if (negativeX) {
                if (currentChar == 'E') {
                    result.append('W');
                    continue;
                } else if (currentChar == 'W') {
                    result.append('E');
                    continue;
                }
            }
            if (negativeY) {
                if (currentChar == 'N') {
                    result.append('S');
                    continue;
                } else if (currentChar == 'S') {
                    result.append('N');
                    continue;
                }
            }
            result.append(currentChar);
        }
        return result.toString();
    }

    private void closeResources() {
        pw.close();
    }

    private String readLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private int readInt() {
        return Integer.parseInt(readLine());
    }

    private int[] readIntArray() {
        StringTokenizer st = new StringTokenizer(readLine());
        int n = st.countTokens();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }
}