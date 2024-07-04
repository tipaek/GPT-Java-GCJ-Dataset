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
        String s;
        long pos;

        for (int i = N / 2; i <= N; i++) {
            pos = (long) Math.pow(4, i);
            for (long j = 0; j < pos; j++) {
                s = String.format("%0" + i + "d", Long.parseLong(Long.toString(j, 4)));
                s = s.replaceAll("0", "N").replaceAll("1", "E").replaceAll("2", "S").replaceAll("3", "W");

                if (move(s)[0] == X && move(s)[1] == Y) {
                    System.out.println("Case #" + test + ": " + s);
                    return;
                }
            }
        }

        System.out.println("Case #" + test + ": IMPOSSIBLE");
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