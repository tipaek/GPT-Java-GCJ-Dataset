

import java.util.Scanner;

public class Solution {
    private static String output1 = "Case #%d: %d";
    private static String output2 = "Case #%d: IMPOSSIBLE";


    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
                new Solution().getAnswer(caseNum, scanner);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAnswer(int caseNum, Scanner scanner) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        char[] path = scanner.next().toCharArray();
        for (int i = 0; i < path.length; ++i) {
            char c = path[i];
            switch (c) {
                case 'S':
                    --y;
                    break;
                case 'N':
                    ++y;
                    break;
                case 'E':
                    ++x;
                    break;
                case 'W':
                    --x;
                    break;
            }

            if (Math.abs(x) + Math.abs(y) <= i+1) {
                println(String.format(output1, caseNum, i+1));
                return;
            }
        }
        println(String.format(output2, caseNum));
    }

    public static void print(Object o) {
        System.out.print(o);
    }
    public static void println(Object o) {
        System.out.println(o);
    }
    public static void println() {
        System.out.println();
    }
    public static void printErr(Object o) {
        System.err.print(o);
    }
    public static void printErrln(Object o) {
        System.err.println(o);
    }
    static class Pair<F, S> {
        final F first;
        final S second;
        Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }
}