import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");
        int testCases = Integer.parseInt(data[0]);
        int bits = Integer.parseInt(data[1]);
        for (int tc = 1; tc <= testCases; ++tc) {
            char[] ba = new char[bits + 1];
            int lo = 1, hi = bits;
            while (lo <= hi) {
                for (int i = 0; i < 5 && lo <= hi; ++i, ++lo, --hi) {
                    ba[lo] = getBit(scanner, lo);
                    if (lo != hi) {
                        ba[hi] = getBit(scanner, hi);
                    }
                }
            }
            StringBuilder sb = new StringBuilder(ba.length);
            for (int i = 1; i <= bits; i++) {
                sb.append(ba[i]);
            }
            String result = sb.toString();
            System.out.println(result);
            String correct = scanner.nextLine();
            if (correct.charAt(0) != 'Y') {
                throw new RuntimeException("Incorrect answer");
            }
        }
    }

    private static char getBit(Scanner scanner, int index) {
        System.out.println(index);
        String line = scanner.nextLine();
        return line.charAt(0);
    }
}
