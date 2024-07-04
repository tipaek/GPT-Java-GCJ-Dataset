import java.io.*;
import java.util.*;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PrintWriter output = new PrintWriter(System.out, true);

    private static int querySingleBit(int pos) {
        output.println(pos);
        return scanner.nextInt();
    }

    private static char queryBitArray(int[] bitArray) {
        StringBuilder sb = new StringBuilder();
        for (int bit : bitArray) {
            sb.append(bit);
        }
        output.println(sb.toString());
        return scanner.next().charAt(0);
    }

    public static void main(String[] args) {
        String input = scanner.nextLine();
        String[] parts = input.split(" ");
        int testCases = Integer.parseInt(parts[0].trim());
        int bitCount = Integer.parseInt(parts[1].trim());

        for (int i = 0; i < testCases; i++) {
            if (!processTestCase(bitCount)) {
                break;
            }
        }
    }

    private static boolean processTestCase(int bitCount) {
        int[] bitArray = new int[bitCount];
        int attempts = 0;
        char status = 'N';

        while (attempts < 150) {
            for (int i = 0; i < bitCount; i++) {
                bitArray[i] = querySingleBit(i + 1);
            }
            status = queryBitArray(bitArray);
            if (status == 'Y' || status == 'N') {
                break;
            }
        }

        return status == 'Y';
    }
}