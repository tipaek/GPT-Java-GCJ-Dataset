import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < amount; i++) {
            List<Integer> numbers = stringToIntegerList(scanner.nextLine());

            System.out.println("Case #" + (i + 1) + ": " + solve(numbers));
        }
    }

    private static StringBuilder solve(List<Integer> numbers) {
        StringBuilder result = new StringBuilder();

        int depth = 0;
        for (int i : numbers) {
            if (i > depth) {
                for (int j = 0; j < i - depth; j++) {
                    result.append("(");
                }
                depth = i;
            } else if (i < depth) {
                for (int j = 0; j < depth - i; j++) {
                    result.append(")");
                }
                depth = i;
            }
            result.append(i);
        }
        for (int j = 0; j < depth; j++) {
            result.append(")");
        }

        return result;
    }

    private static List<Integer> stringToIntegerList(String line) {
        return line.chars().map(Character::getNumericValue).boxed().collect(Collectors.toList());
    }
}
