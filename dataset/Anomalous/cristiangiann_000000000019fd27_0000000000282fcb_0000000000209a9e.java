import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int nTests = Integer.parseInt(input.split(" ")[0]);
        int B = Integer.parseInt(input.split(" ")[1]);

        for (int test = 0; test < nTests; test++) {
            int remainingQueries = B;
            int[] array = new int[B];
            Arrays.fill(array, -1);

            for (int startIndex = 0; startIndex < B; startIndex += 5) {
                int queriesToMake = Math.min(5, remainingQueries / 2);
                for (int i = 0; i < queriesToMake; i++) {
                    System.out.println(startIndex + i + 1);
                    array[startIndex + i] = Integer.parseInt(scanner.nextLine());

                    System.out.println(B - startIndex - i);
                    array[B - startIndex - i - 1] = Integer.parseInt(scanner.nextLine());
                }
                remainingQueries -= 2 * queriesToMake;

                if (remainingQueries == 0) break;

                array = updateArray(array, scanner);
            }

            for (int value : array) {
                System.out.print(value);
            }
            System.out.println();

            if ("N".equals(scanner.nextLine())) {
                return;
            }
        }
    }

    private static int[] updateArray(int[] array, Scanner scanner) {
        int[] complement = calculateComplement(array);
        int[] reverse = calculateReverse(array);
        int[] compRev = calculateReverse(complement);

        int[] indexesToCheck = new int[2];
        HashMap<Integer, String> values = new HashMap<>();
        boolean found = false;

        for (int i = 0; i < array.length && !found; i++) {
            for (int j = i + 1; j < array.length && !found; j++) {
                if (array[i] != -1) {
                    HashMap<Integer, String> tempValues = new HashMap<>();
                    tempValues.put(array[i] * 2 + array[j], "none");
                    tempValues.put(complement[i] * 2 + complement[j], "comp");
                    tempValues.put(reverse[i] * 2 + reverse[j], "reve");
                    tempValues.put(compRev[i] * 2 + compRev[j], "core");

                    if (tempValues.size() >= 3) {
                        values = new HashMap<>(tempValues);
                        indexesToCheck[0] = i;
                        indexesToCheck[1] = j;
                        if (values.size() == 4) found = true;
                    }
                }
            }
        }

        if (values.size() < 3) {
            indexesToCheck[0] = 0;
            indexesToCheck[1] = 1;
            values.put(array[0] * 2 + array[1], "none");
            values.put(complement[0] * 2 + complement[1], "comp");
            values.put(reverse[0] * 2 + reverse[1], "reve");
            values.put(compRev[0] * 2 + compRev[1], "core");
        }

        System.out.println(indexesToCheck[0] + 1);
        int a = Integer.parseInt(scanner.nextLine());
        System.out.println(indexesToCheck[1] + 1);
        int b = Integer.parseInt(scanner.nextLine());

        String transformation = values.get(a * 2 + b);

        switch (transformation) {
            case "comp":
                return complement;
            case "reve":
                return reverse;
            case "core":
                return compRev;
            default:
                return array;
        }
    }

    private static int[] calculateReverse(int[] array) {
        int[] reverse = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reverse[i] = array[array.length - 1 - i];
        }
        return reverse;
    }

    private static int[] calculateComplement(int[] array) {
        int[] complement = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            complement[i] = array[i] != -1 ? 1 - array[i] : -1;
        }
        return complement;
    }
}