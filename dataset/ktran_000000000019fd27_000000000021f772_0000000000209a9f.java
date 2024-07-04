import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      
      String s = in.next();
      
      String answer = buildString(s, 0);
     
      System.out.println("Case #" + i + ": " + answer);
    }
  }
  
  public static String buildString(String s, int availPara) {
    
    if(s.length()==0) {
        return "";
    }
    char[] digits = s.toCharArray();
    
    int minIndex = -1;
    
    for(int i = 0; i < digits.length; i++) {
        char digit = digits[i];
        if(minIndex == -1 || digits[minIndex] > digit) {
            minIndex = i;
        }
    }
    
    String answer = "";
    
    for(int i = 0;  i < digits[minIndex]-'0' - availPara; i++) {
        answer += "(";
    }
    
    answer += buildString(s.substring(0,minIndex),digits[minIndex]-'0');
    answer += s.charAt(minIndex);
    answer += buildString(s.substring(minIndex+1),digits[minIndex]-'0');
    
    for(int i = 0;  i < digits[minIndex]-'0' - availPara; i++) {
        answer += ")";
    }
    
    return answer;
    
    
  }
}