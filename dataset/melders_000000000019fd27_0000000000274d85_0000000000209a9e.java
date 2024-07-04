import java.io.*;
import java.util.*;

public class Solution {
    private static final String FILE_NAME = null;
    private static int B;

    private static String solve(Scanner in) {
        int i = 1;
        int queryCount = 0;
        int[] bits = new int[B];
        
        while (i <= (B + 1) / 2) {
            if (queryCount > 0 && queryCount % 10 == 0) {
                throw new RuntimeException("Not yet implemented");
            } else {
                System.out.println(i);
                bits[i - 1] = in.nextInt();
                System.out.println(B + 1 - i);
                bits[B - i] = in.nextInt();
                //queryCount += 2;
                i++;
            }
        }
        
        StringBuilder bitString = new StringBuilder();
        for (int j = 0; j < B; j++) {
            bitString.append(bits[j]);
        }
        
        return bitString.toString();
    }

    private static void run() {
        try {
            Scanner in = new Scanner(new BufferedReader(FILE_NAME == null ? new InputStreamReader(System.in)
                    : new FileReader(new File(FILE_NAME + ".in"))));

            long tc = in.nextLong();
            B = in.nextInt();
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
