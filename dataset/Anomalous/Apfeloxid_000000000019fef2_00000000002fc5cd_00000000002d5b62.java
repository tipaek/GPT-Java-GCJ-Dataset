import java.util.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCasesAmount = scanner.nextInt();

        for (int test = 1; test <= testCasesAmount; test++) {
            System.out.println("Case #" + test + ": " + solveTestCase());
        }
    }

    private static String solveTestCase() {
        int targetX = scanner.nextInt();
        int targetY = scanner.nextInt();

        List<List<Integer>> xRepresentations = generateRepresentations(Math.abs(targetX), targetX > 0);
        List<List<Integer>> yRepresentations = generateRepresentations(Math.abs(targetY), targetY > 0);

        for (List<Integer> xRep : xRepresentations) {
            for (List<Integer> yRep : yRepresentations) {
                if (areCompatible(xRep, yRep)) {
                    return buildOutput(xRep, yRep);
                }
            }
        }
        return "IMPOSSIBLE";
    }

    private static List<List<Integer>> generateRepresentations(int n, boolean positive) {
        if (n == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> representations = new ArrayList<>();
        if (Integer.bitCount(n) == 1) {
            List<Integer> singleRep = new ArrayList<>();
            singleRep.add(positive ? n : -n);
            representations.add(singleRep);
            return representations;
        }

        int lower = 1 << (Integer.toBinaryString(n).length() - 1);
        List<List<Integer>> lowerReps = generateRepresentations(n - lower, positive);
        addRepresentation(representations, lowerReps, positive ? lower : -lower);

        int upper = 1 << Integer.toBinaryString(n).length();
        List<List<Integer>> upperReps = generateRepresentations(upper - n, !positive);
        addRepresentation(representations, upperReps, positive ? upper : -upper);

        return representations;
    }

    private static void addRepresentation(List<List<Integer>> representations, List<List<Integer>> newReps, int value) {
        for (List<Integer> rep : newReps) {
            if (!rep.contains(value) && !rep.contains(-value)) {
                rep.add(value);
                representations.add(rep);
            }
        }
    }

    private static boolean areCompatible(List<Integer> a, List<Integer> b) {
        sortByAbsoluteValue(a);
        sortByAbsoluteValue(b);

        int aIndex = 0, bIndex = 0;
        for (int i = 0; i < a.size() + b.size(); i++) {
            if (aIndex < a.size() && Math.abs(a.get(aIndex)) == (1 << i)) {
                aIndex++;
            } else if (bIndex < b.size() && Math.abs(b.get(bIndex)) == (1 << i)) {
                bIndex++;
            } else {
                return false;
            }
        }
        return true;
    }

    private static void sortByAbsoluteValue(List<Integer> list) {
        list.sort(Comparator.comparingInt(Math::abs));
    }

    private static String buildOutput(List<Integer> xRep, List<Integer> yRep) {
        StringBuilder result = new StringBuilder();
        int xIndex = 0, yIndex = 0;

        while (xIndex < xRep.size() || yIndex < yRep.size()) {
            if (xIndex < xRep.size() && (yIndex >= yRep.size() || Math.abs(xRep.get(xIndex)) < Math.abs(yRep.get(yIndex)))) {
                result.append(xRep.get(xIndex) > 0 ? "E" : "W");
                xIndex++;
            } else {
                result.append(yRep.get(yIndex) > 0 ? "N" : "S");
                yIndex++;
            }
        }
        return result.toString();
    }
}