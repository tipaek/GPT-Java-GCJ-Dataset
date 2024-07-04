import java.util.Scanner;

public class Solution {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            String s = sc.next();
            solve(s, i);
        }
    }

    public static void solve(String s, int testCase) {
        StringBuilder finalVal = new StringBuilder();
        int lim = Integer.parseInt(s);
        
        if (lim == 0) {
            System.out.println("Case #" + (testCase + 1) + ": " + s);
        } else if (s.length() == 1) {
            for (int i = 0; i < lim; i++) {
                finalVal.append("(");
            }
            finalVal.append(s);
            for (int i = 0; i < lim; i++) {
                finalVal.append(")");
            }
            System.out.println("Case #" + (testCase + 1) + ": " + finalVal.toString());
        } else if (!s.matches(".*[2-9].*")) {
            finalVal.append(s.charAt(0));
            for (int i = 0; i < s.length() - 1; i++) {
                int one = Character.getNumericValue(s.charAt(i));
                int two = Character.getNumericValue(s.charAt(i + 1));
                
                if (one > two) {
                    finalVal.append(")").append(s.charAt(i + 1));
                } else if (two > one) {
                    finalVal.append("(").append(s.charAt(i + 1));
                } else {
                    finalVal.append(s.charAt(i + 1));
                }
            }
            if (s.startsWith("1")) {
                finalVal.insert(0, "(");
            }
            if (s.endsWith("1")) {
                finalVal.append(")");
            }
            System.out.println("Case #" + (testCase + 1) + ": " + finalVal.toString());
        } else {
            int length = s.length();
            finalVal.append(s.charAt(0));
            for (int i = 0; i < length - 1; i++) {
                int one = Character.getNumericValue(s.charAt(i));
                int two = Character.getNumericValue(s.charAt(i + 1));
                
                if (one < two) {
                    for (int j = 0; j < two - one; j++) {
                        finalVal.append("(");
                    }
                    finalVal.append(s.charAt(i + 1));
                } else if (one > two) {
                    for (int j = 0; j < one - two; j++) {
                        finalVal.append(")");
                    }
                    finalVal.append(s.charAt(i + 1));
                } else {
                    finalVal.append(s.charAt(i + 1));
                }
            }
            for (int i = 0; i < Character.getNumericValue(s.charAt(0)); i++) {
                finalVal.insert(0, "(");
            }
            for (int i = 0; i < Character.getNumericValue(s.charAt(s.length() - 1)); i++) {
                finalVal.append(")");
            }
            System.out.println("Case #" + (testCase + 1) + ": " + finalVal.toString());
        }
    }
}