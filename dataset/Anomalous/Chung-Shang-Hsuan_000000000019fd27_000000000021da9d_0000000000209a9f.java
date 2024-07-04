import java.util.Scanner;

public class Solution {

    private String s;

    public Solution(StringBuffer str) {
        int count = 0;
        int position = 0;
        while (position < str.length()) {
            int currentDigit = Character.getNumericValue(str.charAt(position));
            if (count > currentDigit) {
                while (count > currentDigit) {
                    str.insert(position, ')');
                    position++;
                    count--;
                }
            } else if (count < currentDigit) {
                while (count < currentDigit) {
                    str.insert(position, '(');
                    position++;
                    count++;
                }
            } else {
                position++;
            }
        }
        while (count > 0) {
            str.append(')');
            count--;
        }
        s = str.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        scanner.nextLine();
        for (int c = 1; c <= cases; c++) {
            String str = scanner.nextLine().trim();
            Solution solution = new Solution(new StringBuffer(str));
            System.out.println("Case #" + c + ": " + solution.s);
        }
        scanner.close();
    }
}