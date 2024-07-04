import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

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
        String[] s = new String[10000];
        for (int i = 0; i < s.length; ++i) {
            int q = sc.nextInt(); // ignored
            String r = sc.next();
            s[i] = r;
        }

        Set<String> allLetters = Arrays.stream(s).flatMapToInt(e->e.chars().distinct()).distinct().mapToObj(j -> String.valueOf((char)j)).collect(Collectors.toSet());
        Map<String, Long> letters = Arrays.stream(s).collect(Collectors.groupingBy(e -> e.substring(0, 1), Collectors.counting()));
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