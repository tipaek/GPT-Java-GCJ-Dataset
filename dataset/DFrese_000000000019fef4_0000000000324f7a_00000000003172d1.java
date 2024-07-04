import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numberOfTestcases = Integer.parseInt(in.nextLine());

        for(int i = 1; i <= numberOfTestcases; i++) {
            findSolution(i, in);
        }
    }

    private static void findSolution(int index, Scanner in) {
        String[] input = in.nextLine().split(" ");

        int slices = Integer.parseInt(input[0]);
        int guests = Integer.parseInt(input[1]);

        System.err.println("slices: " + slices);
        System.err.println("guests: " + guests);

        List<BigDecimal> sliceWidths = Arrays.stream(in.nextLine().split(" "))
                .map(s -> new BigDecimal(s)).collect(Collectors.toList());

        int cuts = -1;

        Collections.sort(sliceWidths);

        for(int localCuts = 0; (localCuts < guests) && (cuts == -1); localCuts++) {
            for(BigDecimal sliceWidth : sliceWidths) {
                if(cuts != -1) {
                    break;
                }

                List<BigDecimal> newSliceWidths = getNewSliceWidths(localCuts, sliceWidth, sliceWidths);
                if(newSliceWidths.size() < guests) {
                    break;
                }

                System.err.println("cuts: " + cuts);
                System.err.println("localCuts: " + localCuts);
                System.err.println("newSliceWidths: " + newSliceWidths);

                for(BigDecimal newSliceWidth : newSliceWidths) {
                    int frequency = Collections.frequency(newSliceWidths, newSliceWidth);

                    System.err.format("Frequency of %s: %s%n", newSliceWidth, frequency);

                    if(frequency >= guests) {
                        cuts = localCuts;
                        break;
                    }
                }
            }
        }

        String result = cuts == -1 ? "" + (guests - 1) : "" + cuts;
        System.out.println(String.format("Case #%s: %s", index, result));

        System.err.println();
    }

    private static List<BigDecimal> getNewSliceWidths(int localCuts, BigDecimal sliceWidth, List<BigDecimal> sliceWidths) {
        List<BigDecimal> newSliceWidths = new ArrayList<>();

        for(BigDecimal localSliceWidth : sliceWidths) {
            if(localSliceWidth.compareTo(sliceWidth) > 0) {
                BigDecimal newSliceWidth = localSliceWidth.divide(new BigDecimal(localCuts + 1));
                for(int piece = 1; piece <= localCuts + 1; piece ++) {
                    newSliceWidths.add(newSliceWidth);
                }
            } else {
                newSliceWidths.add(localSliceWidth);
            }
        }

        return newSliceWidths;
    }
}
