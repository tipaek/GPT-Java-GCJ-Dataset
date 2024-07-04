import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static final int M_0 = 0x01;
    private static final int M_1 = 0x02;
    private static final int M_2 = 0x04;
    private static final int M_3 = 0x08;
    private static final int M_4 = 0x10;
    private static final int M_5 = 0x20;
    private static final int M_6 = 0x40;
    private static final int M_7 = 0x80;
    private static final int M_8 = 0x100;
    private static final int M_9 = 0x200;
    private static final int M_NOT = 0x400;

    public static String solve(int len, long[] max, String[] lines) {
        int[] map = new int[26];
        for (int i = 0; i < map.length; i++) {
            map[i] = M_0 | M_1 | M_2 | M_3 | M_4 | M_5 | M_6 | M_7 | M_8 | M_9 | M_NOT;
        }

        int[] masks = {M_0, M_1, M_2, M_3, M_4, M_5, M_6, M_7, M_8, M_9};
        int offset = 'A';

        for (int i = 0; i < len; i++) {
            char[] line = lines[i].toCharArray();
            int firstCharIndex = line[0] - offset;

            for (char c : line) {
                int charIndex = c - offset;
                map[charIndex] &= ~M_NOT;
            }

            map[firstCharIndex] &= ~M_0;

            long currentMax = max[i];
            int digitLength = 1;
            while (currentMax >= 10) {
                currentMax /= 10;
                digitLength++;
            }

            if (line.length == digitLength) {
                for (int k = (int) currentMax + 1; k < masks.length; k++) {
                    map[firstCharIndex] &= ~masks[k];
                }
            }
        }

        char[] result = new char[10];
        for (int iter = 0; iter < masks.length; iter++) {
            for (int i = 0; i < map.length; i++) {
                int mask = map[i];
                for (int k = 0; k < masks.length; k++) {
                    if (mask == masks[k]) {
                        for (int j = 0; j < map.length; j++) {
                            map[j] &= ~mask;
                        }
                        result[k] = (char) (offset + i);
                    }
                }
            }
        }

        return new String(result);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        in.nextLine();

        for (int c = 1; c <= t; ++c) {
            int U = Integer.parseInt(in.nextLine());

            long[] map = new long[10000];
            String[] lines = new String[10000];

            for (int i = 0; i < 10000; i++) {
                String[] tokens = in.nextLine().split(" ");
                map[i] = Long.parseLong(tokens[0]);
                lines[i] = tokens[1];
            }

            String res = solve(map.length, map, lines);
            System.out.println("Case #" + c + ": " + res);
        }
    }
}