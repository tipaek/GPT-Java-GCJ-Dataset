import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < t; i++) {
            int[] parameters = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            String solution = solve(parameters[0], parameters[1]);
            System.out.println("Case #" + (i + 1) + ": " + solution);
        }
    }

    private static String solve(int x, int y) {
        int max = Math.max(Math.abs(x), Math.abs(y));
        char[] path = new char[getLower(max) + 2];
        boolean solved = solve(x, y, 1, 1, 0, path);
        String answer;
        if (solved) {
            int l = 0;
            while (l < path.length && path[l] != 0) {
                l++;
            }
            answer = new String(path, 0, l);
        } else {
            answer = "IMPOSSIBLE";
        }
        return answer;
    }

    private static boolean solve(int x, int y, int xDirection, int yDirection, int max, char[] path) {
        if (x != 0) {
            if (x < 0) {
                return solve(x * -1, y, xDirection * -1, yDirection, max, path);
            }
            int lower = getLower(x);
            boolean solved = false;
            if (path[lower] == 0) {
                path[lower] = xDirection >= 0 ? 'E' : 'W';
                solved = solve(x - pow(lower), y, xDirection, yDirection, Math.max(max, lower), path);
                if (!solved) {
                    path[lower] = 0;
                }
            }
            if (!solved && path[lower + 1] == 0) {
                path[lower + 1] = xDirection >= 0 ? 'E' : 'W';
                solved = solve(pow(lower + 1) - x, y, xDirection * -1, yDirection, Math.max(max, lower),path);
                if (!solved) {
                    path[lower + 1] = 0;
                }
            }

            return solved;
        } else if (y != 0) {
            if (y < 0) {
                return solve(x, y * -1, xDirection, yDirection * -1, max, path);
            }
            int lower = getLower(y);
            boolean solved = false;
            if (path[lower] == 0) {
                path[lower] = yDirection >= 0 ? 'N' : 'S';
                solved = solve(0, y - pow(lower), xDirection, yDirection, Math.max(max, lower + 1), path);
                if (!solved) {
                    path[lower] = 0;
                }
            }
            if (!solved && path[lower + 1] == 0) {
                path[lower + 1] = yDirection >= 0 ? 'N' : 'S';
                solved = solve(0, pow(lower + 1) - y, xDirection, yDirection * -1, Math.max(max, lower + 1), path);
                if (!solved) {
                    path[lower + 1] = 0;
                }
            }
            return solved;
        } else {
            for (int i = 0; i < max; i++) {
                if (path[i] == 0) {
                    return false;
                }
            }

            return true;
        }
    }

    private static int getLower(int target) {
        int i = 0;
        int v = 1;
        do {
            v = v * 2;
            i++;
        } while (v <= target);
        return i - 1;
    }

    private static int pow(int i) {
        return (int) Math.pow(2, i);
    }

}
