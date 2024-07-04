import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.lang.Math;

public class Solution {
    public static void findParentheses(int index, String s){
        StringBuilder numStr = new StringBuilder();
        numStr.append(s);
        //String numString = sb.toString();
        StringBuilder s1 = new StringBuilder();
        int end =0;
        int temp = 0;

        int i =0;


        int openedBrackets = 0;
        int lastReadDigit = 0;
        for(int k = 0; k < numStr.length(); k++)
        {
            int readDigit = Character.getNumericValue(numStr.charAt(k));
            if(openedBrackets == 0)
            {
                for(int l = 0; l < readDigit; l++)
                {
                    s1.append('(');
                    openedBrackets++;
                }
                s1.append(numStr.charAt(k));
            }
            else
            {
                if(lastReadDigit == readDigit)
                {
                    s1.append(numStr.charAt(k));
                }
                else if(lastReadDigit < readDigit)
                {
                    int diff = lastReadDigit - readDigit;

                    for(int l = 0; l < Math.abs(diff); l++)
                    {
                        if(diff<0) {
                            s1.append('(');
                            openedBrackets++;
                        }
                        else if (diff > 0) {
                            s1.append(')');
                            openedBrackets--;
                        }
                    }
                    s1.append(numStr.charAt(k));
                }
                else
                {
                    int diff = lastReadDigit - readDigit;
                    for(int l = 0; l < diff; l++)
                    {
                        s1.append(')');
                        openedBrackets--;
                    }
                    s1.append(numStr.charAt(k));
                }
            }

            lastReadDigit = readDigit;
        }
        while(openedBrackets != 0){
            s1.append(')');
            openedBrackets--;
        }
        System.out.println("Case #" + index + ": " + s1);
    }

    public static void main(String args[]){

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String n = in.next();
            //int m = in.nextInt();
            findParentheses(i,n);
        }
    }

}
