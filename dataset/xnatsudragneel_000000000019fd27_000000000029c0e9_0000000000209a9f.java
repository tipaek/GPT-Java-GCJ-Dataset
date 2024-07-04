import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String input = in.next();
            String output = "";
            int count = 0; //keep count of opening brackets left to be closed
            int prev = Character.getNumericValue(input.charAt(0));
            //print opening brackets
            for(int o=0; o<prev; o++){
                output += "(";
                count++;
            }
            output+=prev;
            //numbers after first
            for(int index = 1; index<input.length(); index++){
                int next = Character.getNumericValue(input.charAt(index));
                if(next==prev){
                    output+=next;
                }
                else if(next<prev){
                    //print the # of closing brackets according to the diff prev-next
                    for(int j=0; j<(prev-next); j++){
                        output+=")";
                        count--;
                    }
                    output+=next;
                    prev = next;
                }
                else{
                    //print the # of opening brackets according to the diff next-prev
                    for(int j=0; j<(next-prev); j++){
                        output+="(";
                        count++;
                    }
                    output+=next;
                    prev = next;
                }
            }
            for(int k=0; k<count; k++){
                output+=")";
            }
            System.out.println("Case #" + i + ": " + output);
        }
    }
}