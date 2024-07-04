import java.util.*;

public class Solution {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int testCasesAmount = SCANNER.nextInt();

        for (int test = 1; test <= testCasesAmount; test++) {
            int aimX = SCANNER.nextInt();
            int aimY = SCANNER.nextInt();
            System.out.println("Case #" + test + ": " + findSolution(aimX, aimY));
        }
    }

    private static String findSolution(int aimX, int aimY) {
        List<List<Integer>> possibleXReps = getRepresentations(Math.abs(aimX), aimX > 0);
        List<List<Integer>> possibleYReps = getRepresentations(Math.abs(aimY), aimY > 0);

        List<String> possibleOutputs = new ArrayList<>();
        for (List<Integer> xRep : possibleXReps) {
            for (List<Integer> yRep : possibleYReps) {
                if (areCompatible(xRep, yRep)) {
                    possibleOutputs.add(generateOutput(xRep, yRep));
                }
            }
        }

        if (possibleOutputs.isEmpty()) {
            return "IMPOSSIBLE";
        }

        return Collections.min(possibleOutputs, Comparator.comparingInt(String::length));
    }

    private static List<List<Integer>> getRepresentations(int n, boolean positive) {
        if (n == 0) {
            return Collections.singletonList(new ArrayList<>());
        }

        List<List<Integer>> result = new ArrayList<>();
        if (Integer.bitCount(n) == 1) {
            int value = positive ? n : -n;
            result.add(Collections.singletonList(value));
            return result;
        }

        int lowerPower = 1 << (Integer.toBinaryString(n).length() - 1);
        int higherPower = 1 << Integer.toBinaryString(n).length();

        result.addAll(addRepresentation(n - lowerPower, lowerPower, positive));
        result.addAll(addRepresentation(higherPower - n, higherPower, !positive));

        return result;
    }

    private static List<List<Integer>> addRepresentation(int n, int power, boolean positive) {
        List<List<Integer>> representations = getRepresentations(n, positive);
        int value = positive ? power : -power;

        for (List<Integer> rep : representations) {
            if (!rep.contains(value) && !rep.contains(-value)) {
                rep.add(value);
            }
        }
        return representations;
    }

    private static boolean areCompatible(List<Integer> a, List<Integer> b) {
        a.sort(Comparator.comparingInt(Math::abs));
        b.sort(Comparator.comparingInt(Math::abs));

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

    private static String generateOutput(List<Integer> a, List<Integer> b) {
        StringBuilder output = new StringBuilder();
        int aIndex = 0, bIndex = 0;

        while (aIndex < a.size() || bIndex < b.size()) {
            if (aIndex < a.size() && (bIndex == b.size() || Math.abs(a.get(aIndex)) < Math.abs(b.get(bIndex)))) {
                output.append(a.get(aIndex) > 0 ? "E" : "W");
                aIndex++;
            } else {
                output.append(b.get(bIndex) > 0 ? "N" : "S");
                bIndex++;
            }
        }

        return output.toString();
    }
}