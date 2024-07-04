    import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = in.nextInt();
        for (int k=1;k<=numCases;k++) {
            String answer = "";
            String input = in.next();
            System.out.println(input);
            int depth = 0;

            for (int i=0;i<input.length();i++) {
                int val = Character.getNumericValue(input.charAt(i));
                while (Math.abs(val-depth) > 0) {
                    if (val > depth) {
                        answer += "(";
                        depth++;
                    } else {
                        answer += ")";
                        depth--;
                    }
                }
                answer += val;
            }

            while (--depth >= 0) answer += ")";

            System.out.println("Case #" + k + ": " + answer);
        }
      }
    }
  