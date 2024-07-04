import java.util.*;
import java.io.*;

public class Jump {
    static ArrayList<Integer> best;

    public static void main(String[] args) {
        Integer[] numbers = {-128, -64, -32, -16, -8, -4, -2, -1, 1, 2, 4, 8, 16, 32, 64, 128};
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int n = 1; n <= testCases; n++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int sum = Math.abs(x + y);

            findBestCombination(new ArrayList<>(Arrays.asList(numbers)), sum);

            if (best == null) {
                System.out.println("Case #" + n + ": IMPOSSIBLE");
            } else {
                String direction = convertToString(Math.abs(x), Math.abs(y), sum);

                if (direction.isEmpty()) {
                    System.out.println("Case #" + n + ": IMPOSSIBLE");
                } else if (x >= 0 && y >= 0) {
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

    static void findBestCombination(ArrayList<Integer> numbers, int target) {
        findCombinationRecursive(numbers, target, new ArrayList<>());
    }

    static void findCombinationRecursive(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial) {
        int sum = partial.stream().mapToInt(Integer::intValue).sum();

        if (sum == target && isValidCombination(partial, target)) {
            best = new ArrayList<>(partial);
        }

        if (sum >= target) return;

        for (int i = 0; i < numbers.size(); i++) {
            ArrayList<Integer> remaining = new ArrayList<>(numbers.subList(i + 1, numbers.size()));
            ArrayList<Integer> partialRec = new ArrayList<>(partial);
            partialRec.add(numbers.get(i));
            findCombinationRecursive(remaining, target, partialRec);
        }
    }

    static boolean isValidCombination(ArrayList<Integer> nums, int target) {
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

        for (Integer num : best) {
            findBestCombinationForY(new ArrayList<>(Arrays.asList(numbers)), y);

            if (best.contains(num)) {
                str.append(num < 0 ? "S" : "N");
            } else {
                str.append(num < 0 ? "W" : "E");
            }
        }

        return str.toString();
    }

    static void findBestCombinationForY(ArrayList<Integer> numbers, int target) {
        findCombinationRecursiveForY(numbers, target, new ArrayList<>());
    }

    static void findCombinationRecursiveForY(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial) {
        int sum = partial.stream().mapToInt(Integer::intValue).sum();

        if (sum == target) {
            best = new ArrayList<>(partial);
        }

        if (sum >= target) return;

        for (int i = 0; i < numbers.size(); i++) {
            ArrayList<Integer> remaining = new ArrayList<>(numbers.subList(i + 1, numbers.size()));
            ArrayList<Integer> partialRec = new ArrayList<>(partial);
            partialRec.add(numbers.get(i));
            findCombinationRecursiveForY(remaining, target, partialRec);
        }
    }

    static String flipY(String orig) {
        return orig.replace('S', 'X').replace('N', 'S').replace('X', 'N');
    }

    static String flipX(String orig) {
        return orig.replace('W', 'X').replace('E', 'W').replace('X', 'E');
    }

    static String flipBoth(String orig) {
        return orig.replace('S', 'X').replace('N', 'S').replace('X', 'N')
                   .replace('W', 'X').replace('E', 'W').replace('X', 'E');
    }
}