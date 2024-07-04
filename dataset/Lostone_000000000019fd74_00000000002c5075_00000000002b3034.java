import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = Integer.parseInt(sc.nextLine());
    for (int i = 0; i < T; ++i) {
      int N = Integer.parseInt(sc.nextLine());
      String[] S = new String[N];
      for (int j = 0; j < N; j++) {
        S[j] = sc.nextLine();
      }
      System.out.println("Case #" + (i + 1) + ": " + solve(S));
    }
    sc.close();
  }

  private static String solve(String[] s) {
    int[] indices = new int[s.length];
    //    int[] indices2 = new int[s.length];
    String[] temp = new String[s.length];
    for (int i = 0; i < s.length; i++) {
      indices[i] = 0;
      //      indices2[i] = 0;
    }
    StringBuilder ans = new StringBuilder();
    String subans;
    boolean finished;

    do {
      int maxLength = 0;
      int maxLengthIndex = -1;
      for (int i = 0; i < s.length; i++) {

        temp[i] = "";
        for (int j = indices[i]; j < s[i].length(); ++j) {
          if (s[i].charAt(j) == '*' || j == s[i].length() - 1) {
            if (indices[i] > 0 && s[i].charAt(indices[i] - 1) == '*') {
              temp[i] = "*";
            }
            temp[i] += s[i].substring(indices[i], j + 1);
            //            indices2[i] = j + 1;
            if (maxLength < (j + 1) - indices[i]) {
              maxLengthIndex = i;
              maxLength = j - indices[i];
            }
            indices[i] = j + 1;
            break;
          }
        }
      }
      subans = checkIfStringMatches(temp, maxLengthIndex);
      if (subans.equalsIgnoreCase("*")) {
        return "*";
      }
      ans.append(subans);
      finished = true;
      for (int i = 0; i < s.length; i++) {
        //        indices[i] = indices2[i];
        finished = finished && indices[i] == s[i].length();
      }
    } while (!finished);
    return ans.toString();
  }

  private static String checkIfStringMatches(String[] temp, int maxLengthIndex) {
    String ss;
    boolean[] wasAsterixThereB = new boolean[temp.length];
    boolean[] wasAsterixThereE = new boolean[temp.length];
    for (int i = 0; i < temp.length; ++i) {
      if (temp[i].length() > 0 && temp[i].charAt(0) == '*') {
        temp[i] = temp[i].substring(1);
        wasAsterixThereB[i] = true;
      }
      if (temp[i].length() > 0 && temp[i].charAt(temp[i].length() - 1) == '*') {
        temp[i] = temp[i].substring(0, temp[i].length() - 1);
        wasAsterixThereE[i] = true;
      }
    }
    ss = temp[maxLengthIndex];
    StringBuilder ans = new StringBuilder(ss);
    for (int i = 0; i < temp.length; ++i) {
      if (!ss.contains(temp[i])) {
        if (ss.length() != 1 && temp[i].length() != 1) {
          return "*";
        } else if (ss.length() == 1
            && temp[i].length() == 1
            && ((wasAsterixThereB[i]
                    && wasAsterixThereE[i]
                        & (wasAsterixThereB[maxLengthIndex] || wasAsterixThereE[maxLengthIndex]))
                || (wasAsterixThereB[maxLengthIndex]
                    && wasAsterixThereE[maxLengthIndex]
                    && (wasAsterixThereB[i] || wasAsterixThereE[i])))) {
          ans.append(temp[i]);
        } else {
          return "*";
        }
      }
    }
    return ans.toString();
  }
}
