import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        for (int k = 1; k <= t; k++) {
            pw.println("Case #" + k + ": " + solve(br.readLine()));
        }
        pw.flush();
    }

    private static String solve(String s) throws IOException {
        return solveZero(s);
    }

    private static String solveZero(String s) {
        String result = "";
        if (s.length() > 0 && s.startsWith("0")) {
            return "0" + solveZero(s.substring(1));
        }
        if (s.length() > 0 && s.endsWith("0")) {
            return solveZero(s.substring(0, s.length() - 1)) + "0";
        }
        int indexOfZero = s.indexOf('0');
        if (indexOfZero > 0) {
            return solveZero(s.substring(0, indexOfZero)) + solveZero(s.substring(indexOfZero));
        }
        if (s.length() > 0) {
            return "(" + s + ")";
        }
        return "";
    }
}
