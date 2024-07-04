import java.util.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCasesAmount = scanner.nextInt();

        for (int test = 1; test <= testCasesAmount; test++) {
            int aimX = scanner.nextInt();
            int aimY = scanner.nextInt();
            System.out.println("Case #" + test + ": " + getSolution(aimX, aimY));
        }
    }

    private static String getSolution(int aimX, int aimY) {
        List<List<Integer>> xReps = getRepresentations(Math.abs(aimX), aimX > 0);
        List<List<Integer>> yReps = getRepresentations(Math.abs(aimY), aimY > 0);

        List<String> outputs = new ArrayList<>();
        for (List<Integer> xRep : xReps) {
            for (List<Integer> yRep : yReps) {
                if (areCompatible(xRep, yRep)) {
                    outputs.add(generateOutput(xRep, yRep));
                }
            }
        }

        if (outputs.isEmpty()) {
            return "IMPOSSIBLE";
        } else {
            outputs.sort(Comparator.comparingInt(String::length));
            return outputs.get(0);
        }
    }

    private static List<List<Integer>> getRepresentations(int n, boolean positive) {
        if (n == 0) {
            return Collections.singletonList(new ArrayList<>());
        }

        List<List<Integer>> result = new ArrayList<>();

        if (Integer.bitCount(n) == 1) {
            List<Integer> singleRep = new ArrayList<>();
            singleRep.add(positive ? n : -n);
            result.add(singleRep);
            return result;
        }

        int lower = 1 << (Integer.toBinaryString(n).length() - 1);
        List<List<Integer>> lowerReps = getRepresentations(n - lower, positive);
        for (List<Integer> rep : lowerReps) {
            if (!rep.contains(lower) && !rep.contains(-lower)) {
                rep.add(positive ? lower : -lower);
                result.add(rep);
            }
        }

        int higher = 1 << Integer.toBinaryString(n).length();
        List<List<Integer>> higherReps = getRepresentations(higher - n, !positive);
        for (List<Integer> rep : higherReps) {
            if (!rep.contains(higher) && !rep.contains(-higher)) {
                rep.add(positive ? higher : -higher);
                result.add(rep);
            }
        }

        return result;
    }

    private static boolean areCompatible(List<Integer> a, List<Integer> b) {
        a.sort(Comparator.comparingInt(Math::abs));
        b.sort(Comparator.comparingInt(Math::abs));

        int aPointer = 0;
        int bPointer = 0;
        long exp = 1;

        while (aPointer < a.size() || bPointer < b.size()) {
            if (aPointer < a.size() && Math.abs(a.get(aPointer)) == exp) {
                aPointer++;
            } else if (bPointer < b.size() && Math.abs(b.get(bPointer)) == exp) {
                bPointer++;
            } else {
                return false;
            }
            exp *= 2;
        }
        return true;
    }

    private static String generateOutput(List<Integer> xRep, List<Integer> yRep) {
        StringBuilder result = new StringBuilder();
        int xPointer = 0, yPointer = 0;

        while (xPointer < xRep.size() || yPointer < yRep.size()) {
            if (xPointer < xRep.size() && (yPointer >= yRep.size() || Math.abs(xRep.get(xPointer)) < Math.abs(yRep.get(yPointer)))) {
                result.append(xRep.get(xPointer) > 0 ? "E" : "W");
                xPointer++;
            } else {
                result.append(yRep.get(yPointer) > 0 ? "N" : "S");
                yPointer++;
            }
        }

        return result.toString();
    }
}