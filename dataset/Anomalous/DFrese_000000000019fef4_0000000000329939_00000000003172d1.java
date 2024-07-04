import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    private static final double MARGIN = 0.0000001;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numberOfTestCases = Integer.parseInt(scanner.nextLine());
            for (int i = 1; i <= numberOfTestCases; i++) {
                processTestCase(i, scanner);
            }
        }
    }

    private static void processTestCase(int caseIndex, Scanner scanner) {
        String[] input = scanner.nextLine().split(" ");
        double slices = Double.parseDouble(input[0]);
        double guests = Double.parseDouble(input[1]);

        List<Double> sliceWidths = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .filter(width -> Math.abs(width) > MARGIN)
                .sorted()
                .collect(Collectors.toList());

        int requiredCuts = calculateMinimumCuts(sliceWidths, guests);
        System.out.printf("Case #%d: %d%n", caseIndex, requiredCuts);
    }

    private static int calculateMinimumCuts(List<Double> sliceWidths, double guests) {
        for (int cuts = 0; cuts < guests; cuts++) {
            for (Double sliceWidth : sliceWidths) {
                List<Double> newSliceWidths = generateNewSliceWidths(cuts, sliceWidth, sliceWidths);
                if (newSliceWidths.size() < guests) {
                    break;
                }
                if (hasSufficientSlices(newSliceWidths, guests)) {
                    return cuts;
                }
            }
        }
        return (int) (guests - 1);
    }

    private static List<Double> generateNewSliceWidths(int cuts, Double sliceWidth, List<Double> sliceWidths) {
        List<Double> newSliceWidths = new ArrayList<>();
        for (Double width : sliceWidths) {
            if (width - sliceWidth > MARGIN) {
                double newWidth = width / (cuts + 1.0);
                for (int i = 0; i <= cuts; i++) {
                    newSliceWidths.add(newWidth);
                }
            } else {
                newSliceWidths.add(width);
            }
        }
        return newSliceWidths;
    }

    private static boolean hasSufficientSlices(List<Double> newSliceWidths, double guests) {
        Map<Double, Long> frequencyMap = newSliceWidths.stream()
                .collect(Collectors.groupingBy(width -> width, Collectors.counting()));
        return frequencyMap.values().stream().anyMatch(count -> count >= guests);
    }
}