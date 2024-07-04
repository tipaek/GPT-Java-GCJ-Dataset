import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Solution {

    // Reverse the rightmost `len` bits of `x`
    static int reverseBits(int x, int len) {
        for (int i = 0; i < len / 2; i++) {
            int leftShift = 1 << i;
            int rightShift = 1 << (len - 1 - i);
            int leftBit = x & leftShift;
            int rightBit = x & rightShift;

            if (leftBit == 0) {
                x &= ~rightShift;
            } else {
                x |= rightShift;
            }

            if (rightBit == 0) {
                x &= ~leftShift;
            } else {
                x |= leftShift;
            }
        }
        return x;
    }

    // Read 10 bits from the input
    static int readBits(BufferedReader reader) throws IOException {
        int result = 0;
        for (int i = 0; i < 10; i++) {
            System.out.println(i + 1);
            if (Integer.parseInt(reader.readLine()) == 1) {
                result |= (1 << (9 - i));
            }
        }
        return result;
    }

    // Get the result from the input based on given positions
    static String getResult(int[] positions, BufferedReader reader) throws IOException {
        int result = 0;
        for (int i = 20; i >= 13; i--) {
            System.out.println(i);
            if (Integer.parseInt(reader.readLine()) == 1) {
                result |= (1 << (20 - i));
            }
        }
        System.out.println(10);
        if (Integer.parseInt(reader.readLine()) == 1) {
            result |= (1 << 10);
        }

        for (int pos : positions) {
            if (result == (pos & 0x4FF)) {
                return formatBinaryString(pos, 20);
            }
        }
        return null;
    }

    // Format an integer as a binary string of length `len`
    static String formatBinaryString(int value, int len) {
        return String.format("%" + len + "s", Integer.toBinaryString(value)).replace(' ', '0');
    }

    // Pretty print the binary representation of an integer
    static void prettyPrint(int value, int len, PrintStream writer) {
        char[] binaryChars = formatBinaryString(value, len).toCharArray();
        for (int i = 0; i < binaryChars.length; i++) {
            writer.print(binaryChars[i]);
            if ((i + 1) % 5 == 0) {
                writer.print(' ');
            }
        }
        writer.println();
    }

    // Check if two integers are the same or their reversed/complemented forms
    static boolean isSame(int a, int b) {
        if (a == b) {
            return true;
        }
        int complement = 0x3FF;
        if (a == (b ^ complement)) {
            return true;
        }
        int reversedB = reverseBits(b, 10);
        return a == reversedB || a == (reversedB ^ complement);
    }

    // Read the decision from the input and exit if not successful
    static void readDecision(BufferedReader reader) throws IOException {
        boolean isSuccess = reader.readLine().charAt(0) == 'Y';
        if (!isSuccess) {
            System.exit(0);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int t = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        if (b > 20) {
            throw new UnsupportedOperationException();
        }

        if (b == 10) {
            for (int i = 0; i < t; i++) {
                System.out.println(formatBinaryString(readBits(reader), 10));
                readDecision(reader);
            }
        } else if (b == 20) {
            for (int i = 0; i < t; i++) {
                int first = readBits(reader);
                int second = 0;

                for (int j = 0; j < 6; j++) {
                    second = readBits(reader);
                    if (!isSame(first, second)) {
                        break;
                    }
                }

                int[] positions = new int[8];
                positions[0] = (second << 10) | reverseBits(first, 10);
                positions[1] = (second << 10) | (reverseBits(first, 10) ^ 0x3FF);
                positions[2] = reverseBits(positions[0], 20);
                positions[3] = reverseBits(positions[1], 20);
                positions[4] = positions[0] ^ 0xFFFFF;
                positions[5] = positions[1] ^ 0xFFFFF;
                positions[6] = reverseBits(positions[3], 20);
                positions[7] = reverseBits(positions[4], 20);

                String result = getResult(positions, reader);
                System.out.println(result == null ? "WA" + formatBinaryString(positions[0], 20) : result);
                readDecision(reader);
            }
        }
    }
}