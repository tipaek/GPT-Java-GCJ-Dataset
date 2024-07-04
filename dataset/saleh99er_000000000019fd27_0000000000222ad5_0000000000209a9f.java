import java.util.*;
import java.io.*;
import java.util.Random;
import java.lang.StringBuilder;


public class Solution {

    public static String nestingDepth(String s){
        StringBuilder sb = new StringBuilder();
        int parenLevel = 0;
        for(int i = 0; i < s.length()-1; i++){
            char c = s.charAt(i);
            int digit = c - 48;
            for(int copies = 0; copies < digit-parenLevel; copies++){
                sb.append("(");
            }
            sb.append(digit);
            parenLevel = digit;

            char nextC = s.charAt(i+1);
            int nextDigit = nextC - 48;
            for(int copies = 0; copies < digit-nextDigit; copies++){
                sb.append(")");
            }
        }
       
        
        char c = s.charAt(s.length()-1);
        int digit = c - 48;
        if(s.length() > 1){
            char cBefore = s.charAt(s.length()-2);
            int digitBefore = cBefore - 48;
            for(int copies = 0; copies < digit-digitBefore; copies++){ // close last digit
                sb.append("(");
            }
        }
        else {
            for(int copies = 0; copies < digit; copies++){ // close last digit
                sb.append("(");
            }
        }
        sb.append(digit);
        for(int copies = 0; copies < digit; copies++){ // close last digit
            sb.append(")");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int t = 1; t <= testCases; ++t) {
            String received = in.nextLine();
            System.out.println("String received:" + received);
            String parenString = nestingDepth(received);
            StringBuilder sb = new StringBuilder();
            sb.append("Case #");
            sb.append(t);
            sb.append(": ");
            sb.append(parenString);
            System.out.println(sb.toString());
        }
    }
}