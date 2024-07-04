import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int nTest = in.nextInt();
        for (int i = 0; i < nTest; i++) {
            String s = in.next();
            int[] digits = s.chars().map(x -> x - (int) '0').toArray();
            System.out.println("Case #"+ (i+1) + ": " + compute(s, digits));
            System.out.flush();
        }

    }

    private static String compute(String str, int[] digits) {
        int begin = 0, end = digits.length;
        StringBuilder result = new StringBuilder();

        while (begin < end) {
            while (begin < end && digits[begin] == 0 ) {
                result.append(str.charAt(begin));
                begin++;
            }
            int endTemp = begin;
            while (endTemp < end && digits[endTemp] != 0 )
                endTemp++;
            result.append(computeParenthesis(str, digits, begin, endTemp));
            begin = endTemp;
        }
        return result.toString();
    }

    private static String computeParenthesis(String str, int[] digits, int begin, int end) {
        if (begin == end)
            return "";
        for (int i = begin; i < end; i++)
            digits[i] -= 1;

        StringBuilder result = new StringBuilder();
        while (begin < end) {
            while (begin < end && digits[begin] == 0) {
                result.append(str.charAt(begin));
                begin++;
            }
            int endTemp = begin;
            while (endTemp < end && digits[endTemp] != 0 )
                endTemp++;
            result.append(computeParenthesis(str, digits, begin, endTemp));
            begin = endTemp;
        }

        return result.insert(0, '(').append(')').toString();
    }
}
