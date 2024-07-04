import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int x = 1; x <= t; ++x) {
        ArrayList<String> patterns = new ArrayList<>();
        int noOfPatterns = in.nextInt();
        for(int i = 0; i < noOfPatterns; i++){
            String next = in.next();
            
            patterns.add(next);
        }
        
        //System.out.println(patterns);
      
      System.out.println("Case #" + x + ": " + getPossibleName(patterns));
    }
  }
  
  private static String getPossibleName(ArrayList<String> patterns){
      String shortest = "";
      int length = Integer.MAX_VALUE;
      String name = null;
      
      for(int i = 0; i < patterns.size(); i++){
          if(length > patterns.get(i).length()){
            shortest = patterns.get(i);
            length = patterns.get(i).length();
          }
      }
      
      //System.out.println("Shortest: " + shortest);
      
      patterns.remove(shortest);
      
      ArrayList<Integer> astSS = getAstPosition(shortest);
      String output = "";
      
      //System.out.println(astSS);
      
      for(int i = 0; i < patterns.size(); i++){
          ArrayList<Integer> astPat = getAstPosition(patterns.get(i));
          String pat = patterns.get(i);
          String tmp = "";
          for(int j = 0; j < astSS.size(); j++){
              int init = 0;
              int next = shortest.length();
              
              String before = shortest.substring(init, astSS.get(j));
              String after = shortest.substring(astSS.get(j) + 1, next);
              
              //System.out.println(before + ", " + after);
              
              if((pat.contains(before) && before.length() != 0) || (pat.contains(after) && after.length() != 0)){
                tmp = before + pat.substring((pat.contains(before) ? pat.indexOf(before) + before.length() : 0), (pat.contains(after) ? pat.indexOf(after) : 0)) + after;
              } else {
                  return "*";
              }
          }
          
          if(tmp.length() > output.length())
            output = tmp;
      }
      
      if(output.length() != 0 && output.contains("*")){
        output = output.replaceAll("\\*","");
      }
      
      return output;
  }
  
  private static ArrayList<Integer> getAstPosition(String val){
      ArrayList<Integer> positions = new ArrayList<>();
      for(int i = 0; i < val.length(); i++)
        if(val.charAt(i) == '*')
            positions.add(i);
      return positions;
  }
}