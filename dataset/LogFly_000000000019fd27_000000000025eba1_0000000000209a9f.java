  
    import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String s = in.nextLine();
            int allParentheses = 0;
            StringBuilder answer = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                int sInt = Integer.parseInt(s.substring(j, j + 1));
                if (sInt == 0) {
                    if (allParentheses > 0) {
                        answer.append(getParentheses(allParentheses, false));
                        allParentheses = 0;
                    }
                } else {
                    if (sInt < allParentheses) {
                        answer.append(getParentheses(allParentheses - sInt, false));
                        allParentheses -= sInt;
                    } else if (sInt > allParentheses) {
                        answer.append(getParentheses(sInt - allParentheses, true));
                        allParentheses = sInt - allParentheses;
                    }
                }
                answer.append(sInt);
            }
            answer.append(getParentheses(allParentheses, false));
            System.out.println("Case #" + i + ": " + answer.toString());
        }
      }
      
      private static String getParentheses(int num, boolean isStart) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < num; i++) {
            result.append(isStart ? "(" : ")");
        }
        return result.toString();
    }
    }