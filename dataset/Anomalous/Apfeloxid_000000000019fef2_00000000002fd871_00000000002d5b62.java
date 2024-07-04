import java.util.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCasesAmount = scanner.nextInt();

        for (int test = 1; test <= testCasesAmount; test++) {
            System.out.println("Case #" + test + ": " + solve());
        }
    }

    private static String solve() {
        int targetX = scanner.nextInt();
        int targetY = scanner.nextInt();

        List<List<Integer>> possibleX = getRepresentations(Math.abs(targetX), targetX > 0);
        List<List<Integer>> possibleY = getRepresentations(Math.abs(targetY), targetY > 0);

        for (List<Integer> repX : possibleX) {
            for (List<Integer> repY : possibleY) {
                if (areCompatible(repX, repY)) {
                    return generateOutput(repX, repY);
                }
            }
        }
        return "IMPOSSIBLE";
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

        int lowerPower = 1 << (Integer.toBinaryString(n).length() - 1);
        List<List<Integer>> lowerReps = getRepresentations(n - lowerPower, positive);
        for (List<Integer> rep : lowerReps) {
            if (!rep.contains(lowerPower) && !rep.contains(-lowerPower)) {
                rep.add(positive ? lowerPower : -lowerPower);
                result.add(rep);
            }
        }

        int higherPower = 1 << Integer.toBinaryString(n).length();
        List<List<Integer>> higherReps = getRepresentations(higherPower - n, !positive);
        for (List<Integer> rep : higherReps) {
            if (!rep.contains(higherPower) && !rep.contains(-higherPower)) {
                rep.add(positive ? higherPower : -higherPower);
                result.add(rep);
            }
        }

        return result;
    }

    private static boolean areCompatible(List<Integer> a, List<Integer> b) {
        a.sort(Comparator.comparingInt(Math::abs));
        b.sort(Comparator.comparingInt(Math::abs));

        int pointerA = 0, pointerB = 0;
        for (int i = 0; i < a.size() + b.size(); i++) {
            if (pointerA < a.size() && Math.abs(a.get(pointerA)) == (1 << i)) {
                pointerA++;
            } else if (pointerB < b.size() && Math.abs(b.get(pointerB)) == (1 << i)) {
                pointerB++;
            } else {
                return false;
            }
        }
        return true;
    }

    private static String generateOutput(List<Integer> a, List<Integer> b) {
        StringBuilder result = new StringBuilder();
        int pointerA = 0, pointerB = 0;

        while (pointerA < a.size() || pointerB < b.size()) {
            if (pointerA < a.size() && (pointerB == b.size() || Math.abs(a.get(pointerA)) < Math.abs(b.get(pointerB)))) {
                result.append(a.get(pointerA) > 0 ? "E" : "W");
                pointerA++;
            } else {
                result.append(b.get(pointerB) > 0 ? "N" : "S");
                pointerB++;
            }
        }
        return result.toString();
    }
}