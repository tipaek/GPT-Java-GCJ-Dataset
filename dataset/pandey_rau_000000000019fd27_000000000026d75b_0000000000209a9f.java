import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int testCases = in.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {

            String string = in.next();
            StringBuffer stringBuffer = new StringBuffer();
            for (int index = 0; index < string.length(); index++) {
                int parseInt = Integer.parseInt(string.substring(index, index + 1));
                for (int i = 0; i < parseInt; i++) {
                    stringBuffer.append("(");
                }
                stringBuffer.append(parseInt);
                for (int i = 0; i < parseInt; i++) {
                    stringBuffer.append(")");
                }
            }

            for (int index = 0; index < stringBuffer.length(); index++) {
                if (index != stringBuffer.length() - 1 && stringBuffer.charAt(index) == ')' && stringBuffer.charAt(index + 1) == '(') {
                    stringBuffer.delete(index, index + 2);
                    index = 0;
                }
            }

            System.out.println("Case #" + testCase + ": " + stringBuffer);
        }
    }
}
