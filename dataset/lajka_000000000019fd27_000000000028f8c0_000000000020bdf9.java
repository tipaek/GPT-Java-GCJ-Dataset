import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer numberOfTestCases = Integer.parseInt(in.nextLine());

        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            Integer numberOfPeriods = Integer.parseInt(in.nextLine());

            Set<Integer> jamieMinutes = new HashSet<>();
            Set<Integer> cameronMinutes = new HashSet<>();
            StringBuffer solution = new StringBuffer();
            for (int periodNum = 1; periodNum <= numberOfPeriods; periodNum++) {
                String line = in.nextLine();
                String periodBorders[] = line.split(" ");
                Integer leftBorder = Integer.parseInt(periodBorders[0]);
                Integer rightBorder = Integer.parseInt(periodBorders[1]);
                Set<Integer> range = IntStream.rangeClosed(leftBorder, rightBorder).mapToObj(num -> Integer.valueOf(num)).collect(Collectors.toSet());

                Set cameronIntersection = cameronMinutes.stream().filter(range::contains).collect(Collectors.toSet());
                Set jamieIntersection = jamieMinutes.stream().filter(range::contains).collect(Collectors.toSet());

                if (!solution.toString().equals("IMPOSSIBLE")) {
                    if (cameronIntersection.isEmpty() || (cameronIntersection.size() == 1)) {
                        cameronMinutes.addAll(range);
                        solution.append("C");
                    } else if (jamieIntersection.isEmpty() || (jamieIntersection.size() == 1)) {
                        jamieMinutes.addAll(range);
                        solution.append("J");
                    } else {
                        solution = new StringBuffer("IMPOSSIBLE");
                    }
                }

            }

            System.out.println("Case #" + testCase + ": " + solution);
        }
    }
}
