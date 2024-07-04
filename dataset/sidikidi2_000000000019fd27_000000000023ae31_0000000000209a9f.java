import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String input = in.next();
            StringBuilder builder = new StringBuilder();
            char [] c = input.toCharArray();

            char last = c[0];
            if(last =='1'){
                builder.append("(");
            }
            builder.append(last);
            for(int i1 =1; i1< c.length;i1++){
                if(last== c[i1]){
                    builder.append(last);
                }
                else{
                    if(last == '1'){
                        builder.append(")");
                    }
                    last = c[i1];
                    if(last =='1'){
                        builder.append("(");
                    }
                    builder.append(last);
                }
            }
            if(last =='1'){
                builder.append(")");
            }

            System.out.println("Case #" + i + ": "+builder.toString());
        }
    }
}