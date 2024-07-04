import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) {
        Solution solution = new Solution();
        try {
            solution.solveCases();
        } catch (Exception e) {
            System.out.println("Incorrect answer");
            System.exit(1);
        }
        solution.close();
    }

    private void solveCases() throws Exception {
        int[] arr = readIntArr();
        for (int i = 1; i <= arr[0]; i++) {
            pw.println(solve(arr[1]));
            pw.flush();
            if ("N".equals(readLine())) {
                throw new Exception();
            }
        }
    }

    private String solve(int b) {
        int[] c = new int[b + 1];
        Arrays.fill(c, -1);

        for (int i = 1; i < 6; i++) {
            pw.println(i);
            pw.flush();
            c[i] = readInt();
            pw.println(b - i + 1);
            pw.flush();
            c[b - i + 1] = readInt();
        }

        int ci = 6;

        while (ci <= b / 2) {
            int hsi = findSameIndex(c, ci, b);
            int hdi = findDiffIndex(c, ci, b);

            boolean flipped = checkAndFlip(c, hsi, b);
            boolean flippedD = checkAndFlip(c, hdi, b);

            if (hsi == -1 || hdi == -1) {
                pw.println(1);
                pw.flush();
                readInt();
            }

            if (flipped) {
                flipArray(c, ci, b);
                if (!flippedD) {
                    reverseArray(c, ci, b);
                }
            } else if (flippedD) {
                reverseArray(c, ci, b);
            }

            int cip = ci;
            ci += 4;
            ci = Math.min(ci, b / 2 + 1);
            for (int i = cip; i < ci; i++) {
                pw.println(i);
                pw.flush();
                c[i] = readInt();
                pw.println(b - i + 1);
                pw.flush();
                c[b - i + 1] = readInt();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= b; i++) {
            sb.append(c[i]);
        }
        return sb.toString();
    }

    private int findSameIndex(int[] c, int ci, int b) {
        for (int i = 1; i < ci; i++) {
            if (c[i] == c[b - i + 1]) {
                return i;
            }
        }
        return -1;
    }

    private int findDiffIndex(int[] c, int ci, int b) {
        for (int i = 1; i < ci; i++) {
            if (c[i] != c[b - i + 1]) {
                return i;
            }
        }
        return -1;
    }

    private boolean checkAndFlip(int[] c, int index, int b) {
        if (index != -1) {
            pw.println(index);
            pw.flush();
            int cf = readInt();
            if (cf != c[index]) {
                return true;
            }
        }
        return false;
    }

    private void flipArray(int[] c, int ci, int b) {
        for (int i = 1; i < ci; i++) {
            c[i] = 1 - c[i];
            c[b - i + 1] = 1 - c[b - i + 1];
        }
    }

    private void reverseArray(int[] c, int ci, int b) {
        for (int i = 1; i < ci; i++) {
            int tmp = c[i];
            c[i] = c[b - i + 1];
            c[b - i + 1] = tmp;
        }
    }

    private void close() {
        pw.close();
    }

    private String readLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private int readInt() {
        return Integer.parseInt(readLine());
    }

    private int[] readIntArr() {
        String[] str = readLine().split(" ");
        int[] arr = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        return arr;
    }
}