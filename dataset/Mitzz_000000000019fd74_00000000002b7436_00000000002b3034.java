import java.util.*;

class MyComparator implements Comparator<String> {
  @Override
  public int compare(String str1, String str2) {
    return (str1.length() - str2.length());
  }
}

public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    sc.nextLine();

    for(int i = 0; i < t; ++i) {
      int n = sc.nextInt();
      sc.nextLine();

      List<String> patterns = new ArrayList<>();
      for(int j = 0; j < n; ++j) {
        patterns.add(sc.nextLine());
      }
      Collections.sort(patterns, Collections.reverseOrder(new MyComparator()));

      String universalPattern = patterns.get(0).substring(1);
      boolean flag = true;
      for(int j = 1; j < patterns.size(); ++j) {
        int patternSize = patterns.get(j).length() - 1;
        //System.out.println(universalPattern.substring(universalPattern.length() - patternSize));
        //System.out.println(patterns.get(j).substring(1));
        if(!universalPattern.substring(universalPattern.length() - patternSize).equals(patterns.get(j).substring(1))) {
          flag = false;
          break;
        }
      }

      if(flag) {
        System.out.println("Case #" + (i + 1) + ": " + universalPattern);
      } else {
        System.out.println("Case #" + (i + 1) + ": *");
      }
    }
  }
}
