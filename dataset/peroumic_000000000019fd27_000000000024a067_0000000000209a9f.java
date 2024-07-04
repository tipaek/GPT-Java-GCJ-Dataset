

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int q = 0; q < t; q++) {
            String n = in.next();
            Job s = new Job(n);

            System.out.println("Case #" + (q + 1) + ": " + s.result);
        }
    }

  public static  class Job{

        public final String result;
      public Job(String n) {
          result = getResult(n);
      }

      public  String getResult(String n) {
        for (int i = 10; i > 0; i--) {
            n = doShit(i, n);
        }
        return n;
    }

    public  String doShit(int q, String n) {
        if (n.length() == 0) {
            return "";
        }
        String ret;
        String left = "";
        StringBuilder tmp = new StringBuilder();
        int changed = 0;
        for (int i = 0; i < n.length(); i++) {
            String qwe = (n.charAt(i) + "");
            if (qwe.equals("(") || qwe.equals(")")) {
                tmp.append(qwe);
                continue;
            }
            int val = Integer.parseInt(qwe);
            if (val < q) {
                left = n.substring(i);
                break;
            }
            changed++;
            tmp.append(qwe);
        }

        ret = tmp.toString();
        if (changed > 0) {
            ret = "(" + ret + ")";
        }

        changed = 0;
        tmp = new StringBuilder();
        boolean breaked = false;
        for (int i = 0; i < left.length(); i++) {
            String qwe = (left.charAt(i) + "");
            if (qwe.equals("(") || qwe.equals(")")) {
                tmp.append(qwe);
                continue;
            }
            int val = Integer.parseInt(qwe);
            if (val >= q) {
                left = left.substring(i);
                breaked = true;
                break;
            }
            changed++;
            tmp.append(qwe);
        }
        if (left.length() == tmp.length() && changed > 0 && !breaked) {
            left = "";
        }
        ret += tmp.toString();

        return ret + doShit(q, left);
    }
    }
}
