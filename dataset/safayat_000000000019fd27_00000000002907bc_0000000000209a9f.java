import java.io.*;
import java.util.*;


public class Solution {



    public static void appendCharMultipleTimes(StringBuilder stringBuilder, char brace, int count){
        while (count-->0){
            stringBuilder.append(brace);
        }
    }
    public static void appendCharWithBraces(StringBuilder stringBuilder, char c, int braceCount){
        appendCharMultipleTimes(stringBuilder, '(', braceCount);
        stringBuilder.append(c);
        appendCharMultipleTimes(stringBuilder, ')', braceCount);
    }
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int index=0;index<t;index++){
            String digit = scanner.next();
            StringBuilder ans = new StringBuilder();
            Integer prev = null;
            for(char c : digit.toCharArray()){
                int d = c-'0';
                if(d == 0){
                    ans.append(c);
                }else {
                    if(prev == null || prev == 0){
                        appendCharWithBraces(ans, c, d);
                    }else {
                        int diff = d - prev;
                        if(diff == 0){
                            ans.insert(ans.length() - prev, c);
                        }else if(diff > 0){
                            StringBuilder sequences = new StringBuilder();
                            appendCharWithBraces(sequences,c,diff);
                            ans.insert(ans.length()-prev, sequences);
                        }else{
                            int absDiff = Math.abs(diff);
                            ans.insert(ans.length()-(prev-absDiff), c);
                        }
                    }
                }
                prev = d;
            }
            System.out.print("Case #");
            System.out.print((index+1)+": ");
            System.out.print(ans);
            System.out.println();
        }
    }




}

