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

    private static String solve(int diners, List<Double> originSlices) {
        if (originSlices.size() == 1) {
            return String.valueOf(diners - 1);
        }
        Queue<List<Double>> queue = new ArrayDeque<>();
        queue.offer(originSlices);
        int cut = 0;
        while (!queue.isEmpty() && cut < diners - 1) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                List<Double> slices = queue.poll();
                if (isSolution(slices, diners)) {
                    return String.valueOf(cut);
                }
                Collections.sort(slices);
                for (int j = 0; j < slices.size(); j++) {
                    List<Double> base = new ArrayList<>();
                    Double target = slices.get(j);
                    for (int k = 0; k <= j; k++) {
                        base.add(slices.get(k));
                    }
                    for (int k = j + 1; k < slices.size(); k++) {
                        List<Double> next = new ArrayList<>(base);
                        Double slice = slices.get(k);
                        if (slice > target) {
                            next.add(target);
                            next.add(slice - target);
                        } else {
                            next.add(slice);
                        }
                        for (int l = k + 1; l < slices.size(); l++) {
                            next.add(slices.get(l));
                        }
                        queue.offer(next);
                    }
                }

            }
            cut++;
        }

        return String.valueOf(diners - 1);
    }

    private static boolean isSolution(List<Double> slices, int diners) {
        Map<Double, Integer> counts = new HashMap<>();
        for (Double slice : slices) {
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
