import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numberOfTestCases = Integer.parseInt(scanner.nextLine());

            for (int i = 1; i <= numberOfTestCases; i++) {
                processTestCase(i, scanner);
            }
        }
    }

    private static void processTestCase(int index, Scanner scanner) {
        String[] input = scanner.nextLine().split(" ");
        int slices = Integer.parseInt(input[0]);
        int guests = Integer.parseInt(input[1]);

        List<BigDecimal> sliceWidths = Arrays.stream(scanner.nextLine().split(" "))
                                             .map(BigDecimal::new)
                                             .collect(Collectors.toList());

        int cuts = findMinimumCuts(sliceWidths, guests);
        System.out.printf("Case #%d: %d%n", index, cuts);
    }

    private static int findMinimumCuts(List<BigDecimal> sliceWidths, int guests) {
        Collections.sort(sliceWidths);
        int cuts = -1;

        for (int localCuts = 0; localCuts < guests && cuts == -1; localCuts++) {
            for (BigDecimal sliceWidth : sliceWidths) {
                if (cuts != -1) {
                    break;
                }

                List<BigDecimal> newSliceWidths = calculateNewSliceWidths(localCuts, sliceWidth, sliceWidths);
                if (newSliceWidths.size() < guests) {
                    break;
                }

                for (BigDecimal newSliceWidth : newSliceWidths) {
                    int frequency = Collections.frequency(newSliceWidths, newSliceWidth);
                    if (frequency >= guests) {
                        cuts = localCuts;
                        break;
                    }
                }
            }
        }

        return cuts == -1 ? guests - 1 : cuts;
    }

    private static List<BigDecimal> calculateNewSliceWidths(int localCuts, BigDecimal sliceWidth, List<BigDecimal> sliceWidths) {
        List<BigDecimal> newSliceWidths = new ArrayList<>();

        for (BigDecimal currentSliceWidth : sliceWidths) {
            if (currentSliceWidth.compareTo(sliceWidth) > 0) {
                BigDecimal newSliceWidth = currentSliceWidth.divide(BigDecimal.valueOf(localCuts + 1), BigDecimal.ROUND_HALF_UP);
                for (int piece = 0; piece <= localCuts; piece++) {
                    newSliceWidths.add(newSliceWidth);
                }
            } else {
                newSliceWidths.add(currentSliceWidth);
            }
        }

        return newSliceWidths;
    }
}