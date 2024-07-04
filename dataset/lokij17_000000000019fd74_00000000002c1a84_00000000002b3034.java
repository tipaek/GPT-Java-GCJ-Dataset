import java.util.*;

class Solution {

  static class Rule {
    String start;
    String end;
    String[] seq;
    int numAsterisk;

    public Rule(String start, String end, String[] seq, int numAsterisk) {
      this.start = start;
      this.end = end;
      this.seq = seq;
      this.numAsterisk = numAsterisk;
    }

    public static String matchAll(ArrayList<Rule> rules, String start, String end) {
      StringBuilder builder = new StringBuilder(10000);
      if (start != null) {
        builder.append(start);
      }
      for (Rule r : rules) {
        int s = r.getStart() != null ? 1 : 0;
        int e = r.getEnd() != null ? r.getSeq().length - 2 : r.getSeq().length - 1;
        for (int i = s; i <= e && i < r.getSeq().length; i++) {
          builder.append(r.getSeq()[i]);
        }
      }
      if (end != null) {
        builder.append(end);
      }
      return builder.toString();
    }

    public String getStart() {
      return start;
    }

    public String getEnd() {
      return end;
    }

    public String[] getSeq() {
      return seq;
    }

    public int getNumAsterisk() {
      return numAsterisk;
    }

    @Override public String toString() {
      return "start = "+start + " end= "+end + " numAsterisk=" + numAsterisk +" seq="+Arrays.toString(seq);
    }
  }

  static Rule parseString(String s) {
    String[] split = s.split("\\*");
    String start = null, end = null;
    int numAsterix = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '*') {
        numAsterix++;
      }
    }
    if (s.charAt(0) != '*') {
      start = split[0];
    }
    if (numAsterix > 0 && s.charAt(s.length() - 1) != '*') {
      end = split[split.length - 1];
    }
    ArrayList<String> newSeq = new ArrayList<>();
    for (String tmp:split) {
      if (tmp != null && !tmp.isEmpty()) {
        newSeq.add(tmp);
      }
    }
    return new Rule(start, end, newSeq.toArray(new String[0]), numAsterix);
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    for (int t = 0; t < T; t++) {
      int n = in.nextInt();

      ArrayList<Rule> rules = new ArrayList<>();
      String start = null, end = null;
      boolean output = true;
      for (int i = 0; i < n; i++) {
        String s = in.next();
        Rule r = parseString(s);
        //System.out.println(r);
        rules.add(r);
        start = updateStart(start, r.getStart());
        end = updateEnd(end, r.getEnd());
        //System.out.println("newSttart="+start + " newEnd="+end);
        if ((start != null && start.equals("*")) || (end != null && end.equals("*"))) {
          output = false;
        }
      }
      if (output) {
        System.out.println(
            "Case #" + (t + 1) + ": " + Rule.matchAll(rules, start, end));
      } else {
        System.out.println("Case #" + (t + 1) + ": *");
      }
    }
  }

  private static String updateEnd(String start, String start1) {
    if (start == null) {
      if (!isNullOrEmpty(start1)) {
        return start1;
      }
      return start;
    }
    if (isNullOrEmpty(start1)) {
      return start;
    }
    if (start.endsWith(start1)) {
      return start;
    } else if (start1.endsWith(start)) {
      return start1;
    } else {
      return "*";
    }
  }

  private static String updateStart(String start, String start1) {
    //System.out.println("first="+start + " sec="+start1);
    if (start == null) {
      if (!isNullOrEmpty(start1)) {
        return start1;
      }
      return start;
    }
    if (isNullOrEmpty(start1)) {
      return start;
    }
    if (start.startsWith(start1)) {
      return start;
    } else if (start1.startsWith(start)) {
      return start1;
    } else {
      return "*";
    }
  }

  static boolean isNullOrEmpty(String s) {
    return s == null || s.isEmpty();
  }

}