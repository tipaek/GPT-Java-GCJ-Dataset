import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; ++tc) {
            String C = sc.next();
            String J = sc.next();

            System.out.println(String.format("Case #%d: %s", tc, solve(C, J)));
        }

        sc.close();
    }

    static String solve(String C, String J) {
        String result = null;
        int minTotalDistance = Integer.MAX_VALUE;
        int minDistanceDelta = Integer.MAX_VALUE;
        for (int length = 0; length <= Math.max(C.length(), J.length()); ++length) {
            for (int code = 0; code < pow3(length); ++code) {
                String name = decode(length, code);
                int distance1 = computeDistance(C, name);
                int distance2 = computeDistance(J, name);
                int totalDistance = distance1 + distance2;
                int distanceDelta = Math.abs(distance1 - distance2);

                if (totalDistance < minTotalDistance
                        || (totalDistance == minTotalDistance && distanceDelta < minDistanceDelta)) {
                    result = name;
                    minTotalDistance = totalDistance;
                    minDistanceDelta = distanceDelta;
                }
            }
        }

        return result;
    }

    static int pow3(int exponent) {
        return IntStream.range(0, exponent).reduce(1, (x, i) -> x * 3);
    }

    static String decode(int length, int code) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            result.append((char) (code % 3 + 'X'));
            code /= 3;
        }

        return result.toString();
    }

    static int computeDistance(String s1, String s2) {
        int[][] distances = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); ++i) {
            for (int j = 0; j <= s2.length(); ++j) {
                if (i == 0) {
                    distances[i][j] = j;
                } else if (j == 0) {
                    distances[i][j] = i;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    distances[i][j] = distances[i - 1][j - 1];
                } else {
                    distances[i][j] = Math.min(Math.min(distances[i - 1][j], distances[i][j - 1]),
                            distances[i - 1][j - 1]) + 1;
                }
            }
        }

        return distances[s1.length()][s2.length()];
    }
}