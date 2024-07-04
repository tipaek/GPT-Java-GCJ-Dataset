import java.io.*;
import java.util.*;

public class Solution {

  static int ten9 = 1000000000;

  public static void main(String args[]) throws FileNotFoundException {
    Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    int T = input.nextInt();
    int U = input.nextInt();
    for (int ks = 1; ks <= T; ks++) {
      System.out.println("Case #" + ks + " " + overRandomized(input, U));
    }
  }

  private static String overRandomized(Scanner input, int u) {
    Set<Character> allCharacterSet = new HashSet<>();
    Map<Integer, Set<Character>> firstDigitLengthMap = new HashMap<>();

    for (int i = 0; i < 10000; i++) {
      long val = input.nextLong();
      String str = input.next();
      if (allCharacterSet.size() != 10) {
        addAllCharacterSet(allCharacterSet, str);
      }
      if (val != -1) {
        if (Long.toString(val).length() == str.length()) {
          firstDigitLengthMap.computeIfAbsent(firstDigit(val), k -> new HashSet<>())
              .add(str.charAt(0));
        }
      }
    }

    Map<Integer, Character> dMap = new HashMap<>();
    Set<Character> knownSet = new HashSet<>();

    for (Integer digit = 1; digit < 10; digit++) {
      if (firstDigitLengthMap.containsKey(digit)) {
        Set<Character> newValueSet = firstDigitLengthMap.get(digit);
        Character value = getValue(newValueSet, knownSet);
        dMap.put(digit, value);
        knownSet.add(value);
      }
    }

    dMap.put(0, getValue(allCharacterSet, knownSet));
    char[] mapping = new char[10];
    for (int i = 0; i < 10; i++) {
      mapping[i] = dMap.get(i);
    }

    return new String(mapping);
  }

  private static void addAllCharacterSet(Set<Character> allCharacterSet, String str) {
    for (char c : str.toCharArray()) {
      allCharacterSet.add(c);
    }
  }

  private static Character getValue(Set<Character> newValueSet, Set<Character> knownSet) {
    for (Character c : newValueSet) {
      if (!knownSet.contains(c)) {
        return c;
      }
    }
    return null;
  }

  private static int firstDigit(Long val) {
    return Character.digit(String.valueOf(val).charAt(0), 10);
  }


}