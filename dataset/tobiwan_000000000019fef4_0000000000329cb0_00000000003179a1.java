import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int cases = in.nextInt();

    for (int t = 1; t <= cases; t++) {
      final int u = in.nextInt();

      HashMap<Character, Long> charCount = new HashMap<>();
      for (int i = 0; i < 1000; i++) {
        String q = in.next();
        char[] response = in.next().toCharArray();

        for (char r : response) {
          long count = charCount.getOrDefault(r, 0L);
          charCount.put(r, count + 1);
        }
      }

      ArrayList<Map.Entry<Character, Long>> list = new ArrayList<>(charCount.entrySet());
      list.sort(Map.Entry.comparingByValue());
      Collections.reverse(list);

      String d = "" + list.get(list.size() - 1).getKey();
      for (int i = 0; i < list.size() - 3; i++) {
        d += list.get(i).getKey();
      }
      for (int i = list.size() - 3; i < list.size() - 1; i++) {
        d += list.get(i).getKey();
      }

      System.out.println("Case #" + t + ": " + d);
    }
  }
}