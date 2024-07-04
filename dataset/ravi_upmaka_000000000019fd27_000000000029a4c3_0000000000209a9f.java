import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            String given = sc.next();
            StringBuffer result = new StringBuffer();
            int count = 0;
            
            for (int index = 0; index < given.length(); index++) {
                int digit = Character.getNumericValue(given.charAt(index));
                if (count < digit) {
                    for (int i = 0; i < digit-count; i++) {
                        result.append('(');
                    }
                } else if (count > digit) {
                    for (int i = 0; i < count-digit; i++) {
                        result.append(')');
                    }
                }
                count = digit;
                result.append(digit);
            }
            while (count != 0) {
                result.append(')');
                count--;
            }
            
            System.out.println("Case #" + testCase + ": " + result.toString());
        }
    }
}
