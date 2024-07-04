import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    in.nextLine();
    for (int i = 0; i < t; i++) {
      String n = in.nextLine();
      String newString = "";
      int needClose = 0;
      for (int j=0; j<n.length(); j++){
          if (n.charAt(j)=='1' && needClose==0){
              newString+= "(";
              needClose = 1;
          }
          if (n.charAt(j)=='0' && needClose==1){
              newString+= ")";
              needClose = 0;
          }
          newString+= n.charAt(j)+"";
      }
      if (needClose==1) newString+= ")";
      System.out.println("Case #" + (i+1) + ": " + newString);
    }
  }
}