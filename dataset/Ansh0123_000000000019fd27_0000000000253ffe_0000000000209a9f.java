import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int test = 1; test <= testCases; test++) {
            String st = sc.next();
            String output = getBalancedString(st);
            System.out.println("Case #" + test + ": " + output);
        }
    }

    private static String getBalancedString(String st) {
        StringBuilder sb = new StringBuilder();
        int balance = 0;
        for (char ch : st.toCharArray()) {
            int currBalanceFactor = ch - '0';
            while (currBalanceFactor > balance) {
                balance++;
                sb.append("(");
            }
            while (currBalanceFactor < balance) {
                balance--;
                sb.append(")");
            }
            sb.append(ch);
        }
        while (balance > 0) {
            balance--;
            sb.append(")");
        }
        return sb.toString();
    }
}