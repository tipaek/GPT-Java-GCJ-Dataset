import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int k = 1; k <= t; ++k) {
            char[] input = in.next().toCharArray();
            int[] depthArr = new int[input.length];
            int braceOpenedCount = 0;

            for (int i=0; i<input.length; i++) {
                depthArr[i] = Integer.parseInt(String.valueOf(input[i]));
            }

            System.out.print("Case #" + k + ": ");

            for (int i=0; i<depthArr.length; i++) {
                int val = depthArr[i];

                // open brace till the val == brace opened count

                if (val > braceOpenedCount) {
                    // open braces equal to val.
                    int bracesToOpen = val - braceOpenedCount;
                    for (int j = 0; j< bracesToOpen; j++) {
                        System.out.print("(");
                        braceOpenedCount ++;
                    }

                    System.out.print(val);

                } else if (val < braceOpenedCount) {
                    int bracesToClose = braceOpenedCount - val;
                    for (int j = 0; j< bracesToClose; j++) {
                        System.out.print(")");
                        braceOpenedCount --;
                    }

                    System.out.print(val);
                    // close braces equal to val.
                } else {
                    System.out.print(val);
                }
            }

            while(braceOpenedCount > 0) {
                System.out.print(")");
                braceOpenedCount --;
            }

            System.out.print('\n');
        }
    }
}