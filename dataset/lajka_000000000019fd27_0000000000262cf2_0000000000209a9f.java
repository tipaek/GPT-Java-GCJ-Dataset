import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {

    private static String OPEN_PARENTHESES = "(";
    private static String CLOSE_PARENTHESES = ")";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer numberOfTestCases = Integer.parseInt(in.nextLine());

        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            StringBuffer solution = new StringBuffer();
            String numbers = in.nextLine();

            int index = 0;
            int parenthesesToClose = 0;
            while (index < numbers.length()) {
                Integer number = Integer.parseInt(String.valueOf(numbers.charAt(index)));

                if (parenthesesToClose<number){
                    String openRepeated = IntStream.range(0, (number-parenthesesToClose)).mapToObj(i -> OPEN_PARENTHESES).collect(Collectors.joining(""));
                    parenthesesToClose = number;
                    solution.append(openRepeated).append(number);
                }
                else if (number < parenthesesToClose){
                    String closeRepeated = IntStream.range(0, (parenthesesToClose-number)).mapToObj(i -> CLOSE_PARENTHESES).collect(Collectors.joining(""));
                    parenthesesToClose -= parenthesesToClose-number;
                    solution.append(closeRepeated).append(number);
                }
                else {
                    solution.append(number);
                }

                index++;
            }

            // check if any parethesis left to close
            if (parenthesesToClose != 0){
                String closeRepeated = IntStream.range(0, parenthesesToClose).mapToObj(i -> CLOSE_PARENTHESES).collect(Collectors.joining(""));
                solution.append(closeRepeated);

            }

            System.out.println("Case #" + testCase + ": " + solution.toString());
        }
    }
}
