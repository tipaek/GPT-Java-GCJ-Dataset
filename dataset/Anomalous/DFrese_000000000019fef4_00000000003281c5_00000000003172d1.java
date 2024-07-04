import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    private static final double MARGIN = 0.00000001;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCases; i++) {
            processTestCase(i, scanner);
        }
    }

    private static void processTestCase(int caseNumber, Scanner scanner) {
        String[] input = scanner.nextLine().split(" ");
        double slices = Double.parseDouble(input[0]);
        double guests = Double.parseDouble(input[1]);

        List<Double> sliceWidths = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::valueOf)
                .filter(width -> Math.abs(width) > MARGIN)
                .collect(Collectors.toList());

        Collections.sort(sliceWidths);

        int requiredCuts = findMinimumCuts(sliceWidths, guests);

        String result = requiredCuts == -1 ? String.valueOf((int) (guests - 1)) : String.valueOf(requiredCuts);
        System.out.println(String.format("Case #%d: %s", caseNumber, result));
    }

    private static int findMinimumCuts(List<Double> sliceWidths, double guests) {
        int cuts = -1;

        for (int localCuts = 0; localCuts < guests && cuts == -1; localCuts++) {
            for (Double sliceWidth : sliceWidths) {
                if (cuts != -1) break;

                List<Double> newSliceWidths = generateNewSliceWidths(localCuts, sliceWidth, sliceWidths);

                if (newSliceWidths.size() < guests) break;

                for (Double newSliceWidth : newSliceWidths) {
                    int frequency = Collections.frequency(newSliceWidths, newSliceWidth);

                    if (frequency >= guests) {
                        cuts = localCuts;
                        break;
                    }
                }
            }
        }

        return cuts;
    }

    private static List<Double> generateNewSliceWidths(int localCuts, Double sliceWidth, List<Double> sliceWidths) {
        List<Double> newSliceWidths = new ArrayList<>();

        for (Double currentWidth : sliceWidths) {
            if (currentWidth - sliceWidth > MARGIN) {
                double newWidth = currentWidth / (localCuts + 1.0);
                for (int piece = 0; piece <= localCuts; piece++) {
                    newSliceWidths.add(newWidth);
                }
            } else {
                newSliceWidths.add(currentWidth);
            }
        }

        return newSliceWidths;
    }
}