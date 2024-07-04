import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String n = in.nextLine();
            System.out.println("Case #" + i+": " +solve(n));
        }
    }
    
    public static String solve(String input) {
        String retValue = "";
        char[] source = input.toCharArray();
        int index = 0;
        int leftParen = 0;
        while (index < input.length()){
            int current = Integer.parseInt(String.valueOf(source[index]));
            if (leftParen < current) {
                leftParen++;
                retValue += "(";
            } else if (leftParen > current) {
                while(leftParen > current) {
                    retValue += ")";
                    leftParen--;
                }

            } else {
                retValue += current;
                index++;
            }

        }
        while (leftParen > 0) {
            retValue += ")";
            leftParen--;
        }
        return retValue;
    }
}