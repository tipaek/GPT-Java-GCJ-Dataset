import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = Integer.parseInt(in.nextLine());
    for (int c = 1; c <= t; ++c) {
      int p = Integer.parseInt(in.nextLine());
      List<String> patterns = new ArrayList<>();
      while(p-->0) patterns.add(in.nextLine().replace("*",""));
      patterns.sort((o1, o2) -> Integer.compare(o2.length(), o1.length()));
      String longest = patterns.get(0);
      boolean matches = true;
      for(int i=0; i< patterns.size() && matches; i++) {
        matches &= longest.contains(patterns.get(i));
      }
      System.out.println(String.format("Case #%d: %s", c, matches ? longest : "*"));
    }
  }
}