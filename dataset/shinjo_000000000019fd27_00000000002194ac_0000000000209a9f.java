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

            System.out.print(String.format("Case #%d : ", tc + 1));

            for (int i = 0; i < dataSet[tc].length; i++) {
                if (dataSet[tc][i] != 0 && dataSet[tc][i] >= openBracket) {
                    openBracket = dataSet[tc][i];
                }
                closeBracket = dataSet[tc][i];

                for (int j = 0; j < openBracket; j++) {
                    if (i == 0)
                        System.out.print("(");
                    else if (i > 0 && dataSet[tc][i - 1] < dataSet[tc][i])
                        System.out.print("(");
                    else if (i > 0 && dataSet[tc][i - 1] > dataSet[tc][i]) {
                        System.out.print(")");
                    }
                }

                System.out.print(dataSet[tc][i]);

                for (int j = 0; j < closeBracket; j++) {
                    if ((i > 0 && dataSet[tc][i - 1] > dataSet[tc][i]) || i == dataSet[tc].length - 1)
                        System.out.print(")");
                }
            }

            tc++;
            if (tc != testCase)
                System.out.println();
        }


    }
}
