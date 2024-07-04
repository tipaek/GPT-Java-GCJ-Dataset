

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {


    public static boolean query (Scanner in, int position)
    {
        System.out.println(position);
        String line = in.nextLine();
        if (line.equals("N")) throw new RuntimeException("Exit");
        if (line.equals("0")) return false;
        if (line.equals("1")) return true;
        throw new RuntimeException("Malformed");
    }

    static final byte R_INV = 0;
    static final byte R_REV = 1;



    private static void apply (boolean[] array, byte rule)
    {
        switch (rule)
        {
            case R_INV:
                for (int i=0; i<array.length; i++)
                    array[i] = !array[i];
                break;
            case R_REV:

                for (int i=0; i<array.length / 2; i++) {
                    boolean tmp = array[i];
                    array[i] = array[array.length - i - 1];
                    array[array.length - i - 1] = tmp;
                }
                break;
        }
    }

    public static boolean[] solve (Scanner in, int B)
    {
        // pre:
        int attempts = 0;
        boolean[] array = new boolean[B];

        int pointer = 0;
        int max = B / 2;

        int symmPosition = -1, antiPosition = -1;

        for (; pointer < max; pointer++) {
            boolean left = query(in, pointer + 1);
            boolean right = query(in, B - pointer);
            attempts += 2;

            array[pointer] = left;
            array[B - pointer - 1] = right;

            if (symmPosition < 0)
                if (left == right) {
                    symmPosition = pointer;
                }

            if (antiPosition < 0)
                if (left != right) {
                    antiPosition = pointer;
                }

            if (symmPosition >= 0 && antiPosition >= 0) {
                if (attempts % 10 == 0) {
                    left = query(in, 1); // identify the situation
                    right = query(in, pointer + 1); // re-read since it has changed

                    if (left != array[0])
                        apply(array, R_INV);

                    array[pointer] = right;
                    if (symmPosition > 0)
                        array[B - pointer - 1] = right;
                    else
                        array[B - pointer - 1] = !right;

                } else {
                    left = query(in, 1); // identify the situation
                    left = query(in, 1); // re-read to make in even ??

                    if (left != array[0])
                        apply(array, R_INV);

                }
                attempts += 2;

                pointer++;
                for (; pointer < max; pointer++) {
                    left = query(in, pointer + 1);
                    right = query(in, B - pointer);

                    array[pointer] = left;
                    array[B - pointer - 1] = right;

                    attempts += 2;
                    if (attempts % 10 == 2) {
                        // 2. probe basis points

                        left = query(in, symmPosition + 1);
                        right = query(in, antiPosition + 1);
                        attempts += 2;

                        if (left != array[symmPosition]) {
                            apply(array, R_INV);
                            if (right == array[antiPosition])
                                apply(array, R_REV);
                        } else {
                            if (right != array[antiPosition])
                                apply(array, R_REV);
                        }

                    }

                }
                return array;

            }

        }

        if (symmPosition >= 0)
        {
            boolean left = query(in,symmPosition+1);
            if (left != array[symmPosition])
                apply(array, R_INV);
        }
        else
        {
            boolean left = query(in, antiPosition+11 );
            if (left != array[antiPosition])
                apply(array, R_INV);
        }

        return array;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String line = in.nextLine();
        String[] tokens = line.split(" ");

        int t = Integer.parseInt(tokens[0]);
        int b = Integer.parseInt(tokens[1]);

        for (int c = 1; c <= t; ++c) {

            boolean[] array = solve(in, b);
            char[] result = new char[b];

            for (int i=0; i<b; i++)
                result[i] = array[i]? '1' : '0';

            System.out.println(new String(result));
            line = in.nextLine();

            if (line.equals("Y")) continue;

            break;
        }
    }


}