import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static Scanner scanner;
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int t = scanner.nextInt();
        for (int test = 1; test <= t; test++) {
            solve(test);
        }
    }

    static void solve(int test) {
        char[] directions = {'N', 'S', 'E', 'W'};
        int X = scanner.nextInt();
        int Y = scanner.nextInt();
        int N = (int) (Math.log(Math.max(Math.abs(X), Math.abs(Y))) / Math.log(2)) + 2;

        for (int i = N / 2; i <= N; i++) {
            long limit = (long) Math.pow(4, i);
            for (long j = 0; j < limit; j++) {
                String s = String.format("%0" + i + "d", Integer.valueOf(Long.toString(j, 4)));
                s = s.replace('0', 'N').replace('1', 'E').replace('2', 'S').replace('3', 'W');
                if (isValidMove(s, X, Y)) {
                    System.out.println("Case #" + test + ": " + s);
                    return;
                }
            }
        }
        System.out.println("Case #" + test + ": IMPOSSIBLE");
    }

    static boolean isValidMove(String s, int targetX, int targetY) {
        int[] result = calculatePosition(s);
        return result[0] == targetX && result[1] == targetY;
    }

    static int[] calculatePosition(String s) {
        int[] position = new int[2];
        for (int i = 0; i < s.length(); i++) {
            int step = (int) Math.pow(2, i);
            switch (s.charAt(i)) {
                case 'N':
                    position[1] += step;
                    break;
                case 'S':
                    position[1] -= step;
                    break;
                case 'E':
                    position[0] += step;
                    break;
                case 'W':
                    position[0] -= step;
                    break;
            }
        }
        return position;
    }

    static void printAllKLength(char[] set, int k) {
        printAllKLengthRec(set, "", set.length, k);
    }

    static void printAllKLengthRec(char[] set, String prefix, int n, int k) {
        if (k == 0) {
            list.add(prefix);
            return;
        }
        for (int i = 0; i < n; i++) {
            printAllKLengthRec(set, prefix + set[i], n, k - 1);
        }
    }
}