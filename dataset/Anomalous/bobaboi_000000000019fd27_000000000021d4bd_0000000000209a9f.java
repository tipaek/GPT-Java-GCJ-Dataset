import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static int caseCount = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfCases; i++) {
            processCase(scanner);
        }
    }

    public static void processCase(Scanner scanner) {
        String input = scanner.nextLine();
        List<Character> result = new LinkedList<>();
        char[] characters = input.toCharArray();

        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == '1') {
                result.add('(');
                result.add('1');
                while (i < characters.length) {
                    if (characters[i] == '0') {
                        i--;
                        result.remove(result.size() - 1); // Remove last '1'
                        result.add(')');
                        break;
                    } else {
                        result.add('1');
                        i++;
                    }
                }
            } else {
                result.add('0');
            }
        }
        
        if (result.get(result.size() - 1) == '1') {
            result.remove(result.size() - 1); // Remove last '1'
            result.add(')');
        }

        StringBuilder output = new StringBuilder();
        for (char c : result) {
            output.append(c);
        }
        System.out.println(output.toString());
    }
}