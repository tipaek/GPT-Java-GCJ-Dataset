
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

    int lastNumber = 0;
    int current = 0;
    int numCurrent = 0;
    // System.out.println(input);
    for (int i = 0; i < listaNumeri.size(); i++) {
      current = listaNumeri.get(i);
      // System.out.println("current: " + current + " lastNumber: " +
      // lastNumber);
      if (lastNumber != current) {

        for (int k = 0; k < numCurrent; k++) {
          output += lastNumber + "";
        }
        for (int k = 0; k < lastNumber; k++) {
          output += ")";
        }
        for (int k = 0; k < current; k++) {
          output += "(";
        }
        lastNumber = current;
        numCurrent = 1;
      } else {
        numCurrent++;
      }
    }
    // if (current != 0) {
    for (int k = 0; k < numCurrent; k++) {
      output += lastNumber + "";
    }
    for (int k = 0; k < lastNumber; k++) {
      output += ")";
    }
    // }

    return output;
  }

}