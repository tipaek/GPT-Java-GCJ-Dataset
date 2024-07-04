import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Abhishek Boharpi on 4/4/2020.
 */
public class Solution {

    private static int noOfTestCases = 0;
    private static List<String> listOfStrings = new ArrayList<>();

    private static String open = "(";
    private static String close = ")";

    public static void main(String[] args) {

        Solution nestingDepth = new Solution();

        nestingDepth.readInput();

//        System.out.println(noOfTestCases);
//        System.out.println(listOfStrings);

        for (int i = 0; i < noOfTestCases; i++) {

            String input = listOfStrings.get(i);

//            System.out.println("Working for " + input);

            String[] array = input.split("");

            StringBuilder stringBuilder = new StringBuilder();

            int count = 0;

            for (int j = 0; j < array.length; j++) {

                int value = Integer.valueOf(array[j]);

//                System.out.println(value);

                if (count != value) {
                    if (count > value) {
                        while (count != value) {
                            stringBuilder.append(close);
                            count--;
                        }
                    } else {
                        while (count != value) {
                            stringBuilder.append(open);
                            count++;
                        }
                    }
                }

                stringBuilder.append(value);
            }

            if (count != 0) {
                while (count != 0) {
                    stringBuilder.append(close);
                    count--;
                }
            }

            System.out.printf("Case #%d: %s", i + 1, stringBuilder.toString());
            System.out.println();
        }
    }

    private void readInput() {

        Scanner scanner = new Scanner(System.in);

        noOfTestCases = Integer.valueOf(scanner.nextLine());

        for (int i = 0; i < noOfTestCases; i++) {

            String input = scanner.nextLine();

            listOfStrings.add(input);
        }
    }

}
