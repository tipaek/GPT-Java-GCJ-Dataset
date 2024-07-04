import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCases; i++) {
            solveCase(i, scanner);
        }
    }

    private static void solveCase(int caseIndex, Scanner scanner) {
        String[] input = scanner.nextLine().split(" ");
        int slices = Integer.parseInt(input[0]);
        int guests = Integer.parseInt(input[1]);

        System.err.println("slices: " + slices);
        System.err.println("guests: " + guests);

        List<BigDecimal> sliceWidths = Arrays.stream(scanner.nextLine().split(" "))
                .map(BigDecimal::new)
                .collect(Collectors.toList());

        int minimumCuts = findMinimumCuts(sliceWidths, guests);

        System.out.println(String.format("Case #%d: %d", caseIndex, minimumCuts));
    }

    private static int findMinimumCuts(List<BigDecimal> sliceWidths, int guests) {
        int cuts = -1;
        Collections.sort(sliceWidths);

        for (int localCuts = 0; localCuts < guests && cuts == -1; localCuts++) {
            for (BigDecimal sliceWidth : sliceWidths) {
                List<BigDecimal> newSliceWidths = calculateNewSliceWidths(localCuts, sliceWidth, sliceWidths);
                if (newSliceWidths.size() < guests) {
                    break;
                }

                System.err.println("cuts: " + cuts);
                System.err.println("localCuts: " + localCuts);
                System.err.println("newSliceWidths: " + newSliceWidths);

                for (BigDecimal newSliceWidth : newSliceWidths) {
                    int frequency = Collections.frequency(newSliceWidths, newSliceWidth);

                    System.err.format("Frequency of %s: %d%n", newSliceWidth, frequency);

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
                BigDecimal newSliceWidth = currentSliceWidth.divide(BigDecimal.valueOf(localCuts + 1));
                for (int piece = 1; piece <= localCuts + 1; piece++) {
                    newSliceWidths.add(newSliceWidth);
                }
            } else {
                newSliceWidths.add(currentSliceWidth);
            }
        }

        return newSliceWidths;
    }
}