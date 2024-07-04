import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTests = scanner.nextInt();
        for (int t = 0; t < numTests; t++) {
            String inp = scanner.next();
            int balance = 0;
            String res = "";
            for (int i = 0; i < inp.length(); i++) {
                int val = charToInt(inp.charAt(i));
                while (balance < val) {
                    res += "(";
                    balance++;
                }
                while (balance > val) {
                    res += ")";
                    balance--;
                }
                res += val;
            }
            while (balance > 0) {
                res += ")";
                balance--;
            }
            System.out.println("Case #"+ (t+1) + " " + res);
        }
    }

    public static int charToInt(char c) {
        return c - '0';
    }
}
