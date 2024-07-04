import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int size = in.nextInt();
    String[] digits = new String[size];
    for (int i = 0; i < size; i++) {
        digits[i] = in.next();
    }
    
    ArrayList<String> output = new ArrayList<String>(size);
    for (String s : digits) {
        ArrayList<Character> str = new ArrayList<Character>();
        for (char c : s.toCharArray()) {
            str.add(c);
        }
        while (hasDigit(str)) {
            int[] maxRange = findRange(str);
            dec(str, maxRange[0], maxRange[1]);
            str.add(maxRange[0], '(');
            str.add(maxRange[1] + 2, ')');
        }
        fix(str, s);
        StringBuilder sb = new StringBuilder();
        for (Character c : str) {
            sb.append(c);
        }
        output.add(sb.toString());
    }
    
    for (int i = 0; i < size; i++) {
        int j = i + 1;
        System.out.println("Case #" + j + ": " + output.get(i));
    }
  }
  
  public static boolean hasDigit(ArrayList<Character> s) {
      for (char c : s) {
          if (Character.isDigit(c) && Character.getNumericValue(c) != 0) {
              return true;
          }
      }
      return false;
  }
  
  public static int[] findRange(ArrayList<Character> s) {
      int maxIndex = -1;
      int maxValue = 0;
      
      for (int i = 0; i < s.size(); i++) {
          if (Character.isDigit(s.get(i)) && Character.getNumericValue(s.get(i)) > maxValue) {
              maxIndex = i;
              maxValue = Character.getNumericValue(s.get(i));
          }
      }
      int low = maxIndex;
      int high = maxIndex;
      for (int i = maxIndex; i >= 0; i--) {
          if (Character.isDigit(s.get(i)) && Character.getNumericValue(s.get(i)) == maxValue) {
              low = i;
          }
          else if (Character.isDigit(s.get(i)) && Character.getNumericValue(s.get(i)) < maxValue) {
              break;
          }
      }
      for (int i = maxIndex; i < s.size(); i++) {
          if (Character.isDigit(s.get(i)) && Character.getNumericValue(s.get(i)) == maxValue) {
              high = i;
          }
          else if (Character.isDigit(s.get(i)) && Character.getNumericValue(s.get(i)) < maxValue) {
              break;
          }
      }
      int[] range = new int[2];
      range[0] = low;
      range[1] = high;
      return range;
  }
  
  public static void dec(ArrayList<Character> s, int low, int high) {
      for (int i = low; i <= high; i++) {
          if (Character.isDigit(s.get(i))) {
              int num = Character.getNumericValue(s.get(i)) - 1;
              char c = (char) (num + '0');
              s.set(i, new Character(c));
          }
      }
  }
  
  public static void fix(ArrayList<Character> str, String s) {
      int index = 0;
      while (index < s.length()) {
          for (int i = 0; i < str.size(); i++) {
              if (Character.isDigit(str.get(i))) {
                  str.set(i, s.charAt(index));
                  index++;
              }
          }
          break;
      }
  }
}