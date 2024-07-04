import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int currentDepth = 0;

        for (int i = 1; i <= t; ++i) {
            char[] charArray = in.next().toCharArray();
            String result = "";
            for(int j = 0 ; j< charArray.length; j++){
                int charArrayNumber = Integer.valueOf(charArray[j]) - 48;
                if(currentDepth >charArrayNumber){
                    //cerra parentesis hasta estar en la current depth
                    while (currentDepth > charArrayNumber){
                        result += ")";
                        currentDepth --;
                    }
                    result+= charArray[j];
                }else if(currentDepth < charArrayNumber){
                    //agrega parentesis
                    while (currentDepth < charArrayNumber){
                        result += "(";
                        currentDepth ++;
                    }
                    result += charArray[j];
                }else{
                    result += charArrayNumber;
                }
            }
            while(currentDepth > 0){
                result+= ")";
                currentDepth--;
            }
            System.out.println("Case #" + i + ": " + result);
        }
    }
}
