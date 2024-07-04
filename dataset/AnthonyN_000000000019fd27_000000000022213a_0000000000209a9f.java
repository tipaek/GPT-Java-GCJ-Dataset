import java.util.*;

public class Solution{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    
    int numOfTestCases = Integer.valueOf(in.nextLine());
    for(int i = 0; i < numOfTestCases; i++)
      System.out.println("Case #" + (i + 1) + ": " + nest(in.nextLine()));
  }
  
  
  private static int countRemainingParen(StringBuilder sb, int index){
    int count = 0;
    for(int i = 0; i < index; i++){
      switch(sb.charAt(i)){
        case '(':  count++;  break;
        case ')':  count--;  break;
      }
    }
    
    return count;
  }
  
  private static String openParen(int num){
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < num; i++)
      sb.append("(");
    
    return sb.toString();
  }
  
  private static String closeParen(int num){
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < num; i++)
      sb.append(")");
    
    return sb.toString();
  }
  
  private static int getLeftIndex(StringBuilder sb, int digit, int index){
    for(int i = index - 1; i >= 0; i--){
      int num = sb.charAt(i) - '0';
      if(num >= 0 && num < digit)
        return i + 1;
    }
    
    return 0;
  }
  
  private static int getRightIndex(StringBuilder sb, int digit, int index){
    for(int i = index + 1; i < sb.length(); i++){
      int num = sb.charAt(i) - '0';
      if(num >= 0 && num < digit)
        return i;
    }
    
    return sb.length();
  }
  
  
  private static String nest(String str){
    StringBuilder sb = new StringBuilder(str);
    
    for(int digit = 1; digit <= 9; digit++){
      int startIndex = 0, nextIndex;
      
      while((nextIndex = sb.indexOf(Integer.toString(digit), startIndex)) != -1){
        int remainingParen = digit - countRemainingParen(sb, nextIndex);
        
        if(remainingParen != 0){
          int leftIndex = getLeftIndex(sb, digit, nextIndex);
          sb = sb.insert(leftIndex, openParen(remainingParen));
          
          int rightIndex = getRightIndex(sb, digit, nextIndex + remainingParen);
          sb = sb.insert(rightIndex, closeParen(remainingParen));
        }
        
        startIndex = nextIndex + remainingParen + 1;
      }
    }
    
    return sb.toString();
  }
}