import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        List<String> inputs = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            inputs.add(scanner.nextLine());
        }

        for (String input : inputs) {
            List<Integer> dataList = new ArrayList<>();
            for (char ch : input.toCharArray()) {
                dataList.add(Character.getNumericValue(ch));
            }

            int remaining = 0;
            StringBuilder result = new StringBuilder();

            for (int num : dataList) {
                while (remaining < num) {
                    result.append('(');
                    remaining++;
                }
                while (remaining > num) {
                    result.append(')');
                    remaining--;
                }
                result.append(num);
            }

            while (remaining > 0) {
                result.append(')');
                remaining--;
            }

            System.out.println(result.toString());
        }
        scanner.close();
    }
}