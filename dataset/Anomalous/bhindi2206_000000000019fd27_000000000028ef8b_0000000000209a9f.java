import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int t = 1; t <= numberOfTests; t++) {
            String inputString = scanner.nextLine();
            StringBuilder finalString = new StringBuilder();

            for (char c : inputString.toCharArray()) {
                int num = Character.getNumericValue(c);
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < num; i++) {
                    temp.insert(0, '(');
                    temp.append(')');
                }
                temp.insert(temp.length() / 2, c);
                finalString.append(temp);
            }

            String result = finalString.toString();
            while (result.contains(")(")) {
                result = result.replace(")(", "");
            }

            System.out.println("Case #" + t + ": " + result);
        }

        scanner.close();
    }
}