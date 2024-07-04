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

    private static void processTestCase(int testCaseNumber, Scanner scanner) {
        String[] inputParams = scanner.nextLine().split(" ");
        int slices = Integer.parseInt(inputParams[0]);
        int guests = Integer.parseInt(inputParams[1]);

        List<BigDecimal> sliceWidths = Arrays.stream(scanner.nextLine().split(" "))
                                             .map(BigDecimal::new)
                                             .collect(Collectors.toList());

        int minCuts = calculateMinCuts(sliceWidths, guests);
        System.out.printf("Case #%d: %d%n", testCaseNumber, minCuts);
    }

    private static int calculateMinCuts(List<BigDecimal> sliceWidths, int guests) {
        Collections.sort(sliceWidths);

        for (int cuts = 0; cuts < guests; cuts++) {
            if (canServeAllGuests(sliceWidths, guests, cuts)) {
                return cuts;
            }
        }
        return guests - 1;
    }

    private static boolean canServeAllGuests(List<BigDecimal> sliceWidths, int guests, int cuts) {
        if (cuts == 0) {
            return sliceWidths.stream().anyMatch(slice -> Collections.frequency(sliceWidths, slice) >= guests);
        }

        for (BigDecimal slice : sliceWidths) {
            List<BigDecimal> newSlices = generateNewSlices(sliceWidths, slice, cuts);
            if (newSlices.stream().anyMatch(newSlice -> Collections.frequency(newSlices, newSlice) >= guests)) {
                return true;
            }
        }
        return false;
    }

    private static List<BigDecimal> generateNewSlices(List<BigDecimal> sliceWidths, BigDecimal slice, int cuts) {
        List<BigDecimal> newSlices = new ArrayList<>();

        for (BigDecimal currentSlice : sliceWidths) {
            if (currentSlice.compareTo(slice) > 0) {
                BigDecimal newSliceWidth = currentSlice.divide(BigDecimal.valueOf(cuts + 1), BigDecimal.ROUND_HALF_UP);
                for (int i = 0; i <= cuts; i++) {
                    newSlices.add(newSliceWidth);
                }
            } else {
                newSlices.add(currentSlice);
            }
        }
        return newSlices;
    }
}