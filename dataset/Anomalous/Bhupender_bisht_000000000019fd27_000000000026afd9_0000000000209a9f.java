import java.util.Scanner;

class Solution {
    
    public static String insertString(String originalString, String stringToBeInserted, int index) {
        return originalString.substring(0, index) + stringToBeInserted + originalString.substring(index);
    }

    public static String myCopy(char[] s1) {
        return new String(s1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int caseNumber = 1;

        while (t-- > 0) {
            String s = sc.next();
            String s1 = myCopy(s.toCharArray());
            int leftCount = 0;

            for (int i = 0; i < s.length(); i++) {
                int currentDigit = Character.getNumericValue(s.charAt(i));
                if (leftCount > currentDigit) {
                    int rightCount = leftCount - currentDigit;
                    String rightBrackets = ")".repeat(rightCount);
                    s1 = insertString(s1, rightBrackets, i + leftCount);
                    leftCount -= rightCount;
                    if (i == s.length() - 1) {
                        s1 += rightBrackets;
                    }
                } else if (leftCount < currentDigit) {
                    String leftBrackets = "(".repeat(currentDigit - leftCount);
                    s1 = insertString(s1, leftBrackets, i + leftCount);
                    leftCount = currentDigit;
                    if (i == s.length() - 1) {
                        s1 += ")".repeat(currentDigit);
                    }
                } else if (i == s.length() - 1) {
                    s1 += ")".repeat(currentDigit);
                }
            }

            sb.append("Case #").append(caseNumber).append(": ").append(s1).append("\n");
            caseNumber++;
        }

        System.out.print(sb.toString());
        sc.close();
    }
}