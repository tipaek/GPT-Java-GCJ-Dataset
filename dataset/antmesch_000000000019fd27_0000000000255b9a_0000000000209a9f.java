
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {


  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings,
                          // chars, etc.
    for (int i = 1; i <= t; ++i) {
      String output = analizzaStringa(in);
      System.out.println("Case #" + i + ": " + output);
    }

  }

  public static String analizzaStringa(Scanner in) {
    String output = "";
    String input = in.next();
    final List<Integer> listaNumeri = new ArrayList<>();
    for (int i = 0; i < input.toCharArray().length; i++) {
      listaNumeri.add(Integer.valueOf("" + input.toCharArray()[i]));
    }

    int lastLevel = 0;
    int current = 0;
    int numCurrent = 0;
    int level = 0;
    // System.out.println(input);
    listaNumeri.add(0);
    for (int i = 0; i < listaNumeri.size(); i++) {
      level = listaNumeri.get(i);
      // System.out.print(" level: " + level + " lastLevel: " + lastLevel);
      // System.out.println(" output: " + output);
      if (level == lastLevel) {
        output += level;
      } else if (lastLevel == 0) {
        for (int k = 0; k < level; k++) {
          output += "(";
        }
        output += level;
      } else if (level < lastLevel) {
        int diff = (lastLevel - level);
        for (int k = 0; k < diff; k++) {
          output += ")";
        }
        lastLevel = lastLevel - diff;
        output += level;
      } else if (level > lastLevel) {
        int diff = (level - lastLevel);
        for (int k = 0; k < diff; k++) {
          output += "(";
        }
        output += level;
      }

      lastLevel = level;
    }
    // }
    output = output.substring(0, output.length() - 1);
    return output;
  }

}