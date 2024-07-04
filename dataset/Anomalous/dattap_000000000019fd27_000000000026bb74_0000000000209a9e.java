import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int T = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        for (int testCase = 1; testCase <= T; testCase++) {
            int[][] arrays = new int[4][B];
            int[] b2 = new int[B];

            // Read first 10 bits
            for (int i = 0; i < 10; i++) {
                System.out.println(i + 1);
                int bit = Integer.parseInt(sc.nextLine());
                arrays[0][i] = bit;
                arrays[1][i] = 1 - bit;
                arrays[2][i] = arrays[0][B - i - 1];
                arrays[3][i] = 1 - arrays[2][i];
            }

            // Read second set of 10 bits
            for (int i = 0; i < 10; i++) {
                System.out.println(i + 1);
                b2[i] = Integer.parseInt(sc.nextLine());
            }

            // Check all possible transformations
            if (checkAndPrintResult(sc, arrays[0], b2, B) ||
                checkAndPrintResult(sc, arrays[1], b2, B) ||
                checkAndPrintResult(sc, arrays[2], b2, B) ||
                checkAndPrintResult(sc, arrays[3], b2, B)) {
                continue;
            }
        }
    }

    private static boolean checkAndPrintResult(Scanner sc, int[] array, int[] b2, int B) {
        int cnt = 0, cnt1 = 0, cnt2 = 0, cnt3 = 0;

        for (int i = 0; i < 10; i++) {
            if (b2[i] == array[i]) cnt++;
            if (b2[i] == 1 - array[i]) cnt1++;
            if (b2[i] == array[B - i - 1]) cnt2++;
            if (b2[i] == 1 - array[B - i - 1]) cnt3++;
        }

        if (cnt == 10 || cnt1 == 10 || cnt2 == 10 || cnt3 == 10) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                if (cnt == 10) sb.append(array[i]);
                if (cnt1 == 10) sb.append(1 - array[i]);
                if (cnt2 == 10) sb.append(array[B - i - 1]);
                if (cnt3 == 10) sb.append(1 - array[B - i - 1]);
            }
            System.out.println(sb.toString());
            String output = sc.nextLine();
            return output.equals("Y");
        }
        return false;
    }
}