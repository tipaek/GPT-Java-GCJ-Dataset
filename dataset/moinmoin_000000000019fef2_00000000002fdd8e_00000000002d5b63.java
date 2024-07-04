import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static final String CENTER = "CENTER";
    private static final String HIT = "HIT";
    private static final String MISS = "MISS";
    private static final long MAX_VALUE = 10 ^ 9;
    private static final long MIN_VALUE = -1 * MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();
        long A = in.nextLong();
        long B = in.nextLong();
        for (int i=0; i < testCases; i++) {
            long guessedX = 0;
            long guessedY = 0;
            int count = 0;
            do {
                System.out.println(guessedX + " " + guessedY);
                String result = in.next();
                if (CENTER.equals(result)) {
                    break;
                } else {
                    guessedX++;
                    guessedY--;
                }
            } while (count++ <= 300);
        }
    }
}