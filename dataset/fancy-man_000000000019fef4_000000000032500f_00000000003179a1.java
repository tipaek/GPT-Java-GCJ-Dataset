

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {


    public static final int M_0 = 0x01;
    public static final int M_1 = 0x02;
    public static final int M_2 = 0x04;
    public static final int M_3 = 0x08;
    public static final int M_4 = 0x10;
    public static final int M_5 = 0x20;
    public static final int M_6 = 0x40;
    public static final int M_7 = 0x80;
    public static final int M_8 = 0x100;
    public static final int M_9 = 0x200;
    public static final int M_NOT = 0x400;


    public static String solve (int len, int[] max,  String[] lines)
    {
        int [] map = new int[26];
        for (int i=0; i<map.length; i++)
            map[i] = M_0 | M_1 | M_2 | M_3 | M_4 | M_5 | M_6 | M_7 | M_8 | M_9 | M_NOT;

        int[] masks = new int[10];
        masks[0] = M_0;
        masks[1] = M_1;
        masks[2] = M_2;
        masks[3] = M_3;
        masks[4] = M_4;
        masks[5] = M_5;
        masks[6] = M_6;
        masks[7] = M_7;
        masks[8] = M_8;
        masks[9] = M_9;

        int offset = (int)'A';

        for (int i = 0; i<len; i++)
        {
            char[] line = lines[i].toCharArray();
            int f = (int)line[0] - offset;

            for (int k = 0; k<line.length; k++)
            {
                int ff = (int) line[k] - offset;
                map[ff] &= ~M_NOT;
            }

            map[f] &= ~M_0;

            int m = max[i];
            int dlen = 1;
            while (m > 10)
            {
                m /= 10;
                dlen++;
            }
            if (line.length == dlen)
            {
                for (int k = m+1; k< masks.length; k++)
                    map[f] &= ~masks[k];
            }

        }

        char[] res = new char[10];
        for (int iter =0; iter < masks.length; iter++)
        for (int i=0; i<map.length; i++)
        {
            int mask = map[i];
            for (int k=0; k<masks.length; k++)
                if (mask == masks[k]) {

                    for (int j=0; j<map.length; j++)
                        map[j] &= ~mask;

                    res[k] = (char) (offset + i);

                }

        }


        return new String(res);
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int c = 1; c <= t; ++c) {

            String line = in.nextLine();
            int U = Integer.parseInt(line);

            int[] map = new int[10000];
            String[] lines = new String[10000];

            for (int i=0; i<10000; i++)
            {
                String[] tokens = in.nextLine().split(" ");
                map[i] = Integer.parseInt(tokens[0]);
                lines[i] = tokens[1];
            }

            String res = solve(map.length, map, lines);
            System.out.println("Case #" + c + ": " + res);


        }
    }
}
