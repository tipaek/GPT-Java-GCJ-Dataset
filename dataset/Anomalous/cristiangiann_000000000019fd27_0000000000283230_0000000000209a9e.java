import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int nTests = Integer.parseInt(input.split(" ")[0]);
        int B = Integer.parseInt(input.split(" ")[1]);

        for (int test = 0; test < nTests; test++) {
            int recursions = 5;
            int[] array = new int[B];
            Arrays.fill(array, -1);
            int startIndex = 0;

            for (int query = 0; query < B;) {
                for (int i = 0; i < recursions; i++) {
                    System.out.println(startIndex + i + 1);
                    array[startIndex + i] = Integer.parseInt(scanner.nextLine());

                    System.out.println(B - startIndex - i);
                    array[B - startIndex - i - 1] = Integer.parseInt(scanner.nextLine());
                    query += 2;
                }
                if (query == B) break;
                array = determineTransformation(array, scanner);
                startIndex += recursions;
                recursions = Math.min(4, (B - query) / 2);
            }

            for (int value : array) {
                System.out.print(value);
            }
            System.out.println();

            String serverResponse = scanner.nextLine();
            if (serverResponse.equals("N")) return;
        }
    }

    private static int[] determineTransformation(int[] array, Scanner scanner) {
        int[] complement = calculateComplement(array);
        int[] reverse = calculateReverse(array);
        int[] compRev = calculateReverse(complement);

        int[] indexesToCheck = new int[2];
        Map<Integer, String> transformationMap = new HashMap<>();
        boolean transformationFound = false;

        for (int i = 0; i < array.length && !transformationFound; i++) {
            for (int j = i + 1; j < array.length && !transformationFound; j++) {
                if (array[i] != -1) {
                    Map<Integer, String> tempMap = new HashMap<>();
                    tempMap.put(array[i] * 2 + array[j], "none");
                    tempMap.put(complement[i] * 2 + complement[j], "comp");
                    tempMap.put(reverse[i] * 2 + reverse[j], "reve");
                    tempMap.put(compRev[i] * 2 + compRev[j], "core");

                    if (tempMap.size() >= 3) {
                        transformationMap = new HashMap<>(tempMap);
                        indexesToCheck[0] = i;
                        indexesToCheck[1] = j;
                        if (tempMap.size() == 4) transformationFound = true;
                    }
                }
            }
        }

        if (transformationMap.size() < 3) {
            indexesToCheck[0] = 0;
            indexesToCheck[1] = 1;
            transformationMap.put(array[0] * 2 + array[1], "none");
            transformationMap.put(complement[0] * 2 + complement[1], "comp");
            transformationMap.put(reverse[0] * 2 + reverse[1], "reve");
            transformationMap.put(compRev[0] * 2 + compRev[1], "core");
        }

        System.out.println(indexesToCheck[0] + 1);
        int a = Integer.parseInt(scanner.nextLine());
        System.out.println(indexesToCheck[1] + 1);
        int b = Integer.parseInt(scanner.nextLine());

        String transformation = transformationMap.get(a * 2 + b);
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