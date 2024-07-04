import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            String solution = new Solution(scanner).solve();
            System.out.println("Case #" + t + ": " + solution);
        }
    }

    final int U;
    final List<String> R = new ArrayList<>(10_000);


    public Solution(Scanner scanner) {
        U = scanner.nextInt();
        for (int i = 0; i < 10_000; i++) {
            scanner.next();
            R.add(scanner.next());
        }
    }

    private String solve() {
        Map<String, Integer> firstDigits = new HashMap<>();
        Set<String> allDigits = new HashSet<>();
        for (String r : R) {
            for (char c : r.toCharArray()) {
                allDigits.add(Character.toString(c));
                String s = r.substring(0,1);
                firstDigits.putIfAbsent(s, 0);
                firstDigits.put(s, firstDigits.get(s) + 1);
            }
        }
        String sorted = firstDigits.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.joining());

        allDigits.removeAll(firstDigits.keySet());

        return allDigits.iterator().next() + sorted.substring(0, 9);
    }
}