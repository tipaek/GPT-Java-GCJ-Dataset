import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] generalArgs = s.nextLine().split(" ");
        int testCases = Integer.parseInt(generalArgs[0]);
        int numberOfBits = Integer.parseInt(generalArgs[1]);

        int groupHalf = 5;

        main: for (int test = 1; test <= testCases; test++) {
            Set<String> groups = new HashSet<>();
            groups.add("");

            for (int i = 0; i < numberOfBits / 2; i += groupHalf) {
                String first = readBits(numberOfBits / 2 - i - groupHalf, numberOfBits / 2 - i, s);
                String second = readBits(numberOfBits / 2 + i, numberOfBits / 2 + i + groupHalf, s);

                groups = getMutationResults(groups, first, second);
            }

            Set<Integer> triedBits = new HashSet<>();

            for (int guess = 0; guess < 50; guess++) {
                if (guess % 10 == 0) {
                    // Mutate result further
                    groups = getMutationResults(groups, "", "");
                }

                int bitToCheck = bitToTry(groups, triedBits);

                char bit = readBits(bitToCheck, bitToCheck + 1, s).charAt(0);

                Set<String> filteredGroups = new HashSet<>();

                for (String group : groups) {
                    if (group.charAt(bitToCheck) == bit) {
                        filteredGroups.add(group);
                    }
                }

                groups = filteredGroups;

                if (groups.size() == 1) {
                    String myGuess = groups.iterator().next();
                    System.out.println(myGuess);
                    continue main;
                }
            }

            // Out of guesses
            System.out.println("I don't know");
            return;
        }
    }

    private static int bitToTry(Set<String> groups, Set<Integer> triedBits) {
        int[] bitsSet = new int[groups.iterator().next().length()];
        for (String group : groups) {
            for (int i = 0; i < group.length(); i++) {
                if (group.charAt(i) == '1') {
                    bitsSet[i]++;
                }
            }
        }

        int bestChoiceIndex = 0;
        int bestFound = 0;
        for (int i = 0; i < bitsSet.length; i++) {
            if (triedBits.contains(i)) {
                continue;
            }
            int curValue = Math.min(groups.size() - bitsSet[i], bitsSet[i]);
            if (curValue > bestFound) {
                bestFound = curValue;
                bestChoiceIndex = i;
            }
        }

        triedBits.add(bestChoiceIndex);

        return bestChoiceIndex;
    }

    private static Set<String> getMutationResults(Set<String> groups, String first, String second) {
        Set<String> newGroups = new HashSet<>();

        for (String group : groups) {
            for (String permutation : getPermutations(group)) {
                String g = first + permutation + second;
                newGroups.add(g);
            }
        }
        return newGroups;
    }

    private static String readBits(int from, int to, Scanner s) {
        StringBuilder sb = new StringBuilder();
        for (int j = from; j < to; j++) {
            sb.append(askForBitState(j, s));
        }

        return sb.toString();
    }

    private static List<String> getPermutations(String s) {
        List<String> r = new ArrayList<>(4);

        r.add(s);
        r.add(inverse(s));

        String flipped = flip(s);

        r.add(flipped);
        r.add(inverse(flipped));

        return r;
    }

    private static String flip(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i) == '1' ? '0' : '1');
        }
        return sb.toString();
    }

    private static String inverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    private static String askForBitState(int index, Scanner scanner) {
        System.out.println(index);
        return scanner.nextLine();
    }
}
