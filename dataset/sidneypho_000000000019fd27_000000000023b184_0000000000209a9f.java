import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {


    public static int[] subtractToIntArray(char[] arr) {
        int[] newArray = new int[arr.length - 1];
        int index = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int num = (arr[i] - '0') - (arr[i+1] - '0');
            newArray[index++] = num;
        }
        return newArray;
    }

    public static String addZeroBeforeAndAfter(String str) {
        StringBuilder sb = new StringBuilder(str);

        //add a zero in front and back
        sb.insert(0, "0");
        sb.insert(sb.length(), "0");
        return sb.toString();
    }

    public static StringBuilder insertParenthesis(StringBuilder sb, int numOfP) {
        while (numOfP != 0) {
            if (numOfP < 0) {
                sb.append('(');
                numOfP++;
            } else if (numOfP > 0) {
                sb.append(')');
                numOfP--;
            }
        }
        return sb;
    }


    public static String parenthesize(String str) {
        String val = addZeroBeforeAndAfter(str);
        char[] stringArray = str.toCharArray();
        int lengthOfString = stringArray.length;

        char[] arr = val.toCharArray();
        int[] diffArray = subtractToIntArray(arr);
        StringBuilder sb = new StringBuilder();
        int index = 1;
        for (int diff : diffArray) {
            insertParenthesis(sb, diff);
            if (index <= lengthOfString) {
                sb.append(arr[index++]);
            }
        }
        return sb.toString();
    }




    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String t = in.next();  // Scanner has functions to read ints, longs, strings, chars, etc.
        int testCases = Integer.parseInt(t);
        for (int i = 1; i <= testCases; i++) {
            String s = in.next();
            System.out.println("Case #" + i + ": " + parenthesize(s));
        }

    }
}