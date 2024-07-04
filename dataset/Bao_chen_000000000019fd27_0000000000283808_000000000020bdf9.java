import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for(int i = 0; i > 0; i++) {
        
    }
    for (int i = 1; i <= t; ++i) {
        int activities = in.nextInt();
        int[][] a = new int[activities][2];
        for(int j = 0; j < activities; j++) {
            a[j][0] = in.nextInt();
            a[j][1] = in.nextInt();
        }
        solve(a, i);
    }
  }
  
  private static boolean checkScsC(int[] a, int start, int end) {
        if (scsC.size() == 0) {
            scsC.add(a);
            return true;
        } else if (scsC.size() == 1) {
            for (int[] s : scsC) {
                if (start >= s[1]) {
                    scsC.add(a);
                    return true;
                } else if (end <= s[0]) {
                    scsC.add(0, a);
                    return true;
                } else {
                    return false;
                }
            }
        }

        if(scsC.get(0)[0] >= end) {
            scsC.add(0, a);
            return true;
        }
        if(scsC.get(scsC.size() - 1)[1] <= start) {
            scsC.add(a);
        }
        for (int i = 0; i < scsC.size(); i++) {
            int right = scsC.get(i)[1];
            if (start >= right) {
                if (i < scsC.size() - 1 && scsC.get(i + 1)[0] >= end) {
                    scsC.add(i + 1, a);
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkScsJ(int[] a, int start, int end) {
        if (scsJ.size() == 0) {
            scsJ.add(a);
            return true;
        } else if (scsJ.size() == 1) {
            for (int[] s : scsJ) {
                if (start >= s[1]) {
                    scsJ.add(a);
                    return true;
                } else if (end <= s[0]) {
                    scsJ.add(0, a);
                    return true;
                } else {
                    return false;
                }
            }
        }
        if(scsJ.get(0)[0] >= end) {
            scsJ.add(0, a);
            return true;
        }
        if(scsJ.get(scsJ.size() - 1)[1] <= start) {
            scsJ.add(a);
            return true;
        }
        for (int i = 0; i < scsJ.size(); i++) {
            int right = scsJ.get(i)[1];
            if (start >= right) {
                if (i < scsJ.size() - 1 && scsJ.get(i + 1)[0] >= end) {
                    scsJ.add(i + 1, a);
                    return true;
                }
            }
        }
        return false;
    }


    static List<int[]> scsJ = new ArrayList();
    static List<int[]> scsC = new ArrayList();

    private static void solve(int[][] a, int caseNum) {
        scsC.clear();
        scsJ.clear();
        int length = a.length;
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int start = a[i][0];
            int end = a[i][1];
            if (checkScsJ(a[i], start, end)) {
                answer.append("J");
            } else if (checkScsC(a[i], start, end)) {
                answer.append("C");
            } else {
                i = length;
            }
        }
        if (answer.length() == length) {
            System.out.println("Case #" + caseNum + ": " + answer.toString());
        } else {
            System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
        }
    }
}