import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by birukoudzmitry on 04.04.20.
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ": " + solve(in.next()));
        }
    }

    private static String solve(String s) {
        StringBuilder result = new StringBuilder();
        int prev = 0;
        for(int i=0;i<s.length();++i){
            int n = s.charAt(i) - '0';
            if(n-prev >0) {
                output(result, '(', n - prev);
            }else if(n-prev < 0){
                output(result, ')', prev - n);
            }
            result.append(n);
            prev = n;
        }
        output(result, ')', prev);
        return result.toString();
    }

    private static void output(StringBuilder result, char c, int n) {
        while(n>0){
            result.append(c);
            n--;
        }
    }
}
