import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amountCases = scanner.nextInt();

        for(int currentCase = 1; currentCase <= amountCases; currentCase ++){
            System.out.print("Case #" + currentCase + ": ");
            solve(scanner);
        }
    }

    public static void solve(Scanner scanner){
        String s = scanner.next();
        StringBuilder sb = new StringBuilder();

        char last = 48;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            for (int j = 0; j < Math.abs(curr-last); j++) {
                sb.append((curr > last)?'(':')');
            }
            sb.append(curr);
            last = curr;
        }

        for (int j = 0; j < Math.abs(48-last); j++) {
            sb.append(')');
        }

        System.out.println(sb.toString());
    }
}