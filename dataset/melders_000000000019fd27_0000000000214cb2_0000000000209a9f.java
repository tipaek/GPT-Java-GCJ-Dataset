import java.io.*;
import java.util.*;

public class Solution {
    private static final String FILE_NAME = null;

    private static String solve(Scanner in) {
        String S = in.next();
        StringBuilder sPrime = new StringBuilder();

        int previousNum = 0;
        for (int i = 0; i < S.length(); i++) {
            int num = Integer.valueOf(String.valueOf(S.charAt(i)));

            if (previousNum > num) {
                sPrime.append(")".repeat(previousNum - num));
            } else if (num > previousNum) {
                sPrime.append("(".repeat(num - previousNum));
            }

            sPrime.append(num);
            previousNum = num;
        }
        sPrime.append(")".repeat(previousNum));

        return sPrime.toString();
    }

    private static void run() {
        try {
            Scanner in = new Scanner(new BufferedReader(FILE_NAME == null ? new InputStreamReader(System.in)
                    : new FileReader(new File(FILE_NAME + ".in"))));

            long tc = in.nextLong();
            for (long t = 1; t <= tc; t++) {
                final String solution = solve(in);
                System.out.println("Case #" + t + ": " + solution);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        run();
    }
}
