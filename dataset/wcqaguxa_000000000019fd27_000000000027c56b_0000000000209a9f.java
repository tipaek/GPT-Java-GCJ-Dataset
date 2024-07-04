import java.util.Scanner;

public class Solution {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= cases; i++) {
            String numbers = scanner.nextLine();
            int brackets = 0;
            StringBuilder result = new StringBuilder();
            for (int j = 0; j < numbers.length(); j++) {
                int value = intValue(numbers.charAt(j));
                while (brackets > value) {
                    result.append(')');
                    brackets--;
                }
                while(brackets < value) {
                    result.append('(');
                    brackets++;
                }
                result.append(value);
            }
            while (brackets > 0) {
                result.append(')');
                brackets--;
            }
            System.out.println("Case #"+i+": "+result.toString());
        }
    }

    static int intValue(char C) {
        return C - '0';
    }

}
