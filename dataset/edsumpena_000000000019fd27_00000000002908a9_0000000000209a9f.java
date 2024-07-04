import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int x = 1; x <= t; ++x) {
      String str = in.next();
      
      System.out.println("Case #" + x + ": " + getNestedStr(str));
    }
  }
  
  private static String getNestedStr(String input){
      for(int i = 1; i < 10; i++){
          ArrayList<Integer> range = getGreaterThanRange(input, i);
          
          /*if(!range.isEmpty())
            System.out.println(range);*/
          
          for(int j = range.size() - 1; j >= 0; j -= 2)
            input = input.substring(0, range.get(j - 1)) + "(" + 
                input.substring(range.get(j - 1), range.get(j)) + ")" + 
                input.substring(range.get(j));
         
      }
      return input;
  }
  
  private static ArrayList<Integer> getGreaterThanRange(String input, int val){
      int start = -1;
      ArrayList<Integer> output = new ArrayList<>();
      for(int i = 0; i <= input.length() - 1; i++){
          try{
          if(Integer.valueOf(input.substring(i, i + 1)) >= val && start == -1){
              start = i;
          } else if(Integer.valueOf(input.substring(i, i + 1)) < val && start != -1){
            output.add(start);
            output.add(i);
            start = -1;
          }
          } catch(Exception e){
              e.printStackTrace();
          }
      }
      
      if(start != -1){
        output.add(start);
        output.add(input.length());
      }
        
    return output;
  }
}