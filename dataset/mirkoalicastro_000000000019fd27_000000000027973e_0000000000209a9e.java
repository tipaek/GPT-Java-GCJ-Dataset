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
        byte[] nextSol = new byte[10];
        EnumMap<OP, Integer> map = new EnumMap<OP, Integer>(OP.class);
        map.put(OP.NOTHING, 0);
        map.put(OP.REV, 0);
        map.put(OP.COMPL, 0);
        map.put(OP.BOTH, 0);

        for (int i=0; i<5; i++) {
            sol[i] = askForByte(scanner, i+1);
        }
        for (int i=0; i<5; i++) {
            sol[i+5] = askForByte(scanner, b-4+i);
        }

        byte[] firstSol = sol.clone();

        for (int max=0; max<14; max++) {
            for (int i=0; i<5; i++) {
                nextSol[i] = askForByte(scanner, i+1);
            }
            for (int i=0; i<5; i++) {
                nextSol[i+5] = askForByte(scanner, b-4+i);
            }
            if (Arrays.equals(nextSol, sol)) {
                map.put(OP.NOTHING, map.get(OP.NOTHING)+1);
            } else if (Arrays.equals(nextSol, reverse(sol))) {
                map.put(OP.REV, map.get(OP.REV)+1);
            } else if (Arrays.equals(nextSol, complement(sol))) {
                map.put(OP.COMPL, map.get(OP.COMPL)+1);
            } else {
                map.put(OP.BOTH, map.get(OP.BOTH)+1);
            }
            byte[] tmp = nextSol;
            nextSol = sol;
            sol = tmp;
        }


        int min = Integer.MAX_VALUE;
        OP op = OP.NOTHING;
        for (OP key: map.keySet()) {
            if (map.get(key) < min) {
                min = map.get(key);
                op = key;
            }
        }

        byte[] finalSol;
        switch (op) {
            case NOTHING:
                finalSol = firstSol;
                break;
            case REV:
                finalSol = reverse(firstSol);
                break;
            case COMPL:
                finalSol = complement(firstSol);
                break;
            default:
                finalSol = complement(reverse(firstSol));
                break;
        }
        return finalSol;
    }

}