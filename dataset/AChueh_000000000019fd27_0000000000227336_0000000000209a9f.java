import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        boolean DEBUG = false;
        Scanner in = null;
        try {
            in = DEBUG?new Scanner(new FileInputStream("test.in")):new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ": " + NestingDepth(in.next()));
        }
    }

    static String NestingDepth(String input) {
        StringBuilder sb = new StringBuilder(input);
        char[] chars = input.toCharArray();
        int[] numbers = new int[chars.length];
        for (int i = 0; i < chars.length; ++i) {
            numbers[i] = Character.getNumericValue(chars[i]);
        }
        int currentDepth = 0;
        int currentPivot = 0;
        int currentPivotForInput = 0;
        while(currentPivotForInput < numbers.length) {
            int newDepth = numbers[currentPivotForInput];
            while(currentDepth < newDepth) {
                sb.insert(currentPivot, '(');
                ++currentPivot;
                ++currentDepth;
            }

            while(currentDepth > newDepth) {
                sb.insert(currentPivot, ')');
                ++currentPivot;
                --currentDepth;
            }

            ++currentPivot;
            ++currentPivotForInput;
        }

        while(currentDepth > 0) {
            sb.insert(currentPivot, ')');
            ++currentPivot;
            --currentDepth;
        }
        return sb.toString();
    }
}