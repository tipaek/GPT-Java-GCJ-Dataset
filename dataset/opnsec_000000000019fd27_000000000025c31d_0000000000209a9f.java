import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    in.nextLine();
    for (int i = 1; i <= t; i++) {
      String output = "Case #" + i + ": ";
      String line = in.nextLine();
      System.out.println("nextline is: " + line.length());
      int counter = 0;
      int cursor;
      for(cursor=0; cursor<line.length(); cursor++){
        int current = Integer.parseInt(String.valueOf(line.charAt(cursor)));
        int diff = current - counter;
        for(int diffCount = 0; diffCount < diff; diffCount++){
          output += "(";
        }
        for(int diffCount = 0; diffCount > diff; diffCount--){
          output += ")";
        }
        counter = current;
        output += line.charAt(cursor);
      }
      int current = 0;
      int diff = current - counter;
        for(int diffCount = 0; diffCount < diff; diffCount++){
          output += "(";
        }
        for(int diffCount = 0; diffCount > diff; diffCount--){
          output += ")";
        }
      System.out.println(output);
    }
  }
}
