import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    private static void test() throws IOException {
        StringBuilder total = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("data/testIn"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                total.append(line).append("\n");
            }
        }
        InputStream testInput = new ByteArrayInputStream(total.toString().getBytes(StandardCharsets.UTF_8));
        System.setIn(testInput);
    }

    public static void main(String[] args) throws IOException {
        // test();
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = Integer.parseInt(in.nextLine());
            for (int x = 1; x <= t; ++x) {
                in.nextLine();
                System.out.println("Case #" + x + ": " + getResult(readGuesses(in)));
            }
        }
    }

    private static Guess[] readGuesses(Scanner in) {
        final int count = 10000;
        Guess[] guesses = new Guess[count];
        for (int i = 0; i < count; i++) {
            String[] line = in.nextLine().split(" ");
            guesses[i] = new Guess(line[1]);
        }
        return guesses;
    }

    private static class Guess {
        private final char[] characters;

        public Guess(String result) {
            this.characters = result.toCharArray();
        }
    }

    private static String getResult(Guess[] guesses) {
        Map<Character, Integer> distribution = new HashMap<>();

        for (Guess guess : guesses) {
            for (char c : guess.characters) {
                distribution.put(c, distribution.getOrDefault(c, 0) + 1);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!distribution.isEmpty()) {
            char selectedChar = '0';
            int selectedCount = distribution.values().stream().min(Integer::compareTo).orElse(Integer.MAX_VALUE);
            for (Map.Entry<Character, Integer> entry : distribution.entrySet()) {
                if (entry.getValue() == selectedCount) {
                    selectedChar = entry.getKey();
                    break;
                }
            }
            result.append(selectedChar);
            distribution.remove(selectedChar);
        }

        return result.toString();
    }
}