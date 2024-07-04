import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static final double MARGIN = 0.0000001;
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numberOfTestcases = Integer.parseInt(in.nextLine());

        for(int i = 1; i <= numberOfTestcases; i++) {
            findSolution(i, in);
        }
    }

    private static void findSolution(int index, Scanner in) {
        String[] input = in.nextLine().split(" ");

        double slices = Double.parseDouble(input[0]);
        double guests = Double.parseDouble(input[1]);

//        System.err.println("slices: " + slices);
//        System.err.println("guests: " + guests);

        List<Double> sliceWidths = Arrays.stream(in.nextLine().split(" "))
                .map(s -> Double.valueOf(s))
                .filter(d -> Math.abs(d - 0.0) > MARGIN)
                .collect(Collectors.toList());

        int cuts = -1;

        Collections.sort(sliceWidths);
//        System.err.println("sliceWidths: " + sliceWidths);

        for(int localCuts = 0; (localCuts < guests) && (cuts == -1); localCuts++) {
            for(Double sliceWidth : sliceWidths) {
                if(cuts != -1) {
//                    System.err.println("Break 1");
                    break;
                }

                List<Double> newSliceWidths = getNewSliceWidths(localCuts, sliceWidth, sliceWidths);
//                System.err.println("cuts: " + cuts);
//                System.err.println("localCuts: " + localCuts);
//                System.err.println("newSliceWidths: " + newSliceWidths);
                if(newSliceWidths.size() < guests) {
//                    System.err.println("Break 2");
                    break;
                }

                for(Double newSliceWidth : newSliceWidths) {
                    int frequency = count(newSliceWidths, newSliceWidth);

//                    System.err.format("Frequency of %s: %s%n", newSliceWidth, frequency);

                    if(frequency >= guests) {
                        cuts = localCuts;

//                        System.err.println("Break 3");
                        break;
                    }
                }
            }
        }

        String result = cuts == -1 ? "" + (int) (guests - 1) : "" + cuts;
        System.out.println(String.format("Case #%s: %s", index, result));


        System.err.println();
    }

    private static int count(List<Double> newSliceWidths, Double newSliceWidth) {
        int counter = 0;

        for(Double d : newSliceWidths) {
//            System.err.println(d + " " + newSliceWidth);
            if(Math.abs(d - newSliceWidth) < MARGIN) {
                counter ++;
            }
        }

        return counter;
    }

    private static List<Double> getNewSliceWidths(double localCuts, Double sliceWidth, List<Double> sliceWidths) {
        List<Double> newSliceWidths = new ArrayList<>();

        for(Double localSliceWidth : sliceWidths) {
            if(localSliceWidth - sliceWidth > MARGIN) {
                Double newSliceWidth = localSliceWidth / (localCuts + 1.0);
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