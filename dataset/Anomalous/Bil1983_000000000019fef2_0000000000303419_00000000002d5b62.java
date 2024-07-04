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
            long pos = (long) Math.pow(4, i);
            for (int j = 0; j < pos; j++) {
                String s = String.format("%0" + i + "d", Integer.valueOf(Integer.toString(j, 4)));
                s = s.replaceAll("0", "N").replaceAll("1", "E").replaceAll("2", "S").replaceAll("3", "W");
                if (move(s)[0] == X && move(s)[1] == Y) {
                    System.out.println("Case #" + test + ": " + s);
                    return;
                }
            }
        }

        System.out.println("Case #" + test + ": IMPOSSIBLE");
    }

    static void printAllKLength(char[] set, int k) {
        int n = set.length;
        printAllKLengthRec(set, "", n, k);
    }

    static void printAllKLengthRec(char[] set, String prefix, int n, int k) {
        if (k == 0) {
            list.add(prefix);
            return;
        }

        for (int i = 0; i < n; ++i) {
            String newPrefix = prefix + set[i];
            printAllKLengthRec(set, newPrefix, n, k - 1);
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