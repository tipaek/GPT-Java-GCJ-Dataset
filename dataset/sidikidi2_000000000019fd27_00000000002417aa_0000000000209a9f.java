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
            int open = last -'0';
            int balance = open;
            for(int i1 =0; i1<open;i1++){
                builder.append("(");
            }

            builder.append(last);
            for(int i1 =1; i1< c.length;i1++){
                if(last== c[i1]){
                    builder.append(last);
                }
                else{
                    int count = c[i1] -last;
                    if(count<0){
                        int lp = -1* count;
                        for(int l =0; l< lp;l++) {
                            builder.append(")");
                            balance--;
                        }
                    }
//                    if(last == '1'){
//                        builder.append(")");
//                    }
                    last = c[i1];
                    if(count >0){
                        for(int l =0; l< count;l++) {
                            builder.append("(");
                            balance++;
                        }
                    }
                    builder.append(last);
                }
            }
            for (int k =0;k<balance;k++){
                builder.append(")");
            }

            System.out.println("Case #" + i + ": "+builder.toString());
        }
    }
}
