import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Solution {

    private static void test() throws IOException {
        BufferedReader read = new BufferedReader(new FileReader("data/testIn"));
        StringBuilder total = new StringBuilder();
        String s;
        while ((s = read.readLine()) != null) {
            total.append(s).append("\n");
        }
        InputStream testInput = new ByteArrayInputStream(total.toString().getBytes(StandardCharsets.UTF_8));
        System.setIn(testInput);
        read.close();
    }

    public static void main(String[] args) throws IOException {
        // test();
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());
        for (int x = 1; x <= t; ++x) {
            String wh = in.nextLine();
            long maxNum = wh.equals("2") ? 99 : 9999999999999999L;
            System.out.println("Case #" + x + ": " + getResult(readGuesses(in, maxNum)));
        }
        in.close();
    }

    private static Guess[] readGuesses(Scanner in, long maxNum) {
        int count = 10000;
        Guess[] guesses = new Guess[count];
        for (int i = 0; i < count; i++) {
            String[] line = in.nextLine().split(" ");
            long num = Long.parseLong(line[0]);
            if (num == -1) num = maxNum;
            guesses[i] = new Guess(num, line[1]);
        }
        return guesses;
    }

    private static class Guess {
        private final long num;
        private final char[] characters;

        public Guess(long num, String result) {
            this.num = num;
            this.characters = result.toCharArray();
        }
    }

    private static String getResult(Guess[] guesses) {
        Set<Character> allCharacters = new HashSet<>();
        Set<Character> allNonZeroCharacters = new HashSet<>();
        Map<Character, Integer> maxNum = new HashMap<>();
        List<Set<Character>> options = new ArrayList<>(Collections.nCopies(10, new HashSet<>()));
        Map<Character, Integer> distribution = new HashMap<>();

        for (Guess guess : guesses) {
            for (char c : guess.characters) {
                distribution.put(c, distribution.getOrDefault(c, 0) + 1);
            }
            if (guess.num < 10) {
                char ch = guess.characters[0];
                allNonZeroCharacters.add(ch);
                allCharacters.add(ch);
                evaluateMaxnum(maxNum, 1, (int) guess.num, ch, options);
            } else if (Long.toString(guess.num).length() == guess.characters.length) {
                evaluateFullLengthGuess(guess, allCharacters, allNonZeroCharacters, maxNum, options);
            } else {
                for (char c : guess.characters) allCharacters.add(c);
            }
        }

        return determineResult(allCharacters, options, distribution);
    }

    private static void evaluateMaxnum(Map<Character, Integer> maxNum, int minNum, int maxNumHere, char ch, List<Set<Character>> options) {
        if (!maxNum.containsKey(ch)) {
            maxNum.put(ch, maxNumHere);
            for (int k = minNum; k <= maxNumHere; k++) options.get(k).add(ch);
        } else if (maxNum.get(ch) > maxNumHere) {
            for (int k = maxNumHere + 1; k <= maxNum.get(ch); k++) options.get(k).remove(ch);
            maxNum.put(ch, maxNumHere);
        }
    }

    private static int firstDigit(long n) {
        while (n >= 10) n /= 10;
        return (int) n;
    }

    private static void evaluateFullLengthGuess(Guess guess, Set<Character> allCharacters, Set<Character> allNonZeroCharacters, Map<Character, Integer> maxNum, List<Set<Character>> options) {
        evaluateMaxnum(maxNum, 1, firstDigit(guess.num), guess.characters[0], options);
        for (int i = 0; i < guess.characters.length; i++) {
            char c = guess.characters[i];
            if (i > 0) allNonZeroCharacters.add(c);
            allCharacters.add(c);
        }
    }

    private static String determineResult(Set<Character> allCharacters, List<Set<Character>> options, Map<Character, Integer> distribution) {
        Set<Character> determined = new HashSet<>();
        StringBuilder result = new StringBuilder();
        boolean guessMode = false;

        for (int i = 9; i >= 1; i--) {
            Set<Character> option = options.get(i);
            if (option.size() > 1) {
                guessMode = true;
                break;
            }
            for (Character c : option) {
                result.insert(0, c);
                allCharacters.remove(c);
            }
            for (int j = i - 1; j >= 1; j--) options.get(j).removeAll(option);
        }

        if (guessMode) {
            char lowestChar = distribution.entrySet().stream().min(Map.Entry.comparingByValue()).get().getKey();
            result = new StringBuilder(Character.toString(lowestChar));
            distribution.remove(lowestChar);
            while (!distribution.isEmpty()) {
                char highest = distribution.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
                result.append(highest);
                distribution.remove(highest);
            }
            return result.toString();
        }

        if (allCharacters.size() > 1) {
            System.out.println("ERROR 2");
            System.exit(1);
        }

        for (Character c : allCharacters) {
            result.insert(0, c);
        }

        return result.toString();
    }
}