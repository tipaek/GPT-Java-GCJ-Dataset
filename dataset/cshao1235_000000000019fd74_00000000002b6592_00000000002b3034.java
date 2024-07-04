import java.io.*;
import java.util.*;

public class Solution {
  static final char ASTERISK = '*';

  static String prefix(List<String> strs) {
    for (String big : strs) {
      boolean good = true;
      for (String small : strs) {
        if (!big.startsWith(small)) {
          good = false;
          break;
        }
      }
      if (good) {
        return big;
      }
    }
    return null;
  }

  static String suffix(List<String> strs) {
    for (String big : strs) {
      boolean good = true;
      for (String small : strs) {
        if (!big.endsWith(small)) {
          good = false;
          break;
        }
      }
      if (good) {
        return big;
      }
    }
    return null;
  }

  static String removeAsterisks(String s) {
    StringBuffer b = new StringBuffer("");
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != ASTERISK) {
        b.append(s.charAt(i));
      }
    }
    return b.toString();
  }

  public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(f.readLine());
		for(int num = 1; num <= t; num++) {
      int n = Integer.parseInt(f.readLine());
      List<String> prefixes = new ArrayList<>();
      List<String> suffixes = new ArrayList<>();
      String middle = "";
      for(int i = 0; i < n; i++) {
        String s = f.readLine();
        int l = s.length();
        int forward = 0;
        while (forward < l && s.charAt(forward) != ASTERISK) {
          forward++;
        }
        int backward = l - 1;
        while (backward >= 0 && s.charAt(backward) != ASTERISK) {
          backward--;
        }
        prefixes.add(s.substring(0, forward));
        middle += removeAsterisks(s.substring(forward, backward));
        suffixes.add(s.substring(backward + 1));
      }
      
      String prefix = prefix(prefixes);
      String suffix = suffix(suffixes);
      String output = "*";
      if (prefix != null && suffix != null) {
        output = prefix + middle + suffix;
      }

      //System.out.println(prefixes);
      //System.out.println(suffixes);
      //System.out.println(middle);

      System.out.println("Case #" + num + ": " + output);
		}
		f.close();
	}
}