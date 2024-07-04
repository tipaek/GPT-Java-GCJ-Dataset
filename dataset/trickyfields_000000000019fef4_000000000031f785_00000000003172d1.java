import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        final int testCaseCount = sc.nextInt();

        for (int i = 1; i <= testCaseCount; i++) {
            System.out.println("Case #" + i + ": " + process());
        }
    }

    private static long process() {
        int cuts = 2;
        int slices = sc.nextInt();
        int diners = sc.nextInt();

        long[] angles = new long[slices];
        for (int i = 0; i < angles.length; i++) {
            angles[i] = sc.nextLong();
        }
        Arrays.sort(angles);

        if (diners == 2 && slices == 1) {
            return 1;
        }

        int i = 0;
        int count = 1;

        while (i < angles.length) {
            while (i + 1 < angles.length && angles[i] == angles[i + 1]) {
                i++;
                count++;
            }
            if (diners <= count) {
                cuts = 0;
            }

            if (i + 1 < angles.length) {
                for (int j = i + 1; j < angles.length; j++) {
                    if (2 * angles[i] == angles[j]) {
                        cuts = Math.min(cuts, 1);
                    }
                }
            }

            i++;
            count = 1;
        }

        return cuts;
    }

}
