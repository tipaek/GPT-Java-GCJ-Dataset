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
        list = new ArrayList<>();
        char[] directions = {'N', 'S', 'E', 'W'};
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int N = (int) (Math.log(Math.max(Math.abs(X), Math.abs(Y))) / Math.log(2)) + 2;

        for (int i = 1; i <= N; i++) {
            generateCombinations(directions, i);
        }

        for (String s : list) {
            if (move(s)[0] == X && move(s)[1] == Y) {
                System.out.println("Case #" + test + ": " + s);
                return;
            }
        }

        System.out.println("Case #" + test + ": IMPOSSIBLE");
    }

    static void generateCombinations(char[] set, int length) {
        generateCombinationsRec(set, "", set.length, length);
    }

    static void generateCombinationsRec(char[] set, String prefix, int n, int k) {
        if (k == 0) {
            list.add(prefix);
            return;
        }

        for (char c : set) {
            generateCombinationsRec(set, prefix + c, n, k - 1);
        }
    }

    static int[] move(String s) {
        int[] position = new int[2];
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'N':
                    position[1] += Math.pow(2, i);
                    break;
                case 'S':
                    position[1] -= Math.pow(2, i);
                    break;
                case 'E':
                    position[0] += Math.pow(2, i);
                    break;
                case 'W':
                    position[0] -= Math.pow(2, i);
                    break;
            }
        }
        return position;
    }
}