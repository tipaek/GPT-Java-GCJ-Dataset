import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        int lastDigit = 0;
        int lastBracesAdded = 0;
        for (int i = 0; i < n; i++) {
            String a = s.next();
            StringBuilder result = new StringBuilder();
            lastDigit = 0;
            lastBracesAdded = 0;
            for (int j = 0; j < a.length(); j++) {
                int diff = lastDigit - Integer.parseInt(String.valueOf(a.charAt(j)));
                lastDigit = Integer.parseInt(String.valueOf(a.charAt(j)));
                if (diff == 0) {
                    result.append(a.charAt(j));
                } else if (diff < 0) {
                    for (int k = 0; k < diff; k++) {
                        result.append("(");
                        lastBracesAdded++;
                    }
                    result.append(a.charAt(j));
                } else {
                    for (int k = 0; k < Math.abs(diff); k++) {
                        result.append(")");
                        lastBracesAdded--;
                    }
                    result.append(a.charAt(j));
                }
            }
            for (int j = 0; j <lastBracesAdded ; j++) {
                result.append(")");
            }
            
            System.out.println("Case #" + (i + 1) + ":" + " " + result);
        }
    }
}
