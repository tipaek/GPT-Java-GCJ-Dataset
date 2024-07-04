import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int x = in.nextInt();
            int y = in.nextInt();
            if(x%2 == 0 && y%2 ==0){
                System.out.println(String.format("Case #%d: IMPOSSIBLE", caseNumber));
            }
            System.out.println(x + " " + y);
        }
        
//        int[] positive = toArray(number);
//        int[] negative = toNegative(number);
//        System.out.println(Arrays.toString(negative));


    }

    private static int[] toNegative(int number) {
        int pow2 = 1 << Integer.toBinaryString(number).length();
        int[] next2 = toArray(pow2);
        int[] negative = toArray(pow2 - number);

        for(int i = 0; i < 32; i++) {
            if(negative[i] != 0) {
                next2[i] = -1;
            }
        }

        return next2;
    }

    public static int[] toArray(int number) {
        char[] s = Integer.toBinaryString(number).toCharArray();
        int[] table = new int[32];
        for(int i = 0; i < s.length; i++) {
            table[31 - i] = s[s.length - i -1] - '0';
        }
        return table;
    }


    private static void buildOutput(int caseNumber) {
        System.out.println(String.format("Case #%s:", caseNumber));
    }

}