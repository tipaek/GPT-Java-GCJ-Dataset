import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer numberOfTestCases = Integer.parseInt(in.nextLine());

        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            Integer numberOfPeriods = Integer.parseInt(in.nextLine());

            Set<Tuple<Integer, Integer>> cameronMinutes = new HashSet<>();
            Set<Tuple<Integer, Integer>> jamieMinutes = new HashSet<>();
            List<Tuple<Integer, Tuple<Integer, Integer>>> periods = new ArrayList<>();
            StringBuffer solution = new StringBuffer();
            for (int periodNum = 1; periodNum <= numberOfPeriods; periodNum++) {
                String line = in.nextLine();
                String periodBorders[] = line.split(" ");
                Integer leftBorder = Integer.parseInt(periodBorders[0]);
                Integer rightBorder = Integer.parseInt(periodBorders[1]);
                Tuple<Integer, Integer> range = new Tuple(leftBorder, rightBorder);
                periods.add(new Tuple(periodNum, range));
            }
            Comparator<Tuple<Integer, Tuple<Integer, Integer>>> myComparator = new Comparator<Tuple<Integer, Tuple<Integer, Integer>>>() {
                public int compare(Tuple<Integer, Tuple<Integer, Integer>> t1, Tuple<Integer, Tuple<Integer, Integer>> t2) {
                    if (t1.getRight().getLeft().compareTo(t2.getRight().getLeft()) != 0) {
                        return t1.getRight().getLeft().compareTo(t2.getRight().getLeft());
                    } else {
                        return t1.getRight().getRight().compareTo(t2.getRight().getRight());
                    }
                }
            };

            List<Tuple<Integer, Tuple<Integer, Integer>>> sortedPeriods = periods.stream()
                    .sorted(myComparator)
                    .collect(Collectors.toList());

            sortedPeriods.stream().forEach(tuple -> System.out.println("(" + tuple.getRight().getLeft() + "," + tuple.getRight().getRight() + ")"));

            Map<Integer, String> solutionMap = new HashMap<>();
            for (Tuple<Integer, Tuple<Integer, Integer>> period : sortedPeriods) {

                Tuple<Integer, Integer> range = period.getRight();
                Set cameronIntersection = cameronMinutes.stream().filter(tuple -> (tuple.getLeft() < range.getRight()) && (range.getLeft() < tuple.getRight())).collect(Collectors.toSet());
                Set jamieIntersection = jamieMinutes.stream().filter(tuple -> (tuple.getLeft() < range.getRight()) && (range.getLeft() < tuple.getRight())).collect(Collectors.toSet());

                if (!solution.toString().equals("IMPOSSIBLE")) {
                    if (cameronIntersection.isEmpty()) {
                        cameronMinutes.add(range);
                        solutionMap.put(period.getLeft(), "C");
                    } else if (jamieIntersection.isEmpty()) {
                        jamieMinutes.add(range);
                        solutionMap.put(period.getLeft(), "J");
                    } else {
                        solution = new StringBuffer("IMPOSSIBLE");
                    }
                }

            }
            if (!solution.toString().equals("IMPOSSIBLE")) {
                for (Tuple<Integer, Tuple<Integer, Integer>> period : periods) {
                    solution.append(solutionMap.get(period.getLeft()));
                }
                System.out.println("Case #" + testCase + ": " + solution);
            }

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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Tuple)) return false;
            Tuple<?, ?> tuple = (Tuple<?, ?>) o;
            return Objects.equals(x, tuple.x) &&
                    Objects.equals(y, tuple.y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}
