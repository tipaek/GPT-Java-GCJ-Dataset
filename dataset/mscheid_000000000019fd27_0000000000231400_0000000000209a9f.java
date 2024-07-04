import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String input = in.next();
            String nestingDepthStr = nestingDepth(input);
            System.out.println("Case #" +i + ": "+nestingDepthStr);
        }
    }
    public static String nestingDepth(String input){
        int nextNum = -1;
        int unpairedParens = 0;
        int diff;
        StringBuilder stringBuilder = new StringBuilder(input.length());

        for(int i=0;i<input.length();i++){
            int num = charToInt(input.charAt(i));

            if(unpairedParens <= num){
                diff = num - unpairedParens;
                while(diff > 0 ){
                    stringBuilder.append("(");
                    diff--;
                    unpairedParens++;
                }
            }


            stringBuilder.append(input.charAt(i));

            if(unpairedParens >= num && num>0){
                if(i+1 < input.length()){
                    nextNum = charToInt(input.charAt(i+1));
                    diff = Math.abs(num - nextNum);
                }else {
                    diff = num;
                }

                while(diff > 0 && unpairedParens>=0 ){
                    stringBuilder.append(")");
                    diff--;
                    unpairedParens--;
                }
            }


        }


        return stringBuilder.toString();
    }

    public static int charToInt(char c){
        int asciiZero = (int) '0';
        return (int) c - asciiZero;
    }

}