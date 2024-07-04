import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static Scanner sc;
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();

        for (int test = 1; test <= t; test++) {
            solve(test);
        }
    }

    static void solve(int test) {
        char[] directions = {'N', 'S', 'E', 'W'};
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int N = (int) (Math.log(Math.max(Math.abs(X), Math.abs(Y))) / Math.log(2)) + 2;

        for (int i = 1; i <= N; i++) {
            list.clear();
            generateAllKLengthStrings(directions, i);
            for (String s : list) {
                if (isValidMove(s, X, Y)) {
                    System.out.println("Case #" + test + ": " + s);
                    return;
                }
            }
        }

        System.out.println("Case #" + test + ": IMPOSSIBLE");
    }

    static void generateAllKLengthStrings(char[] set, int k) {
        generateAllKLengthStringsRec(set, "", set.length, k);
    }

    static void generateAllKLengthStringsRec(char[] set, String prefix, int n, int k) {
        if (k == 0) {
            list.add(prefix);
            return;
        }

        for (int i = 0; i < n; i++) {
            generateAllKLengthStringsRec(set, prefix + set[i], n, k - 1);
        }
    }

    static boolean isValidMove(String s, int targetX, int targetY) {
        int[] position = calculatePosition(s);
        return position[0] == targetX && position[1] == targetY;
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
}