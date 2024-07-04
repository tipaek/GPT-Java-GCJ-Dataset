import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());

        for (int x = 0; x < t; x++) {
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int k = Integer.parseInt(str[1]);

            pw.print("Case #" + (x + 1) + ": ");
            if (isPossible(n, k)) {
                pw.println("POSSIBLE");
                printSolution(pw, n, k);
            } else {
                pw.println("IMPOSSIBLE");
            }
        }

        pw.flush();
        pw.close();
    }

    private static boolean isPossible(int n, int k) {
        if (n == 2) {
            return k != 3;
        } else if (n == 3) {
            return k == 3 || k == 6 || k == 9;
        } else if (n == 4) {
            return k >= 4 && k <= 16 && k != 5 && k != 15;
        } else if (n == 5) {
            return k >= 5 && k <= 25 && k != 6 && k != 24;
        }
        return false;
    }

    private static void printSolution(PrintWriter pw, int n, int k) {
        if (n == 2) {
            if (k == 2) {
                pw.println("1 2");
                pw.println("2 1");
            } else if (k == 4) {
                pw.println("2 1");
                pw.println("1 2");
            }
        } else if (n == 3) {
            if (k == 3) {
                pw.println("1 2 3");
                pw.println("3 1 2");
                pw.println("2 3 1");
            } else if (k == 6) {
                pw.println("2 1 3");
                pw.println("3 2 1");
                pw.println("1 3 2");
            } else if (k == 9) {
                pw.println("3 1 2");
                pw.println("2 3 1");
                pw.println("1 2 3");
            }
        } else if (n == 4) {
            switch (k) {
                case 4:
                    pw.println("1 2 3 4");
                    pw.println("2 1 4 3");
                    pw.println("3 4 1 2");
                    pw.println("4 3 2 1");
                    break;
                case 6:
                    pw.println("1 2 3 4");
                    pw.println("2 1 4 3");
                    pw.println("3 4 2 1");
                    pw.println("4 3 1 2");
                    break;
                case 7:
                    pw.println("1 2 3 4");
                    pw.println("3 1 4 2");
                    pw.println("4 3 2 1");
                    pw.println("2 4 1 3");
                    break;
                case 8:
                    pw.println("2 3 4 1");
                    pw.println("1 2 3 4");
                    pw.println("4 1 2 3");
                    pw.println("3 4 1 2");
                    break;
                case 9:
                    pw.println("1 4 2 3");
                    pw.println("3 1 4 2");
                    pw.println("4 2 3 1");
                    pw.println("2 3 1 4");
                    break;
                case 10:
                    pw.println("1 4 3 2");
                    pw.println("4 1 2 3");
                    pw.println("2 3 4 1");
                    pw.println("3 2 1 4");
                    break;
                case 11:
                    pw.println("1 4 3 2");
                    pw.println("4 2 1 3");
                    pw.println("2 3 4 1");
                    pw.println("3 1 2 4");
                    break;
                case 12:
                    pw.println("3 4 1 2");
                    pw.println("2 3 4 1");
                    pw.println("1 2 3 4");
                    pw.println("4 1 2 3");
                    break;
                case 13:
                    pw.println("2 4 3 1");
                    pw.println("4 3 1 2");
                    pw.println("1 2 4 3");
                    pw.println("3 1 2 4");
                    break;
                case 14:
                    pw.println("3 4 2 1");
                    pw.println("4 3 1 2");
                    pw.println("1 2 4 3");
                    pw.println("2 1 3 4");
                    break;
                case 16:
                    pw.println("4 1 2 3");
                    pw.println("3 4 1 2");
                    pw.println("2 3 4 1");
                    pw.println("1 2 3 4");
                    break;
            }
        } else if (n == 5) {
            switch (k) {
                case 5:
                    pw.println("1 2 3 4 5");
                    pw.println("5 1 2 3 4");
                    pw.println("4 5 1 2 3");
                    pw.println("3 4 5 1 2");
                    pw.println("2 3 4 5 1");
                    break;
                case 7:
                    pw.println("1 4 3 2 5");
                    pw.println("2 1 4 5 3");
                    pw.println("5 3 2 4 1");
                    pw.println("3 2 5 1 4");
                    pw.println("4 5 1 3 2");
                    break;
                case 8:
                    pw.println("1 5 3 2 4");
                    pw.println("5 3 2 4 1");
                    pw.println("4 2 1 3 5");
                    pw.println("2 4 5 1 3");
                    pw.println("3 1 4 5 2");
                    break;
                case 9:
                    pw.println("3 4 2 1 5");
                    pw.println("1 2 3 5 4");
                    pw.println("5 3 1 4 2");
                    pw.println("4 1 5 2 3");
                    pw.println("2 5 4 3 1");
                    break;
                case 10:
                    pw.println("2 3 4 5 1");
                    pw.println("1 2 3 4 5");
                    pw.println("5 1 2 3 4");
                    pw.println("4 5 1 2 3");
                    pw.println("3 4 5 1 2");
                    break;
                case 11:
                    pw.println("3 1 5 4 2");
                    pw.println("2 3 4 1 5");
                    pw.println("1 5 2 3 4");
                    pw.println("5 4 1 2 3");
                    pw.println("4 2 3 5 1");
                    break;
                case 12:
                    pw.println("5 4 1 3 2");
                    pw.println("1 2 5 4 3");
                    pw.println("2 1 3 5 4");
                    pw.println("4 3 2 1 5");
                    pw.println("3 5 4 2 1");
                    break;
                case 13:
                    pw.println("5 1 2 4 3");
                    pw.println("2 3 1 5 4");
                    pw.println("1 4 3 2 5");
                    pw.println("3 5 4 1 2");
                    pw.println("4 2 5 3 1");
                    break;
                case 14:
                    pw.println("5 1 2 4 3");
                    pw.println("3 4 1 5 2");
                    pw.println("1 5 3 2 4");
                    pw.println("2 3 4 1 5");
                    pw.println("4 2 5 3 1");
                    break;
                case 15:
                    pw.println("5 2 4 1 3");
                    pw.println("1 4 5 3 2");
                    pw.println("3 5 1 2 4");
                    pw.println("2 1 3 4 5");
                    pw.println("4 3 2 5 1");
                    break;
                case 16:
                    pw.println("5 2 3 1 4");
                    pw.println("1 5 4 3 2");
                    pw.println("3 4 1 2 5");
                    pw.println("2 1 5 4 3");
                    pw.println("4 3 2 5 1");
                    break;
                case 17:
                    pw.println("5 2 4 1 3");
                    pw.println("3 5 1 2 4");
                    pw.println("4 1 2 3 5");
                    pw.println("1 3 5 4 2");
                    pw.println("2 4 3 5 1");
                    break;
                case 18:
                    pw.println("5 2 1 3 4");
                    pw.println("1 5 4 2 3");
                    pw.println("2 4 3 1 5");
                    pw.println("3 1 5 4 2");
                    pw.println("4 3 2 5 1");
                    break;
                case 19:
                    pw.println("5 1 3 2 4");
                    pw.println("4 5 2 1 3");
                    pw.println("1 3 4 5 2");
                    pw.println("3 2 1 4 5");
                    pw.println("2 4 5 3 1");
                    break;
                case 20:
                    pw.println("5 2 1 3 4");
                    pw.println("4 5 2 1 3");
                    pw.println("3 1 4 2 5");
                    pw.println("2 3 5 4 1");
                    pw.println("1 4 3 5 2");
                    break;
                case 21:
                    pw.println("5 2 1 3 4");
                    pw.println("4 5 3 2 1");
                    pw.println("2 3 4 1 5");
                    pw.println("3 1 5 4 2");
                    pw.println("1 4 2 5 3");
                    break;
                case 22:
                    pw.println("5 4 3 2 1");
                    pw.println("4 5 1 3 2");
                    pw.println("2 1 4 5 3");
                    pw.println("1 3 2 4 5");
                    pw.println("3 2 5 1 4");
                    break;
                case 23:
                    pw.println("5 3 4 1 2");
                    pw.println("4 5 2 3 1");
                    pw.println("1 4 5 2 3");
                    pw.println("3 2 1 4 5");
                    pw.println("2 1 3 5 4");
                    break;
                case 25:
                    pw.println("5 1 2 3 4");
                    pw.println("4 5 1 2 3");
                    pw.println("3 4 5 1 2");
                    pw.println("2 3 4 5 1");
                    pw.println("1 2 3 4 5");
                    break;
            }
        }
    }
}