import java.util.*;
import java.io.*;

public class Solution {
    static List<Integer> best;

    public static void main(String[] args) {
        Integer[] numbers = {-128, -64, -32, -16, -8, -4, -2, -1, 1, 2, 4, 8, 16, 32, 64, 128};
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();

        for (int n = 1; n <= t; n++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int sum = Math.abs(x + y);

            findSumCombination(new ArrayList<>(Arrays.asList(numbers)), sum);
            if (best == null) {
                System.out.println("Case #" + n + ": IMPOSSIBLE");
            } else {
                String direction = convertToString(Math.abs(x), Math.abs(y), sum);
                if (direction.isEmpty()) {
                    System.out.println("Case #" + n + ": IMPOSSIBLE");
                } else {
                    if (x >= 0 && y >= 0) {
                        System.out.println("Case #" + n + ": " + direction);
                    } else if (x >= 0 && y < 0) {
                        System.out.println("Case #" + n + ": " + flipY(direction));
                    } else if (x < 0 && y >= 0) {
                        System.out.println("Case #" + n + ": " + flipX(direction));
                    } else {
                        System.out.println("Case #" + n + ": " + flipBoth(direction));
                    }
                }
            }
        }
    }

    static void findSumCombination(List<Integer> numbers, int target) {
        findSumCombinationRecursive(numbers, target, new ArrayList<>());
    }

    static void findSumCombinationRecursive(List<Integer> numbers, int target, List<Integer> partial) {
        int sum = partial.stream().mapToInt(Integer::intValue).sum();
        if (sum == target && isValidCombination(partial, target)) {
            best = new ArrayList<>(partial);
        }
        if (sum >= target) return;

        for (int i = 0; i < numbers.size(); i++) {
            List<Integer> remaining = new ArrayList<>(numbers.subList(i + 1, numbers.size()));
            List<Integer> partialRec = new ArrayList<>(partial);
            partialRec.add(numbers.get(i));
            findSumCombinationRecursive(remaining, target, partialRec);
        }
    }

    static boolean isValidCombination(List<Integer> nums, int target) {
        for (int i = 0; i < nums.size(); i++) {
            if (Math.abs(nums.get(i)) != Math.pow(2, i)) {
                return false;
            }
        }
        return true;
    }

    static String convertToString(int x, int y, int target) {
        Integer[] numbers = best.toArray(new Integer[0]);
        StringBuilder str = new StringBuilder();

        for (int num : best) {
            findSumCombinationSecond(new ArrayList<>(Arrays.asList(numbers)), y);
            if (best.contains(num)) {
                if (num < 0) {
                    str.append("S");
                } else {
                    str.append("N");
                }
            } else {
                if (num < 0) {
                    str.append("W");
                } else {
                    str.append("E");
                }
            }
        }
        return str.toString();
    }

    static void findSumCombinationSecond(List<Integer> numbers, int target) {
        findSumCombinationRecursiveSecond(numbers, target, new ArrayList<>());
    }

    static void findSumCombinationRecursiveSecond(List<Integer> numbers, int target, List<Integer> partial) {
        int sum = partial.stream().mapToInt(Integer::intValue).sum();
        if (sum == target) {
            best = new ArrayList<>(partial);
        }
        if (sum >= target) return;

        for (int i = 0; i < numbers.size(); i++) {
            List<Integer> remaining = new ArrayList<>(numbers.subList(i + 1, numbers.size()));
            List<Integer> partialRec = new ArrayList<>(partial);
            partialRec.add(numbers.get(i));
            findSumCombinationRecursiveSecond(remaining, target, partialRec);
        }
    }

    static String flipY(String orig) {
        return orig.replace('S', 'n').replace('N', 'S').replace('n', 'N');
    }

    static String flipX(String orig) {
        return orig.replace('W', 'e').replace('E', 'W').replace('e', 'E');
    }

    static String flipBoth(String orig) {
        return flipX(flipY(orig));
    }
}