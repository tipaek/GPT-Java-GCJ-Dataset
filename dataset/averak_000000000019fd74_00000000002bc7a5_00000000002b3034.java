import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {


  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int countTest = Integer.parseInt(in.nextLine());
    for (int i = 1; i <= countTest; i++) {
      int count = Integer.parseInt(in.nextLine());
      ArrayList<String> a = new ArrayList<>();
      // count sort
      for (int j = 0; j < count; j++) {
        a.add(in.nextLine());
      }
      String res = findMatch(a);
      System.out.println("Case #" + i + ": " + res);
    }
  }

  private static String findMatch(ArrayList<String> a) {
    String max = a.get(0);

    for (int i = 1; i < a.size(); i++) {
      if (max.length() < a.get(i).length()) {
        max = a.get(i);
      }
    }
    char[] str1 = max.toCharArray();
    for (int i = 0; i < a.size(); i++) {
      char[] str2 = a.get(i).toCharArray();
      int j = max.length() - 1;
      //int l = str2.length - 1;
      for (int l = str2.length - 1; l >= 0; l--) {
        if (str2[l] == '*') {
          j = 0;
          break;
        } else if (str1[j] != str2[l]) {
          return "*";
        }
        j--;
      }
      if (j > 0) {
        return "*";
      }
    }
    return max.substring(1);
    }
  }