import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    in.nextLine(); // clear first line
    for (int i = 1; i <= t; ++i) {
      String line = in.nextLine();
      String res = parenthize(line);
      System.out.println("Case #" + i + ": " + res);
    }
  }

  public static String parenthize(String line) {
    String res = "";
    int openedParentesis = 0;
    int prev = 0;
    for (int i = 0; i < line.length(); i++) {
      char c = line.charAt(i);
      int curr = toNumber(c);
      if (curr > prev) {
        // tengo que abrir
        int p = curr - prev;
        for (int j = 0; j < p; j++) {
          res += "(";
        }
        openedParentesis += p;
      } else if (curr < prev) {
        // tengo que cerrar
        int p = prev - curr;
        for (int j = 0; j < p; j++) {
          res += ")";
        }
        openedParentesis -= p;
      } // else tengo 2 numeros iguales seguidos

      res += c;
      prev = curr;
    }
    for (int i = 0; i < openedParentesis; i++) {
      res += ")";
    }
    return res;
  }

  public static int toNumber(char ch) {
    return (int)ch - (int)'0';
  }

}