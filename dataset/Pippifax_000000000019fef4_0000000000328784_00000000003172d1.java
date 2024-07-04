import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static BufferedReader in;
    static List<Integer> numbersOfDiners = new ArrayList<>();
    static List<Long[]> allSlices = new ArrayList<>();

    public static void main(String[] args) {
        readInput();

        int i = 1;

        for (int numberOfDiners : numbersOfDiners) {
            processSlices(numberOfDiners, allSlices.get(i - 1), i);
            i++;
        }
    }

    private static void processSlices(int numberOfDiners, Long[] slices, int testcaseId) {
        if (slices.length == 1) {
            System.out.println("Case #" + testcaseId + ": " + (numberOfDiners - 1));
            return;
        }

        List<Long> differentSlices = new ArrayList<>();
        List<Long> duplicateSlices = new ArrayList<>();

        for (Long slice : slices) {
            if (duplicateSlices.contains(slice)) {
                System.out.println("Case #" + testcaseId + ": " + 0);
                return;
            }

            if (differentSlices.contains(slice)) {
                if (numberOfDiners == 2) {
                    System.out.println("Case #" + testcaseId + ": " + 0);
                    return;
                }
                duplicateSlices.add(slice);
            } else {
                differentSlices.add(slice);
            }
        }

        if (numberOfDiners == 2) {
            System.out.println("Case #" + testcaseId + ": " + 1);
            return;
        }

        for (Long slice : differentSlices) {
            if (slice % 2 == 0) {
                long sliceHalf = slice / 2;
                if (differentSlices.contains(sliceHalf)) {
                    System.out.println("Case #" + testcaseId + ": " + 1);
                    return;
                }
            }

            if (differentSlices.contains(slice * 2)) {
                System.out.println("Case #" + testcaseId + ": " + 1);
                return;
            }
        }

        for (Long slice : differentSlices) {
            for (Long differentSlice : differentSlices) {
                if (differentSlice > slice) {
                    System.out.println("Case #" + testcaseId + ": " + 1);
                    return;
                }
            }
        }

        System.out.println("Case #" + testcaseId + ": " + (numberOfDiners - 1));
    }

    private static void readInput() {
        in = new BufferedReader(new InputStreamReader(System.in));

        try {
            String line = in.readLine();

            int numberOfTestCases = Integer.parseInt(line);

            for (int i = 0; i < numberOfTestCases; i++) {
                line = in.readLine();

                String[] fractals = line.split(" ");

                int numberOfSlices = Integer.parseInt(fractals[0]);
                int numberOfDiners = Integer.parseInt(fractals[1]);

                numbersOfDiners.add(numberOfDiners);

                line = in.readLine();

                String[] fractals2 = line.split(" ");

                Long[] slices = new Long[numberOfSlices];

                for (int j = 0; j < numberOfSlices; j++) {
                    slices[j] = Long.parseLong(fractals2[j]);
                }

                allSlices.add(slices);
            }
        } catch (IOException e) {
            System.out.println("something went wrong during reading input");
        }
    }
}
