import java.io.BufferedInputStream;
import java.util.Scanner;

public class Solution {

    public static void main(String... args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int testCasesCount = scanner.nextInt();
        for (int i=1; i<=testCasesCount; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            String string = scanner.next();

            int previousNumber = 0;

            for (int j=0; j<string.length(); j++) {
                int number = string.charAt(j) - 48;
                System.out.println(number);
                if (number < previousNumber) {
                    int t = previousNumber - number;
                    for (int k=0; k<t; k++) {
                        stringBuilder.append(')');
                    }
                } else if (number > previousNumber) {
                    int t = number - previousNumber;
                    for (int k=0; k<t; k++) {
                        stringBuilder.append('(');
                    }
                }
                stringBuilder.append(string.charAt(j));
                previousNumber = number;
            }
            for (int j=0; j<previousNumber; j++) {
                stringBuilder.append(')');
            }

            printResult(i, stringBuilder.toString());
        }
    }

    private static void printResult(int i, String s) {
        System.out.print("Case #");
        System.out.print(i);
        System.out.print(": ");

        System.out.print(s);

        System.out.println();
    }

}
