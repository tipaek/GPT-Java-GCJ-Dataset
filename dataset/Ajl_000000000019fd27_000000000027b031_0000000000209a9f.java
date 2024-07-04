import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T_tests = sc.nextInt();
    for (int i = 1; i <= T_tests; i++) {
      String S_input = sc.next();
      String prime_S = BuildPrime_S(S_input);
      System.out.println("Case #" + i + ": " + prime_S);
    }
  }

  public static String BuildPrime_S(String S_input) {
    int depth = 0;
    int S_inputLength = S_input.length();
    String prime_S = "";
    for (int i = 0; i < S_inputLength; i++) {
      int cur_digit = S_input.charAt(i) - 48;
	  while (depth < cur_digit) {
	    prime_S += "(";
		depth++;
	  }
	  while (depth > cur_digit) {
	    prime_S += ")";
		depth--;
	  }
      prime_S += cur_digit;
    }
    while (depth > 0) {
      prime_S += ")";
      depth--;
    }
    return prime_S;
  }
}