import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static final String CAMERON = "C";
    private static final String JAMIE = "J";
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            StringBuilder result = new StringBuilder();
            boolean[] cameron = new boolean[24 * 60 + 1];
            boolean[] jamie = new boolean[24 * 60 + 1];
            for (int period = 0; period < 24 * 60 + 1; period++) {
                cameron[period] = false;
                jamie[period] = false;
            }

            int n = in.nextInt();
            try {
                for (int task = 0; task < n; task++) {
                    int s = in.nextInt();
                    int e = in.nextInt();
                    result.append(assign(s, e, cameron, jamie));
                }
            } catch (ImpossibleException e) {
                result = new StringBuilder(IMPOSSIBLE);
            }
            System.out.println(String.format("Case #%d: %s", i, result.toString()));
        }
    }

    private static String assign(int s, int e, boolean[] cameron, boolean[] jamie) throws ImpossibleException {
        boolean c = true;
        for (int period = s + 1; period <= e; period++) {
            if (cameron[period]) {
                c = false;
                break;
            }
        }
        if (c) {
            for (int period = s + 1; period <= e; period++) {
                cameron[period] = true;
            }
            return CAMERON;
        }

        boolean j = true;
        for (int period = s + 1; period <= e; period++) {
            if (jamie[period]) {
                j = false;
                break;
            }
        }
        if (j) {
            for (int period = s + 1; period <= e; period++) {
                jamie[period] = true;
            }
            return JAMIE;
        }

        throw new ImpossibleException();
    }


    private static class ImpossibleException extends Exception {
        //
    }
}