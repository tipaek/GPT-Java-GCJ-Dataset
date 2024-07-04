import java.io.*;
import java.util.*;

public class Solution {
    private static final boolean INTERACTIVE_PROBLEM = false;
    private static final String FILE_NAME = null;
    private static int B;

    private static String solve(Scanner in) {
        int N = in.nextInt();

        StringBuilder walk = new StringBuilder();
        walk.append("1 1");
        N -= 1;

        for (int i = 1; i < 500 && N > 0; i++) {
            if (N >= i) {
                N -= i;
                walk.append("\n" + (i + 1) + " 2");
            } else {
                N -= 1;
                walk.append("\n" + (i) + " 1");
            }
        }

        return walk.toString();
    }

    private static void run() {
        try {
            Scanner in = new Scanner(new BufferedReader(FILE_NAME == null ? new InputStreamReader(System.in)
                    : new FileReader(new File(FILE_NAME + ".in"))));

            long tc = in.nextLong();
            if (INTERACTIVE_PROBLEM) {
                B = in.nextInt();
            }
            for (long t = 1; t <= tc; t++) {
                final String solution = solve(in);
                if (INTERACTIVE_PROBLEM) {
                    System.out.println(solution);
                    if (in.next().equals("N")) {
                        break;
                    }
                } else {
                    System.out.println("Case #" + t + ":\n" + solution);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        run();
    }
}
