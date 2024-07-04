import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Scanner;

public class Solution {

    private enum OP {
        NOTHING, COMPL, REV, BOTH;
    }

    static byte[] complement(byte[] bytes) {
        byte[] copy = bytes.clone();
        for (int i=0; i<copy.length; i++) {
            copy[i] = complement(bytes[i]);
        }
        return copy;
    }
    static byte[] reverse(byte[] bytes) {
        byte[] copy = bytes.clone();
        for (int i=0; i<copy.length; i++) {
            copy[i] = bytes[copy.length-1-i];
        }
        return copy;
    }
    static byte complement(byte b) {
        switch (b) {
            case 0:
                return 1;
            case 1:
                return 0;
            default:
                return b;
        }
    }

    public static void main(String...args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int testCases = scanner.nextInt();
        final int b = scanner.nextInt();
        for (int t=1; t<=testCases; t++) {
            byte[] sol = solve(scanner, b);
            System.out.println(join(sol));
            String ans = scanner.next();
            if (ans.equals("N"))
                return;
        }
    }

    private static String join(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b: bytes)
            sb.append(b);
        return sb.toString();
    }

    private static byte askForByte(Scanner scanner, int index) {
        System.out.println(index);
        return Byte.parseByte(scanner.next());
    }

    private static byte[] solve(Scanner scanner, int b) {
        byte[] sol = new byte[10];

        for (int i=0; i<10; i++) {
            sol[i] = askForByte(scanner, i+1);
        }
        return sol;
    }

}