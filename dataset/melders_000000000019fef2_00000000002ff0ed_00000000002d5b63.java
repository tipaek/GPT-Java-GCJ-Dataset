import java.io.*;
import java.util.*;

public class Solution {
    private static final boolean INTERACTIVE_PROBLEM = true;
    private static final String FILE_NAME = null;

    private static String solve(Scanner in) {
        int A = in.nextInt();
        int B = in.nextInt();
        
        for (int i = -5; i <= 5; i++) {
            for (int j = -5; j <= 5; j++) {
                System.out.println(i + " " + j);
                if (in.next().equals("CENTER")) {
                    return "";
                }
            }
        }
        
        System.out.println("I give up");
        return "";
    }

    private static void run() {
        try {
            Scanner in = new Scanner(new BufferedReader(FILE_NAME == null ? new InputStreamReader(System.in)
                    : new FileReader(new File(FILE_NAME + ".in"))));

            long tc = in.nextLong();
            for (long t = 1; t <= tc; t++) {
                final String solution = solve(in);
                if (!INTERACTIVE_PROBLEM) {
                    System.out.println("Case #" + t + ": " + solution);
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
