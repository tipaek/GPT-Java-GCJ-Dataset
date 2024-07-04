
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static final int SAMPLES = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final int numOfCases = Integer.parseInt(in.readLine());
        for (int i = 1; i <= numOfCases; i++) {
            String result = solveProbabilistic(in);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    static String solveProbabilistic(BufferedReader in) throws IOException {
        final int digitNum = Integer.parseInt(in.readLine()); // why would we care ? :|
        Map<Character, Integer> countsOfStartingChars = new HashMap<>();
        Set<Character> allChars = new HashSet<>();
        for (int i = 0; i < SAMPLES; i++) {
            final String sampleUnparsed = in.readLine();
            final String[] sample = sampleUnparsed.split(" ");
            final String response = sample[1];
            for (char c : response.toCharArray()) {
                allChars.add(c);
            }
            final char startingChar = response.charAt(0);
            countsOfStartingChars.compute(startingChar, (ch, currCount) -> currCount == null ? 1 : currCount + 1);
        }

        final Comparator<Map.Entry<Character, Integer>> entryComp = Comparator.comparingInt(Map.Entry::getValue);
        final List<Character> chars = countsOfStartingChars.entrySet().stream().sorted(entryComp.reversed()).map(Map.Entry::getKey).collect(Collectors.toList());
        final Set<Character> zeroChar = allChars.stream().filter(ch -> !countsOfStartingChars.containsKey(ch)).collect(Collectors.toSet());
        if (zeroChar.size() == 1) {
            chars.add(0, zeroChar.iterator().next());
            return chars.stream().map(Object::toString).collect(Collectors.joining());
        } else {
            throw new IllegalStateException("Cannot Decode zero :(, there are some undecodable " + zeroChar);
        }
    }


}