import java.io.*;
import java.util.*;

public class Solution {
  public static void step(StringBuffer s, int diff) {
    char c = '(';
    if (diff < 0) {
      c = ')';
    }
    for(int i = 0; i < Math.abs(diff); i++) {
      s.append(c);
    }
  }
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(f.readLine());
		for(int num = 1; num <= t; num++) {
      String s = f.readLine();
      StringBuffer out = new StringBuffer();
      int counter = 0;
      for(int i = 0; i < s.length(); i++) {
        int c = s.charAt(i) - '0';
        int diff = c - counter;
        step(out, diff);
        out.append(s.charAt(i));
        counter = c;
      }
      step(out, counter * -1);

      System.out.println("Case #" + num + ": " + out.toString());
		}
		f.close();
	}
}