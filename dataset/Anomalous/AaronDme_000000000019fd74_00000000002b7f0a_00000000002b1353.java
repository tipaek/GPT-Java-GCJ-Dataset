import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        int t = readInt();
        for (int i = 1; i <= t; i++) {
            System.out.println("Case #" + i + ":");
            int n = readInt();
            if (n == 1) {
                System.out.println(1 + " " + 1);
                continue;
            }
            boolean[] visited = new boolean[32];
            Arrays.fill(visited, false);
            visited[0] = true;
            boolean onLeft = true;
            int maxBit = findMaxBit(n, visited);
            n = adjustRemainingBits(n, visited, maxBit);

            printPath(maxBit, visited, onLeft, n);
        }
    }

    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    private static int readInt() throws IOException {
        int c = skipWhitespace();
        boolean isNegative = (char) c == '-';
        int result = 0;
        if (isNegative) {
            c = input.read();
        }
        while (c >= '0' && c <= '9') {
            result = result * 10 + (c - '0');
            c = input.read();
        }
        return isNegative ? -result : result;
    }

    private static int skipWhitespace() throws IOException {
        int s = input.read();
        while (s == ' ' || s == '\n' || s == '\r') {
            s = input.read();
        }
        return s;
    }

    private static int findMaxBit(int n, boolean[] visited) {
        int maxBit = 0;
        for (int j = 30; j >= 0; j--) {
            if (n >= ((1 << j) + j)) {
                maxBit = j;
                n -= ((1 << j) + j);
                visited[j] = true;
                break;
            }
        }
        return maxBit;
    }

    private static int adjustRemainingBits(int n, boolean[] visited, int maxBit) {
        for (int j = maxBit - 1; j >= 0; j--) {
            if (n >= (1 << j) - 1) {
                n -= (1 << j) - 1;
                visited[j] = true;
            }
        }
        return n;
    }

    private static void printPath(int maxBit, boolean[] visited, boolean onLeft, int remainingSteps) {
        System.out.println(1 + " " + 1);
        for (int j = 1; j <= maxBit; j++) {
            System.out.println((j + 1) + " " + (onLeft ? 1 : (j + 1)));
            if (visited[j]) {
                if (onLeft) {
                    for (int k = 2; k <= j + 1; k++) {
                        System.out.println((j + 1) + " " + k);
                    }
                } else {
                    for (int k = j; k > 0; k--) {
                        System.out.println((j + 1) + " " + k);
                    }
                }
                onLeft = !onLeft;
            }
        }

        for (int j = 0; j < remainingSteps; j++) {
            maxBit++;
            System.out.println((maxBit + 1) + " " + (onLeft ? 1 : (maxBit + 1)));
        }
    }
}