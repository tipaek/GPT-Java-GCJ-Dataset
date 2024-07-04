import java.io.*;
import java.util.*;

public class Solution {
    private static final boolean INTERACTIVE_PROBLEM = true;
    private static final String FILE_NAME = null;
    private static int B;

    private static String solve(Scanner in) {
        int matchingIndex = -1;
        int mirrorIndex = -1;
        int i = 1;
        int queryCount = 0;
        int[] bits = new int[B];

        while (i <= (B + 1) / 2) {
            if (queryCount > 0 && queryCount % 10 == 0) {
                boolean matchesFlipped = false;
                boolean mirrorsFlipped = false;

                if (matchingIndex != -1) {
                    System.out.println(matchingIndex + 1);
                    matchesFlipped = (bits[matchingIndex] != in.nextInt());
                } else {
                    System.out.println(1);
                    in.nextInt();
                }

                if (mirrorIndex != -1) {
                    System.out.println(mirrorIndex + 1);
                    mirrorsFlipped = (bits[mirrorIndex] != in.nextInt());
                } else {
                    System.out.println(1);
                    in.nextInt();
                }

                queryCount += 2;

                for (int j = 0; j < i; j++) {
                    if (bits[j] == bits[B - 1 - j]) {
                        if (matchesFlipped) {
                            bits[j] = 1 - bits[j];
                            bits[B - 1 - j] = 1 - bits[B - 1 - j];
                        }
                    } else {
                        if (mirrorsFlipped) {
                            bits[j] = 1 - bits[j];
                            bits[B - 1 - j] = 1 - bits[B - 1 - j];
                        }
                    }
                }
            } else {
                if (bits[i - 1] == bits[B - i]) {
                    matchingIndex = i - 1;
                } else {
                    mirrorIndex = i - 1;
                }
                
                System.out.println(i);
                bits[i - 1] = in.nextInt();
                System.out.println(B + 1 - i);
                bits[B - i] = in.nextInt();
                queryCount += 2;
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
                if (INTERACTIVE_PROBLEM) {
                    System.out.println(solution);
                    if (in.next().equals("N")) {
                        break;
                    }
                } else {
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
