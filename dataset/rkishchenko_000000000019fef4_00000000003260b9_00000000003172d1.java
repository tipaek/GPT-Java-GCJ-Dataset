import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.BiFunction;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < t; i++) {
            String[] parameters = scanner.nextLine().split(" ");
            int slicesNumber = Integer.parseInt(parameters[0]);
            int diners = Integer.parseInt(parameters[1]);
            String[] anglesString = scanner.nextLine().split(" ");
            List<Double> slices = new ArrayList<>(anglesString.length);
            for (String s : anglesString) {
                slices.add(Double.parseDouble(s));
            }
            String solution = solve(diners, slices);
            System.out.println("Case #" + (i + 1) + ": " + solution);
        }
    }

    private static String solve(int diners, List<Double> slices) {
        Map<Double, Integer> counts = new HashMap<>();
        for (Double slice : slices) {
            counts.compute(slice, new BiFunction<Double, Integer, Integer>() {
                @Override
                public Integer apply(Double current, Integer count) {
                    return count == null ? 1 : count + 1;
                }
            });
        }

        Double fSlice = null;
        Double maxSlice = null;
        for (Map.Entry<Double, Integer> count : counts.entrySet()) {
            if (count.getValue() >= diners) {
                return String.valueOf(0);
            }
            if (fSlice == null || (count.getValue() > counts.get(fSlice))) {
                fSlice = count.getKey();
            }
            if (maxSlice == null || count.getKey() > maxSlice) {
                maxSlice = count.getKey();
            }
        }

        if (diners == 3) {
            if (counts.get(fSlice) == 2 && !maxSlice.equals(fSlice)) {
                return "1";
            } else {
                for (Double slice : counts.keySet()) {
                    if (counts.containsKey(slice / 2)) {
                        return "1";
                    }
                }

                return "2";
            }
        } else if (diners == 2) {
            return "1";
        }

        return "IMPOSSIBLE";
    }

    private static boolean isSolution(State state, int diners) {
        Map<Double, Integer> counts = new HashMap<>();
        for (Double slice : state.slices) {
            counts.compute(slice, new BiFunction<Double, Integer, Integer>() {
                @Override
                public Integer apply(Double current, Integer count) {
                    return count == null ? 1 : count + 1;
                }
            });
        }

        for (Map.Entry<Double, Integer> count : counts.entrySet()) {
            if (count.getValue() >= diners) {
                return true;
            }
        }

        return false;
    }

    private static class State {

        private List<Double> slices;

        public State(List<Double> slices) {
            this.slices = slices;
        }
    }

}
