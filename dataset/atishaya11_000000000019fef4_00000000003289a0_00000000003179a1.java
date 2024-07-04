import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int count = in.nextInt();
    for (int t = 1; t <= count; t++) {
      int u = in.nextInt();
      Query[] q = new Query[10000];
      Map<Character, Integer> distinct = new HashMap<>();

      Set<Character> nonZero = new HashSet<>();
      for (int i = 0; i < 10000; i++) {
        String s = in.next();
        String r = in.next();
        q[i] = new Query(s, r);
        if (!s.equals("-1") && s.length() == r.length()) {
          distinct.merge(r.charAt(0), s.charAt(0) - '0', Math::min);
          nonZero.add(r.charAt(0));
        } else if (!s.equals("-1")){
          distinct.merge(r.charAt(0), 9, Math::min);
          nonZero.add(r.charAt(0));
        }
        for (Character ch : q[i].r) {
            distinct.merge(ch, 9, Math::min);
        }
      }
      //System.out.println(distinct);
      //System.out.println(nonZero);

      char[] ans = new char[10];

      Map<Character, Integer> sorted = distinct.entrySet().stream()
          .sorted(Map.Entry.comparingByValue())
          .collect(
              Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
          //System.out.println(sorted);
      int i = 1;
      for (Character c : sorted.keySet()) {
        if (nonZero.contains(c)) {
          ans[i++] = c;
        } else {
          ans[0] = c;
        }
      }

      System.out.printf("Case #%d: %s\n", t, new String(ans));
    }
  }

  static class Query {
    String q;
    char[] r;
    public Query(String q, String r) {
      this.q = q;
      this.r = r.toCharArray();
    }

  }


}

