import java.io.*;
import java.util.*;

import java.nio.file.Path;
import java.nio.file.Files;
import java.util.regex.*;
import java.io.*;
import java.math.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;
import java.text.*;
import java.util.Locale;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = Integer.parseInt(in.nextLine());  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      
      String n = in.nextLine();
      String res = "";
      
      bool zero = false;
      bool one = false;
      for(int j = 0;j < n.length(); j++){
       int curr = (int)(n.charAt(j) - '0');
           if(curr == 0){
               if (one){
                   res += ")0";
               }
               else{
                   res += "0";
               }
              zero = true;
              one = false;
           }
           else{
               if (j == 0 || zero){
                   res += "(1";
               }
               else if(j == n.length() - 1 && one){
                   res += "1)";
               }
               else if(j == n.length() - 1 && zero){
                   res += "(1)";
               }
               else{
                   res += "1";
               }
              zero = false;
              one = true;
           }
       }
       
      System.out.println("Case #" + i + ": " + res);
    }
  }
}