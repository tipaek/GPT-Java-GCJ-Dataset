import java.util.Scanner;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        int testCase;
        int roofTestCase;
        int tc = 0;

        String inputSet[] = new String[100];

        int dataSet[][] = new int[100][100];

        Scanner sc = new Scanner(System.in);

        testCase = Integer.parseInt(sc.nextLine());
        roofTestCase = testCase;

        while (roofTestCase-- > 0) {
            inputSet[tc] = sc.nextLine();
            tc++;
        }

        // initial variables
        roofTestCase = testCase;
        tc = 0;

        while (roofTestCase-- > 0) {
            dataSet[tc] = Stream.of(inputSet[tc].split("")).mapToInt(Integer::parseInt).toArray();

            int openBracket = 0;
            int closeBracket = 0;
            int actionBracket = 0;

            System.out.print(String.format("Case #%d : ", tc + 1));

            for (int i = 0; i < dataSet[tc].length; i++) {
                if (i > 0 && dataSet[tc][i] > (openBracket + closeBracket))
                    actionBracket = dataSet[tc][i] - (openBracket + closeBracket);
                else if (i > 0 && dataSet[tc][i] < (openBracket + closeBracket))
                    actionBracket = (openBracket + closeBracket) - dataSet[tc][i];
                else
                    actionBracket = dataSet[tc][i];

                if (i == 0) {
                    for (int j = 0; j < actionBracket; j++) {
                        System.out.print("(");
                        openBracket++;
                    }
                }

                for (int j = 0; j < actionBracket; j++) {
                    if (i > 0 && dataSet[tc][i - 1] > dataSet[tc][i]) {
                        System.out.print(")");
                        closeBracket--;
                    } else if (i > 0 && dataSet[tc][i - 1] < dataSet[tc][i]) {
                        System.out.print("(");
                        openBracket++;
                    }

                }

                System.out.print(dataSet[tc][i]);

                for (int j = 0; j < openBracket + closeBracket; j++) {
                    if (i == dataSet[tc].length - 1) {
                        System.out.print(")");
                    }
                }
            }

            tc++;
            if (tc != testCase)
                System.out.println();
        }
    }
}
