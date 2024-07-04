package A;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(input.nextLine());
//        System.out.println(numCases);
        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
//            System.out.println("attempting to get number of patterns");
//            String foo = input.nextLine();
//            System.out.println(foo);
            int n = Integer.parseInt(input.nextLine());
//            System.out.printf("number of patterns is %d\n", n);
            List<String> patterns = new ArrayList<>();
            for (int i = 0; i < n; i++) {
//                System.out.println("getting new pattern");
                patterns.add(input.nextLine());
            }

//            List<List<String>> expandedPatterns = patterns.stream().map(Arrays::asList).collect(Collectors.toList());
//
//            String solution = "";
//
//            while (true) {
//                Set<Character> possibleNextLetters = getAllLetters();
//                for (List<String> patternSet : expandedPatterns) {
//                    possibleNextLetters.retainAll(getNextLetters(solution, patternSet));
//                }
//            }
//
//
//            System.out.println(patterns);

            List<List<String>> explodedPatterns = patterns.stream()
                    .map(pattern -> {
                        int starIndex = pattern.indexOf("*");
                        return Arrays.asList(pattern.substring(0, starIndex), pattern.substring(starIndex+1));
                    })
                    .collect(Collectors.toList());

//            System.out.println(explodedPatterns);
            String longestPrefix = "";
            String longestSuffix = "";
            for (List<String> explodedPattern : explodedPatterns) {
                if (explodedPattern.get(0).length() > longestPrefix.length()) {
                    longestPrefix = explodedPattern.get(0);
                }
                if (explodedPattern.get(explodedPattern.size() - 1).length() > longestSuffix.length()) {
                    longestSuffix = explodedPattern.get(explodedPattern.size() - 1);
                }
            }

            String solution = longestPrefix + longestSuffix;
            solution = solution.replace("*", "");

//            System.out.println(solution);

            boolean solutionIsValid = true;

            for (String pattern : patterns) {
                if (!solution.matches(pattern.replace("*", ".*"))) {
                    solutionIsValid = false;
                    break;
                }
            }


            if (solutionIsValid) {
                System.out.printf("Case #%d: %s\n", caseNum, solution);
            } else {
                System.out.printf("Case #%d: *\n", caseNum);
            }
        }
    }

//    private static Set<Character> getNextLetters(String solution, List<String> patternSet) {
//        for (String pattern : patternSet) {
//
//        }
//    }

    private static Set<Character> getAllLetters() {
        return new HashSet<>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'));
    }
}
