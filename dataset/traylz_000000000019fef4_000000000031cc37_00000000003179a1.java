
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
            String result = solve(in);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    static String solve(BufferedReader in) throws IOException {
        final int digitNum = Integer.parseInt(in.readLine()); // why would we care ? :|
        Map<Integer, Set<Character>> samples = new HashMap<>();
        Set<Character> allChars = new HashSet<>();
        for (int i = 0; i < SAMPLES; i++) {
            final String sampleUnparsed = in.readLine();
            final String[] sample = sampleUnparsed.split(" ");
            final String request = sample[0];
            final String response = sample[1];
            for (char c : response.toCharArray()) {
                allChars.add(c);
            }
            if (!request.equals("-1") && request.length() == response.length()) {
                final int startingDigit = Integer.parseInt(request.substring(0, 1));
                final char startingChar = response.charAt(0);
                final Set<Character> samplesStartingWithDigit = samples.computeIfAbsent(startingDigit, __ -> new HashSet<>());
                samplesStartingWithDigit.add(startingChar);
            }
        }

        Map<Integer, Character> result = new HashMap<>();

        for (int i = 1; i <= 9; i++) {
            final Set<Character> possibleChars = samples.get(i);
            final Set<Character> possibleValues = possibleChars.stream().filter(ch -> !result.containsValue(ch)).collect(Collectors.toSet());
            if (possibleValues.size() == 1) {
                result.put(i, possibleValues.iterator().next());
            } else {
                throw new IllegalStateException("Cannot Decode " + i);
            }
        }
        final Set<Character> undecodedValue = allChars.stream().filter(ch -> !result.containsValue(ch)).collect(Collectors.toSet());
        if (undecodedValue.size() == 1) {
            result.put(0, undecodedValue.iterator().next());
        } else {
            throw new IllegalStateException("Cannot Decode zero :(, there are some undecodable " + undecodedValue);
        }
        return result.entrySet().stream().sorted(Map.Entry.comparingByKey()).map(e -> e.getValue().toString()).collect(Collectors.joining());
    }

}
