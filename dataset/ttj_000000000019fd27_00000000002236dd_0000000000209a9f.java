public class Solution {
    
    public static void main(String[] args) {
        solve(new Scanner(System.in));
    }
    
    public static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String input = scanner.next();
            String result = getResult(input);
            System.out.print("Case #" + (i + 1) + ": ");
            System.out.print(result);
            if (i != n - 1)
                System.out.println();
        }
    }

    public static String getResult(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        int openParentheses = 0;
        for (char c : input.toCharArray()) {
            int next = c - '0';

            if (openParentheses > next) {
                stringBuilder.append(")".repeat(openParentheses - next));
            } else if (openParentheses < next) {
                stringBuilder.append("(".repeat(next - openParentheses));
            }
            openParentheses = next;

            stringBuilder.append(c);
        }

        stringBuilder.append(")".repeat(openParentheses));
        return stringBuilder.toString();
    }
}
