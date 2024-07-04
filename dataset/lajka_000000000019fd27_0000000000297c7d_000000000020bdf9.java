import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer numberOfTestCases = Integer.parseInt(in.nextLine());

        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            Integer numberOfPeriods = Integer.parseInt(in.nextLine());

            Set<Tuple<Integer, Integer>> jamieMinutes = new HashSet<>();
            Set<Tuple<Integer, Integer>> cameronMinutes = new HashSet<>();
            StringBuffer solution = new StringBuffer();
            for (int periodNum = 1; periodNum <= numberOfPeriods; periodNum++) {
                String line = in.nextLine();
                String periodBorders[] = line.split(" ");
                Integer leftBorder = Integer.parseInt(periodBorders[0]);
                Integer rightBorder = Integer.parseInt(periodBorders[1]);
                Tuple<Integer, Integer> range = new Tuple(leftBorder, rightBorder);

                Set cameronIntersection = cameronMinutes.stream().filter(tuple -> tuple.getLeft() < range.getRight() && range.getLeft() < tuple.getRight()).collect(Collectors.toSet());
                Set jamieIntersection = jamieMinutes.stream().filter(tuple -> tuple.getLeft() < range.getRight() && range.getLeft() < tuple.getRight()).collect(Collectors.toSet());

                if (!solution.toString().equals("IMPOSSIBLE")) {
                    if (cameronIntersection.isEmpty()) {
                        cameronMinutes.add(range);
                        solution.append("C");
                    } else if (jamieIntersection.isEmpty()) {
                        jamieMinutes.add(range);
                        solution.append("J");
                    } else {
                        solution = new StringBuffer("IMPOSSIBLE");
                    }
                }

            }

            System.out.println("Case #" + testCase + ": " + solution);
        }
    }

    public static class Tuple<X, Y> {
        public final X x;
        public final Y y;

        public Tuple(X x, Y y) {
            this.x = x;
            this.y = y;
        }

        public X getLeft() {
            return x;
        }

        public Y getRight() {
            return y;
        }
    }

}
