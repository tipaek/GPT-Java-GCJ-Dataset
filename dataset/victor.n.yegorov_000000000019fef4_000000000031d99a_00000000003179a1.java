import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= t; ++i) {
            String output = solve(sc);
            sb.append("Case #").append(i).append(": ").append(output).append("\n");
        }
        System.out.print(sb);
    }

    private static String solve(Scanner sc) {
        int u = sc.nextInt(); // ignored
        boolean[] present = new boolean[26];
        int[] countFirst = new int[26];
        for (int i = 0; i < 10000; ++i) {
            int q = sc.nextInt(); // ignored
            String r = sc.next();
            r.chars().forEach(j -> present[j - 'A'] = true);
            ++countFirst[r.charAt(0) - 'A'];
        }
        Set<String> allLetters = IntStream.rangeClosed('A', 'Z').filter(i -> present[i - 'A']).mapToObj(i -> String.valueOf((char) i)).collect(Collectors.toSet());
        Map<String, Integer> letters = IntStream.rangeClosed('A', 'Z').filter(i -> countFirst[i - 'A'] > 0).boxed()
                .collect(Collectors.toMap(i -> String.valueOf((char) i.intValue()), i -> countFirst[i - 'A']));
        List<String> sortedLetters = letters.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey).collect(Collectors.toList());
        allLetters.removeAll(sortedLetters);
        String zeroLetter = allLetters.iterator().next();
        StringBuilder sb = new StringBuilder();
        sb.append(zeroLetter);
        for (String letter : sortedLetters) {
            sb.append(letter);
        }
        return sb.toString();
    }
}