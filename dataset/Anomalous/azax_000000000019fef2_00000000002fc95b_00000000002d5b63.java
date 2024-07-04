import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static final String CENTER = "CENTER";
    private static final String HIT = "HIT";
    private static final String MISS = "MISS";

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numCases = Integer.parseInt(sc.nextLine().trim());
            for (int index = 0; index < numCases; index++) {
                boolean foundCenter = false;
                for (int x = -5; x <= 5 && !foundCenter; x++) {
                    for (int y = -5; y <= 5; y++) {
                        System.out.println(x + " " + y);
                        String response = sc.nextLine().trim();
                        if (CENTER.equals(response)) {
                            foundCenter = true;
                            break;
                        }
                    }
                }
            }
        }
    }
}