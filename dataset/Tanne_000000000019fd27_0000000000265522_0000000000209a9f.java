import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // initiating the base variables
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 1; i <= t; i++) {
            String s = scan.next();
            String y = "";
            int cnt = 0;
            for (int j = 0; j < s.length(); j++) {
                while (Character.getNumericValue(s.charAt(j)) > cnt) {
                    y += "(";
                    cnt++;
                }
                while (Character.getNumericValue(s.charAt(j)) < cnt) {
                    y += ")";
                    cnt--;
                }
                y += s.charAt(j);
            }
            while (cnt != 0) {
                y += ")";
                cnt--;
            }
            System.out.println("Case #" + i + ": " + y);
        }
    }
}
