import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= numCases; i++) {
            String string = scanner.nextLine();
            string = string + string.charAt(string.length() - 1);
            StringBuffer buffer = new StringBuffer();
            int prev = Integer.parseInt(String.valueOf(string.charAt(0)));
            appendOpen(buffer, prev);
            for (int k = 0; k < string.length() - 1; k++) {
                int cur = Integer.parseInt(String.valueOf(string.charAt(k)));
                int next = Integer.parseInt(String.valueOf(string.charAt(k + 1)));

                //add to the left
                if (cur < prev) {
                    //appendClose(buffer, prev - cur);
                } else if (cur > prev) {
                    appendOpen(buffer, cur - prev);
                }

                //add current number
                buffer.append(cur);

                //add to the right
                if (cur < next) {
                    //appendOpen(buffer, next - cur);
                } else if (cur > next) {
                    appendClose(buffer, cur - next);
                }

                prev = cur;
            }

            int lastNum = Integer.parseInt(String.valueOf(string.charAt(string.length() - 1)));
            appendClose(buffer, lastNum);

            System.out.println("Case #" + i + ": " + buffer.toString());
        }
    }

    private static StringBuffer appendOpen(StringBuffer buffer, int number) {
        for (int i = 0; i < number; i++) {
            buffer.append("(");
        }
        return buffer;
    }

    private static StringBuffer appendClose(StringBuffer buffer, int number) {
        for (int i = 0; i < number; i++) {
            buffer.append(")");
        }
        return buffer;
    }
}
