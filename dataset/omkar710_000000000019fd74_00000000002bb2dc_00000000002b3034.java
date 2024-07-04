import java.util.*;

public class Solution {

  public static void main(String[] args) throws Exception {

    Scanner in = new Scanner(System.in);
    int numCases = in.nextInt();

    for(int i  = 0; i < numCases; i++) {
      int n = in.nextInt();

      List<String> arr = new ArrayList<>();

      for(int j = 0; j < n; j++) {
        arr.add(in.next());
      }

      Collections.sort(arr, new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
          return o2.length() - o1.length();
        }
      });

      int total_count = 0;
      String res = "*";

      for(int j = 0; j < arr.size(); j++) {
        StringBuilder s1 = new StringBuilder();
        s1.append(arr.get(j));
        s1.deleteCharAt(s1.indexOf("*"));

        int inner_count = 0;

        for(int k = 0; k < arr.size(); k++) {
          if(j == k) {
            continue;
          }

          String s2 = arr.get(k);

          int pos = s2.indexOf('*');

          String s2p1 = s2.substring(0, pos);
          String s2p2 = s2.substring(pos+1);

          if((s1.length() - s2p2.length() < 0) || (s2p1.length() > s1.length())) {
            continue;
          }

          String s1p1 = s1.substring(0, s2p1.length());

          String s1p2 = s1.substring(s1.length() - s2p2.length());

          if(s1p1.equals(s2p1) && s1p2.equals(s2p2)) {
            inner_count++;
          }
        }

        if(inner_count > total_count) {
          total_count = inner_count;
          res = s1.toString();
        }

      }

      System.out.printf("Case #%d: ", i+1);
      System.out.println(res);

    }

  }

}
