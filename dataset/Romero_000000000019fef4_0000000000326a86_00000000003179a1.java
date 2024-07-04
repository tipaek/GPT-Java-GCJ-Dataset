import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static class Pair {
        final String first;
        final String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return Objects.equals(first, pair.first) &&
                    Objects.equals(second, pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int i = 1; i <= cases; ++i) {
            int u = in.nextInt();
            List<Pair> input = new ArrayList<>();
            for (int j = 0; j < 10000; j++) {
                String q = in.next(); // number
                String r = in.next(); // letters
                input.add(new Pair(q, r));
            }

            Set<Character> allLetters = getAllLetters(input);
            char zeroLetter = findZeroLetter(input, allLetters);

            // Letter -> [minDigit, maxDigit]
            char[][] minAndMaxForLetter = new char[256][2];
            for (Character letter : allLetters) {
                if (letter == zeroLetter) {
                    minAndMaxForLetter[zeroLetter][0] = '0';
                    minAndMaxForLetter[zeroLetter][1] = '0';
                } else {
                    minAndMaxForLetter[letter][0] = '1';
                    minAndMaxForLetter[letter][1] = '9';
                }
            }

            while (!checkResultFound(allLetters, minAndMaxForLetter)) {
                for (Pair line : input) {
                    if (line.first.length() == line.second.length()) {
                        int targetIndex = -1;
                        for (int index = 0; index < line.second.length(); index++) {
                            char c = line.second.charAt(index);
                            if (minAndMaxForLetter[c][0] != minAndMaxForLetter[c][1]) {
                                targetIndex = index;
                                break;
                            } else { // min and max for current letter are found. If no bounds on next digits, skip this number
                                if (minAndMaxForLetter[c][0] != line.first.charAt(index)) {
                                    break;
                                }
                            }
                        }
                        if (targetIndex >= 0) {
                            char letter = line.second.charAt(targetIndex);
                            char currentMax = minAndMaxForLetter[letter][1];
                            char possibleNewMax = line.first.charAt(targetIndex);
                            minAndMaxForLetter[letter][1] = (char) Math.min(currentMax, possibleNewMax);

                            if (minAndMaxForLetter[letter][0] == minAndMaxForLetter[letter][1]) {
                                processMinMaxOnMatch(allLetters, minAndMaxForLetter, letter);
                            }
                        }
                    }
                }
            }

            // construct answer
            char[] result = new char[10];
            for (Character currentLetter : allLetters) {
                if (minAndMaxForLetter[currentLetter][0] == minAndMaxForLetter[currentLetter][1]) {
                    result[minAndMaxForLetter[currentLetter][0] - '0'] = currentLetter;
                }
            }
            System.out.println(String.format("Case #%d: %s", i, new String(result)));
        }
    }

    private static void processMinMaxOnMatch(Set<Character> allLetters, char[][] minAndMaxForLetter, char letter) {
        // found match, it can be only next from previous digit
        char computedLetterValue = minAndMaxForLetter[letter][1];
        for (Character allLettersCandidate : allLetters) {
            if (allLettersCandidate != letter && minAndMaxForLetter[allLettersCandidate][0] == computedLetterValue) {
                minAndMaxForLetter[allLettersCandidate][0]++;
            }
        }
        // Possibly new letter matching found
        for (Character allLettersCandidate : allLetters) {
            if (minAndMaxForLetter[allLettersCandidate][0] > computedLetterValue
                    && minAndMaxForLetter[allLettersCandidate][0] == minAndMaxForLetter[allLettersCandidate][1]) {

                processMinMaxOnMatch(allLetters, minAndMaxForLetter, allLettersCandidate);
            }
        }
    }

    private static char findZeroLetter(List<Pair> input, Set<Character> allLetters) {
        // find 0
        Set<Character> zeroCandidate = new HashSet<>(allLetters);
        for (int j = 0; j < input.size() && zeroCandidate.size() > 1; j++) {
            Pair pair = input.get(j);
            if (pair.second.length() > 1) {
                zeroCandidate.remove(pair.second.charAt(0));
            }
        }
        return zeroCandidate.iterator().next();
    }

    private static Set<Character> getAllLetters(List<Pair> input) {
        Set<Character> allLetters = new HashSet<>();
        for (int j = 0; j < input.size() && allLetters.size() < 10; j++) {
            for (char c : input.get(j).second.toCharArray()) {
                allLetters.add(c);
            }
        }
        return allLetters;
    }

    private static boolean checkResultFound(Set<Character> allLetters, char[][] minAndMaxForLetter) {
        for (Character currentLetter : allLetters) {
            if (minAndMaxForLetter[currentLetter][0] != minAndMaxForLetter[currentLetter][1]) {
                return false;
            }
        }
        return true;
    }
}
