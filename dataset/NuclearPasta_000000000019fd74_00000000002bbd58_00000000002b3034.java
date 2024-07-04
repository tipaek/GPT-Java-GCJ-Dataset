import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) throws FileNotFoundException{
    Scanner in = new Scanner(new File("bruh.txt"));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int N = in.nextInt();
      String output = "";
      ArrayList<String> patterns = new ArrayList<>();
      for(int j = 0; j < N+1; j++){
          patterns.add(in.nextLine().replaceAll("\\*", ""));
      }
      patterns.remove(0);
      int min_size = -9999999;
      int mindex = 0;
      for(int k = 0; k < patterns.size(); k++){
          if(patterns.get(k).length() > min_size){
              min_size = patterns.get(k).length();
              mindex = k;
          }
      }
      for(int l = 0; l < patterns.size(); l++){
          if(patterns.get(mindex).contains(patterns.get(l)) == false){
            output = "*";
			break;
			}
          else
            output = "FUCK" + patterns.get(mindex);
      }
      System.out.println("Case #" + i + ": " + output);
    }
  }
}