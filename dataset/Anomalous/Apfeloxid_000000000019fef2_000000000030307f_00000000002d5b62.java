import java.util.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCasesAmount = scanner.nextInt();

        for (int i = -4; i <= 4; i++) {
            for (int j = -4; j <= 4; j++) {
                System.out.println(i + " " + j + ":" + getSolution(i, j));
            }
        }

        for (int test = 1; test <= testCasesAmount; test++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println("Case #" + test + ": " + getSolution(x, y));
        }
    }

    private static String getSolution(int aimX, int aimY) {
        List<List<Integer>> possibleRepresentationsX = getRepresentations(Math.abs(aimX), aimX > 0);
        List<List<Integer>> possibleRepresentationsY = getRepresentations(Math.abs(aimY), aimY > 0);

        List<String> possibleOutputs = new ArrayList<>();
        for (List<Integer> repX : possibleRepresentationsX) {
            for (List<Integer> repY : possibleRepresentationsY) {
                if (areCompatible(repX, repY)) {
                    possibleOutputs.add(generateOutput(repX, repY));
                }
            }
        }

        if (possibleOutputs.isEmpty()) {
            return "IMPOSSIBLE";
        } else {
            possibleOutputs.sort(Comparator.comparingInt(String::length));
            return possibleOutputs.get(0);
        }
    }

    private static List<List<Integer>> getRepresentations(int n, boolean positive) {
        if (n == 0) {
            return Collections.singletonList(new ArrayList<>());
        }

        List<List<Integer>> result = new ArrayList<>();

        if (Integer.bitCount(n) == 1) {
            List<Integer> singleNumber = new ArrayList<>();
            singleNumber.add(positive ? n : -n);
            result.add(singleNumber);
            return result;
        }

        int lower = 1 << (Integer.toBinaryString(n).length() - 1);
        int higher = 1 << Integer.toBinaryString(n).length();

        for (List<Integer> rep : getRepresentations(n - lower, positive)) {
            if (!rep.contains(lower) && !rep.contains(-lower)) {
                rep.add(positive ? lower : -lower);
                result.add(rep);
            }
        }

        for (List<Integer> rep : getRepresentations(higher - n, !positive)) {
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

        int aPointer = 0, bPointer = 0;
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

    private static String generateOutput(List<Integer> a, List<Integer> b) {
        int pointerA = 0, pointerB = 0;
        StringBuilder result = new StringBuilder();

        while (pointerA < a.size() || pointerB < b.size()) {
            if (pointerA < a.size() && (pointerB >= b.size() || Math.abs(a.get(pointerA)) < Math.abs(b.get(pointerB)))) {
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