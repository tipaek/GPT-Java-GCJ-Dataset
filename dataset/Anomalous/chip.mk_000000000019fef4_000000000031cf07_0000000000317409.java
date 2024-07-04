import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Scanner scanner = new Scanner(reader)
        ) {
            scanner.useLocale(Locale.US);
            int testCases = scanner.nextInt();

            for (int testCase = 1; testCase <= testCases; testCase++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                String moves = scanner.next();

                char[] path = moves.toCharArray();
                int minSteps = Integer.MAX_VALUE;
                int steps = 0;

                if (x != 0 || y != 0) {
                    for (char move : path) {
                        steps++;
                        switch (move) {
                            case 'N': y++; break;
                            case 'E': x++; break;
                            case 'S': y--; break;
                            case 'W': x--; break;
                        }

                        int distance = Math.abs(x) + Math.abs(y);
                        if (distance <= steps && steps < minSteps) {
                            minSteps = steps;
                            if (distance == minSteps) break;
                        }
                    }
                } else {
                    minSteps = steps;
                }

                String result = (minSteps < Integer.MAX_VALUE) ? String.valueOf(minSteps) : "IMPOSSIBLE";
                System.out.printf("Case #%d: %s%n", testCase, result);
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}