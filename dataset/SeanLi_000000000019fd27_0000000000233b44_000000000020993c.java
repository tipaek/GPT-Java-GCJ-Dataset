import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static boolean[] exists = new boolean[100];
    static int[][] metrics = new int[100][100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
/*
        Scanner sc = null;
        try {
            sc = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
*/
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            solve(sc, i);
        }
    }

    private static void solve(Scanner sc, int c) {
        int n = sc.nextInt();
        int ans = 0;
        int column = 0;
        int line = 0;
        for (int i = 0; i < n; i++) {
            boolean columnCool = true;
            Arrays.fill(exists, false);
            for (int j = 0; j < n; j++) {
                metrics[i][j] = sc.nextInt();
                int value = metrics[i][j];
                if (i == j) {
                    ans += value;
                }
                if (columnCool && exists[value]) {
                    columnCool = false;
                    column++;
                } else {
                    exists[value] = true;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            Arrays.fill(exists, false);
            for (int i = 0; i < n; i++) {
                int value = metrics[i][j];
                if (exists[value]) {
                    line++;
                    break;
                } else {
                    exists[value] = true;
                }
            }
        }
        System.out.printf("Case #%d: %d %d %d\n", c, ans, column, line);
    }
}
