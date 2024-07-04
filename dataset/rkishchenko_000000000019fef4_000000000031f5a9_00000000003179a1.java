import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < t; i++) {
            scanner.nextLine();
            Map<Integer, List<String>> numbers = new HashMap<>();
            for (int j = 0; j < 10000; j++) {
                String[] parameters = scanner.nextLine().split(" ");
                String number = parameters[1];
                numbers.computeIfAbsent(number.length(), l -> new ArrayList<>()).add(number);
            }
            String solution = solve(numbers);
            System.out.println("Case #" + (i + 1) + ": " + solution);
        }
    }

    private static String solve(Map<Integer, List<String>> numbers) {
        Set<Character> characters = new HashSet<>();
        int[] counts = new int[26];
        for (int i = 1; i < 10; i++) {
            List<String> strings = numbers.computeIfAbsent(i, l -> new ArrayList<>());
            for (String string : strings) {
                counts[string.charAt(0) - 'A']++;
                for (char c : string.toCharArray()) {
                    characters.add(c);
                }
            }

        }
        List<CharacterFrequency> frequency = new ArrayList<>();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                char c = (char) (i + 'A');
                frequency.add(new CharacterFrequency(c, counts[i]));
            }
        }

        Collections.sort(frequency, new Comparator<CharacterFrequency>() {
            @Override
            public int compare(CharacterFrequency o1, CharacterFrequency o2) {
                return -Integer.compare(o1.count, o2.count);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (CharacterFrequency characterFrequency : frequency) {
            sb.append(characterFrequency.c);
            characters.remove(characterFrequency.c);
        }
        Character zero = characters.iterator().next();

        return zero + sb.toString();
    }

    private static class CharacterFrequency {

        private char c;
        private int count;

        public CharacterFrequency(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

}
