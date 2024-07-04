
import java.sql.SQLOutput;
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String line =in.nextLine();
            System.out.println("Case #" + i + ": " + proc(line));
        }
    }
    private static String proc(String line){
        StringBuilder sb=new StringBuilder();
        char[] chars=line.toCharArray();
        int outer=0;
        int i=0;
        while(i<chars.length){
            int n=Character.digit(chars[i],10);
            if(n>outer){
                for(int k=0;k<n-outer;k++){
                    sb.append("(");
                }
                outer=n;
                sb.append(n);
            }else if(n<outer){

                for(int k=0;k<outer-n;k++){
                    sb.append(")");
                }
                outer=n;
                sb.append(n);
            }
            else if (n==outer){
                sb.append(n);
            }
            i++;

        }
        for(int k=0;k<outer;k++){
            sb.append(")");
        }

        return sb.toString();
    }

}