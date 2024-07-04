import java.util.Scanner;

public class Solution {

    private static String solve(String[] patterns) {
        int longestPattern = -1;
        int longestIndex = -1;
        int shortestPattern = -1;
        int shortest = -1;
        int shortestIndex = -1;
        for (int i = 0; i < patterns.length; i++) {
            for (int j = 0; j < patterns[i].length(); j++) {
                if (patterns[i].charAt(j) == '*') {
                    if (j > longestIndex) {
                        longestIndex = j;
                        longestPattern = i;
                    }
                    int fromEnd = patterns[i].length() - j;
                    if (fromEnd > shortest) {
                        shortest = fromEnd;
                        shortestIndex = j;
                        shortestPattern = i;
                    }
                    break;
                }
            }
        }
        String name =  patterns[longestPattern].substring(0, longestIndex)
                + patterns[shortestPattern].substring(shortestIndex + 1, patterns[shortestPattern].length());
        for (String pattern : patterns) {
            String[] parts = pattern.split("\\*");
            if (!name.startsWith(parts[0]) || !name.endsWith(parts[1])) {
                return "*";
            }
        }
        return name;
    }

    public static void main(String[] args) {
        int T = ni();
        for (int i = 1; i <= T; i++) {
            int N = ni();
            String[] patterns = new String[N];
            for (int j = 0; j < N; j++) {
                patterns[j] = ns();
            }
            System.out.println("Case #" + i + ": " + solve(patterns));
        }
    }

    static Scanner io = new Scanner(System.in);

    static int ni() {
        return io.nextInt();
    }

    static long nl() {
        return io.nextLong();
    }

    static String ns() {
        return io.next();
    }

    static int[] nia(int N) {
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = ni();
        }
        return array;
    }

    static int[][] nim(int N, int cols) {
        int[][] matrix = new int[N][cols];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = ni();
            }
        }
        return matrix;
    }
}
