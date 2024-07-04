package zi.jam.y20.qual;

import java.io.*;
import java.util.Arrays;

public class Solution {

    // Reverse the rightmost 'len' bits of 'x'
    static int reverseBits(int x, int len) {
        for (int i = 0; i < len / 2; i++) {
            int leftShift = 1 << i, rightShift = 1 << (len - 1 - i);
            int leftBit = x & leftShift, rightBit = x & rightShift;
            if (leftBit == 0)
                x &= ~rightShift;
            else
                x |= rightShift;
            if (rightBit == 0)
                x &= ~leftShift;
            else
                x |= leftShift;
        }
        return x;
    }

    // Read 10 bits from the input
    static int read(BufferedReader reader) throws IOException {
        int result = 0;
        for (int j = 0; j < 10; j++) {
            System.out.println(j + 1);
            if (Integer.parseInt(reader.readLine()) == 1)
                result |= (1 << (9 - j));
        }
        return result;
    }

    // Get the result based on the provided positions
    static String result(int[] positions, BufferedReader reader) throws IOException {
        int result = 0;
        for (int i = 20; i >= 13; i--) {
            System.out.println(i);
            if (Integer.parseInt(reader.readLine()) == 1)
                result |= (1 << (20 - i));
        }
        System.out.println(10);
        if (Integer.parseInt(reader.readLine()) == 1)
            result |= (1 << 10);
        for (int pos : positions) {
            if (result == (pos & 0x4FF))
                return padBinaryStr(pos, 20);
        }
        return null;
    }

    // Pad the binary string representation of 'in' to 'len' bits
    static String padBinaryStr(int in, int len) {
        return String.format("%" + len + "s", Integer.toBinaryString(in)).replace(' ', '0');
    }

    // Pretty print the binary representation
    static void prettyPrint(int in, int len, PrintStream writer) {
        char[] binaryChars = padBinaryStr(in, len).toCharArray();
        for (int i = 0; i < binaryChars.length; i++) {
            writer.print(binaryChars[i]);
            if ((i + 1) % 5 == 0)
                writer.print(' ');
        }
        writer.println();
    }

    // Check if two numbers are the same considering bitwise operations
    static boolean isSame(int left, int right) {
        if (left == right)
            return true;
        int complement = 0x3FF;
        if (left == (right ^ complement))
            return true;
        int reversedRight = reverseBits(right, 10);
        if (left == reversedRight)
            return true;
        return left == (reversedRight ^ complement);
    }

    // Read decision from the input
    static void readDecision(BufferedReader reader) throws IOException {
        boolean isSuccess = reader.readLine().charAt(0) == 'Y';
        if (!isSuccess)
            System.exit(0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("/Users/bchandrasekaran/Temp/db.in"));
        String[] tb = reader.readLine().split(" ");
        int t = Integer.parseInt(tb[0]), b = Integer.parseInt(tb[1]);
        if (b > 20)
            throw new UnsupportedOperationException();
        if (b == 10) {
            for (int i = 0; i < t; i++) {
                System.out.println(padBinaryStr(read(reader), 10));
                readDecision(reader);
            }
        } else if (b == 20) {
            int first = read(reader), second = 0;
            for (int i = 0; i < 6; i++) {
                second = read(reader);
                if (!isSame(first, second))
                    break;
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
            String result = result(positions, reader);
            System.out.println(result == null ? "bs" : result);
            readDecision(reader);
        }
    }
}