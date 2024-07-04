import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder finalStr = new StringBuilder();

        for (char ch : input.toCharArray()) {
            StringBuilder tmp = new StringBuilder(String.valueOf(ch));
            int num = Character.getNumericValue(ch);
            for (int i = 0; i < num; i++) {
                tmp.insert(0, "(").append(")");
            }
            finalStr.append(tmp);
        }

        String result = finalStr.toString();
        while (result.contains(")(")) {
            result = result.replace(")(", "");
        }

        System.out.println(result);
    }
}